/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Articulo;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticuloController {
    
    private JdbcTemplate jdbcTemplate;

    public ArticuloController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(value = "ArticuloIndex.htm", method = RequestMethod.GET)
    public ModelAndView ArticuloIndex(
       
            HttpServletResponse hresponse,
            HttpServletRequest request
    ) {
        List articulos = null;
        List Errores = null;
        try {
            articulos = this.jdbcTemplate.queryForList("select * from ARTICULO where ID_POST_DOC = "+request.getParameter("id"));
        } catch (Exception ex) {
            Errores.add("Error. No hay acceso a la BD" + ex.toString());
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/Articulos/ArticuloIndex");
        mav.addObject("Articulos", articulos);
        mav.addObject("Errores", Errores);
        mav.addObject("id", request.getParameter("id"));
        return mav;
    }
    
    @RequestMapping(value = "ArticuloAdd.htm", method = RequestMethod.GET)
    public ModelAndView ArticuloAdd(
            HttpServletResponse hresponse,
            HttpServletRequest request
    ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/Articulos/ArticuloAdd");
        mav.addObject("articulo", new Articulo());
        String id = request.getParameter("id");
        mav.addObject("identificador", id);
        return mav;
    }
    
    @RequestMapping(value = "ArticuloAdd.htm", method = RequestMethod.POST)
    public ModelAndView ArticuloAddPost(
            HttpServletResponse hresponse,
            HttpServletRequest request,
            @ModelAttribute("articulo") Articulo a,
            BindingResult result,
            SessionStatus status,
            ModelMap model
    ) 
    {
        String id = request.getParameter("id");
        ModelAndView mav = new ModelAndView("Errores/Error");
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_INSERT_ARTICULO(?,?,?,?)}");
            cst.setString(1, id);
            cst.setString(2, a.getNombreArticulo());
            cst.setString(3, a.getLugarPublicado());
            cst.setBigDecimal(4, a.getNumEdicion());
            cst.execute();
            cn.close();
            return new ModelAndView("redirect:" + "ArticuloIndex.htm?id="+id);
        } catch (SQLException ex) {
            model.addAttribute("Errores", "Error al cerrar conexion o ejecutar "+ex.toString());
            return new ModelAndView("redirect:/Error.htm");
        }
        
    }
    
    @RequestMapping(value = "ArticuloEdit.htm", method = RequestMethod.GET)
    public ModelAndView ArticuloEdit(
            HttpServletResponse hresponse,
            HttpServletRequest request
    ) {
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/Articulos/ArticuloEdit");
        
        BigDecimal id = BigDecimal.valueOf(Double.valueOf(request.getParameter("id")));
        
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_OBTENER_ARTICULO(?,?,?,?)}");
            cst.setBigDecimal(1, id);
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            cst.registerOutParameter(4, java.sql.Types.BIGINT);
            cst.execute();
            Articulo art = new Articulo();
            art.setIdArticulo(id);
            art.setNombreArticulo(cst.getString(2));
            art.setLugarPublicado(cst.getString(3));
            art.setNumEdicion(cst.getBigDecimal(4));
            cn.close();
            mav.addObject("articulo", art);
            //resultado = 1;
            return mav;
        } catch (SQLException ex) {
            mav.addObject("Error", "Error al cerrar conexion o ejecutar "+ex.toString());
            return mav;
        }
        //return mav;
    }
    
    @RequestMapping(value = "ArticuloEdit.htm", method = RequestMethod.POST)
    public ModelAndView ArticuloEditPost(
            HttpServletResponse hresponse,
            HttpServletRequest request,
            @ModelAttribute("articulo") Articulo a,
            BindingResult result,
            SessionStatus status
    ) {
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/Articulos/ArticuloEdit");
        
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_ACTUALIZAR_ARTICULO(?,?,?,?,?)}");
            
            cst.setInt(1, Integer.valueOf(request.getParameter("id")));
            cst.setString(2, request.getParameter("id2"));
            cst.setString(3, a.getNombreArticulo());
            cst.setString(4, a.getLugarPublicado());
            cst.setBigDecimal(5, a.getNumEdicion());
            cst.execute();
            cn.close();
            //resultado = 1;
             return new ModelAndView("redirect:" + "ArticuloIndex.htm?id="+request.getParameter("id2"));
        } catch (SQLException ex) {
            mav.addObject("Error", "Error al cerrar conexion o ejecutar "+ex.toString());
            return mav;
        }
        //return mav;
    }
    @RequestMapping(value = "ArticuloDelete.htm", method = RequestMethod.GET)
    public ModelAndView ArticuloDelete(HttpServletResponse hresponse,
            HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/Articulos/ArticuloIndex");
        String id = request.getParameter("id");
        
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_ELIMINAR_ARTICULO(?)}");
            
            cst.setInt(1, Integer.valueOf(request.getParameter("id")));
            cst.execute();
            cn.close();
            //resultado = 1;
            return new ModelAndView("redirect:" + "ArticuloIndex.htm?id="+request.getParameter("id2"));
        } catch (SQLException ex) {
            mav.addObject("Errores", "Error al cerrar conexion o ejecutar "+ex.toString());
            return mav;
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Articulo;
import Entidad.Oferta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class OfertaController {
    private JdbcTemplate jdbcTemplate;

    public OfertaController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(value = "OfertaIndex.htm", method = RequestMethod.GET)
    public ModelAndView OfertaIndex(
            HttpServletRequest request
    ) {
        List ofertas = null;
        List Errores = null;
        try {
            ofertas = this.jdbcTemplate.queryForList("select * from OFERTA");
        } catch (Exception ex) {
            Errores.add("Error. No hay acceso a la BD" + ex.toString());
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Ofertas/OfertaIndex");
        mav.addObject("Ofertas", ofertas);
        mav.addObject("Errores", Errores);
        mav.addObject("id", request.getParameter("id"));
        return mav;
    }
    
    @RequestMapping(value = "OfertaAdd.htm", method = RequestMethod.GET)
    public ModelAndView ArticuloAdd(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Ofertas/OfertaAdd");
        mav.addObject("oferta", new Oferta());
        String id = request.getParameter("id");
        mav.addObject("identificador", id);
        List areas = null;
        List niveles = null;
        List Errores = null;
        try {
            areas = this.jdbcTemplate.queryForList("select * from AREA_DE_ESTUDIO");
            niveles = this.jdbcTemplate.queryForList("select * from NIVEL_ESTUDIO");
        } catch (Exception ex) {
            Errores.add("Error. No hay acceso a la BD" + ex.toString());
        }
        mav.addObject("Areas",areas);
        mav.addObject("Niveles",niveles);
        return mav;
    }
    
    @RequestMapping(value = "OfertaAdd.htm", method = RequestMethod.POST)
    public ModelAndView OfertaAddPost(
            HttpServletRequest request,
            @ModelAttribute("oferta") Oferta o,
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
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_INSERT_OFERTA(?,?,?,?,?,?,?)}");
            cst.setInt(1, o.getArea());
            cst.setInt(2, o.getNivel());
            cst.setInt(3, o.getVacantes());
            cst.setString(4, o.getDescripcion());
            cst.setString(5, o.getTipoContrato());
            cst.setDouble(6, o.getSalario());
            cst.setInt(7, o.getNit());
            cst.execute();
            cn.close();
            return new ModelAndView("redirect:" + "OfertaIndex.htm");
        } catch (SQLException ex) {
            model.addAttribute("Errores", "Error al cerrar conexion o ejecutar "+ex.toString());
            return new ModelAndView("redirect:/Error.htm");
        }
        
    }
    
}

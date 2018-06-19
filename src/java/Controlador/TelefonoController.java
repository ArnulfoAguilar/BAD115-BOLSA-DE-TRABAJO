/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Articulo;
import Entidad.Telefono;
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
public class TelefonoController {
    private JdbcTemplate jdbcTemplate;

    public TelefonoController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    @RequestMapping(value = "TelefonoIndex.htm", method = RequestMethod.GET)
    public ModelAndView TelefonoIndex(
            HttpServletRequest request
    ) {
        List telefonos = null;
        List Errores = null;
        try {
            telefonos = this.jdbcTemplate.queryForList("select * from TELEFONO where ID_POST_DOC = "+request.getParameter("id"));
        } catch (Exception ex) {
            Errores.add("Error. No hay acceso a la BD" + ex.toString());
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/Telefonos/TelefonoIndex");
        mav.addObject("Telefonos", telefonos);
        mav.addObject("Errores", Errores);
        mav.addObject("id", request.getParameter("id"));
        return mav;
    }
    
    @RequestMapping(value = "TelefonoAdd.htm", method = RequestMethod.GET)
    public ModelAndView TelefonoAdd(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/Telefonos/TelefonoAdd");
        mav.addObject("telefono", new Telefono());
        String id = request.getParameter("id");
        List tipos = null;
        List Errores = null;
        try {
            tipos = this.jdbcTemplate.queryForList("select * from TIPO_TELEFONO");
        } catch (Exception ex) {
            Errores.add("Error. No hay acceso a la BD" + ex.toString());
        }
        mav.addObject("Tipos", tipos);
        mav.addObject("Errores", Errores);
        mav.addObject("identificador", id);
        return mav;
    }
    
    @RequestMapping(value = "TelefonoAdd.htm", method = RequestMethod.POST)
    public ModelAndView TelefonoAddPost(
            HttpServletRequest request,
            @ModelAttribute("telefono") Telefono t,
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
            CallableStatement cst = cn.prepareCall("{call PR_INSERT_TELEFONO(?,?,?)}");
            cst.setInt(1, t.getTipo());
            cst.setString(2, id);
            cst.setInt(3, t.getNumero());
            cst.execute();
            cn.close();
            return new ModelAndView("redirect:" + "TelefonoIndex.htm?id="+id);
        } catch (SQLException ex) {
            model.addAttribute("Errores", "Error al cerrar conexion o ejecutar "+ex.toString());
            return new ModelAndView("redirect:" + "TelefonoIndex.htm?id="+id).addObject("Errores", "Error al cerrar conexion o ejecutar "+ex.toString());
            
        }
        
    }
    
}

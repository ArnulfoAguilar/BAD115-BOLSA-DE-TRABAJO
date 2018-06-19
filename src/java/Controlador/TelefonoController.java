/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Telefono;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        String tipotel = null;
        mav.addObject("tipo", tipotel);
        String id = request.getParameter("id");
        List tipos = null;
        List Errores = null;
        try {
            tipos = this.jdbcTemplate.queryForList("select * from TIPO_TELEFONO");
        } catch (Exception ex) {
            Errores.add("Error. No hay acceso a la BD" + ex.toString());
        }
        mav.addObject("Tipos", tipos);
        //if (tipos==null){Errores.add("Error. Tipos esta vacio");}
        mav.addObject("Errores", Errores);
        mav.addObject("identificador", id);
        return mav;
    }
    
}

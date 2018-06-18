/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Articulo;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public ModelAndView ArticuloAdd(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/Articulos/ArticuloAdd");
        mav.addObject("articulo", new Articulo());
        String id = request.getParameter("id");
        mav.addObject("identificador", id);
        return mav;
    }
}

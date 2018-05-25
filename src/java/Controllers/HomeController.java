/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Modelo.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin Posada Alegría
 */
@Controller
public class HomeController {
    
    private JdbcTemplate jdbcTemplate;

    public HomeController() {
        this.jdbcTemplate = new JdbcTemplate(Conectar.conectar());
    }
    
    @RequestMapping(value="Indice.htm",method=RequestMethod.GET)
    public ModelAndView Indice(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Indice");
        return mav;
    }
    @RequestMapping(value="Home.htm",method=RequestMethod.GET)
    public ModelAndView Home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Home");
        return mav;
    }
}

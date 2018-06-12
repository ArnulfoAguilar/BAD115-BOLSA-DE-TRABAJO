/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidad.Oferta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Juan Murcia
 */
public class OfertaEmpleoController {
    
    private JdbcTemplate jdbcTemplate;
    
    public OfertaEmpleoController(){
         Conectar con= new Conectar();
         this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }

    @RequestMapping(value="ofertaempleo.htm",method=RequestMethod.GET)
    public ModelAndView ofertaempleo(){
        //ModelAndView of = new ModelAndView();
        //of.setViewName("OfertaEmpleo");
        //return of;
        return new ModelAndView("OfertaEmpleo");
    }
         
             
    
}

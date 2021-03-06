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
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.ModelMap;
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

    @RequestMapping(value="ofertaEmpleo.htm",method=RequestMethod.GET)
    public ModelAndView RegistrofertaEmpleo(ModelMap model){
        ModelAndView of = new ModelAndView();
        of.setViewName("OfertaEmpleo");
        return of;
    }
    
    @RequestMapping(value="editarOferta.htm",method=RequestMethod.GET)
    public ModelAndView EditarofertaEmpleo(ModelMap model){
        ModelAndView of = new ModelAndView();
        of.setViewName("EditarOfertaEmpleo");
        return of;
    }
    
    //Lista de ofertas segun kevin
    @RequestMapping(value ="listaOferta.htm", method=RequestMethod.GET)
    public ModelAndView listaOferta(ModelMap model){  
    ModelAndView mav = new ModelAndView();
    mav.setViewName("ListaOferta");
    String sql = "SELECT * FROM OFERTA";
        List<String> ERRORES = new ArrayList<>();
        ERRORES.add("Al menos manda las variables");
        List OFERTAS = null;
        try{
            OFERTAS = this.jdbcTemplate.queryForList(sql);
        }catch(Exception ex){
            ERRORES.add("Error. No hay acceso a la BD"+ex.toString());
        }
        model.addAttribute("OFERTAS", OFERTAS);
        model.addAttribute("ERRORES", ERRORES);
    return mav;
    }
             
    
}
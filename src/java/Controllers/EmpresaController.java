/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidad.Empresa;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Arnulfo
 */
@Controller
public class EmpresaController 
{
    private JdbcTemplate jdbcTemplate;
    
    public EmpresaController(){
         Conectar con= new Conectar();
         this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    
    @RequestMapping(value="Empresa.htm", method=RequestMethod.GET)
    public ModelAndView empresaHome()
    {  
       return new ModelAndView("Empresa","comand",new Empresa());
    }
    
    
     @RequestMapping(value="Empresa.htm",method=RequestMethod.POST)
    public ModelAndView empresaHome(
             @ModelAttribute("empresa") Empresa e,
                BindingResult result,
                SessionStatus status
    ){
    
       this.jdbcTemplate.update
        (
        "insert into EMPRESA (NIT, RAZON_SOCIAL,  ID_GIRO ) values (?,?,?)",
         e.getNit(),e.getRazonSocial(),e.getGiroEmpresa()
        );
         return new ModelAndView("redirect:/index.htm");
       
    } 
    
}


package Controlador;

import Entidad.Empresa;
import Entidad.Usuarios;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Arnulfo
 
public class CRUDEmpresaController {
    
     private JdbcTemplate jdbcTemplate;
     
    public CRUDEmpresaController(){
         Conectar con= new Conectar();
         this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
     @RequestMapping(value="Empresa.htm", method=RequestMethod.GET)
    public ModelAndView registrarEmpresa()
    {  
       ModelAndView mav=new ModelAndView();
        mav.setViewName("signup");
        mav.addObject("usuarios",new Usuarios());
        return mav;
    }
}*/

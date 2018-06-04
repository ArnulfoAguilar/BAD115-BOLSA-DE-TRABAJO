/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Empresa;
import Entidad.Reclutador;
import Entidad.TipoEmpresa;
import Entidad.Usuarios;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Arnulfo
 */
@Controller
public class LoginController {
    
    
    private JdbcTemplate jdbcTemplate;
    
    public LoginController()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    
    
     @RequestMapping(value="login.htm", method=RequestMethod.GET)
    public ModelAndView login()
    {  
       return new ModelAndView("LogIn/LogIn");
    }
    
    
    
     @RequestMapping(value="signup.htm", method=RequestMethod.GET)
    public ModelAndView signup()
    {  
    ModelAndView mav=new ModelAndView();
        /*String sql="select * from tipo_empresa order by id_tipo_emp desc";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);*/
        
        mav.addObject("reclutador",new Reclutador());
        mav.addObject("empresa",new Empresa());
        mav.setViewName("LogIn/SignUp");
        return mav;

    }
    
     /*@RequestMapping(value="signup.htm",method=RequestMethod.POST)
    public ModelAndView signup(
              @ModelAttribute("empresa") Empresa e,
                @ModelAttribute("reclutador") Reclutador r,
                BindingResult result,
                SessionStatus status
    ){
    
       this.jdbcTemplate.update
        (
        "insert into EMPRESA (NIT,  ) values (?)",
         e.getNit()
        );
       this.jdbcTemplate.update("insert into Reclutador (DUI) values (?)",
            r.getDui()
               );
         return new ModelAndView("redirect:/index.htm");
       
    } */
    @RequestMapping(value="signup.htm",method=RequestMethod.POST)
    public ModelAndView basicForm
        (
            @RequestParam("giroEmpresa") int giroEmpresa,
            @RequestParam("departamentoEmpresa") int departamentoEmpresa,
            @RequestParam("municipioEmpresa") int municipioEmpresa,
            @RequestParam("tipoEmpresa") int tipoEmpresa,
            @RequestParam("emailUsuario") String emailUsuario,
            @RequestParam("passwUsuario") String passwUsuario,
            @RequestParam("nombreEmpresa") String nombreEmpresa,
            @RequestParam("razonSocial") String razonSocial,
            @RequestParam("nitEmpresa") String nitEmpresa,
            @RequestParam("direccionEmpresa") String direccionEmpresa,
            @RequestParam("descripcionEmpresa") String descripcionEmpresa,
            @RequestParam("paginaWeb") String paginaWeb,
            @RequestParam("duiReclutador") String duiReclutador,
            @RequestParam("nombresReclutador") String nombresReclutador,
            @RequestParam("apellidosReclutador") String apellidosReclutador,
            @RequestParam("telefonoReclutador") String telefonoReclutador
        ) {
            
            //INSERTAR USUARIO
            this.jdbcTemplate.update
            (
                "insert into Usuarios values (?,?,?)",
                1,emailUsuario, passwUsuario
            );
            
             //INSERTAR RECLUTADOR
            this.jdbcTemplate.update("insert into Reclutador values (?,?,?,?)",
                duiReclutador,nombresReclutador,apellidosReclutador,telefonoReclutador
            );
            //INSERTAR EMPRESA
            this.jdbcTemplate.update
            (
                "insert into EMPRESA values (?,?,?,?,?,?,?,?,?,?,?,?,?)",
                nitEmpresa,tipoEmpresa,giroEmpresa,duiReclutador
                , 1,municipioEmpresa,departamentoEmpresa,razonSocial,
                nombreEmpresa,direccionEmpresa,descripcionEmpresa,
                paginaWeb,emailUsuario
            );
            
            
           
        
            return new ModelAndView("redirect:/index.htm"); 
    }

}

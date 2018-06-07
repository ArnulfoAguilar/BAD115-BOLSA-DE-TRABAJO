/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Empresa;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Arnulfo
 */
public class LoginController {
     @RequestMapping(value="login.htm", method=RequestMethod.GET)
    public ModelAndView login()
    {  
       return new ModelAndView("LogIn/LogIn");
    }
    
     @RequestMapping(value="signup.htm", method=RequestMethod.GET)
    public ModelAndView signup()
    {  
       return new ModelAndView("LogIn/SignUp");
    }
}

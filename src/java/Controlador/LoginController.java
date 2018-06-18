
package Controlador;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


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
    
    
     @RequestMapping(value = "/login.htm?error", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        JOptionPane.showMessageDialog(null, "llego al error");
        model.addAttribute("ERRORS", "true");
        return "login";

    }

    
    @RequestMapping(value="validarLogin.htm", method=RequestMethod.POST)
    public ModelAndView Validarlogin(
            @RequestParam("username") String Username,
            @RequestParam("password") String Password
    )
             
    {
        String usuario="Arnulfo@gmail.com";
        String contra="pass";
        ModelAndView mav=new ModelAndView();
     
    
            
        try {
                if (usuario.equals(Username)) {
                    mav.setViewName("index");            
                }
                else {
                    mav.addObject("ERRORS","ERRORS");
                    mav.setViewName("LogIn/LogIn");            
                }
            } catch (Exception ex) {
                String error = ex.toString();
            mav.addObject("ERRORS",error); 
            
            }
        
    return mav;
}
}

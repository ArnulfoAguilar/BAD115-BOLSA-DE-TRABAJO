
package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import servicio.servicio;


@Controller
public class LoginController {
    
    
    public servicio serv;
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
        String loginSql="select emai_usuario, contrasena from Usuarios where emai_usuario=? and contrasena=?";
        List listaUser = jdbcTemplate.queryForList(loginSql, Username, Password);
        
        if (listaUser.size() > 0) {
            ModelAndView v = new ModelAndView();
            v.setViewName("EMPRESA/HomeEmpresa");
            v.addObject("lista_datos_usu", listaUser);
            return v;
        } else {
            ModelAndView v = new ModelAndView("index");
            v.addObject("mjs", "<div style='color: red;'>ERROR, usuario no existe.</div>");
            return v;
        }
}
}


package Controlador;


import java.util.Iterator;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import servicio.servicio;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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
    
    
 
    
    @RequestMapping(value="validarLogin.htm", method=RequestMethod.POST)
    public ModelAndView Validarlogin(
            @RequestParam("username") String Username,
            @RequestParam("password") String Password,
            HttpServletRequest hrequest,
            HttpServletResponse hresponse
    )
             
    {
        
        String loginSql="select emai_usuario, contrasena from usuari where emai_usuario=? and contrasena=?";
        List listaUser = jdbcTemplate.queryForList(loginSql, Username, Password);
        ModelAndView v = new ModelAndView();
        if (listaUser.size() > 0) {
            
                HttpSession session = hrequest.getSession();
                session.setAttribute("USERNAME", Username);
               
               
                //Lista para sacar el id_rol del usuario logeado
                String idRolSql= "select id_rol from usuarios where emai_usuario=?";
                List listaIdrol = jdbcTemplate.queryForList( idRolSql, Username);
               session.setAttribute("id_rol", listaIdrol);
                
                //Lista para sacar el nombre del rol
                String nombreRolSql = "select r.NOMBRE_ROL from roles r join USUARIOS u on R.ID_ROL=U.ID_ROL and emai_usuario=?";
                List listaNombreRol = jdbcTemplate.queryForList(nombreRolSql, Username );
                String nombreRol;
                
                for(int i=0; i<listaNombreRol.size(); i++)
                {
                    System.out.println(listaNombreRol.get(i));
                    nombreRol=listaNombreRol.get(i).toString();
                    session.setAttribute("nombre_rol", nombreRol );
                }
                
                 v.setViewName("redirect:/EMPRESA/homeEmpresa.htm");
                            
        } else {
            v.setViewName("LogIn/LogIn");   
        }  
         return v;
    }

}

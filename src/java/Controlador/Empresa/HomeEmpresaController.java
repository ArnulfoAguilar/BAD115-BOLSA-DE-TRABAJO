
package Controlador.Empresa;

import Controlador.Conectar;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeEmpresaController {
     private JdbcTemplate jdbcTemplate;
    
    public HomeEmpresaController()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(value="EMPRESA/homeEmpresa.htm", method=RequestMethod.GET)
    public ModelAndView signup(HttpServletRequest hrequest, HttpServletResponse hresponse)
    {  
        ModelAndView mav=new ModelAndView();
       
       if(hrequest.getSession()==null){
            mav.setViewName("LogIn/LogIn");
            return mav;
        }else{
            HttpSession session=hrequest.getSession();
        String alert =(String)session.getAttribute("User");
         if((Long)session.getLastAccessedTime() < (Long)session.getAttribute("tiempo")+600000){
        mav.setViewName("EMPRESA/homeEmpresa");
       Long tiempo =(Long)session.getLastAccessedTime();
        mav.addObject("username", alert);
        mav.addObject("tiempo", tiempo);
        }else{
           session.invalidate();
            ModelAndView v = new ModelAndView("redirect:/login.htm");  
        }
        }
        return mav;

    }
}

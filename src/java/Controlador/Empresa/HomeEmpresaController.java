
package Controlador.Empresa;

import Controlador.Conectar;
import java.util.List;
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
    public ModelAndView signup()
    {  
        ModelAndView mav=new ModelAndView();
        mav.setViewName("EMPRESA/homeEmpresa");
        return mav;

    }
}

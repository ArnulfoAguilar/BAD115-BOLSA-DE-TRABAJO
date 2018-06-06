package Controlador;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class CandidatoController {
    private JdbcTemplate jdbcTemplate;
    
    public CandidatoController() {
        Conectar con= new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(value ="RegistroCandidato.htm")
    public ModelAndView RegistroCandidatoHome(){  
    ModelAndView MV = new ModelAndView();
    MV.setViewName("RegistroCandidato");
    return MV;
    }
    
    @RequestMapping(value ="PerfilCandidato.htm")
    public ModelAndView Perfil(){  
    ModelAndView MV = new ModelAndView();
    MV.setViewName("PerfilCandidato");
    return MV;
    }
    
    @RequestMapping(value ="CandidatoAdd.htm", method=RequestMethod.GET)
    public ModelAndView CandidatoAdd(){  
    ModelAndView mav = new ModelAndView();
    mav.setViewName("CandidatoAdd");
    return mav;
    }
    
    @RequestMapping(value ="CandidatoIndex.htm", method=RequestMethod.GET)
    public ModelAndView CandidatoIndex(){  
    ModelAndView mav = new ModelAndView();
    mav.setViewName("CandidatoIndex");
    String sql = "SELECT * FROM CANDIDATO";
        List<String> ERRORES = new ArrayList<>();
        ERRORES.add("Al menos manda las variables");
        List CANDIDATOS = null;
        try{
            CANDIDATOS = this.jdbcTemplate.queryForList(sql);
        }catch(Exception ex){
            ERRORES.add("Error. No hay acceso a la BD"+ex.toString());
        }
        mav.addObject("CANDIDATOS", CANDIDATOS);
        mav.addObject("ERRORES", ERRORES);
    return mav;
    }
   
    
}

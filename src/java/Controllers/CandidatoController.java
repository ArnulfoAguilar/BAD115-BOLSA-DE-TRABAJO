package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CandidatoController {
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
    
    @RequestMapping(value="CandidatoIndex.htm",method=RequestMethod.GET)
    public ModelAndView CandidatoIndex(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidato/CandidatoIndex");
        return mav;
    }
   
    
}

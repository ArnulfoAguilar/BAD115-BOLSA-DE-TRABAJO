/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Empresa;

import Controlador.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class misAspirantes {
    private JdbcTemplate jdbcTemplate;
    
    public misAspirantes()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
     @RequestMapping(value="EMPRESA/misAspirantes.htm", method=RequestMethod.GET)
    public ModelAndView signup(
            HttpServletRequest hrequest, 
            HttpServletResponse hresponse)
    {  
        ModelAndView mav=new ModelAndView(); 
        HttpSession session=hrequest.getSession();

        String DOC=(String)session.getAttribute("DOC");
        String USER =(String)session.getAttribute("USERNAME");
        String NombreRol =(String)session.getAttribute("nombre_rol");
        session.setAttribute("USERNAME", USER);
        session.setAttribute("NombreRol", NombreRol);
        session.setAttribute("DOC", DOC);
        mav.setViewName("ASPIRANTE/misAspirantes");
        mav.addObject("DOC", DOC);
        mav.addObject("USER", USER);
       
        mav.addObject("NombreRol", NombreRol);
        
       
        //LISTA DE OFERTAS CREARAS
        String Aspirante=" select us.ID_POST_DOC,PRIMER_NOMBRE,SEGUNDO_NOMBRE,TERCER_NOMBRE,\n" +
"                       PRIMER_APELLIDO,SEGUNDO_APELLIDO,PORCENTAJE, DIRECCION\n" +
"                       from aspirante a join candidato us on A.ID_POST_DOC=US.ID_POST_DOC\n" +
"                       join empresa em on A.NIT=EM.NIT where em.NIT=?";
        try{
        List Aspirantes=this.jdbcTemplate.queryForList(Aspirante,DOC);
        
        mav.addObject("Aspirantes",Aspirantes);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        
        return mav;
        }
}

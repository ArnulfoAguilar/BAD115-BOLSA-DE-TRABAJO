
package Controlador.Empresa;

import Controlador.Conectar;
import java.util.Iterator;
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
    public ModelAndView signup(
            HttpServletRequest hrequest, 
            HttpServletResponse hresponse)
    {  
        ModelAndView mav=new ModelAndView();
       
       if(hrequest.getSession()==null){
            mav.setViewName("LogIn/LogIn");
            return mav;
        }else{
        HttpSession session=hrequest.getSession();
        String DOCUMENTO =(String)session.getAttribute("DOC");
        String USER =(String)session.getAttribute("USERNAME");
        String NombreRol =(String)session.getAttribute("nombre_rol");
        session.setAttribute("USERNAME", USER);
        mav.setViewName("EMPRESA/homeEmpresa");
        mav.addObject("DOC", DOCUMENTO);
        mav.addObject("USER", USER);
        mav.addObject("NombreRol", NombreRol);
        
       
 
        //LISTA DE OFERTAS CREARAS
        String oferta="select id_oferta, vacantes, fecha_expiracion,o.descripcion, tipo_contrato,o.salario \n" +
                                " from usuarios us join empresa em on US.EMAI_USUARIO=EM.EMAIL_USUARIO\n" +
                                " join oferta o on EM.NIT=O.NIT\n" +
                                " join NIVEL_ESTUDIO ni on O.ID_NIVEL_ESTUDIO=Ni.ID_NIVEL_ESTUDIO \n" +
                                " join AREA_DE_ESTUDIO ar on AR.ID_AREA_ESTUDIO=O.ID_AREA_ESTUDIO\n" +
                                " where US.EMAI_USUARIO=?";
        try{
        List OFERTAS_CREADAS=this.jdbcTemplate.queryForList(oferta,USER);
        
        mav.addObject("Oferta",OFERTAS_CREADAS);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        }
        return mav;
        }

    }

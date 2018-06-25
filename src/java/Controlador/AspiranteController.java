
package Controlador;

import Entidad.Aspirante;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AspiranteController {
    
    private JdbcTemplate jdbcTemplate;
    
    public AspiranteController(){
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(value = "OfertaIndex.htm", method = RequestMethod.POST)
    public ModelAndView AplicarAddPost(
        HttpServletRequest request,
            @RequestParam("idOferta") Integer idOferta_aspirante,
            @RequestParam("nit") Integer nit_EMPRESA,
            SessionStatus status,
            ModelMap model
    )
    {
        ModelAndView mav = new ModelAndView();
        
         HttpSession session=request.getSession();
        String DOC=(String)session.getAttribute("DOC");
        String USER =(String)session.getAttribute("USERNAME");
        String NombreRol =(String)session.getAttribute("nombre_rol");
        session.setAttribute("USERNAME", USER);
        session.setAttribute("NombreRol", NombreRol);
        session.setAttribute("DOC", DOC);
        Connection cn = null;
    try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_INSERT_ASPIRANTE(?,?,?)}");
            cst.setString(1, DOC);
            cst.setInt(2, idOferta_aspirante);
            cst.setInt(3, nit_EMPRESA);
            cst.execute();
            cn.close();
            return new ModelAndView("redirect:/OfertaIndex.htm");
        }catch (SQLException ex) {
            model.addAttribute("Errores", "Error al cerrar conexion o ejecutar "+ex.toString());
            return new ModelAndView("redirect:/Error.htm");
        }
    
    }
    
     @RequestMapping(value = "misAspiraciones.htm", method = RequestMethod.GET)
    public ModelAndView misAspiraciones(
        HttpServletRequest request
    )
    {
        ModelAndView mav = new ModelAndView();
        
         HttpSession session=request.getSession();
        String DOC=(String)session.getAttribute("DOC");
        String USER =(String)session.getAttribute("USERNAME");
        String NombreRol =(String)session.getAttribute("nombre_rol");
        session.setAttribute("USERNAME", USER);
        session.setAttribute("NombreRol", NombreRol);
        session.setAttribute("DOC", DOC);

            String sql="select e.nombre_comercial,o.descripcion,tipo_contrato,salario,fecha_expiracion, id_nivel_estudio \n" +
"                       from aspirante a join OFERTA o on A.ID_OFERTA=O.ID_OFERTA \n" +
"                       join empresa e on A.NIT=E.NIT where A.ID_POST_DOC=";
            List Aspiraciones= this.jdbcTemplate.queryForList(sql, DOC);
            mav.addObject("Aspiraciones",Aspiraciones);
            return new ModelAndView("ASPIRANTE/misAspiraciones");
        
    
    }
}

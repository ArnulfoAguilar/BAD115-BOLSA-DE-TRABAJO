
package Controlador;

import Entidad.Logros;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class LogrosController {
    
    private JdbcTemplate jdbcTemplate;

    public LogrosController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(value = "LogrosAdd.htm", method = RequestMethod.GET)
    public ModelAndView LogrosAdd(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/Logros/LogrosAdd");
        mav.addObject("logro", new Logros());
        String id = request.getParameter("id");
        mav.addObject("identificador", id);
        return mav;
    }
    
    @RequestMapping(value = "LogrosAdd.htm", method = RequestMethod.POST)
    public ModelAndView LogrosAddPost(
            HttpServletRequest request,
            @ModelAttribute("logro") Logros l,
            BindingResult result,
            SessionStatus status,
            ModelMap model
    ) 
    {
        String id = request.getParameter("id");
        ModelAndView mav = new ModelAndView("Errores/Error");
        
        //int resultado = 0;
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call InsertLogro(?,?)}");
            cst.setString(1, l.getLugar());
            
            cst.setString(2, id);
            //String c = l.getFecha().toString();
            //java.sql.Date sqlDate = java.sql.Date.valueOf(c);
            //cst.setString(2,c);
            cst.execute();
            cn.close();
            //resultado = 1;
            return new ModelAndView("redirect:/CandidatoIndex.htm");
        } catch (SQLException ex) {
            model.addAttribute("Errores", "Error al cerrar conexion o ejecutar "+ex.toString());
        }
        return new ModelAndView("redirect:/Error.htm");
        /*if (resultado == 1) {
            return new ModelAndView("redirect:/PerfilCandidato.htm");
            
        } else {

            return new ModelAndView("redirect:/Home.htm");
        }*/
    }
    
    @RequestMapping(value = "LogrosIndex.htm", method = RequestMethod.GET)
    public ModelAndView LogrosIndex(
            HttpServletRequest request
    ) {
        List logros = null;
        List Errores = null;
        try {
            logros = this.jdbcTemplate.queryForList("select * from LOGROS where ID_POST_DOC = "+request.getParameter("id"));
        } catch (Exception ex) {
            Errores.add("Error. No hay acceso a la BD" + ex.toString());
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/Logros/LogrosIndex");
        mav.addObject("Logros", logros);
        mav.addObject("Errores", Errores);
        mav.addObject("id", request.getParameter("id"));
        return mav;
    }
    
    @RequestMapping(value = "LogrosEdit.htm", method = RequestMethod.GET)
    public ModelAndView LogrosEdit(HttpServletRequest request) {
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/Logros/LogrosEdit");
        
        BigDecimal id = BigDecimal.valueOf(Double.valueOf(request.getParameter("id")));
        
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call ObtenerLogro(?,?,?)}");
            cst.setBigDecimal(1, id);
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.DATE);
            cst.execute();
            Logros logro = new Logros();
            logro.setIdLogros(id);
            logro.setLugar(cst.getString(2));
            logro.setFecha(cst.getDate(3));
            cn.close();
            mav.addObject("logro", logro);
            //resultado = 1;
            return mav;
        } catch (SQLException ex) {
            mav.addObject("Error", "Error al cerrar conexion o ejecutar "+ex.toString());
            return mav;
        }
        //return mav;
    }
    
    @RequestMapping(value = "LogrosEdit.htm", method = RequestMethod.POST)
    public ModelAndView LogrosEditPost(
            HttpServletRequest request,
            @ModelAttribute("logro") Logros l,
            BindingResult result,
            SessionStatus status
    ) {
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/Logros/LogrosEdit");
        
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call ActualizarLogro(?,?)}");
            
            cst.setInt(1, Integer.valueOf(request.getParameter("id")));
            cst.setString(2, l.getLugar());
            cst.execute();
            cn.close();
            //resultado = 1;
             return new ModelAndView("redirect:" + "LogrosIndex.htm?id="+request.getParameter("id2"));
        } catch (SQLException ex) {
            mav.addObject("Error", "Error al cerrar conexion o ejecutar "+ex.toString());
            return mav;
        }
        //return mav;
    }
    @RequestMapping(value = "LogrosDelete.htm", method = RequestMethod.GET)
    public ModelAndView LogrosDelete(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/Logros/LogrosIndex");
        String id = request.getParameter("id");
        
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call EliminarLogro(?)}");
            
            cst.setInt(1, Integer.valueOf(request.getParameter("id")));
            cst.execute();
            cn.close();
            //resultado = 1;
            return new ModelAndView("redirect:" + "LogrosIndex.htm?id="+request.getParameter("id2"));
        } catch (SQLException ex) {
            mav.addObject("Errores", "Error al cerrar conexion o ejecutar "+ex.toString());
            return mav;
        }
        
    }
}

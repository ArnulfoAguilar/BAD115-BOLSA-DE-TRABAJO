
package Controlador;

import Entidad.Logros;
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
import java.time.LocalDate;

/**
 *
 * @author Kevin Posada Alegría
 */
public class LogrosController {
    
    @RequestMapping(value = "LogrosAdd.htm", method = RequestMethod.GET)
    public ModelAndView LogrosAdd(ModelMap model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Logros/LogrosAdd");
        model.addAttribute("logro", new Logros());
        return mav;
    }
    
    @RequestMapping(value = "LogrosAdd.htm", method = RequestMethod.POST)
    public ModelAndView LogrosAddPost(@ModelAttribute("candidato") Logros l,
                             BindingResult result,
                             SessionStatus status,
                             ModelMap model) 
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Logros/LogrosAdd");
        int resultado = 0;
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call InsertLogro(?)}");
            cst.setString(1, l.getLugar());
            cst.execute();
            resultado = 1;
        } catch (SQLException ex) {
            model.addAttribute("Error", "Error al ejecutar "+ex.toString());
        } finally {
            try {
                cn.close();
                String estadoConexion = "Conexion cerrada";
                model.addAttribute("EstadoConexion", estadoConexion);
            } catch (SQLException ex) {
                String estadoConexion = ex.toString();
                estadoConexion += " No se pudo cerrar la conexion";
                model.addAttribute("EstadoConexion", estadoConexion);
            }
        }
        if (resultado == 1) {
            return new ModelAndView("redirect:/CandidatoIndex.htm");
            
        } else {

            return new ModelAndView("redirect:/Home.htm");
        }
    }
}

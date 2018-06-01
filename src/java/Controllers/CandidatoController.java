package Controllers;

import Entidad.Candidato;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CandidatoController {

    @RequestMapping(value = "RegistroCandidato.htm", method = RequestMethod.GET)
    public ModelAndView RegistroCandidatoHome() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidato/RegistroCandidato");
        mav.addObject("candidato", new Candidato());
        return mav;
    }

    @RequestMapping(value = "Exito.htm", method = RequestMethod.GET)
    public ModelAndView Exito() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidato/Exito");
        return mav;
    }

    @RequestMapping(value = "RegistroCandidato.htm", method = RequestMethod.POST)
    public ModelAndView RegistroCandidatoHomePOST(
            @ModelAttribute("candidato") Candidato c,
            BindingResult result,
            SessionStatus status
    ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidato/RegistroCandidato");

        Integer resultado = 0;
        String error = null;

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Connection cn = null;
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call InsertCandidato(?,3,?,?,?,'','','','','')}");
            // Parametro 1 del procedimiento almacenado

            cst.setString(1, c.getIdPostDoc());
            cst.setString(2, c.getPrimerNombre());
            cst.setString(3, c.getSegundoNombre());
            cst.setString(4, c.getTercerNombre());

            // Ejecuta el procedimiento almacenado
            cst.execute();
            resultado = 1;
            mav.addObject("Resultado", resultado);
        } catch (SQLException ex) {
            error = ex.toString();
            mav.addObject("Error", error);
            mav.addObject("Resultado", resultado);

        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                error = ex.toString();
                error += " No se pudo cerrar la conexion";
                mav.addObject("Error", error);
            }
        }
        if (resultado == 1) {
            return new ModelAndView("redirect:/Exito.htm");
        } else {
            return mav;
        }
    }

    @RequestMapping(value = "PerfilCandidato.htm")
    public ModelAndView Perfil() {
        ModelAndView MV = new ModelAndView();
        MV.setViewName("PerfilCandidato");
        return MV;
    }

    @RequestMapping(value = "CandidatoIndex.htm", method = RequestMethod.GET)
    public ModelAndView CandidatoIndex() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidato/CandidatoIndex");
        return mav;
    }

}

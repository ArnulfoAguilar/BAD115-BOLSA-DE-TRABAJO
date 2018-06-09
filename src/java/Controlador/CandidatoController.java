package Controlador;

import Entidad.Candidato;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CandidatoController {

    private JdbcTemplate jdbcTemplate;

    public CandidatoController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    @RequestMapping(value = "RegistroCandidato.htm")
    public ModelAndView RegistroCandidatoHome() {
        ModelAndView MV = new ModelAndView();
        MV.setViewName("RegistroCandidato");
        return MV;
    }

    @RequestMapping(value = "CandidatoAdd.htm", method = RequestMethod.GET)
    public ModelAndView CandidatoAdd(ModelMap model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/CandidatoAdd");
        model.addAttribute("candidato", new Candidato());
        return mav;
    }
    
    @RequestMapping(value = "CandidatoAdd.htm", method = RequestMethod.POST)
    public ModelAndView CandidatoAddPost(
            @ModelAttribute("candidato") Candidato c,
                             BindingResult result,
                             SessionStatus status,
                             ModelMap model
    ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/CandidatoAdd");
        Integer resultado=0;
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call InsertCandidato(?,?,?,?,?,?,?,?)}");
            cst.setString(1, c.getIdPostDoc());
            cst.setString(2, c.getPrimerNombre());
            cst.setString(3, c.getSegundoNombre());
            cst.setString(4, c.getTercerNombre());
            cst.setString(5, c.getPrimerApellido());
            cst.setString(6, c.getSegundoApellido());
            cst.setString(7, c.getCasadaApellido());
            cst.setString(8, c.getDireccion());
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
        //ModelAndView mav = new ModelAndView();
        //mav.setViewName("CandidatoAdd");
        
    }

    @RequestMapping(value = "CandidatoIndex.htm", method = RequestMethod.GET)
    public ModelAndView CandidatoIndex(ModelMap model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/CandidatoIndex");
        String sql = "SELECT * FROM CANDIDATO";
        List ERRORES = null;
        List CANDIDATOS = null;
        try {
            CANDIDATOS = this.jdbcTemplate.queryForList(sql);
        } catch (Exception ex) {
            ERRORES.add("Error. No hay acceso a la BD" + ex.toString());
        }
        model.addAttribute("CANDIDATOS", CANDIDATOS);
        model.addAttribute("ERRORES", ERRORES);
        return mav;
    }

    @RequestMapping(value = "PerfilCandidato.htm", method = RequestMethod.GET)
    public ModelAndView Perfil(HttpServletRequest request, ModelMap model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("PerfilCandidato");
        String id = request.getParameter("id");

        Integer resultado = 0;
        String estadoConexion = null;
        String p = "Esto es una prueba fuera del TRY";
        model.addAttribute("Prueba", p);
        
        Connection cn = null;
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call ObtenerCandidato(?,?,?,?,?,?,?,?)}");
            // Parametro 1 del procedimiento almacenado
            cst.setString(1, id);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            cst.registerOutParameter(4, java.sql.Types.VARCHAR);
            cst.registerOutParameter(5, java.sql.Types.VARCHAR);
            cst.registerOutParameter(6, java.sql.Types.VARCHAR);
            cst.registerOutParameter(7, java.sql.Types.VARCHAR);
            cst.registerOutParameter(8, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            resultado = 1;
            // Se obtienen la salida del procedimineto almacenado
            Candidato cand = new Candidato();
            cand.setPrimerNombre(cst.getString(2));
            cand.setSegundoNombre(cst.getString(3));
            cand.setTercerNombre(cst.getString(4));
            cand.setPrimerApellido(cst.getString(5));
            cand.setSegundoApellido(cst.getString(6));
            cand.setCasadaApellido(cst.getString(7));
            cand.setDireccion(cst.getString(8));

            model.addAttribute("candidato", cand);
            //mav.addObject("candidato", cand);

        } catch (SQLException ex) {
            model.addAttribute("Error", "Error al ejecutar "+ex.toString());
            model.addAttribute("Resultado", resultado);
        } finally {
            try {
                estadoConexion = "Conexion cerrada";
                model.addAttribute("EstadoConexion", estadoConexion);
                cn.close();
            } catch (SQLException ex) {
                estadoConexion = ex.toString();
                estadoConexion += " No se pudo cerrar la conexion";
                model.addAttribute("EstadoConexion", estadoConexion);
            }
        }
        if (resultado == 1) {
            return mav;
        } else {

            return new ModelAndView("redirect:/Home.htm");
        }
    }

}

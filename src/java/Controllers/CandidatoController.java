package Controllers;

import Entidad.Candidato;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
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
        Conectar con= new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }

    @RequestMapping(value = "CandidatoIndex.htm", method = RequestMethod.GET)
    public ModelAndView CandidatoIndex() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidato/CandidatoIndex");
        String sql = "select * from CANDIDATO";
        List<String> ERRORES = new ArrayList<>();
        List CANDIDATOS = null;
        try{
            CANDIDATOS = this.jdbcTemplate.queryForList(sql);
        }catch(Exception ex){
            ERRORES.add("Error");
            ERRORES.add("No hay acceso a la base");
            ERRORES.add(ex.toString());
        }
        mav.addObject("CANDIDATOS", CANDIDATOS);
        mav.addObject("ERRORES", ERRORES);
        return mav;
    }
    
    @RequestMapping(value = "Exito.htm", method = RequestMethod.GET)
    public ModelAndView Exito() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidato/Exito");
        return mav;
    }
    
    @RequestMapping(value = "RegistroCandidato.htm", method = RequestMethod.GET)
    public ModelAndView RegistroCandidatoHome() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidato/RegistroCandidato");
        mav.addObject("candidato", new Candidato());
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

    @RequestMapping(value = "PerfilCandidato.htm", method=RequestMethod.GET)
    public ModelAndView Perfil(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidato/PerfilCandidato");
        String id = request.getParameter("id");
        
        String error = null;
        Integer resultado = 0;
        String estadoConexion = null;
        
        Connection cn = null;
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call ObtenerCandidato(?,?,?,?,?,?,?,?,?)}");
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
            cst.registerOutParameter(9, java.sql.Types.VARCHAR);
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
            cand.setEmail(cst.getString(9));  
            
            mav.addObject("candidato", cand);
            
        } catch (SQLException ex) {
            error = "pendejo"+ex.toString();
            mav.addObject("Error", error);
            mav.addObject("Resultado", resultado);
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                estadoConexion = ex.toString();
                estadoConexion += " No se pudo cerrar la conexion";
                mav.addObject("EstadoConexion", estadoConexion);
            }
        }
        if (resultado == 1) {
            return mav;
        } else {
           
            return new ModelAndView("redirect:/Home.htm");
        }
        
    }
    
    @RequestMapping(value = "PerfilCandidato.htm", method=RequestMethod.POST)
    public ModelAndView PerfilPOST(
            HttpServletRequest request,
            @ModelAttribute("candidato") Candidato c,
            BindingResult result,
            SessionStatus status)
    {
        if (c==null){}else{}
        //REALIZAR LA VERIFICACION DE QUE DATOS VIENEN VACIOS Y QUE VIENE LLENO PARA REALIZAR EL INSERT DE ESE DATO
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidato/PerfilCandidato");
        String id = request.getParameter("id");
        
        String error = null;
        Integer resultado = 0;
        String estadoConexion = null;
        
        Connection cn = null;
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call ObtenerCandidato(?,?,?,?,?,?,?,?,?)}");
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
            cst.registerOutParameter(9, java.sql.Types.VARCHAR);
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
            cand.setEmail(cst.getString(9));  
            
            mav.addObject("candidato", cand);
            
        } catch (SQLException ex) {
            error = "pendejo"+ex.toString();
            mav.addObject("Error", error);
            mav.addObject("Resultado", resultado);
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                estadoConexion = ex.toString();
                estadoConexion += " No se pudo cerrar la conexion";
                mav.addObject("EstadoConexion", estadoConexion);
            }
        }
        if (resultado == 1) {
            return mav;
        } else {
           
            return new ModelAndView("redirect:/Home.htm");
        }
        
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Empresa;
import Entidad.Reclutador;
import Entidad.TipoEmpresa;
import Entidad.Usuarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Arnulfo
 */
@Controller
public class LoginController {
    
    
    private JdbcTemplate jdbcTemplate;
    
    public LoginController()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    
    
     @RequestMapping(value="login.htm", method=RequestMethod.GET)
    public ModelAndView login()
    {  
       return new ModelAndView("LogIn/LogIn");
    }
    
    
    
     @RequestMapping(value="signup.htm", method=RequestMethod.GET)
    public ModelAndView signup()
    {  
    ModelAndView mav=new ModelAndView();
        /*String sql="select * from tipo_empresa order by id_tipo_emp desc";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);*/
        
        mav.addObject("reclutador",new Reclutador());
        mav.addObject("empresa",new Empresa());
        mav.setViewName("LogIn/SignUp");
        return mav;

    }
    
     /*@RequestMapping(value="signup.htm",method=RequestMethod.POST)
    public ModelAndView signup(
              @ModelAttribute("empresa") Empresa e,
                @ModelAttribute("reclutador") Reclutador r,
                BindingResult result,
                SessionStatus status
    ){
    
       this.jdbcTemplate.update
        (
        "insert into EMPRESA (NIT,  ) values (?)",
         e.getNit()
        );
       this.jdbcTemplate.update("insert into Reclutador (DUI) values (?)",
            r.getDui()
               );
         return new ModelAndView("redirect:/index.htm");
       
    } 


    @RequestMapping(value="signup.htm",method=RequestMethod.POST)
    public ModelAndView basicForm
        (
            @RequestParam("giroEmpresa") int giroEmpresa,
            @RequestParam("departamentoEmpresa") int departamentoEmpresa,
            @RequestParam("municipioEmpresa") int municipioEmpresa,
            @RequestParam("tipoEmpresa") int tipoEmpresa,
            @RequestParam("emailUsuario") String emailUsuario,
            @RequestParam("passwUsuario") String passwUsuario,
            @RequestParam("nombreEmpresa") String nombreEmpresa,
            @RequestParam("razonSocial") String razonSocial,
            @RequestParam("nitEmpresa") String nitEmpresa,
            @RequestParam("direccionEmpresa") String direccionEmpresa,
            @RequestParam("descripcionEmpresa") String descripcionEmpresa,
            @RequestParam("paginaWeb") String paginaWeb,
            @RequestParam("duiReclutador") String duiReclutador,
            @RequestParam("nombresReclutador") String nombresReclutador,
            @RequestParam("apellidosReclutador") String apellidosReclutador,
            @RequestParam("telefonoReclutador") String telefonoReclutador
        ) {
            
            //INSERTAR USUARIO
            this.jdbcTemplate.update
            (
                "insert into Usuarios values (?,?,?)",
                1,emailUsuario, passwUsuario
            );
            
             //INSERTAR RECLUTADOR
            this.jdbcTemplate.update("insert into Reclutador values (?,?,?,?)",
                duiReclutador,nombresReclutador,apellidosReclutador,telefonoReclutador
            );
            //INSERTAR EMPRESA
            this.jdbcTemplate.update
            (
                "insert into EMPRESA values (?,?,?,?,?,?,?,?,?,?,?,?,?)",
                nitEmpresa,tipoEmpresa,giroEmpresa,duiReclutador
                , 1,municipioEmpresa,departamentoEmpresa,razonSocial,
                nombreEmpresa,direccionEmpresa,descripcionEmpresa,
                paginaWeb,emailUsuario
            );
            
            
           
        
            return new ModelAndView("redirect:/index.htm"); 
    }*/
    

    
    @RequestMapping(value="signup.htm",method=RequestMethod.POST)
    public ModelAndView basicForm
        (
            @RequestParam("nitEmpresa") String NIT,
            @RequestParam("tipoEmpresa") int ID_TIPO_EMP,
            @RequestParam("giroEmpresa") int ID_GIRO,
            @RequestParam("duiReclutador") String DUI,
            @RequestParam("emailUsuario") String EMAIL_USUARIO,
            @RequestParam("passwUsuario") String PASSWORD,
            @RequestParam("municipioEmpresa") int ID_MUNI,
            @RequestParam("departamentoEmpresa") int ID_DEPTO,
            @RequestParam("razonSocial") String RAZON_SOCIAL,
            @RequestParam("nombreEmpresa") String NOMBRE_COMERCIAL,
            @RequestParam("direccionEmpresa") String UBICACION,
            @RequestParam("descripcionEmpresa") String DESCRIPCION,
            @RequestParam("paginaWeb") String PAGINA_WEB,
            @RequestParam("nombresReclutador") String NOMBRES,
            @RequestParam("apellidosReclutador") String APELLIDOS,
            @RequestParam("telefonoReclutador") String TELEFONO
        ) {
            int resultado=0;
            Connection cn = null;
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BOLSA_TRABAJO", "bolsa_trabajo");
// Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call INSERTAR_EMPRESA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            // Parametro 1 del procedimiento almacenado
            cst.setString(1,NIT );
            cst.setInt(2,ID_TIPO_EMP);
            cst.setInt(3,ID_GIRO );
            cst.setString(4,DUI );
            cst.setString(5,EMAIL_USUARIO);
            cst.setString(6,PASSWORD );
            cst.setInt(7, ID_MUNI);
            cst.setInt(8, ID_DEPTO);
            cst.setString(9,RAZON_SOCIAL );
            cst.setString(10, NOMBRE_COMERCIAL);
            cst.setString(11, UBICACION);
            cst.setString(12,DESCRIPCION );
            cst.setString(13,PAGINA_WEB );
            cst.setString(14,EMAIL_USUARIO );
            cst.setString(15, NOMBRES);
            cst.setString(16, APELLIDOS);
            cst.setString(17, TELEFONO);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            resultado=1;

        } catch (SQLException ex) {
            resultado=0;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                
            }
        }
        if (resultado == 1) {
            return new ModelAndView("redirect:/index.htm");
        } else {
            return new ModelAndView("ERROR");
}
            
    }
}

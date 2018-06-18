
package Controlador.Empresa;

import Controlador.Conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ActualizarEmpresaController {
    
    private JdbcTemplate jdbcTemplate;
    
    public ActualizarEmpresaController()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(value="EMPRESA/actualizar_Empresa.htm", method=RequestMethod.GET)
    public ModelAndView traerdatos()
    {  
        ModelAndView mav=new ModelAndView();
        
        //LISTA DE GIRO EMPRESA
        String SELECT_Empresasql="select NIT,ID_TIPO_EMP,ID_GIRO,RE.DUI,ID_MUNI,EM.ID_DEPTO,\n" +
            "RAZON_SOCIAL, NOMBRE_COMERCIAL,UBICACION,DESCRIPCION,\n" +
            "PAGINA_WEB, EMAIL, NOMBRES,APELLIDOS,TELEFONO from EMPRESA em, RECLUTADOR re\n" +
            "where EM.DUI=RE.DUI";
        List SELECT_EMPRESA=this.jdbcTemplate.queryForList(SELECT_Empresasql);
        mav.addObject("SELECT_EMPRESA",SELECT_EMPRESA);
        mav.setViewName("EMPRESA/actualizar_Empresa");
        return mav;

    }
    
    
    @RequestMapping(value="EMPRESA/actualizar_Empresa.htm", method=RequestMethod.POST)
    public ModelAndView actualizar(

            //@RequestParam("duiReclutador") String DUI,
            @RequestParam("razonSocial") String RAZON_SOCIAL,
            @RequestParam("nombreEmpresa") String NOMBRE_COMERCIAL,
            @RequestParam("direccionEmpresa") String UBICACION,
            @RequestParam("descripcionEmpresa") String DESCRIPCION,
            @RequestParam("paginaWeb") String PAGINA_WEB,
            @RequestParam("nombresReclutador") String NOMBRES,
            @RequestParam("apellidosReclutador") String APELLIDOS,
            @RequestParam("telefonoReclutador") String TELEFONO
    ) throws SQLException {
            int resultado=0;
            Connection cn = null;
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "BOLSA_TRABAJO", "bolsa_trabajo");
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call ACTUALIZAR_EMPRESA(?,?,?,?,?,?,?,?)}");
            // Parametro 1 del procedimiento almacenado
            cst.setString(1,RAZON_SOCIAL );
            cst.setString(2, NOMBRE_COMERCIAL);
            cst.setString(3, UBICACION);
            cst.setString(4,DESCRIPCION );
            cst.setString(5,PAGINA_WEB );
            cst.setString(6, NOMBRES);
            cst.setString(7, APELLIDOS);
            cst.setString(8, TELEFONO);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            resultado=1;
        } catch (SQLException ex) {
            resultado=0;
        } finally {
          try {
                cn.close();
            } catch (SQLException ex) {
                cn.close();
            }
        }
        if (resultado == 1) {
            return new ModelAndView("redirect:/index.htm");
        } else {
            return new ModelAndView("ERROR");
}
            
    }
}

    



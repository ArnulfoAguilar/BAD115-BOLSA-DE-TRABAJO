
package Controlador.Empresa;

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
import Controlador.Conectar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class SignupEmpresaController {
       private JdbcTemplate jdbcTemplate;
    
    public SignupEmpresaController()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
      @RequestMapping(value="signup.htm", method=RequestMethod.GET)
    public ModelAndView signup()
    {  
    ModelAndView mav=new ModelAndView();
    
        //LISTA DE TIPO EMPRESA
        String tipo_Empresasql="select ID_TIPO_EMP,NOMBRE_TIPO_EMP from tipo_empresa order by id_tipo_emp asc";
        List tipo_Empresa=this.jdbcTemplate.queryForList(tipo_Empresasql);
        mav.addObject("tipo_Empresa",tipo_Empresa);
        
        //LISTA DE MUNICIPIOS
        String Municipiosql="select MUNICIPIO.ID_MUNI,MUNICIPIO.NOMBRE_MUNI  from MUNICIPIO order by ID_MUNI asc";
        List Municipio=this.jdbcTemplate.queryForList(Municipiosql);
        mav.addObject("Municipio",Municipio);
        
        
        //LISTA DE DEPARTAMENTOS
        String Departamentosql="select DEPARTAMENTO.ID_DEPTO,DEPARTAMENTO.NOMBRE_DEPTO  from DEPARTAMENTO order by ID_DEPTO asc";
        List Departamento=this.jdbcTemplate.queryForList(Departamentosql);
        mav.addObject("Departamento",Departamento);
        
        //LISTA DE GIRO EMPRESA
        String giro_Empresasql="select ID_GIRO, NOMBRE_GIRO from GIRO_EMPRESA order by 1";
        List giro_Empresa=this.jdbcTemplate.queryForList(giro_Empresasql);
        mav.addObject("giro_Empresa",giro_Empresa);
        mav.setViewName("LogIn/SignUp");
        return mav;

    }
    
    @RequestMapping(value="signup.htm",method=RequestMethod.POST)
    public ModelAndView basicForm
        (
            @RequestParam("nitEmpresa") String NIT,
            @RequestParam("tipoEmpresa") String ID_TIPO_EMP,
            @RequestParam("giro_Empresa") int ID_GIRO,
            @RequestParam("duiReclutador") String DUI,
            @RequestParam("emailUsuario") String EMAIL_USUARIO,
            @RequestParam("passwUsuario") String PASSWORD,
            @RequestParam("municipioEmpresa") String ID_MUNI,
            @RequestParam("departamentoEmpresa") String ID_DEPTO,
            @RequestParam("razonSocial") String RAZON_SOCIAL,
            @RequestParam("nombreEmpresa") String NOMBRE_COMERCIAL,
            @RequestParam("direccionEmpresa") String UBICACION,
            @RequestParam("descripcionEmpresa") String DESCRIPCION,
            @RequestParam("paginaWeb") String PAGINA_WEB,
            @RequestParam("nombresReclutador") String NOMBRES,
            @RequestParam("apellidosReclutador") String APELLIDOS,
            @RequestParam("telefonoReclutador") String TELEFONO,
            HttpServletRequest hrequest,
            HttpServletResponse hresponse
        ) throws SQLException {
            int resultado=0;
            Connection cn = null;
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call INSERTAR_EMPRESA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            // Parametro 1 del procedimiento almacenado
            cst.setString(1,NIT );
            cst.setInt(2,Integer.parseInt(ID_TIPO_EMP));
            cst.setInt(3,ID_GIRO );
            cst.setString(4,DUI );
            cst.setString(5,EMAIL_USUARIO);
            cst.setString(6,PASSWORD );
            cst.setInt(7,Integer.parseInt(ID_MUNI) );
            cst.setInt(8, Integer.parseInt(ID_DEPTO));
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
            System.out.println(ex.toString());
        } 
         ModelAndView v = new ModelAndView();
        if (resultado == 1) { 
                HttpSession session = hrequest.getSession();
                session.setAttribute("DOC", NIT);
                session.setAttribute("USERNAME", EMAIL_USUARIO);
                v.setViewName("redirect:/EMPRESA/homeEmpresa.htm");
        } else {
            v.setViewName("LogIn/LogIn");
        }
        return v;
            
    }
}

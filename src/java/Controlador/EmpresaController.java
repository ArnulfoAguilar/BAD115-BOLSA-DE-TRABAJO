/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Empresa;
import static antlr.Utils.error;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Arnulfo
 */
@Controller
public class EmpresaController 
{
    private JdbcTemplate jdbcTemplate;
    
    public EmpresaController(){
         Conectar con= new Conectar();
         this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    
    @RequestMapping(value="Empresa.htm", method=RequestMethod.GET)
    public ModelAndView empresaHome()
    {  
       return new ModelAndView("Empresa","comand",new Empresa());
    }
    
    
    /* @RequestMapping(value="Empresa.htm",method=RequestMethod.POST)
    public ModelAndView empresaHome(
             @ModelAttribute("empresa") Empresa e,
                BindingResult result,
                SessionStatus status
    ){
    
       this.jdbcTemplate.update
        (
        "insert into EMPRESA (NIT, RAZON_SOCIAL,  ID_GIRO ) values (?,?,?)",
         e.getNit(),e.getRazonSocial(),e.getGiroEmpresa()
        );
         return new ModelAndView("redirect:/index.htm");
       
    } */
    @RequestMapping(value="Empresa.htm",method=RequestMethod.POST)
    public ModelAndView empresaHomeProcedure(
            @ModelAttribute("empresa") Empresa e,
                BindingResult result,
                SessionStatus status
    ){
          Connection cn = null;
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl", "BOLSA_TRABAJO", "bolsa_trabajo");
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call insertar_empresa (?,'','','','','','','','','')}");
                // Parametro 1 del procedimiento almacenado
                cst.setString(1,e.getNit());
                 
                //cst.setInt(1, 3);
                // Definimos los tipos de los parametros de salida del procedimiento almacenado
                //cst.registerOutParameter(2, java.sql.Types.VARCHAR);
                //cst.registerOutParameter(3, java.sql.Types.DATE);
                // Ejecuta el procedimiento almacenado
                cst.execute();
                // Se obtienen la salida del procedimineto almacenado
                
        } catch (SQLException ex) {
              String error = ex.toString();
          
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidad.Oferta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Juan Murcia
 */
public class OfertaEmpleoController {
    
    private JdbcTemplate jdbcTemplate;
    
    public OfertaEmpleoController(){
         Conectar con= new Conectar();
         this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(value="OfertaEmpleo.htm", method=RequestMethod.GET)
    public ModelAndView ofertaHome()
    {  
       return new ModelAndView("Oferta","comand",new Oferta());
    }
        
    @RequestMapping(value="Oferta.htm",method=RequestMethod.POST)
    public ModelAndView ofertaHomeProcedure(
            @ModelAttribute("oferta") Oferta o,
                BindingResult result,
                SessionStatus status
    ){
          Connection cn = null;
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "gm13021", "gm13021");
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call insertar_oferta (?,'','','','','','','','','')}");
                // Parametro 1 del procedimiento almacenado
                cst.setString(1,o.toString());
                 
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Modelo.Conectar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin Posada Alegría
 */
@Controller
public class HomeController {
    
    private JdbcTemplate jdbcTemplate;

    public HomeController() {
        this.jdbcTemplate = new JdbcTemplate(Conectar.conectar());
    }
    
    @RequestMapping(value="Indice.htm",method=RequestMethod.GET)
    public ModelAndView Indice(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Indice");
        return mav;
    }
    @RequestMapping(value="Home.htm",method=RequestMethod.GET)
    public ModelAndView Home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Home");
        return mav;
    }
    
    @RequestMapping(value="Prueba1.htm",method=RequestMethod.GET)
    public ModelAndView Prueba1(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Pruebas/Prueba1");
      
        String error=null;
        
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Connection cn = null;
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call ObtenerDatosLogros (?,?,?)}");
                // Parametro 1 del procedimiento almacenado
                cst.setInt(1, 3);
                // Definimos los tipos de los parametros de salida del procedimiento almacenado
                cst.registerOutParameter(2, java.sql.Types.VARCHAR);
                cst.registerOutParameter(3, java.sql.Types.DATE);
                // Ejecuta el procedimiento almacenado
                cst.execute();
                // Se obtienen la salida del procedimineto almacenado
                String lugar = cst.getString(2);
                mav.addObject("Lugar", lugar);
                String fecha = String.valueOf(cst.getDate(3));
                mav.addObject("Fecha", fecha);
        } catch (SQLException ex) {
           error =  ex.toString();
           mav.addObject("Error", error);
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
               error =  ex.toString();
               mav.addObject("Error", error);
            }
        }
        return mav;
    }   
}

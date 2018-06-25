/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Articulo;
import Entidad.ExperienciaLaboral;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.jdbc.core.JdbcTemplate;
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
 * @author Juan Murcia
 */
@Controller
public class ExperienciaController {
   
    
    private JdbcTemplate jdbcTemplate;

    public ExperienciaController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(value = "ExperienciaIndex.htm", method = RequestMethod.GET)
    public ModelAndView ExperienciaIndex(
       
            HttpServletResponse hresponse,
            HttpServletRequest request
    ) {
        List experiencias = null;
        List Errores = null;
        try {
            experiencias = this.jdbcTemplate.queryForList("select * from EXPERIENCIA_LABORAL where ID_POST_DOC = "+request.getParameter("id"));
        } catch (Exception ex) {
            Errores.add("Error. No hay acceso a la BD" + ex.toString());
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/ExperienciaLaborales/ExperienciaIndex");
        mav.addObject("Experiencia_Laboral", experiencias);
        mav.addObject("Errores", Errores);
        mav.addObject("id", request.getParameter("id"));
        return mav;
    }
    
    @RequestMapping(value = "ExperienciaAdd.htm", method = RequestMethod.GET)
    public ModelAndView ExperienciaAdd(
            HttpServletResponse hresponse,
            HttpServletRequest request
    ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/ExperienciaLaborales/ExperienciaAdd");
        mav.addObject("experiencia", new ExperienciaLaboral());
        String id = request.getParameter("id");
        mav.addObject("identificador", id);
        return mav;
    }
    
    @RequestMapping(value = "ExperienciaAdd.htm", method = RequestMethod.POST)
    public ModelAndView ExperienciaAddPost(
            HttpServletResponse hresponse,
            HttpServletRequest request,
            @ModelAttribute("experiencia") ExperienciaLaboral a,
            BindingResult result,
            SessionStatus status,
            ModelMap model
    ) 
    {
        String id = request.getParameter("id");
        ModelAndView mav = new ModelAndView("Errores/Error");
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_INSERT_EXPERIENCIA(?,?,?,?,?)}");
            cst.setString(1, id);
            cst.setString(2, a.getOrganizacion());
            cst.setString(3, a.getCargoCandidato());
            cst.setString(4, a.getFunciones());
            cst.setDate(5, (Date) a.getFechaInicio());
            cst.setDate(6, (Date) a.getFechaFin());
            cst.execute();
            cn.close();
            return new ModelAndView("redirect:" + "ExperienciaIndex.htm?id="+id);
        } catch (SQLException ex) {
            model.addAttribute("Errores", "Error al cerrar conexion o ejecutar "+ex.toString());
            return new ModelAndView("redirect:/Error.htm");
        }
        
    }
    
    @RequestMapping(value = "ExperienciaEdit.htm", method = RequestMethod.GET)
    public ModelAndView ExperienciaEdit(
            HttpServletResponse hresponse,
            HttpServletRequest request
    ) {
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/ExperienciaLaborales/ExperienciaEdit");
        
        BigDecimal id = BigDecimal.valueOf(Double.valueOf(request.getParameter("id")));
        
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_ACTUALIZAR_EXPERIENCIA(?,?,?,?,?,?)}");
            cst.setBigDecimal(1, id);
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            cst.registerOutParameter(4, java.sql.Types.VARCHAR);
            cst.registerOutParameter(5, java.sql.Types.DATE);
            cst.registerOutParameter(6, java.sql.Types.DATE);
            cst.execute();
            ExperienciaLaboral exp = new ExperienciaLaboral();
            exp.setIdExperiencia(id);
            exp.setOrganizacion(cst.getString(2));
            exp.setCargoCandidato(cst.getString(3));
            exp.setFunciones(cst.getString(4));
            exp.setFechaInicio(cst.getDate(5));
            exp.setFechaFin(cst.getDate(6));
            cn.close();
            mav.addObject("experiencia", exp);
            //resultado = 1;
            return mav;
        } catch (SQLException ex) {
            mav.addObject("Error", "Error al cerrar conexion o ejecutar "+ex.toString());
            return mav;
        }
        //return mav;
    }
    
    @RequestMapping(value = "ExperienciaEdit.htm", method = RequestMethod.POST)
    public ModelAndView ExperienciaEditPost(
            HttpServletResponse hresponse,
            HttpServletRequest request,
            @ModelAttribute("experiencia") ExperienciaLaboral a,
            BindingResult result,
            SessionStatus status
    ) {
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/ExperieciaLaborales/ExperienciaEdit");
        
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_ACTUALIZAR_ARTICULO(?,?,?,?,?,?)}");
            
            cst.setInt(1, Integer.valueOf(request.getParameter("id")));
            cst.setString(2, request.getParameter("id2"));
            cst.setString(3, a.getOrganizacion());
            cst.setString(4, a.getCargoCandidato());
            cst.setString(5, a.getFunciones());
            cst.setDate(6, (Date) a.getFechaInicio());
            cst.setDate(7, (Date) a.getFechaFin());
            cst.execute();
            cn.close();
            //resultado = 1;
             return new ModelAndView("redirect:" + "ExeIndex.htm?id="+request.getParameter("id2"));
        } catch (SQLException ex) {
            mav.addObject("Error", "Error al cerrar conexion o ejecutar "+ex.toString());
            return mav;
        }
        //return mav;
    }
    @RequestMapping(value = "ExperienciaDelete.htm", method = RequestMethod.GET)
    public ModelAndView ExperienciaDelete(HttpServletResponse hresponse,
            HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Candidatos/ExperienciaLaborales/ExperienciaIndex");
        String id = request.getParameter("id");
        
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_ELIMINAR_EXPERIENCIA(?)}");
            
            cst.setInt(1, Integer.valueOf(request.getParameter("id")));
            cst.execute();
            cn.close();
            //resultado = 1;
            return new ModelAndView("redirect:" + "ExperienciaIndex.htm?id="+request.getParameter("id2"));
        } catch (SQLException ex) {
            mav.addObject("Errores", "Error al cerrar conexion o ejecutar "+ex.toString());
            return mav;
        }
        
    }
}



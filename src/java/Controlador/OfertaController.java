/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Articulo;
import Entidad.Aspirante;
import Entidad.Oferta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OfertaController {
    private JdbcTemplate jdbcTemplate;

    public OfertaController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(value = "OfertaIndex.htm", method = RequestMethod.GET)
    public ModelAndView OfertaIndex(
            HttpServletResponse hresponse,
            HttpServletRequest request
    ) {
        List ofertas = null;
        List Errores = null;
        HttpSession session=request.getSession();
        String DOC=(String)session.getAttribute("DOC");
        String USER =(String)session.getAttribute("USERNAME");
        String NombreRol =(String)session.getAttribute("nombre_rol");
        session.setAttribute("USERNAME", USER);
        session.setAttribute("NombreRol", NombreRol);
        session.setAttribute("DOC", DOC);
        try {
            String sql="select * from OFERTA";
            ofertas = this.jdbcTemplate.queryForList(sql);
        } catch (Exception ex) {
            Errores.add("Error. No hay acceso a la BD" + ex.toString());
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Ofertas/OfertaIndex");
        mav.addObject("Ofertas", ofertas);
        mav.addObject("Errores", Errores);
        mav.addObject("id", request.getParameter("id"));
        return mav;
    }
    
    @RequestMapping(value = "OfertaAdd.htm", method = RequestMethod.GET)
    public ModelAndView ArticuloAdd(
            HttpServletResponse hresponse,
            HttpServletRequest request
    ) {
        ModelAndView mav = new ModelAndView();
         HttpSession session=request.getSession();
        String DOC=(String)session.getAttribute("DOC");
        String USER =(String)session.getAttribute("USERNAME");
        String NombreRol =(String)session.getAttribute("nombre_rol");
        session.setAttribute("USERNAME", USER);
        session.setAttribute("NombreRol", NombreRol);
        session.setAttribute("DOC", DOC);
        
        mav.addObject("DOC", DOC);
        mav.setViewName("Ofertas/OfertaAdd");
        mav.addObject("oferta", new Oferta());
        String id = request.getParameter("id");
        mav.addObject("identificador", id);
        List areas = null;
        List niveles = null;
        List Errores = null;
        try {
            areas = this.jdbcTemplate.queryForList("select * from AREA_DE_ESTUDIO");
            niveles = this.jdbcTemplate.queryForList("select * from NIVEL_ESTUDIO");
        } catch (Exception ex) {
            Errores.add("Error. No hay acceso a la BD" + ex.toString());
        }
        mav.addObject("Areas",areas);
        mav.addObject("Niveles",niveles);
        return mav;
    }
    
    @RequestMapping(value = "OfertaAdd.htm", method = RequestMethod.POST)
    public ModelAndView OfertaAddPost(
            HttpServletResponse hresponse,
            HttpServletRequest request,
            @ModelAttribute("oferta") Oferta o,
            BindingResult result,
            SessionStatus status,
            ModelMap model
    ) 
    {
        String id = request.getParameter("id");
        ModelAndView mav = new ModelAndView("Errores/Error");
        HttpSession session=request.getSession();
        String DOC=(String)session.getAttribute("DOC");
        String USER =(String)session.getAttribute("USERNAME");
        String NombreRol =(String)session.getAttribute("nombre_rol");
        session.setAttribute("USERNAME", USER);
        session.setAttribute("NombreRol", NombreRol);
        session.setAttribute("DOC", DOC);
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_INSERT_OFERTA(?,?,?,?,?,?,?)}");
            cst.setInt(1, o.getArea());
            cst.setInt(2, o.getNivel());
            cst.setInt(3, o.getVacantes());
            cst.setString(4, o.getDescripcion());
            cst.setString(5, o.getTipoContrato());
            cst.setDouble(6, o.getSalario());
            cst.setInt(7, o.getNit());
            cst.execute();
            cn.close();
            return new ModelAndView("redirect:" + "OfertaIndex.htm");
        } catch (SQLException ex) {
            model.addAttribute("Errores", "Error al cerrar conexion o ejecutar "+ex.toString());
            return new ModelAndView("redirect:/Error.htm");
        }
        
    }
    @RequestMapping(value = "OfertaEdit.htm", method = RequestMethod.GET)
    public ModelAndView OfertaEdit(
            HttpServletResponse hresponse,
            HttpServletRequest request
    ) {
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Ofertas/OfertaEdit");
        
        Integer id = Integer.valueOf(request.getParameter("id"));
        
        List areas = null;
        List niveles = null;
        List Errores = null;
        try {
            areas = this.jdbcTemplate.queryForList("select * from AREA_DE_ESTUDIO");
            niveles = this.jdbcTemplate.queryForList("select * from NIVEL_ESTUDIO");
        } catch (Exception ex) {
            Errores.add("Error. No hay acceso a la BD" + ex.toString());
        }
        mav.addObject("Areas",areas);
        mav.addObject("Niveles",niveles);
        
        
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_OBTENER_OFERTA(?,?,?,?,?,?,?)}");
            cst.setInt(1, id);
            cst.registerOutParameter(2, java.sql.Types.NUMERIC);
            cst.registerOutParameter(3, java.sql.Types.NUMERIC);
            cst.registerOutParameter(4, java.sql.Types.NUMERIC);
            cst.registerOutParameter(5, java.sql.Types.VARCHAR);
            cst.registerOutParameter(6, java.sql.Types.VARCHAR);
            cst.registerOutParameter(7, java.sql.Types.NUMERIC);
            cst.execute();
            Oferta ofer = new Oferta();
            ofer.setIdOf(id);
            ofer.setNivel(cst.getInt(2));
            ofer.setArea(cst.getInt(3));
            ofer.setVacantes(cst.getInt(4));
            ofer.setDescripcion(cst.getString(5));
            ofer.setTipoContrato(cst.getString(6));
            ofer.setSalario(cst.getDouble(7));
            cn.close();
            mav.addObject("oferta", ofer);
            //resultado = 1;
            return mav;
        } catch (SQLException ex) {
            mav.addObject("Error", "Error al cerrar conexion o ejecutar "+ex.toString());
            return mav;
        }
        //return mav;
    }
    
    @RequestMapping(value = "OfertaEdit.htm", method = RequestMethod.POST)
    public ModelAndView OfertaEditPost(
            HttpServletResponse hresponse,
            HttpServletRequest request,
            @ModelAttribute("oferta") Oferta o,
            BindingResult result,
            SessionStatus status
    ) {
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Ofertas/OfertaEdit");
        
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_ACTUALIZAR_OFERTA(?,?,?,?,?,?,?)}");
            
            cst.setInt(1, Integer.valueOf(request.getParameter("id")));
            cst.setInt(2, o.getNivel());
            cst.setInt(3, o.getArea());
            cst.setInt(4, o.getVacantes());
            cst.setString(5, o.getDescripcion());
            cst.setString(6, o.getTipoContrato());
            cst.setDouble(7, o.getSalario());
            cst.execute();
            cn.close();
            //resultado = 1;
             return new ModelAndView("redirect:" + "OfertaIndex.htm?id="+request.getParameter("id2"));
        } catch (SQLException ex) {
            mav.addObject("Error", "Error al cerrar conexion o ejecutar "+ex.toString());
            return mav;
        }
        //return mav;
    }
    
    @RequestMapping(value = "OfertaDelete.htm", method = RequestMethod.GET)
    public ModelAndView OfertaDelete(
            HttpServletResponse hresponse,
            HttpServletRequest request
    ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Ofertas/OfertaIndex");
        //String id = request.getParameter("id");
        
        Connection cn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_ELIMINAR_OFERTA(?)}");
            
            cst.setInt(1, Integer.valueOf(request.getParameter("id")));
            cst.execute();
            cn.close();
            //resultado = 1;
            return new ModelAndView("redirect:" + "OfertaIndex.htm?id="+request.getParameter("id"));
        } catch (SQLException ex) {
            mav.addObject("Errores", "Error al cerrar conexion o ejecutar "+ex.toString());
            return mav;
        }
        
    }
    
   /* @RequestMapping(value = "Aplicar.htm", method = RequestMethod.POST)
    public ModelAndView AplicarAddPost(
        HttpServletRequest request,
            @RequestParam("idOferta") Integer idOferta_aspirante,
            @RequestParam("nit") Integer nit_aspirante,
            @ModelAttribute("aspirante") Aspirante a,
            BindingResult result,
            SessionStatus status,
            ModelMap model
    )
    {   ModelAndView mav = new ModelAndView();
        String id = request.getParameter("id");
        mav.addObject("identificador", id);
        Connection cn = null;
    try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "BOLSA_TRABAJO", "BOLSA_TRABAJO");
            CallableStatement cst = cn.prepareCall("{call PR_INSERT_ASPIRANTE(?,?,?)}");
            cst.setString(1, id);
            cst.setInt(2, idOferta_aspirante);
            cst.setInt(3, nit_aspirante);
            cst.execute();
            cn.close();
            return new ModelAndView("redirect:/OfertaIndex.htm");
        }catch (SQLException ex) {
            model.addAttribute("Errores", "Error al cerrar conexion o ejecutar "+ex.toString());
            return new ModelAndView("redirect:/Error.htm");
        }
    
    }*/
}

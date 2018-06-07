
package Controlador.Empresa;

import Controlador.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        mav.setViewName("EMPRESA/actualizar_Empresa");
        return mav;

    }
    
}

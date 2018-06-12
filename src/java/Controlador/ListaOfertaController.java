/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Oferta;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Juan Murcia
 */
public class ListaOfertaController {
    private JdbcTemplate jdbcTemplate;
    
    public ListaOfertaController(){
         Conectar con= new Conectar();
         this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    //Codigo para la lista oferta que se desplegara en la opcion listado de ofertas.
    @RequestMapping(value="ListaOferta.htm", method=RequestMethod.GET)
    public ModelAndView listaoferta()
    {  
       ModelAndView of = new ModelAndView() ;
       
       String lista_Ofertasql = "Select ID_OFERTA,ID_NIVEL_ESTUDIO,ID_AREA_ESTUDIO,VACANTES order by FECHA_EXPIRACION asc";
       List lista_Oferta = this.jdbcTemplate.queryForList(lista_Ofertasql);
       of.addObject("lista_Oferta",lista_Oferta);
               
      return of;         
    }
}

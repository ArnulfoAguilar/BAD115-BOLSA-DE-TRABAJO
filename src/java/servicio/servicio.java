package servicio;

import Controlador.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class servicio {

     private JdbcTemplate jdbcTemplate;
    
    public servicio()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }

    public List verificar_login(String email, String password) {
        List lista = jdbcTemplate.queryForList("verificar_login ?,?", email, password);
        return lista;
    }

    public void usp_registrar_usuario(String nom, String dni, String clave) {
        jdbcTemplate.update("usp_registrar_usuario ?,?,?", nom, dni, clave);
    }

    public List usp_listar_preguntas() {
        List lista = jdbcTemplate.queryForList("usp_listar_preguntas");
        return lista;
    }

    public List usp_listar_respuestas() {
        List lista = jdbcTemplate.queryForList("usp_listar_respuestas");
        return lista;
    }

    public void usp_registrar_resultados(int cod, int punj) {
        jdbcTemplate.update("usp_registrar_resultados ?,?", cod, punj);
    }

    public List usp_listar_resultados() {
        List lista = jdbcTemplate.queryForList("usp_listar_resultados");
        return lista;
    }
    
    public List usp_valida_registro(String dni){
        List lista = jdbcTemplate.queryForList("usp_valida_registro ?",dni);
        return lista;
    }
}

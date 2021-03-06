package Entidad;
// Generated 06-02-2018 04:31:03 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Recomendaciones generated by hbm2java
 */
@Entity
@Table(name="RECOMENDACIONES"
    ,schema="BOLSA_TRABAJO"
)
public class Recomendaciones  implements java.io.Serializable {


     private BigDecimal idRecomendacion;
     private Candidato candidato;
     private String nombre;
     private String apellido;
     private String afinidad;
     private String cargo;
     private String empresa;
     private String telefono;

    public Recomendaciones() {
    }

	
    public Recomendaciones(BigDecimal idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }
    public Recomendaciones(BigDecimal idRecomendacion, Candidato candidato, String nombre, String apellido, String afinidad, String cargo, String empresa, String telefono) {
       this.idRecomendacion = idRecomendacion;
       this.candidato = candidato;
       this.nombre = nombre;
       this.apellido = apellido;
       this.afinidad = afinidad;
       this.cargo = cargo;
       this.empresa = empresa;
       this.telefono = telefono;
    }
   
     @Id 

    
    @Column(name="ID_RECOMENDACION", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getIdRecomendacion() {
        return this.idRecomendacion;
    }
    
    public void setIdRecomendacion(BigDecimal idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_POST_DOC")
    public Candidato getCandidato() {
        return this.candidato;
    }
    
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    
    @Column(name="NOMBRE", length=400)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="APELLIDO", length=400)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    @Column(name="AFINIDAD", length=400)
    public String getAfinidad() {
        return this.afinidad;
    }
    
    public void setAfinidad(String afinidad) {
        this.afinidad = afinidad;
    }

    
    @Column(name="CARGO", length=400)
    public String getCargo() {
        return this.cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
    @Column(name="EMPRESA", length=400)
    public String getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    
    @Column(name="TELEFONO", length=100)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }




}



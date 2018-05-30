package Entidad;
// Generated 05-12-2018 07:16:50 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Logros generated by hbm2java
 */
@Entity
@Table(name="LOGROS"
    ,schema="BOLSA_TRABAJO"
)
public class Logros  implements java.io.Serializable {


     private BigDecimal idLogros;
     private String lugar;
     private Date fecha;
     private Set<Candidato> candidatos = new HashSet<Candidato>(0);

    public Logros() {
    }

	
    public Logros(BigDecimal idLogros) {
        this.idLogros = idLogros;
    }
    public Logros(BigDecimal idLogros, String lugar, Date fecha, Set<Candidato> candidatos) {
       this.idLogros = idLogros;
       this.lugar = lugar;
       this.fecha = fecha;
       this.candidatos = candidatos;
    }
   
     @Id 

    
    @Column(name="ID_LOGROS", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getIdLogros() {
        return this.idLogros;
    }
    
    public void setIdLogros(BigDecimal idLogros) {
        this.idLogros = idLogros;
    }

    
    @Column(name="LUGAR", length=400)
    public String getLugar() {
        return this.lugar;
    }
    
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA", length=7)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="logros")
    public Set<Candidato> getCandidatos() {
        return this.candidatos;
    }
    
    public void setCandidatos(Set<Candidato> candidatos) {
        this.candidatos = candidatos;
    }




}


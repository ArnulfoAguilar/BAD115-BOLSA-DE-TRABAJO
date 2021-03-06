package Entidad;
// Generated 06-02-2018 04:31:03 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Congresos generated by hbm2java
 */
@Entity
@Table(name="CONGRESOS"
    ,schema="BOLSA_TRABAJO"
)
public class Congresos  implements java.io.Serializable {


     private BigDecimal idCongreso;
     private Participacion participacion;
     private Candidato candidato;
     private String pais;
     private String lugar;
     private String anfitrion;
     private Date fechaInicio;
     private Date fechaFin;
     private String tema;

    public Congresos() {
    }

	
    public Congresos(BigDecimal idCongreso) {
        this.idCongreso = idCongreso;
    }
    public Congresos(BigDecimal idCongreso, Participacion participacion, Candidato candidato, String pais, String lugar, String anfitrion, Date fechaInicio, Date fechaFin, String tema) {
       this.idCongreso = idCongreso;
       this.participacion = participacion;
       this.candidato = candidato;
       this.pais = pais;
       this.lugar = lugar;
       this.anfitrion = anfitrion;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.tema = tema;
    }
   
     @Id 

    
    @Column(name="ID_CONGRESO", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getIdCongreso() {
        return this.idCongreso;
    }
    
    public void setIdCongreso(BigDecimal idCongreso) {
        this.idCongreso = idCongreso;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PARTICIPACION")
    public Participacion getParticipacion() {
        return this.participacion;
    }
    
    public void setParticipacion(Participacion participacion) {
        this.participacion = participacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_POST_DOC")
    public Candidato getCandidato() {
        return this.candidato;
    }
    
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    
    @Column(name="PAIS", length=200)
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }

    
    @Column(name="LUGAR", length=200)
    public String getLugar() {
        return this.lugar;
    }
    
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    
    @Column(name="ANFITRION", length=200)
    public String getAnfitrion() {
        return this.anfitrion;
    }
    
    public void setAnfitrion(String anfitrion) {
        this.anfitrion = anfitrion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_INICIO", length=7)
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_FIN", length=7)
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    
    @Column(name="TEMA", length=200)
    public String getTema() {
        return this.tema;
    }
    
    public void setTema(String tema) {
        this.tema = tema;
    }




}



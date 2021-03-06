package Entidad;
// Generated 06-02-2018 04:31:03 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Oferta generated by hbm2java
 */
@Entity
@Table(name="OFERTA"
    ,schema="BOLSA_TRABAJO"
)
public class Oferta  implements java.io.Serializable {


     private OfertaId id;
     private NivelEstudio nivelEstudio;
     private AreaDeEstudio areaDeEstudio;
     private Empresa empresa;
     private BigDecimal aniosExp;
     private BigDecimal vacantes;
     private Date fechaExpiracion;
     private String descripcion;
     private String tipoContrato;
     private BigDecimal salario;
     private BigDecimal tieneExamen;
     private Set<Aspirante> aspirantes = new HashSet<Aspirante>(0);
     private Set<Examen> examens = new HashSet<Examen>(0);

    public Oferta() {
    }

	
    public Oferta(OfertaId id, Empresa empresa) {
        this.id = id;
        this.empresa = empresa;
    }
    public Oferta(OfertaId id, NivelEstudio nivelEstudio, AreaDeEstudio areaDeEstudio, Empresa empresa, BigDecimal aniosExp, BigDecimal vacantes, Date fechaExpiracion, String descripcion, String tipoContrato, BigDecimal salario, BigDecimal tieneExamen, Set<Aspirante> aspirantes, Set<Examen> examens) {
       this.id = id;
       this.nivelEstudio = nivelEstudio;
       this.areaDeEstudio = areaDeEstudio;
       this.empresa = empresa;
       this.aniosExp = aniosExp;
       this.vacantes = vacantes;
       this.fechaExpiracion = fechaExpiracion;
       this.descripcion = descripcion;
       this.tipoContrato = tipoContrato;
       this.salario = salario;
       this.tieneExamen = tieneExamen;
       this.aspirantes = aspirantes;
       this.examens = examens;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idOferta", column=@Column(name="ID_OFERTA", nullable=false, precision=22, scale=0) ), 
        @AttributeOverride(name="nit", column=@Column(name="NIT", nullable=false, length=100) ) } )
    public OfertaId getId() {
        return this.id;
    }
    
    public void setId(OfertaId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_NIVEL_ESTUDIO")
    public NivelEstudio getNivelEstudio() {
        return this.nivelEstudio;
    }
    
    public void setNivelEstudio(NivelEstudio nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_AREA_ESTUDIO")
    public AreaDeEstudio getAreaDeEstudio() {
        return this.areaDeEstudio;
    }
    
    public void setAreaDeEstudio(AreaDeEstudio areaDeEstudio) {
        this.areaDeEstudio = areaDeEstudio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="NIT", nullable=false, insertable=false, updatable=false)
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
    @Column(name="ANIOS_EXP", precision=22, scale=0)
    public BigDecimal getAniosExp() {
        return this.aniosExp;
    }
    
    public void setAniosExp(BigDecimal aniosExp) {
        this.aniosExp = aniosExp;
    }

    
    @Column(name="VACANTES", precision=22, scale=0)
    public BigDecimal getVacantes() {
        return this.vacantes;
    }
    
    public void setVacantes(BigDecimal vacantes) {
        this.vacantes = vacantes;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_EXPIRACION", length=7)
    public Date getFechaExpiracion() {
        return this.fechaExpiracion;
    }
    
    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    
    @Column(name="DESCRIPCION", length=4000)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="TIPO_CONTRATO", length=400)
    public String getTipoContrato() {
        return this.tipoContrato;
    }
    
    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    
    @Column(name="SALARIO", precision=8)
    public BigDecimal getSalario() {
        return this.salario;
    }
    
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    
    @Column(name="TIENE_EXAMEN", precision=22, scale=0)
    public BigDecimal getTieneExamen() {
        return this.tieneExamen;
    }
    
    public void setTieneExamen(BigDecimal tieneExamen) {
        this.tieneExamen = tieneExamen;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oferta")
    public Set<Aspirante> getAspirantes() {
        return this.aspirantes;
    }
    
    public void setAspirantes(Set<Aspirante> aspirantes) {
        this.aspirantes = aspirantes;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oferta")
    public Set<Examen> getExamens() {
        return this.examens;
    }
    
    public void setExamens(Set<Examen> examens) {
        this.examens = examens;
    }




}



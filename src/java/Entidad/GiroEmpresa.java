package Entidad;
// Generated 05-12-2018 07:16:50 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * GiroEmpresa generated by hbm2java
 */
@Entity
@Table(name="GIRO_EMPRESA"
    ,schema="BOLSA_TRABAJO"
)
public class GiroEmpresa  implements java.io.Serializable {


     private BigDecimal idGiro;
     private String nombreGiro;
     private Set<ExperienciaLaboral> experienciaLaborals = new HashSet<ExperienciaLaboral>(0);
     private Set<Empresa> empresas = new HashSet<Empresa>(0);

    public GiroEmpresa() {
    }

	
    public GiroEmpresa(BigDecimal idGiro) {
        this.idGiro = idGiro;
    }
    public GiroEmpresa(BigDecimal idGiro, String nombreGiro, Set<ExperienciaLaboral> experienciaLaborals, Set<Empresa> empresas) {
       this.idGiro = idGiro;
       this.nombreGiro = nombreGiro;
       this.experienciaLaborals = experienciaLaborals;
       this.empresas = empresas;
    }
   
     @Id 

    
    @Column(name="ID_GIRO", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getIdGiro() {
        return this.idGiro;
    }
    
    public void setIdGiro(BigDecimal idGiro) {
        this.idGiro = idGiro;
    }

    
    @Column(name="NOMBRE_GIRO", length=400)
    public String getNombreGiro() {
        return this.nombreGiro;
    }
    
    public void setNombreGiro(String nombreGiro) {
        this.nombreGiro = nombreGiro;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="giroEmpresa")
    public Set<ExperienciaLaboral> getExperienciaLaborals() {
        return this.experienciaLaborals;
    }
    
    public void setExperienciaLaborals(Set<ExperienciaLaboral> experienciaLaborals) {
        this.experienciaLaborals = experienciaLaborals;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="giroEmpresa")
    public Set<Empresa> getEmpresas() {
        return this.empresas;
    }
    
    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }




}



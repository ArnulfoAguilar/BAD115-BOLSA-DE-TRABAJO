package Entidad;
// Generated 06-02-2018 04:31:03 PM by Hibernate Tools 4.3.1


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
 * TipoEmpresa generated by hbm2java
 */
@Entity
@Table(name="TIPO_EMPRESA"
    ,schema="BOLSA_TRABAJO"
)
public class TipoEmpresa  implements java.io.Serializable {


     private BigDecimal idTipoEmp;
     private String nombreTipoEmp;
     private Set<Empresa> empresas = new HashSet<Empresa>(0);

    public TipoEmpresa() {
    }

	
    public TipoEmpresa(BigDecimal idTipoEmp) {
        this.idTipoEmp = idTipoEmp;
    }
    public TipoEmpresa(BigDecimal idTipoEmp, String nombreTipoEmp, Set<Empresa> empresas) {
       this.idTipoEmp = idTipoEmp;
       this.nombreTipoEmp = nombreTipoEmp;
       this.empresas = empresas;
    }
   
     @Id 

    
    @Column(name="ID_TIPO_EMP", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getIdTipoEmp() {
        return this.idTipoEmp;
    }
    
    public void setIdTipoEmp(BigDecimal idTipoEmp) {
        this.idTipoEmp = idTipoEmp;
    }

    
    @Column(name="NOMBRE_TIPO_EMP", length=400)
    public String getNombreTipoEmp() {
        return this.nombreTipoEmp;
    }
    
    public void setNombreTipoEmp(String nombreTipoEmp) {
        this.nombreTipoEmp = nombreTipoEmp;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tipoEmpresa")
    public Set<Empresa> getEmpresas() {
        return this.empresas;
    }
    
    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }




}



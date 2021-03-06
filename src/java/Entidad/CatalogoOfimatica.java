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
 * CatalogoOfimatica generated by hbm2java
 */
@Entity
@Table(name="CATALOGO_OFIMATICA"
    ,schema="BOLSA_TRABAJO"
)
public class CatalogoOfimatica  implements java.io.Serializable {


     private BigDecimal idOfimatica;
     private String nombreOfimatica;
     private Set<Ofimatica> ofimaticas = new HashSet<Ofimatica>(0);

    public CatalogoOfimatica() {
    }

	
    public CatalogoOfimatica(BigDecimal idOfimatica) {
        this.idOfimatica = idOfimatica;
    }
    public CatalogoOfimatica(BigDecimal idOfimatica, String nombreOfimatica, Set<Ofimatica> ofimaticas) {
       this.idOfimatica = idOfimatica;
       this.nombreOfimatica = nombreOfimatica;
       this.ofimaticas = ofimaticas;
    }
   
     @Id 

    
    @Column(name="ID_OFIMATICA", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getIdOfimatica() {
        return this.idOfimatica;
    }
    
    public void setIdOfimatica(BigDecimal idOfimatica) {
        this.idOfimatica = idOfimatica;
    }

    
    @Column(name="NOMBRE_OFIMATICA", length=200)
    public String getNombreOfimatica() {
        return this.nombreOfimatica;
    }
    
    public void setNombreOfimatica(String nombreOfimatica) {
        this.nombreOfimatica = nombreOfimatica;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catalogoOfimatica")
    public Set<Ofimatica> getOfimaticas() {
        return this.ofimaticas;
    }
    
    public void setOfimaticas(Set<Ofimatica> ofimaticas) {
        this.ofimaticas = ofimaticas;
    }




}



package Entidad;
// Generated 06-02-2018 04:31:03 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OfimaticaId generated by hbm2java
 */
@Embeddable
public class OfimaticaId  implements java.io.Serializable {


     private BigDecimal idOfimatica;
     private String idPostDoc;

    public OfimaticaId() {
    }

    public OfimaticaId(BigDecimal idOfimatica, String idPostDoc) {
       this.idOfimatica = idOfimatica;
       this.idPostDoc = idPostDoc;
    }
   


    @Column(name="ID_OFIMATICA", precision=22, scale=0)
    public BigDecimal getIdOfimatica() {
        return this.idOfimatica;
    }
    
    public void setIdOfimatica(BigDecimal idOfimatica) {
        this.idOfimatica = idOfimatica;
    }


    @Column(name="ID_POST_DOC", length=200)
    public String getIdPostDoc() {
        return this.idPostDoc;
    }
    
    public void setIdPostDoc(String idPostDoc) {
        this.idPostDoc = idPostDoc;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof OfimaticaId) ) return false;
		 OfimaticaId castOther = ( OfimaticaId ) other; 
         
		 return ( (this.getIdOfimatica()==castOther.getIdOfimatica()) || ( this.getIdOfimatica()!=null && castOther.getIdOfimatica()!=null && this.getIdOfimatica().equals(castOther.getIdOfimatica()) ) )
 && ( (this.getIdPostDoc()==castOther.getIdPostDoc()) || ( this.getIdPostDoc()!=null && castOther.getIdPostDoc()!=null && this.getIdPostDoc().equals(castOther.getIdPostDoc()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdOfimatica() == null ? 0 : this.getIdOfimatica().hashCode() );
         result = 37 * result + ( getIdPostDoc() == null ? 0 : this.getIdPostDoc().hashCode() );
         return result;
   }   


}



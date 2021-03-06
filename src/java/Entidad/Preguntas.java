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
 * Preguntas generated by hbm2java
 */
@Entity
@Table(name="PREGUNTAS"
    ,schema="BOLSA_TRABAJO"
)
public class Preguntas  implements java.io.Serializable {


     private BigDecimal idPregunta;
     private Examen examen;
     private String pregunta;
     private String respuestaCorrecta;
     private String respuestaIncorrecta1;
     private String respuestaIncorrecta2;
     private String respuestaIncorrecta3;

    public Preguntas() {
    }

	
    public Preguntas(BigDecimal idPregunta) {
        this.idPregunta = idPregunta;
    }
    public Preguntas(BigDecimal idPregunta, Examen examen, String pregunta, String respuestaCorrecta, String respuestaIncorrecta1, String respuestaIncorrecta2, String respuestaIncorrecta3) {
       this.idPregunta = idPregunta;
       this.examen = examen;
       this.pregunta = pregunta;
       this.respuestaCorrecta = respuestaCorrecta;
       this.respuestaIncorrecta1 = respuestaIncorrecta1;
       this.respuestaIncorrecta2 = respuestaIncorrecta2;
       this.respuestaIncorrecta3 = respuestaIncorrecta3;
    }
   
     @Id 

    
    @Column(name="ID_PREGUNTA", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getIdPregunta() {
        return this.idPregunta;
    }
    
    public void setIdPregunta(BigDecimal idPregunta) {
        this.idPregunta = idPregunta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_EXAMEN")
    public Examen getExamen() {
        return this.examen;
    }
    
    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    
    @Column(name="PREGUNTA", length=400)
    public String getPregunta() {
        return this.pregunta;
    }
    
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    
    @Column(name="RESPUESTA_CORRECTA", length=400)
    public String getRespuestaCorrecta() {
        return this.respuestaCorrecta;
    }
    
    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    
    @Column(name="RESPUESTA_INCORRECTA1", length=400)
    public String getRespuestaIncorrecta1() {
        return this.respuestaIncorrecta1;
    }
    
    public void setRespuestaIncorrecta1(String respuestaIncorrecta1) {
        this.respuestaIncorrecta1 = respuestaIncorrecta1;
    }

    
    @Column(name="RESPUESTA_INCORRECTA2", length=400)
    public String getRespuestaIncorrecta2() {
        return this.respuestaIncorrecta2;
    }
    
    public void setRespuestaIncorrecta2(String respuestaIncorrecta2) {
        this.respuestaIncorrecta2 = respuestaIncorrecta2;
    }

    
    @Column(name="RESPUESTA_INCORRECTA3", length=400)
    public String getRespuestaIncorrecta3() {
        return this.respuestaIncorrecta3;
    }
    
    public void setRespuestaIncorrecta3(String respuestaIncorrecta3) {
        this.respuestaIncorrecta3 = respuestaIncorrecta3;
    }




}



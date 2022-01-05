/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author andresruedalibre
 */
@Entity
@Table(name="reservations")
public class Reserva implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";
   
    
        
    @ManyToOne
    @JoinColumn(name="idOrtopedic", nullable = true)
    @JsonIgnoreProperties({"reservations"})
    private Ortesis ortopedic;
    
    
    @ManyToOne
    @JoinColumn(name="idClient", nullable = true)
    @JsonIgnoreProperties({"reservations", "messages"})
    private Cliente client;

    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    
    public Ortesis getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(Ortesis ortopedic) {
        this.ortopedic = ortopedic;
    }
    

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente cliente) {
        this.client = cliente;
    }

    
    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

  

    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}

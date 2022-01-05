/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author andresruedalibre
 */
@Entity
@Table(name="messages")
public class Mensaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    
      
    @ManyToOne
    @JoinColumn(name="idOrtopedics", nullable = true)
    @JsonIgnoreProperties({"messages", "reservations"})
    private Ortesis ortopedic;
    //@OneToMany(cascade={CascadeType.PERSIST}, mappedBy="messages")
    //@JsonIgnoreProperties("messages")
    //private List<Ortesis> ortopedic;
    
    @ManyToOne
    @JoinColumn(name="idClient", nullable = true)
    @JsonIgnoreProperties({"messages", "reservations"})
    private Cliente client;
    
    

    public Integer getIdMessage() {
        return idMessage;
    }

    public Ortesis getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(Ortesis ortopedic) {
        this.ortopedic = ortopedic;
    }

    
  
   

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    //public Ortesis getOrtesis() {
      //  return ortesis;
    //}

    //public void setOrtesis(Ortesis ortesis) {
      //  this.ortesis = ortesis;
    //}

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    

   

    
    
}

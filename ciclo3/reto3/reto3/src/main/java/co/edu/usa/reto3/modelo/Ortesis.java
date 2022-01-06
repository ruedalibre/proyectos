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
@Table(name = "ortopedics")
public class Ortesis implements Serializable {

    /*
    * valores de los campos
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
    * tipo variable id
    */
    private int id; 
    /*
    * tipo variable name
    */
    private String name; 
    /*
    * tipo variable brand
    */
    private String brand; 
    /*
    * tipo variable year
    */
    private Integer year; 
    /*
    * tipo variable descripcion
    */
    private String description; 

    /*
    * tipo de relacion many to one
    */
    @ManyToOne
    @JoinColumn(name = "idCategory", nullable = false)
    @JsonIgnoreProperties("ortopedics")
    /*
    * instancia categoría
    */
    private Categoria category; 

    /*
    * tipo de relacion one to many
    */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ortopedic")
    @JsonIgnoreProperties({"ortopedic", "client"})
    /*
    *  
    */
    private List<Mensaje> messages;

    /*
    * tipo de relacion one to many
    */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ortopedic")
    @JsonIgnoreProperties({"ortopedic", "client"})
    /*
    * 
    */
    private List<Reserva> reservations;

    public List<Reserva> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reserva> reservations) {
        this.reservations = reservations;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) { 
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}

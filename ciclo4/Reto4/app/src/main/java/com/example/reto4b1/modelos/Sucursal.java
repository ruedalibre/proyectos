package com.example.reto4b1.modelos;

import com.google.android.gms.maps.model.LatLng;

public class Sucursal {
    private int id;
    private String name;
    private String description;
    private String location;
    private byte[] image;

    public Sucursal(int id, String name, String description, String location, byte[] image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.image = image;
    }

    public Sucursal(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Sucursal() {}

    public int getId() {
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

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public LatLng locationToCoord(){
        String[] coord = this.location.split(",");
        Double latitud = Double.parseDouble(coord[0]);
        Double longitud = Double.parseDouble(coord[1]);
        LatLng latLng = new LatLng(latitud, longitud);
        return latLng;
    }
}

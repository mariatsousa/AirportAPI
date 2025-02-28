/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.maria.airports.DTO;

import br.dev.maria.airports.entities.Airport;

/**
 *
 * @author sesidevb
 */
public class AirportMinDTO {
    private long id;
    private String name;
    private String city;
    private String iatacode;
    
    public AirportMinDTO() {
    }
    
    public AirportMinDTO (Airport airport) {
        this.id = airport.getId();
        this.name = airport.getName();
        this.city = airport.getCity();
        this.iatacode = airport.getIataCode();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getIatacode() {
        return iatacode;
    }
    
    
}

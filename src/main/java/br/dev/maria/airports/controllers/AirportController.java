/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.maria.airports.controllers;

import br.dev.maria.airports.DTO.AirportMinDTO;
import br.dev.maria.airports.entities.Airport;
import br.dev.maria.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesidevb
 */

@RestController
public class AirportController {
    @Autowired
    private AirportService airportService;
    
    /**
    Endpoint /airports/airport
    Retorna TODOS os aeroportos da base de dados.
    * @return
    */
    
    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;
    }
    
    /**
     * Endpoint /airports/city/[cityName)
     * @param cityName
     * @return
     */
    
    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase (@PathVariable String cityName) {
        List<Airport> result = airportService.findByCity(cityName);
        
        if(result.isEmpty()){
            // Ops.. lista vazia...
            // not Found devolve 484
            return ResponseEntity.notFound().build();
        }else{
           // Eba! Tem dados!
            // ok devolve 200
            return ResponseEntity.ok(result); 
        }
    }
    
    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> FindByCountryIgnoreCase(@PathVariable String countryName) {
        List<AirportMinDTO> result = airportService.findByCountry(countryName);
        if (result.isEmpty()) {
            //Ops.. lista vazia...
            //notFound devolve 404
            return ResponseEntity.notFound().build();
        } else {
            // Eba Tem dados
            // ok devolue 200
            return ResponseEntity.ok(result);
        }
    }
    
    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCode (@PathVariable String iataCode) {
        Airport result = airportService.findByIataCode(iataCode);
        
        if (result == null) {
            // Ops.. Aeroporto vazio...
            // notFound devolve 404
            return ResponseEntity.notFound().build();
        } else {
            // Eba! Tem dados!
            // ok devolve 200
            return ResponseEntity.ok(result);
        }
    }
}

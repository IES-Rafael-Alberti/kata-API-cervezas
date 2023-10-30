package com.mi.appCervezas.controllers;

import com.mi.appCervezas.models.Brewery;
import com.mi.appCervezas.services.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/breweries")
public class BreweryController {

    @Autowired
    private BreweryService breweryService;

    @GetMapping
    public List<Brewery> getAllBreweries() {
        return breweryService.getAllBreweries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brewery> getBreweryById(@PathVariable Long id) {
        Brewery brewery = breweryService.getBreweryById(id);
        return ResponseEntity.ok(brewery);
    }

    @PostMapping
    public ResponseEntity<Brewery> addBrewery(@RequestBody Brewery brewery) {
        Brewery newBrewery = breweryService.addBrewery(brewery);
        return ResponseEntity.ok(newBrewery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrewery(@PathVariable Long id) {
        breweryService.deleteBrewery(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brewery> updateBrewery(@PathVariable Long id, @RequestBody Brewery newBrewery) {
        Brewery updatedBrewery = breweryService.updateBrewery(id, newBrewery);
        return ResponseEntity.ok(updatedBrewery);
    }
}


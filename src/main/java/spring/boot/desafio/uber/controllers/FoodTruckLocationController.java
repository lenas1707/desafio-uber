package spring.boot.desafio.uber.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.desafio.uber.entities.FoodTruckLocation;
import spring.boot.desafio.uber.services.FoodTruckLocationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foodtrucks")
public class FoodTruckLocationController {

    private final FoodTruckLocationService service;

    public FoodTruckLocationController(FoodTruckLocationService service) {
        this.service = service;
    }

    @GetMapping
    public List<FoodTruckLocation> getAll(@RequestParam Optional<String> facilitytype){
        return facilitytype.map(service::filterByType)
                .orElseGet(service::getAllTrucks);
    }

}

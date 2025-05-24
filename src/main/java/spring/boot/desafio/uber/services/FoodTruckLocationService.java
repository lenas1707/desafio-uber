package spring.boot.desafio.uber.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import spring.boot.desafio.uber.entities.FoodTruckLocation;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FoodTruckLocationService {

    private final WebClient webClient;

    public FoodTruckLocationService(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://data.sfgov.org/resource/rqzj-sfat.json")
                .build();
    }


    public List<FoodTruckLocation> getAllTrucks(){
        return webClient.get()
                .retrieve()
                .bodyToFlux(FoodTruckLocation.class)
                .collectList()
                .block();
    }

    public List<FoodTruckLocation> filterByType(String query){
        return getAllTrucks().stream()
                .filter(t -> t.getFacilityType() != null && t.getFacilityType().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<String> autocomplete(String prefix){
        return getAllTrucks().stream()
                .map(FoodTruckLocation::getApplicant)
                .filter(Objects::nonNull)
                .filter(a -> a.toLowerCase().startsWith(prefix.toLowerCase()))
                .distinct()
                .sorted()
                .limit(10)
                .collect(Collectors.toList());
    }
}

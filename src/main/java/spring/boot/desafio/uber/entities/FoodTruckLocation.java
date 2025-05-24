package spring.boot.desafio.uber.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.List;

@Data
public class FoodTruckLocation {

    private String applicant;
    @JsonProperty("facilitytype")
    private String facilityType;
    private String address;
    @JsonProperty("fooditems")
    @JsonDeserialize(using = FoodItemsDeserializer.class)
    private List<String> foodItems;

    public FoodTruckLocation() {
    }

    public FoodTruckLocation(String applicant, String facilityType, String address, List<String> foodItems) {
        this.applicant = applicant;
        this.facilityType = facilityType;
        this.address = address;
        this.foodItems = foodItems;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<String> foodItems) {
        this.foodItems = foodItems;
    }
}

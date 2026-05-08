package com.pluralsight;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNull;

public class DealershipTest {

    @Test
    /**
     * Creates a Dealership and Vehicle
     * Adds Vehicle into Dealership list
     * Checks if null
     */
    public void getVehiclesByPrice() {
        // Arrange

        Dealership dealership = new Dealership("Audi Meadowlands", "425 NJ-3, Secaucus, NJ 07094", "+18777014078");
        Vehicle a4 = new Vehicle(1021, 2026, "Audi", "A4", "Sedan", "Black", 15200, 35000);
        dealership.addVehicle(a4);

        // Act
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(3000.12, 50000.42);
        // Assert
        assertNull(vehicles);
    }

//    @Test
//    public void getVehiclesByMake() {
//    }
//
//    @Test
//    public void getVehiclesByYear() {
//    }
//
//    @Test
//    public void getVehiclesByColor() {
//    }
//
//    @Test
//    public void getVehiclesByMileage() {
//    }
//
//    @Test
//    public void getVehiclesByType() {
//    }
//
//    @Test
//    public void getAllVehicles() {
//    }
//
//    @Test
//    public void addVehicle() {
//    }
}
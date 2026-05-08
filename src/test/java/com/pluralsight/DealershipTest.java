package com.pluralsight;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

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

        // Act

        dealership.addVehicle(a4);
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(3000.12, 50000.42);

        // Assert

        assertNull(vehicles);
    }

    @Test
    public void getVehiclesByMake() {

        // Arrange

        Dealership dealership = new Dealership("Audi Meadowlands", "425 NJ-3, Secaucus, NJ 07094", "+18777014078");
        Vehicle a4 = new Vehicle(1021, 2026, "Audi", "A4", "Sedan", "Black", 15200, 35000);

        // Act

        dealership.addVehicle(a4);
        List<Vehicle> vehicles = dealership.getVehiclesByMake("Audi", "A4");

        // Assert

        assertNull(vehicles);


    }

    @Test
    public void getVehiclesByYear() {
        // Arrange

        Dealership dealership = new Dealership("Audi Meadowlands", "425 NJ-3, Secaucus, NJ 07094", "+18777014078");
        Vehicle a4 = new Vehicle(1021, 2026, "Audi", "A4", "Sedan", "Black", 15200, 35000);

        // Act

        dealership.addVehicle(a4);
        List<Vehicle> vehicles = dealership.getVehiclesByYear(1995, 2026);

        //Assert

        assertNull(vehicles);
    }


    @Test
    public void getVehiclesByColor() {

        // Arrange

        Dealership dealership = new Dealership("Audi Meadowlands", "425 NJ-3, Secaucus, NJ 07094", "+18777014078");
        Vehicle a4 = new Vehicle(1021, 2026, "Audi", "A4", "Sedan", "Black", 15200, 35000);

        // Act

        dealership.addVehicle(a4);
        List<Vehicle> vehicles = dealership.getVehiclesByColor("Black");

        // Assert

        assertNull(vehicles);

    }

    @Test
    public void getVehiclesByMileage() {
        // Arrange

        Dealership dealership = new Dealership("Audi Meadowlands", "425 NJ-3, Secaucus, NJ 07094", "+18777014078");
        Vehicle a4 = new Vehicle(1021, 2026, "Audi", "A4", "Sedan", "Black", 15200, 35000);

        // Act

        dealership.addVehicle(a4);
        List<Vehicle> vehicles = dealership.getVehiclesByMileage(2313, 100000);

        // Assert

        assertNull(vehicles);

    }

    @Test
    public void getVehiclesByType() {
        // Arrange

        Dealership dealership = new Dealership("Audi Meadowlands", "425 NJ-3, Secaucus, NJ 07094", "+18777014078");
        Vehicle a4 = new Vehicle(1021, 2026, "Audi", "A4", "Sedan", "Black", 15200, 35000);

        // Act

        dealership.addVehicle(a4);
        List<Vehicle> vehicles = dealership.getVehiclesByType("Sedan");

        // Assert

        assertNull(vehicles);

    }

    @Test
    public void getAllVehicles() {
        // Arrange

        Dealership dealership = new Dealership("Audi Meadowlands", "425 NJ-3, Secaucus, NJ 07094", "+18777014078");
        Vehicle a4 = new Vehicle(1021, 2026, "Audi", "A4", "Sedan", "Black", 15200, 35000);

        // Act
        dealership.addVehicle(a4);
        List<Vehicle> vehicles = dealership.getAllVehicles();

        // Assert

        assertEquals(vehicles.size(), 1);
    }

    @Test
    public void addVehicle() {
        // Arrange

        Dealership dealership = new Dealership("Audi Meadowlands", "425 NJ-3, Secaucus, NJ 07094", "+18777014078");
        Vehicle a4 = new Vehicle(1021, 2026, "Audi", "A4", "Sedan", "Black", 15200, 35000);

        // Act

        dealership.addVehicle(a4);
        List<Vehicle> vehicles = dealership.getAllVehicles();

        // Assert
        assertTrue(vehicles.contains(a4));
        assertEquals(vehicles.size(), 1);


    }
}


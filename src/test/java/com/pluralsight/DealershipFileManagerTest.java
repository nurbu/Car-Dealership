package com.pluralsight;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DealershipFileManagerTest {

    /**
     * Creates new dealershipFileManager
     * imports inventory.csv information into dealershipFileManager
     * create correct input array
     * Compare the toStrings of both arrays
     * keep track using boolean test
     */
    @Test
    public void testGetDealership() {
        //Arrange

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        List<Vehicle> correctOutput = new ArrayList<Vehicle>();
        Vehicle v1 = new Vehicle(10234, 2015, "Toyota", "Camry", "sedan", "silver", 12000, 15995.0);
        Vehicle v2 = new Vehicle(10567, 2018, "Honda", "Civic", "sedan", "black", 8000, 18995.0);
        Vehicle v3 = new Vehicle(10987, 2017, "Ford", "Escape", "SUV", "white", 25000, 20995.0);
        Vehicle v4 = new Vehicle(11000, 2018, "Chevrolet", "Malibu", "sedan", "red", 12000, 16995.0);
        Vehicle v5 = new Vehicle(11111, 2019, "Toyota", "RAV4", "SUV", "blue", 10000, 27995.0);

        // Act

        Dealership dealership = dealershipFileManager.getDealership();
        List<Vehicle> vehicles = dealership.getAllVehicles();
        correctOutput.add(v1);
        correctOutput.add(v2);
        correctOutput.add(v3);
        correctOutput.add(v4);
        correctOutput.add(v5);

        // Assert

        boolean test = false;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.size() != correctOutput.size()) {
                break;
            }
            String vehiclesString = vehicles.toString();
            String correctOutputString = correctOutput.toString();
            if (vehiclesString.equals(correctOutputString)) {
                test = true;
            } else {
                test = false;
                break;
            }
        }
        Assert.assertTrue(test);
    }
}
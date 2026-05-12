package com.pluralsight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public static Dealership getDealership() {

        File file = new File("inventory.csv");
        Dealership dealership = null;

        if (!file.exists()) {
            try {
                // Creates new "inventory.csv" and lets user know.
                if (file.createNewFile()) {
                    System.out.println("New \"inventory.csv\" file created");
                }
            } catch (IOException e) {
                // Catches any errors when creating file.
                System.out.println("Error creating file: " + e.getMessage());
            }
            // If "inventory.csv" didn't exist, dealership has no details.
            return dealership;
        }

        // Uses try-with-resources to auto-close BufferReader
        try (BufferedReader br = new BufferedReader(new FileReader("inventory.csv"))) {

            // Handles the header line

            String headerLine = br.readLine();

            // If file is truly empty returns null.

            if (headerLine == null || headerLine.isBlank()) {
                System.out.println("Header missing or blank");
                return dealership;
            }
            String[] header = headerLine.split("\\|");
            // Handles blank header and less than over
            if (header.length != 3) {
                System.out.println("Invalid header" + headerLine);
                return dealership;
            }

            dealership = new Dealership(header[0], header[1], header[2]);

            String line;
            while ((line = br.readLine()) != null) {
                /**
                 * Catches bad lines and skips them to prevent exception.
                 * Handles all vehicle object creation
                 */
                try {

                    String[] values = line.split("\\|");

                    if (values.length != 8) {
                        throw new Exception("Incomplete line " + line);
                    }

                    int vin = parseInt(values[0]);
                    int year = parseInt(values[1]);
                    String make = values[2];
                    String model = values[3];
                    String vehicleType = values[4];
                    String color = values[5];
                    int odometer = parseInt(values[6]);
                    double price = parseDouble(values[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
                // Catches all general errors within each transaction.
                catch (Exception e) {
                    System.out.println("Skipping bad line: " + line + "(" + e.getMessage() + ")");
                }
            }
            // catches file not being found or can't read, etc....
        } catch (IOException e) {
            System.out.println("Error reading file:  " + e.getMessage());
        }
        return dealership;
    }

    public static void saveDealership(Dealership dealership) {

    }


    /* --------------------------------------------------------------------------
       Helper Functions

     * Parse double and int strings
     * if s is empty throws Exception with Custom message (skipped by user)
     * Uses try/catch to check if user input valid.
     * if s is not a number or in a Double format throws Exception

       -------------------------------------------------------------------------- */

    private static Double parseDouble(String s) {
        if (s.isEmpty()) {
            throw new IllegalArgumentException("Input can't be empty");
        }
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number: " + s);
        }
    }

    private static int parseInt(String s) {
        if (s.isEmpty()) {
            throw new IllegalArgumentException("Input can't be empty");
        }
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number: " + s);
        }
    }
}

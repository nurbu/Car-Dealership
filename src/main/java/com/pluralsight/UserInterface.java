package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private static final String ROW_FORMAT =
            "%-8s %-6s %-12s %-12s %-8s %-8s %-10s %-10s%n";
    private static final String FORMATTED_HEADER = String.format(ROW_FORMAT,
            "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price")
            + "-".repeat(80);


    public UserInterface() {
    }

    public void display() {

        init();
        // Main menu loop
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 10) {
            System.out.println("\nWelcome to the Dealership!");

            System.out.println("1. Filter by price");
            System.out.println("2. Filter by Make and Model");
            System.out.println("3. Filter by Year");
            System.out.println("4. Filter by Color");
            System.out.println("5. Filter by Mileage");
            System.out.println("6. Filter by Vehicle Type");
            System.out.println("7. See All Vehicles");
            System.out.println("8. Add a Vehicle");
            System.out.println("9. Remove a Vehicle");
            System.out.println("10. Exit");
            System.out.print("Your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter 1-10.");
                scanner.nextLine();                 // discard bad input
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();                     // clear newline

            switch (choice) {
                case 1 -> processGetByPriceRequest(scanner);
                case 2 -> processGetByMakeModelRequest(scanner);
                case 3 -> processGetByYearRequest(scanner);
                case 4 -> processGetByColorRequest(scanner);
                case 5 -> processGetByMileageRequest(scanner);
                case 6 -> processGetByVehicleTypeRequest(scanner);
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest(scanner);
                case 9 -> processRemoveVehicleRequest(scanner);
                case 10 -> System.out.println("Thank you for visiting our dealership!");
                default -> System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    private void processGetByPriceRequest(Scanner scanner) {

        System.out.println("Filtering by Price");
        System.out.print("Enter Min Price: ");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Max Price: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Based off your price range of " + minPrice + " and " + maxPrice + ".\n");

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);

        System.out.println(FORMATTED_HEADER);
        displayVehicles(vehicles);

    }

    private void processGetByMakeModelRequest(Scanner scanner) {

        System.out.println("Filtering by Make and Model");
        System.out.print("Enter Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();

        System.out.println("Based off your desired Make: " + make + " and Model:" + model + ".\n");

        List<Vehicle> vehicles = dealership.getVehiclesByMake(make, model);

        System.out.println(FORMATTED_HEADER);
        displayVehicles(vehicles);

    }

    private void processGetByYearRequest(Scanner scanner) {

        System.out.println("Filtering by Year");
        System.out.print("Enter Min Year: ");
        int minYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Max Year: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Based off your Year range of " + minYear + " and " + maxYear + ".\n");

        List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);

        System.out.println(FORMATTED_HEADER);
        displayVehicles(vehicles);

    }

    private void processGetByColorRequest(Scanner scanner) {

        System.out.println("Filtering by Color");
        System.out.print("Enter Color: ");
        String color = scanner.nextLine();

        System.out.println("Based off your desired color of " + color + ".\n");

        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);

        System.out.println(FORMATTED_HEADER);
        displayVehicles(vehicles);

    }

    private void processGetByMileageRequest(Scanner scanner) {

        System.out.println("Filtering by Mileage");
        System.out.print("Enter Min Mileage: ");
        int minMileage = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Max Mileage: ");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Based off your Mileage range of " + minMileage + " and " + maxMileage + ".\n");

        List<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);

        System.out.println(FORMATTED_HEADER);
        displayVehicles(vehicles);

    }

    private void processGetByVehicleTypeRequest(Scanner scanner) {

        System.out.println("Filtering by Vehicle Type");
        System.out.print("Enter Vehicle Type: ");
        String vehicleType = scanner.nextLine();

        System.out.println("Based off your desired Vehicle Type of " + vehicleType + ".\n");

        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);

        System.out.println(FORMATTED_HEADER);
        displayVehicles(vehicles);

    }

    /**
     * Displays all vehicles within dealership's inventory
     */
    private void processGetAllVehiclesRequest() {

        List<Vehicle> vehicles = dealership.getAllVehicles();
        System.out.println("\n" + FORMATTED_HEADER);
        displayVehicles(vehicles);

    }

    private void processAddVehicleRequest(Scanner scanner) {

        System.out.println("Adding a Vehicle");

        System.out.print("Enter Vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Year Manufactured: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter Color: ");
        String color = scanner.nextLine();
        System.out.print("Enter Mileage: ");
        int mileage = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\nAdded Vehicle");
        System.out.println("\n" + FORMATTED_HEADER);
        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
        System.out.println(vehicle);
        dealership.addVehicle(vehicle);
        DealershipFileManager.saveDealership(dealership);

    }

    private void processRemoveVehicleRequest(Scanner scanner) {

        System.out.println("Removing a Vehicle");

        System.out.print("Enter Vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Year Manufactured: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter Color: ");
        String color = scanner.nextLine();
        System.out.print("Enter Mileage: ");
        int mileage = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\nRemoved Vehicle");
        System.out.println("\n" + FORMATTED_HEADER);
        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
        System.out.println(vehicle);
        dealership.removeVehicle(vehicle);
        DealershipFileManager.saveDealership(dealership);

    }



    /* --------------------------------------------------------------------------
       Helper Functions
       -------------------------------------------------------------------------- */

    /**
     * Loads dealership details from dealerShipFileManager
     * into this.dealerShip
     */
    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    /**
     * Prints all the vehicles given within filtered list
     *
     * @param vehicles A custom list of vehicles (filtered)
     */
    private void displayVehicles(List<Vehicle> vehicles) {

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}

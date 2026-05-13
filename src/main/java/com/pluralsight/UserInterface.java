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
        System.out.println("Filtering by price");
        System.out.print("Enter min price: ");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter max price: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Based off your price range of " + minPrice + " and " + maxPrice + ".\n");

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        System.out.println(FORMATTED_HEADER);
        displayVehicles(vehicles);

    }

    private void processGetByMakeModelRequest(Scanner scanner) {
    }

    private void processGetByYearRequest(Scanner scanner) {
    }

    private void processGetByColorRequest(Scanner scanner) {
    }

    private void processGetByMileageRequest(Scanner scanner) {
    }

    private void processGetByVehicleTypeRequest(Scanner scanner) {
    }

    /**
     * Displays all vehicles within dealership's inventory
     */
    private void processGetAllVehiclesRequest() {

        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);

    }

    private void processAddVehicleRequest(Scanner scanner) {
    }

    private void processRemoveVehicleRequest(Scanner scanner) {
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

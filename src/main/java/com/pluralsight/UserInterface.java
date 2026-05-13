package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

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
                System.out.println("Please enter 1-9.");
                scanner.nextLine();                 // discard bad input
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();                     // clear newline

            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 10 -> System.out.println("Thank you for visiting our dealership!");
                default -> System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    private void processRemoveVehicleRequest() {
    }

    private void processAddVehicleRequest() {
    }

    private void processGetByVehicleTypeRequest() {
    }

    private void processGetByMileageRequest() {
    }

    private void processGetByColorRequest() {
    }

    private void processGetByYearRequest() {
    }

    private void processGetByMakeModelRequest() {
    }

    private void processGetByPriceRequest() {
    }

    /**
     * Displays all vehicles within dealership's inventory
     */
    private void processGetAllVehiclesRequest() {

        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);

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
            System.out.println(vehicle.toString());
        }
    }
}

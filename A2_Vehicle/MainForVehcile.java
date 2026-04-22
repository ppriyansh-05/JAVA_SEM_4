import java.util.Scanner;

public class MainForVehicle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creating Multiple Objects (Teacher Style)
        Vehicle v1 = new Vehicle("Toyota", "Corolla", 1500000, "Petrol");
        Vehicle v2 = new Vehicle("Tata", "Nexon", 1400000, "Diesel");
        Vehicle v3 = new Vehicle("Tesla", "Model 3", 6000000, "Electric");
        Vehicle v4 = new Vehicle("Honda", "City Hybrid", 2000000, "Hybrid");

        // Custom User Input
        System.out.println("Enter Custom Vehicle Details:");

        System.out.print("Brand Name: ");
        String brand = sc.nextLine();

        System.out.print("Model Name: ");
        String model = sc.nextLine();

        System.out.print("Price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Fuel Type (Petrol/Diesel/Electric/Hybrid): ");
        String fuel = sc.nextLine();

        Vehicle v5 = new Vehicle(brand, model, price, fuel);

        // Array of Vehicles
        Vehicle[] vehicles = {v1, v2, v3, v4, v5};

        float distance = 500;
        float fuelUsed = 25;

        System.out.println("\n===== VEHICLE OPERATIONS =====\n");

        // Calling Methods (Teacher Style Execution)
        for (Vehicle v : vehicles) {

            v.start();
            v.drive();

            float newSp = v.changeSpeed(40);
            System.out.println("New Speed: " + newSp);

            float mileage = v.calcMileage(distance, fuelUsed);
            System.out.println("Mileage: " + mileage);

            v.stop();
            System.out.println("----------------------------");
        }

        // Extra: Tabular Format Printing
        System.out.println("\n===== FINAL VEHICLE DATA TABLE =====\n");

        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-10s %-12s %-15s %-10s %-10s\n",
                "FuelType", "Brand", "Model", "Mileage", "Price");
        System.out.println("--------------------------------------------------------------------------");

        for (Vehicle v : vehicles) {

            float mileage = v.calcMileage(distance, fuelUsed);

            System.out.printf("%-10s %-12s %-15s %-10.2f %-10.2f\n",
                    v.getFuelType(),
                    v.getBrandName(),
                    v.getModelName(),
                    mileage,
                    v.getPrice());
        }

        System.out.println("--------------------------------------------------------------------------");

        sc.close();
    }
}

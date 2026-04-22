public class Main {

    public static void main(String[] args) {

        // FullTimeEmployee (SWE)
        FullTimeEmployee emp1 = new FullTimeEmployee(
                "Aayush", "ABCDE1234F", "01-01-2023", "SWE", 101,
                50000, 10000, "SWE"
        );

        // FullTimeEmployee (HR)
        FullTimeEmployee emp2 = new FullTimeEmployee(
                "Pooja", "XYZAB5678L", "05-02-2023", "HR", 102,
                40000, 0, "HR"
        );

        // ContractEmployee
        ContractEmployee emp3 = new ContractEmployee(
                "Riya", "PQRSX5678K", "15-02-2024", "Consultant", 103,
                120, 500
        );

        // Manager
        Manager manager = new Manager(
                "Rahul", "LMNOP9876Z", "10-03-2022", "Manager", 104,
                80000, 20000, "SWE",
                5000, 7000
        );

        // Output
        System.out.println("\n--- Full Time Employee (SWE) ---");
        emp1.displayDetails();
        System.out.println("Gross Salary: " + emp1.calcCTC());

        System.out.println("\n--- Full Time Employee (HR) ---");
        emp2.displayDetails();
        System.out.println("Gross Salary: " + emp2.calcCTC());

        System.out.println("\n--- Contract Employee ---");
        emp3.displayDetails();
        System.out.println("Gross Salary: " + emp3.calcCTC());

        System.out.println("\n--- Manager ---");
        manager.displayDetails();
        System.out.println("Gross Salary: " + manager.calcCTC());
    }
}
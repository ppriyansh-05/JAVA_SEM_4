abstract class Employee {

    String name;
    String PANNo;
    String joiningDate;
    String designation;
    int empId;

    // Constructor
    Employee(String name, String PANNo, String joiningDate, String designation, int empId) {
        this.name = name;
        this.PANNo = PANNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
        this.empId = empId;
    }

    // Abstract Method
    abstract double calcCTC();

    // Display Method
    void displayDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("PAN No: " + PANNo);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("Designation: " + designation);
    }
}
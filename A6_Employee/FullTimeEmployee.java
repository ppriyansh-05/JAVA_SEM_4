class FullTimeEmployee extends Employee {

    double baseSalary;
    double perfBonus;
    String role;

    FullTimeEmployee(String name, String PANNo, String joiningDate,
                     String designation, int empId,
                     double baseSalary, double perfBonus, String role) {

        super(name, PANNo, joiningDate, designation, empId);
        this.baseSalary = baseSalary;
        this.perfBonus = perfBonus;
        this.role = role;
    }

    // calcCTC based on role
    double calcCTC() {
        if (role.equalsIgnoreCase("SWE")) {
            return baseSalary + perfBonus;
        } else if (role.equalsIgnoreCase("HR")) {
            double hiringCommission = 5000;
            return baseSalary + hiringCommission;
        } else {
            return baseSalary;
        }
    }
}
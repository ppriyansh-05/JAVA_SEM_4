class ContractEmployee extends Employee {

    int noOfHrs;
    double hourlyRate;

    ContractEmployee(String name, String PANNo, String joiningDate,
                     String designation, int empId,
                     int noOfHrs, double hourlyRate) {

        super(name, PANNo, joiningDate, designation, empId);
        this.noOfHrs = noOfHrs;
        this.hourlyRate = hourlyRate;
    }

    // calcCTC for contract
    double calcCTC() {
        return noOfHrs * hourlyRate;
    }
}
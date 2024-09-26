public class Employee extends Person {
    // name attribute is inherited from Person class
    private double salary;
    private int hireYear;
    private String id;

    // Constructor for Employee object
    public Employee(String initName, String initId, double initSalary, int initHireYear) {
        //utilize parent class Person's constructor for name
        super(initName);
        id = initId;
        salary = initSalary;
        hireYear = initHireYear;
    }

    // getName() and setName() are inherited from parent class

    // mutator and accessor methods for salary
    public void setSalary(double newSalary) {
        salary = newSalary;
    }

    public double getSalary() {
        return salary;
    }

    // mutator and accessor methods for year of hire
    public void setHireYear(int newHireYear) {
        hireYear = newHireYear;
    }

    public int getHireYear() {
        return hireYear;
    }

    // mutator and accessor methods for employee ID
    public void setId(String newId) {
        id = newId;
    }

    public String getId() {
        return id;
    }

    // method to print all attributes to stdout
    public void writeOutput() {
        super.writeOutput();
        System.out.println("Employee ID: " + getId());
        System.out.println("Salary: " +  getSalary());
        System.out.println("Year of Hire: " + getHireYear());
    }

    // method to determine if two employees are the same (i.e. all attributes are the same)
    public boolean equals(Employee otherEmployee) {
        return super.equals(otherEmployee) &&
                this.getId().equalsIgnoreCase(otherEmployee.getId()) &&
                this.getSalary() == otherEmployee.getSalary() &&
                this.getHireYear() == otherEmployee.getHireYear();
    }
}

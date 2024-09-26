public class Faculty extends Employee {
    String title;

    public Faculty(String initName, String initId, double initSalary, int initHireYear, String initTitle) {
        //utilize parent class Employee's constructor for other fields
        super(initName, initId, initSalary, initHireYear);
        title = initTitle;
    }
    // accessor and mutator methods for Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    // method to print all attributes to stdout
    public void WriteOutput() {
        super.writeOutput();
        System.out.println("Title: " + getTitle());
    }

    // method to determine if two Faculty are the same (i.e. all attributes are the same)
    public boolean equals(Faculty otherFac) {
        return super.equals(otherFac) && (this.getTitle().equalsIgnoreCase(otherFac.getTitle()));
    }
}

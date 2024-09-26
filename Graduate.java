public class Graduate extends Student {
    private enum level {
        MASTERS, DOCTORAL
    }
    private level lvl;

    public Graduate(String initialName, int initialStudentNumber, String initLevel) {
        //utilize parent class Student's constructor for other fields
        super(initialName, initialStudentNumber);
        if (initLevel.equalsIgnoreCase(level.MASTERS.name())) {
            lvl = level.MASTERS;
        }
        else {
            lvl = level.DOCTORAL;
        }
    }

    // accessor and mutator methods for Level
    public String getLvl() {
        return lvl.name();
    }

    public void setLvl(String newLvl) {
        if (newLvl.equalsIgnoreCase(level.MASTERS.name())) {
            lvl = level.MASTERS;
        }
        else {
            lvl = level.DOCTORAL;
        }
    }

    // method to print all attributes to stdout
    public void writeOutput() {
        super.writeOutput();
        System.out.println("Graduate Level: " + lvl);
    }

    // method to determine if two Graduates are the same (i.e. all attributes are the same)
    public boolean equals(Graduate otherGrad) {
        return   super.equals(otherGrad) &&
                (this.getLvl().equalsIgnoreCase(otherGrad.getLvl()));
    }
}


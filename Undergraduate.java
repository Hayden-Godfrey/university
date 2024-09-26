public class Undergraduate extends Student {

    private enum level {
        FRESHMAN, SOPHOMORE, JUNIOR, SENIOR
    }
    private level lvl;

    public Undergraduate(String initialName, int initialStudentNumber, String initLevel) {
        //utilize parent class Student's constructor for other fields
        super(initialName, initialStudentNumber);
        if (initLevel.equalsIgnoreCase(level.FRESHMAN.name())) {
            lvl = level.FRESHMAN;
        }
        else if (initLevel.equalsIgnoreCase(level.SOPHOMORE.name())) {
            lvl = level.SOPHOMORE;
        }
        else if (initLevel.equalsIgnoreCase(level.JUNIOR.name())) {
            lvl = level.JUNIOR;
        }
        else {
            lvl = level.SENIOR;
        }
    }

    // accessor and mutator methods for Level
    public String getLvl() {
        return lvl.name();
    }

    public void setLvl(String newLvl) {
        if (newLvl.equalsIgnoreCase(level.FRESHMAN.name())) {
            lvl = level.FRESHMAN;
        }
        else if (newLvl.equalsIgnoreCase(level.SOPHOMORE.name())) {
            lvl = level.SOPHOMORE;
        }
        else if (newLvl.equalsIgnoreCase(level.JUNIOR.name())) {
            lvl = level.JUNIOR;
        }
        else {
            lvl = level.SENIOR;
        }
    }

    // method to print all attributes to stdout
    public void writeOutput() {
        super.writeOutput();
        System.out.println("Undergraduate Level: " + lvl);
    }

    // method to determine if two Undergraduates are the same (i.e. all attributes are the same)
    public boolean equals(Undergraduate otherUG) {
        return   super.equals(otherUG) &&
                (this.getLvl().equalsIgnoreCase(otherUG.getLvl()));
    }
}


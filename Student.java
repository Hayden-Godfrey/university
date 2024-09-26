public class Student extends Person
{
    private int studentNumber;
    public Student(String initialName, int initialStudentNumber) {
        super(initialName);
        studentNumber = initialStudentNumber;
    }
    // resets name and number for Student
    public void reset(String newName, int newStudentNumber) {
        setName(newName);
        studentNumber = newStudentNumber;
    }

    // accessor and mutator methods for Student ID Number
    public int getStudentNumber()
    {
        return studentNumber;
    }
    public void setStudentNumber(int newStudentNumber) {
        studentNumber = newStudentNumber;
    }

    // method to print all attributes to stdout
    public void writeOutput() {
        System.out.println("Name: " + getName());
        System.out.println("Student Number: " + studentNumber);
    }

    // method to determine if two Students are the same (i.e. all attributes are the same)
    public boolean equals(Student otherStudent) {
        return super.equals(otherStudent) && (this.studentNumber == otherStudent.studentNumber);
    } }
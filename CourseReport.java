import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CourseReport {

    public static void main(String[] args) {
        // ********** Get filename from STDIN **********
        Scanner sc = new Scanner(System.in);
        String inputFileName;
        System.out.print("Please enter the filename for the file that contains course details: ");
        inputFileName = sc.nextLine();
        // ********** ********** **********

        // ********** Open input file **********
        Scanner inp = null;
        String filePath = System.getProperty("user.dir") + "/";
        try {
            inp = new Scanner(new File(filePath + inputFileName));
        }
        catch(FileNotFoundException e) {
            System.out.println(filePath);
            System.out.println("Error opening the file: " + inputFileName);
            System.exit(1);
        }
        // ********** ********** **********

        // ********** Collecting data **********

        // Create ArrayLists to store different objects created as txt file is parsed (dynamic)
        ArrayList<Faculty> facList = new ArrayList<>();
        ArrayList<Staff> staffList = new ArrayList<>();
        ArrayList<Undergraduate> uList = new ArrayList<>();
        ArrayList<Graduate> gList = new ArrayList<>();
        String number = "";
        String name = "";

        while (inp.hasNextLine()) {
            String content = inp.nextLine();

            // Remove prefix from text, then create the object.
            // Add object to its respective ArrayList only if it is not a duplicate.

            if (content.contains("Number: ")) {
                content = content.replace("Number: ", "");
                number = content;
            }
            else if (content.contains("Name: ")) {
                content = content.replace("Name: ", "");
                name = content;
            }
            else if (content.contains("Instructor: ")) {
                content = content.replace("Instructor: ", "");
                String[] attr = content.split("; ");
                Faculty f = new Faculty(attr[0], attr[1], Double.parseDouble(attr[2].replace(",","")), Integer.parseInt(attr[3]), attr[4]);
                boolean skip = false;
                for (Faculty x : facList)
                    if (x.equals(f)) {
                        skip = true;
                        break;
                    }
                // Course can have at most 2 faculty
                if (!skip && (facList.size() < 2)) {
                    facList.add(f);
                }
            }

            else if (content.contains("Staff: ")) {
                content = content.replace("Staff: ", "");
                String[] attr = content.split("; ");
                Staff s = new Staff(attr[0], attr[1], Double.parseDouble(attr[2].replace(",","")), Integer.parseInt(attr[3]), Integer.parseInt(attr[4]));
                boolean skip = false;
                for (Staff x : staffList)
                    if (x.equals(s)) {
                        skip = true;
                        break;
                    }
//                 Course can have at most 5 staff
                if (!skip && (staffList.size() < 5)) {
                    staffList.add(s);
                }
//                System.out.println(content);
            }

            else if (content.contains("Undergraduate: ")) {
                content = content.replace("Undergraduate: ", "");
                String[] attr = content.split("; ");
                Undergraduate u = new Undergraduate(attr[0], Integer.parseInt(attr[1]), attr[2]);
                boolean skip = false;
                for (Undergraduate x : uList)
                    if (x.equals(u)) {
                        skip = true;
                        break;
                    }
                if (!skip) {
                    uList.add(u);
                }
            }

            else if (content.contains("Graduate: ")) {
                content = content.replace("Graduate: ", "");
                String[] attr = content.split("; ");
                Graduate g = new Graduate(attr[0], Integer.parseInt(attr[1]), attr[2]);
                boolean skip = false;
                for (Graduate x : gList)
                    if (x.equals(g)) {
                        skip = true;
                        break;
                    }
                if (!skip) {
                    gList.add(g);
                }
            }
        }
        // ********** ********** **********


        //********** Create Course Object **********
        Course c = new Course(number, name, facList, staffList, uList, gList);
        // ********** ********** **********

        // ********** Get/execute desired action from STDIN **********
        String userInput;
        action: while(true) {
            System.out.print("What would you like to know?\n" +
                    "1. Name of the course.\n" +
                    "2. Number of the course.\n" +
                    "3. How many employees?\n" +
                    "4. Who are the instructors?\n" +
                    "5. Who are the teaching assistants?\n" +
                    "6. How many instructors are teaching?\n" +
                    "7. How many teaching assistants?\n" +
                    "8. How many students?\n" +
                    "9. How many graduate students?\n" +
                    "10. How many undergraduate students?\n" +
                    "11. How many freshman/sophomore/juniors/seniors?\n" +
                    "12. How many masters/doctoral students?\n" +
                    "13. Find a specific student, either based on the student’s name or student number.\n" +
                    "14. Exit" +
                    "\n\nSelection: ");
            userInput = sc.nextLine();
            System.out.println();

            // use switch to execute based on input
            switch((Integer.parseInt(userInput))) {
                case 1: // print Course name
                    System.out.println("Course Name: ");
                    System.out.println(c.getCourseName());
                    break;
                case 2:// print Course number
                    System.out.println("Course Number: ");
                    System.out.println(c.getCourseNum());
                    break;
                case 3: // print number of Employees
                    System.out.println("Total employees: " + c.getNumEmployees());
                    break;
                case 4: // print Instructor Information
                    System.out.println("Instructor Information:");
                    c.getInstructorInfo();
                    break;
                case 5:// print Staff names
                    System.out.println("Staff Names:");
                    c.getStaffInfo();
                    break;
                case 6: // print number of Faculty
                    System.out.println("Total number of instructors: "+ c.getNumFaculty());
                    break;
                case 7: // print number of Staff
                    System.out.println("Total number of staff: " + c.getNumStaff());
                    break;
                case 8: // print number of Students
                    System.out.println("Total number of students: " + c.getNumStudents());
                    break;
                case 9: // print number of Graduates
                    System.out.println("Total number of graduates: " + c.getNumGrads());
                    break;
                case 10: // print number of Undergraduates
                    System.out.println("Total number of undergraduates: " + c.getNumUndergrads());
                    break;
                case 11: // print number of Undergraduates by Level
                    System.out.println("Undergraduate level breakdown:");
                    System.out.println(c.getNumUndergradsByLevel());
                    break;
                case 12: // print number of Graduates by level
                    System.out.println("Graduate level breakdown:");
                    System.out.println(c.getNumGradsByLevel());
                    break;
                case 13: // print results of searching for student by name or by student ID
                    System.out.print("How would you like to find the student?\n1. Student name\n2. Student number\n");
                    userInput = sc.nextLine();
                    boolean found = false;
                    // Search by name
                    if (userInput.equals("1")){
                        System.out.print("Please enter the student name: ");
                        userInput = sc.nextLine();
                        System.out.println();
                        for(Undergraduate u : uList){
                            if(userInput.equalsIgnoreCase(u.getName())){
                                System.out.println("Student Search Result:");
                                u.writeOutput();
                                found = true;
                                break;
                            }
                        }
                        if (!found){
                            for(Graduate g : gList){
                                if(userInput.equalsIgnoreCase(g.getName())){
                                    System.out.println("Student Search Result:");
                                    g.writeOutput();
                                    found = true;
                                    break;
                                }
                            }
                        }
                        // If no matching student was found, print a message
                        if(!found) {
                            System.out.println("Student not found.");
                        }
                    }
                    // Search by Student ID
                    else if (userInput.equals("2")){
                        System.out.print("Please enter the student number: ");
                        userInput = sc.nextLine();
                        System.out.println();
                        for(Undergraduate u : uList){
                            if(Integer.parseInt(userInput) == u.getStudentNumber()){
                                System.out.println("Student Search Result:");
                                u.writeOutput();
                                found = true;
                                break;
                            }
                        }
                        if (!found){
                            for(Graduate g : gList){
                                if(Integer.parseInt(userInput) == g.getStudentNumber()){
                                    System.out.println("Student Search Result:");
                                    g.writeOutput();
                                    found = true;
                                    break;
                                }
                            }
                        }
                        // If no matching student was found, print a message
                        if(!found){
                            System.out.println("Student not found");
                        }
                    }
                    break;
                case 14: // Break out of the program loop
                    break action;
            }
            System.out.println();
            System.out.println();
        }
        sc.close();
        // ********** ********** **********

    }
}
import java.util.ArrayList;
public class Course {
    String c_num;
    String c_name;
    ArrayList<Faculty> fac;
    ArrayList<Staff> stf;
    ArrayList<Undergraduate> ug;
    ArrayList<Graduate> gr;

    public Course(String num, String name, ArrayList<Faculty> instructor, ArrayList<Staff> ta, ArrayList<Undergraduate> under, ArrayList<Graduate> grad) {
        c_num = num;
        c_name = name;
        fac = instructor;
        stf = ta;
        ug = under;
        gr = grad;

    }

    public String getCourseName() {
        return c_name;
    }

    public String getCourseNum() {
        return c_num;
    }

    public void getInstructorInfo() {
        for (Faculty f : fac) {
            f.writeOutput();
        }
    }

    public void getStaffInfo() {
        for (Staff s : stf) {
            s.writeOutput();
        }
    }

    public int getNumUndergrads(){
        return ug.size();
    }

    public int getNumGrads(){
        return gr.size();
    }

    public int getNumStudents(){
        return ug.size() + gr.size();
    }
    public int getNumFaculty(){
        return fac.size();
    }
    public int getNumEmployees(){
        return fac.size() + stf.size();
    }
    public int getNumStaff(){
        return stf.size();
    }
    public String getNumUndergradsByLevel(){
        int fresh = 0;
        int soph = 0;
        int juni = 0;
        int sen = 0;
        for(Undergraduate s : ug){
            if(s.getLvl().equalsIgnoreCase("Freshman")){
                fresh++;
            }
            else if(s.getLvl().equalsIgnoreCase("Sophomore")){
                soph++;
            }
            else if(s.getLvl().equalsIgnoreCase("Junior")){
                juni++;
            }
            else{
                sen++;
            }
        }
        return String.format("Freshman: %d\nSophomore: %d\nJunior: %d\nSeniors: %d", fresh, soph, juni, sen);
    }
    public String getNumGradsByLevel(){
        int master = 0;
        int doctor = 0;
        for(Graduate g : gr){
            if(g.getLvl().equalsIgnoreCase("Masters")){
                master++;
            }
            else{
                doctor++;
            }
        }
        return String.format("Masters: %d\nDoctoral: %d", master, doctor);
    }
}
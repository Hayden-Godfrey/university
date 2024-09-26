public class Test {
    public static void main(String[] args) {
        // ******** Person Test ********
        Person p1 = new Person("Nik Kalli");
        Person p2 = new Person("Hayden Godfrey");
        Person p3 = new Person("Nik Kalli");

        if (p1.equals(p2)) {
            System.out.println("Failed: p1 != p2");
        }
        if (!p1.equals(p3)) {
            System.out.println("Failed: p1 == p3");
        }

        // ******** Student Test ********
        Student s1 = new Student("Nik Kalli", 12345);
        Student s2 = new Student("Hayden Godfrey", 54321);
        Student s3 = new Student("Nik Kalli", 12345);

        if (s1.equals(s2)) {
            System.out.println("Failed: s1 != s2");
        }
        if (!s1.equals(s3)) {
            System.out.println("Failed: s1 == s3");
        }

        // ******** Undergraduate Test ********
        Undergraduate u1 = new Undergraduate("Nik Kalli", 12345, "JUNIOR");
        Undergraduate u2 = new Undergraduate("Hayden Godfrey", 54321, "JUNIOR");
        Undergraduate u3 = new Undergraduate("Nik Kalli", 12345, "JUNIOR");

        if (u1.equals(u2)) {
            System.out.println("Failed: u1 != u2");
        }
        if (!u1.equals(u3)) {
            System.out.println("Failed: u1 == u3");
        }

        // ******** Graduate Test ********
        Graduate g1 = new Graduate("Nik Kalli", 12345, "MASTERS");
        Graduate g2 = new Graduate("Hayden Godfrey", 54321, "DOCTORAL");
        Graduate g3 = new Graduate("Nik Kalli", 12345, "MASTERS");

        if (g1.equals(g2)) {
            System.out.println("Failed: g1 != g2");
        }
        if (!g1.equals(g3)) {
            System.out.println("Failed: g1 == g3");
        }

        // ******** Employee Test ********
        Employee e1 = new Employee("Nik Kalli", "a12345", 50000, 2018);
        Employee e2 = new Employee("Hayden Godfrey", "a54321", 60000,2015);
        Employee e3 = new Employee("Nik Kalli", "a12345", 50000, 2018);

        if (e1.equals(e2)) {
            System.out.println("Failed: e1 != e2");
        }
        if (!e1.equals(e3)) {
            System.out.println("Failed: e1 == e3");
        }


        // ******** Faculty Test ********
        Faculty f1 = new Faculty("Nik Kalli", "a12345", 50000, 2018, "PROFESSOR");
        Faculty f2 = new Faculty("Hayden Godfrey", "a54321", 60000,2015, "MR");
        Faculty f3 = new Faculty("Nik Kalli", "a12345", 50000, 2018, "PROFESSOR");
        if (f1.equals(f2)) {
            System.out.println("Failed: f1 != f2");
        }
        if (!f1.equals(f3)) {
            System.out.println("Failed: f1 == f3");
        }

        // ******** Staff Test ********
        Staff st1 = new Staff("Nik Kalli", "a12345", 50000, 2018, 15);
        Staff st2 = new Staff("Hayden Godfrey", "a54321", 60000, 2015, 16);
        Staff st3 = new Staff("Nik Kalli", "a12345", 50000, 2018, 15);

        if (st1.equals(st2)) {
            System.out.println("Failed: st1 != st2");
        }
        if (!st1.equals(st3)) {
            System.out.println("Failed: st1 == st3");
        }
    }
}

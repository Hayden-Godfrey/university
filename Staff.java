public class Staff extends Employee{
    int pay;
    public Staff(String initName, String initId, double initSalary, int initHireYear, int payGrade){
        super(initName, initId, initSalary, initHireYear);
        pay = payGrade;
    }
    public int getPay(){
        return pay;
    }
    public void setPay(int p) {
        if (p <= 20 || p >= 1)
            pay = p;
    }
    public void writeOutput(){
        super.writeOutput();
        System.out.println("Staff pay grade: " + pay);
    }
    public boolean equals(Staff stf) {
        return super.equals(stf) && (this.getPay() == stf.getPay());
    }
}
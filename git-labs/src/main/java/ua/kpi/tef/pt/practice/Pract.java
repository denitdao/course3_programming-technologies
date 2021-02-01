package ua.kpi.tef.pt.practice;

public class Pract {

    private int prv;
    int def;
    protected int prot;
    public int pbl;

    void smth() {
        Pract pract = new Pract();
        pract.prv = 3;
        pract.prot = 3;
        pract.def = 3;
        pract.pbl = 3;
        this.prv = 3;
        this.prot = 3;
        this.def = 3;
        this.pbl = 3;
    }

    public static void main(String[] args) {

    }

}

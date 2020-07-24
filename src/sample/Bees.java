package sample;

import java.util.ArrayList;
import java.util.Objects;

public class Bees  implements Comparable {
    ArrayList<Integer> rArea = new ArrayList<>();
    SAT sat;
    int dance ;
    int nbchance;

    public Bees(ArrayList<Integer> rArea,SAT sat) {
        this.rArea = rArea;
        this.sat= sat;
        this.sat.setVal(rArea);
        this.dance=this.sat.getListeclause().size()-this.sat.NBSatisfait();
    }
    public Bees(ArrayList<Integer> rArea,SAT sat,int nbchance) {
        this.rArea = rArea;
        this.sat= sat;
        this.sat.setVal(rArea);
        this.dance=this.sat.getListeclause().size()-this.sat.NBSatisfait();
        this.nbchance=nbchance;
    }

    public Bees(Bees b) {
        this.rArea = new ArrayList<>(b.rArea);
        this.sat= new SAT(b.sat.getListeclause(),b.rArea);
        this.dance=this.sat.getListeclause().size()-this.sat.NBSatisfait();
    }

    public int dance()
    {   this.sat.setVal(rArea);
        this.dance=sat.getListeclause().size()-sat.NBSatisfait();
        return dance;
    }

    public ArrayList<Integer> getrArea() {
        return rArea;
    }

    public void setrArea(ArrayList<Integer> rArea) {
        this.rArea = rArea;
    }

    public SAT getSat() {
        return sat;
    }

    public void setSat(SAT sat) {
        this.sat = sat;
    }

    public Integer getDance() {
        return dance;
    }

    public void setDance(Integer dance) {
        this.dance = dance;
    }

    @Override
    public int compareTo(Object o) {
        Bees bee =(Bees) o;
        Integer d1=this.dance;
        Integer d2=bee.dance;
        return d1.compareTo(d2);
    }

    int distance_hamming(ArrayList<Integer> b)
    {   int nb=0;
        for(int i= 0;i<b.size();i++)
        {
            if (!b.get(i).equals(rArea.get(i)))
            {
                nb++;
            }
        }
        return nb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bees)) return false;
        Bees bees = (Bees) o;
        return rArea.equals(bees.rArea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rArea);
    }

    @Override
    public String toString() {
        return "sample.Bees{" +
                "rArea=" + rArea +
                ", dance=" + dance +
                '}';
    }
}

package sample;

import java.util.ArrayList;
import java.util.LinkedList;

public class SAT {
   private LinkedList<Clause> Listeclause = new LinkedList<>();
   private ArrayList<Integer> Val;
    public SAT(LinkedList<Clause> listeclause, ArrayList<Integer>val) {
        Listeclause = listeclause;
        Val = val;
    }

    public SAT(LinkedList<Clause> listeclause) {
        Listeclause = listeclause;
    }

    public LinkedList<Clause> getListeclause() {
        return Listeclause;
    }

    public void setListeclause(LinkedList<Clause> listeclause) {
        Listeclause = listeclause;
    }

    public ArrayList<Integer> getVal() {
        return Val;
    }

    public void setVal(ArrayList<Integer> val) {
        Val = val;
    }
    public int NBSatisfait()
    {   int nb=0;
        for(int i=0;i<Listeclause.size();i++)
        {
            if(Listeclause.get(i).isCheck(Val))
            {
                nb++;
            }

        }
        return nb;
    }
    public boolean satisfait()
    {
        return (NBSatisfait()==Listeclause.size());
    }
}

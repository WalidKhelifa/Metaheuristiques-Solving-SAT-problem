package sample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Chromosone implements Comparable{
    // represente les atributs et methodes  pour chaque individu

    ArrayList<Integer> Val = new ArrayList<>();// represente la solution
    Integer value ;// le nombre de clause insatisfaite




    public Chromosone() {
        Random rand = new Random();
        for(int i=0;i<=75;i++)
        {
            int rnd = rand.nextInt(2);// [1,0...]

            Val.add(rnd);
        }
    }



    public ArrayList<Integer> getVal()
    {
        return Val;
    }

    public void setVal(ArrayList<Integer> val)
    {
        Val = val;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    // methode qui exécute le sat avec la solution et initialisé value et retourn value
    public int calcCost(LinkedList<Clause> list){

        SAT S =new SAT(list,Val);
        this.value =S.getListeclause().size()-S.NBSatisfait();
        return value ;
    }

    // la methode de croisement a en entre un individu et retourne 4 enfant avec un croisement a double pivot

    public LinkedList<Chromosone> Croisement (Chromosone marie)
    {   LinkedList<Chromosone>  l =new LinkedList<>();
        Random rand = new Random();
        int pivot = rand.nextInt(Val.size());
        int pivot2 = rand.nextInt(Val.size());

        while (pivot==pivot2)
        {
            pivot2 = rand.nextInt(Val.size());
        }
        if (pivot>pivot2)
        {
            int val =pivot2;
            pivot2 = pivot;
            pivot =val;
        }

        Chromosone child1 =new Chromosone();
        child1.setVal(new ArrayList<Integer>(Val.subList(0,pivot)) );
        child1.Val.addAll(marie.Val.subList(pivot,pivot2));
        child1.Val.addAll(Val.subList(pivot2,Val.size()));

        Chromosone child2 =new Chromosone();
        child2.setVal(new ArrayList<Integer>( marie.Val.subList(0,pivot)));
        child2.Val.addAll(Val.subList(pivot,pivot2));
        child2.Val.addAll(marie.Val.subList(pivot2,Val.size()));

        Chromosone child3 =new Chromosone();
        child3.setVal(new ArrayList<Integer>(Val.subList(0,pivot)) );
        child3.Val.addAll(marie.Val.subList(pivot,marie.Val.size()));

        Chromosone child4 =new Chromosone();
        child4.setVal(new ArrayList<Integer>( marie.Val.subList(0,pivot2)));
        child4.Val.addAll(Val.subList(pivot2,Val.size()));
        l.add(child1);
        l.add(child2);
        l.add(child3);
        l.add(child4);
        return l;
    }



    //la methode de mutation qui fait muté le chromosone
    public boolean mutation (int chance)
    {
        Random rand = new Random();
        int zhar = rand.nextInt(101);
        if(zhar> chance)
        {
            return false;
        }
        int nbgene =1;
        for(int i=0;i<=nbgene;i++)
        {
            int genemutant = rand.nextInt(Val.size());
            if (Val.get(genemutant)==1)
            {
                Val.set(genemutant,0);
            }
            else
            {
                Val.set(genemutant,1);
            }
        }
        return  true ;
    }


    @Override
    public int compareTo(Object o) {
        Chromosone c =(Chromosone) o;
        return value.compareTo(c.value);
    }

    @Override
    public String toString() {
        return "sample.Chromosone{" +
                "Val=" + Val +
                ", value=" + value +
                '}';
    }
}

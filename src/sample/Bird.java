package sample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Bird implements Comparable {
    SAT s;
    ArrayList<Integer> Position = new ArrayList<>();
    ArrayList<Integer> pref= new ArrayList<>() ;
    int perf ;
    int pref_perf;
    float vitesse ;
    float c1,c2,w;
    float r1,r2;

    public Bird(ArrayList<Integer> position, LinkedList<Clause> s, float v , float c1, float c2, float w, float r1, float r2, ArrayList<Integer> pref) {
        Position .addAll(position);
        this.pref.addAll(pref);
        this.vitesse=v;
        this.s=new SAT(s,Position);
        this.c1=c1;
        this.c2=c2;
        this.w=w;
        this.r1=r1;
        this.r2=r2;
        perf=this.s.getListeclause().size()-this.s.NBSatisfait();
        pref_perf=perf;



    }

    public Bird() {
    }

    public void calcperf()
    {   this.s.setVal(Position);
        perf=s.getListeclause().size()-s.NBSatisfait();
    }


    @Override
    public String toString() {
        return "sample.Bird{" +
                "perf=" + perf +
                ", pref_perf=" + pref_perf +
                '}';
    }

    public void move(ArrayList<Integer> gref)
    {
        int v;
        ArrayList<Integer> x = new ArrayList<>(Position);
        Random r = new Random();
        r1=r.nextFloat();
        r2=r.nextFloat();
        //System.out.println(this.distance_hamming(pref)+"========"+this.distance_hamming(gref));
        v= (int) ( w*vitesse+c1*r1*this.distance_hamming(pref)+c2*r2*this.distance_hamming(gref));
        if(v>=35)
        {
            v=35;
        }
        if(v==0)
        {
            v=5;
        }
        this.vitesse=v;

        Random rand = new Random();
        ArrayList<Integer> l=null;
        int ra=rand.nextInt();
        if(ra%3!=0)
        {
            l=different(pref);
        }
        else
        {
            l=different(gref);
        }
        /*if(l.size()==0)
        {
            l=different(gref);
            System.out.println("**");
        }*/
        if (l.size()%3!=0)
        {
        for(int i =1;i<=v;i++)
        {   if(l.size()==0)
            {
            break;
            }
            int k=rand.nextInt(l.size());
            int bit=l.get(k);
            l.remove(k);
            if (x.get(bit)==1)
            {
                x.set(bit,0);
            }
            else
            {
                x.set(bit,1);
            }

        }}
        else {
            for(int i =1;i<=v;i++)
            {
            int k=rand.nextInt(x.size());
            int bit=k;
            if (x.get(bit)==1)
            {
                x.set(bit,0);
            }
            else
            {
                x.set(bit,1);
            }

        }

        }

        this.Position= new ArrayList<>(x);
        calcperf();
        if(perf<pref_perf)
        {
            this.pref.clear();
            this.pref=new ArrayList<>(Position);
             pref_perf=perf;

        }
        
        if(w>0.4)
        {
            w=w-0.001f;
        }
    }

    int distance_hamming(ArrayList<Integer> b)
    {   int nb=0;
        for(int i= 0;i<b.size();i++)
        {
            if (!b.get(i).equals(Position.get(i)))
            {
                nb++;
            }
        }
        return nb;
    }
    ArrayList<Integer> different(ArrayList<Integer> b)
    {ArrayList<Integer> l=new ArrayList<>();
        for(int i= 0;i<b.size();i++)
        {
            if (!b.get(i).equals(Position.get(i)))
            {
                l.add(i);
            }

        }
        return l;
    }

    @Override
    public int compareTo(Object o) {
        Bird b= (Bird) o;
        Integer pref_perf= this.pref_perf;
        Integer pref_perf2=b.pref_perf;
        return pref_perf.compareTo(pref_perf2);
    }
}

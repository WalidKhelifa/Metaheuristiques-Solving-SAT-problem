package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class PSO {
    LinkedList<Bird> swarm = new LinkedList<>();
    ArrayList<Integer> Gref;
    int perf_Gref;
    int nbswarm;
    int vitesse_initial;
    int max_int;
    float c1,c2,w;
    float r1,r2;
    SAT s;

    public PSO(int nbswarm, int vitesse_initial, int max_int, float c1, float c2, float w, float r1, float r2, LinkedList<Clause> s) {
        this.nbswarm = nbswarm;
        this.vitesse_initial = vitesse_initial;
        this.max_int = max_int;
        this.c1 = c1;
        this.c2 = c2;
        this.w = w;
        this.r1 = r1;
        this.r2 = r2;
        this.s = new SAT(s);


        for(int j=1;j<=nbswarm;j++)
        {
            ArrayList<Integer> ref =new ArrayList<>();
            for(int i=0;i<=75;i++)
            {   Random rand =new Random();
                int rnd = rand.nextInt(2);

                ref.add(rnd);
            }
            Bird b = new Bird(ref,s,vitesse_initial,c1,c2,w,r1,r2,ref);
            swarm.add(b);
        }
    }

    public ArrayList<Integer> solvePso()
    {
        Collections.sort(swarm);
        Gref=swarm.getFirst().pref;
        perf_Gref=swarm.getFirst().pref_perf;
        while (max_int>0 && perf_Gref!=0)
        {   //Gref=new ArrayList<>(local_s(Gref));
            for (int i=0;i<swarm.size();i++)
            {
                swarm.get(i).move(Gref);
                swarm.get(i).calcperf();
                swarm.get(i).move(Gref);
                swarm.get(i).calcperf();

                //System.out.println(swarm.getFirst().different(Gref).size());
            }
            Collections.sort(swarm);
            if(perf_Gref>swarm.getFirst().pref_perf)
            {
                Gref=new ArrayList<>(swarm.getFirst().pref);
                perf_Gref=swarm.getFirst().pref_perf;
            }

             //Gref=new ArrayList<>(local_s(Gref));
            max_int--;
           //System.out.println(swarm.getFirst().vitesse);
            //System.out.println(swarm.getFirst().different(Gref).size());
            //System.out.println(perf_Gref);
        }
        return Gref;
    }
    public ArrayList<Integer> local_s(ArrayList<Integer> p)
    {   ArrayList<Integer> r=null;
        Random rand= new Random();
        int zhar = rand.nextInt(101);
        if(zhar>70 )
        {
            return p;
        }
        for(int i=0;i<1;i++)
        {   r= new ArrayList<>(p);
            rand= new Random();
           for(int j=0;j<=3;j++){
            int bit =rand.nextInt(p.size());
            int bit2=rand.nextInt(p.size());
            if(r.get(bit)==0)
            {
                r.set(bit,1);
            }
            else
            {
                r.set(bit,0);
            }
            if(r.get(bit2)==0)
            {
                r.set(bit2,1);
            }
            else
            {
                r.set(bit2,0);
            }}



        }
        return r;
    }

}

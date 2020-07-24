package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class BSO {
    SAT sat ;
    Bees sref ;
    int flip;
    int nbtry;
    int NbtryArea;
    int nbchance;
    int nbbees;
    LinkedList<Bees> danceList =new LinkedList<>();
    LinkedList<Area> researshArea =new LinkedList<>();
    LinkedList<Bees> taboo= new LinkedList<>();

    public BSO(SAT sat, int flip, int nbtry, int nbtryArea,int nbchance,int nbbees) {
        this.sat = sat;
        this.flip = flip;
        this.nbtry = nbtry;
        NbtryArea = nbtryArea;
        Random rand =new Random();
        ArrayList<Integer> ref =new ArrayList<>();
        for(int i=0;i<=75;i++)
        {
            int rnd = rand.nextInt(2);

            ref.add(rnd);
        }
        sref =new Bees(ref,this.sat,nbchance);
        sref.dance();
        this.nbchance=nbchance;
        this.nbbees=nbbees;

    }



    public void fliping(Bees sref)
    {
        ArrayList<Integer> s=null;

        for(int i=0;i<nbbees;i++)
        {   int p=0;
            s=new ArrayList<>(sref.rArea);
            int fliping=flip*p+i;
            while (fliping<s.size())
            {

                if (s.get(fliping)==1)
                {
                    s.set(fliping,0);
                }
                else
                {
                    s.set(fliping,1);
                }
                p++;
                fliping=flip*p+i;

            }
            researshArea.add(new Area(s,NbtryArea,sat));

        }

        }

    public void bestRef()
    {
        for (Area a :researshArea)
        {   a.search(taboo);
            danceList.add(a.danceArea.getFirst());
        }

        Collections.sort(danceList);


    }
    int diversity(Bees b1,Bees b2)
    {
       return b1.distance_hamming(b2.rArea);
    }
    Bees affectationsref(Bees b1)
    {
        if(!b1.equals(sref))
        {
            b1.nbchance=this.nbchance;
            return b1;
        }
        b1.nbchance--;
        if(b1.nbchance>0)
        {
            return b1;
        }
        int max= 0;
        int indice=0;
        Collections.sort(taboo);
        for (int i=0;i<taboo.size();i++)
        {
            if(taboo.get(i).distance_hamming(sref.rArea)==max)
            {
                if(taboo.get(i).dance<taboo.get(indice).dance)
                {
                    indice=i;
                }
            }
            if(taboo.get(i).distance_hamming(sref.rArea)>max)
            {
               indice=i;
            }
        }
        taboo.get(indice).nbchance=this.nbchance;
        return taboo.get(indice);
    }

    public ArrayList<Integer> solve()
    {   sref=this.sref;
        taboo.add(sref);
        while (nbtry>0 && sref.dance!=0){


            fliping(sref);
            bestRef();
            sref=affectationsref(danceList.getFirst());
           // sref=new sample.Bees(danceList.getFirst());
           // System.out.println(danceList);
            danceList.clear();
            researshArea.clear();
            //System.out.println(sref.dance);
            taboo.add(sref);

            nbtry--;
        }
        Collections.sort(taboo);
       return taboo.getFirst().rArea;

    }

}

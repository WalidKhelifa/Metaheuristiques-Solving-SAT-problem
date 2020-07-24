package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Area {
    ArrayList<Integer> rArea = new ArrayList<>();
    int nbresearch;
    SAT sat;
    LinkedList<Bees> danceArea =new LinkedList<>();

    public Area() {
    }

    public Area(ArrayList<Integer> rArea, int nbresearch,SAT s) {
        this.rArea = rArea;
        this.nbresearch = nbresearch;
        this.sat=s;
    }

    public void search(LinkedList<Bees> danceList)
    {

        ArrayList<Integer> rArea2=new ArrayList<>(rArea);;
        int r=0;
        Bees b2;
        for(int i=1;i<nbresearch;i++)
        {


            do{
                Random rand = new Random();
                rArea2=new ArrayList<>(rArea);
            int generating = rand.nextInt(rArea.size());
            if (rArea2.get(generating)==1)
            {
                rArea2.set(generating,0);
            }
            else
            {
                rArea2.set(generating,1);
            }
            }while (containsarea(danceArea,rArea2) || containsarea(danceList,rArea2));
            r=0;
            b2 =new Bees(rArea2,sat);
            danceArea.add(b2);

        }
        Collections.sort(danceArea);

    }
    public boolean containsarea( LinkedList<Bees> list,  ArrayList<Integer> area){
        return list.stream().anyMatch(o -> o.rArea.equals(area));
    }


}

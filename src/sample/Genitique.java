package sample;

import java.util.*;

public class Genitique {
    int size;
    LinkedList<Chromosone>  population =new LinkedList<>();
    LinkedList<Clause> list =new LinkedList<>();



    public Genitique(int size ,LinkedList<Clause> list) {
        this.size = size;
        this.list=list;
        for (int i =0; i<size;i++)
        {
            Chromosone c =new Chromosone();
            int cost =c.calcCost(this.list);
            population.add(c);

        }
    }


    //methode de selection
    public void selection ()
    {
        Collections.sort(population);// tri de la population
        int deuxTier = (population.size()*2)/3;//on garde deux tier de notre population
        if(population.size()>=30)//s'assuré ne pas dépasser le nombre max de la population
        {
            deuxTier=30*2/3;
        }
        population= new LinkedList<Chromosone>(population.subList(0,deuxTier));


    }


    // methode de croisement
    public void wedding()
    {
        int stop =population.size()/2;//prendre la moitier de la population
        //parcours de la moitier de la population
        //croiser chaque individu avec son voisin (i avec i++)
        for (int i=0 ;i<stop/2;i++)
        {

            int marie =i+1;

            LinkedList<Chromosone> croisement = population.get(i).Croisement(population.get(marie));
            croisement.get(0).calcCost(list);
            croisement.get(1).calcCost(list);
            croisement.get(2).calcCost(list);
            croisement.get(3).calcCost(list);
            //généré les enfants et les trié pour les ajouter a la population
            Collections.sort(croisement);
            population.addAll(croisement);
            i++;


        }
    }


    //methode de mutation
    public void mutate()
    {
        for (int i=0;i<population.size();i++)
        {
            population.get(i).mutation(70);
            int coast =population.get(i).calcCost(list);//calcul du cout pour pouvoir trier la population apres


        }
        Collections.sort(population);//trié la population apres la mutation selon le cout

    }


}

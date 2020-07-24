package sample;

import java.io.*;
import java.util.*;



public class SolverSat {
    // variable de résultat
    float temps_execution;// temps execution
    ArrayList<Integer> valeurresult; // [1,0,1,0,0...]
    int nbnonsatisfait;//




    // la methode principale de notre algorthme géénitique
    public static ArrayList<Integer> GA(Genitique gene,int nbTry )
    {
        boolean essayer= false;
        while (  essayer==false && nbTry!=0)
        {   //appel a  la methode selection
            gene.selection();
            //appel a  la methode croisement
            gene.wedding();
            //appel a  la methode mutation
            gene.mutate();
            //evalué la meilleur solution et l'affecter a essayer
            essayer=gene.population.getFirst().getValue()==0;
            // decrémanté le nombre d'essai
            nbTry--;
        }
       // ArrayList<Integer> list1= new ArrayList(Arrays.asList(0,1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0));
        SAT s =new SAT(gene.list,gene.population.getFirst().Val);
        return gene.population.getFirst().Val;
    }








    // permet de lire le data set et retourne une liste de clause
    public  LinkedList<Clause> lecteur(String path) throws IOException {

        LinkedList<Clause> list =new LinkedList<>();

        InputStream ips=new FileInputStream(path);
        InputStreamReader ipsr=new InputStreamReader(ips);
        BufferedReader br=new BufferedReader(ipsr);
        String ligne;
        while (!(ligne=br.readLine()).equals("%"))
        {
            if(ligne.startsWith("c")||ligne.startsWith("p")||ligne.startsWith("%")||ligne.startsWith("0")){
            }
            else
            {

                Clause c = new Clause(ligne);
                list.add(c);
            }

        }
        return list;
    }



    void solverBSO(SAT sat, int flip, int nbtry, int nbtryArea,int nbchance,int nbbees)
    {
        BSO bso=new BSO(sat,flip,nbtry,nbtryArea,nbchance,nbbees);
        //sauvegarde le temps aux début de l'execution d'une itération
        long tempit1=System.currentTimeMillis();

        ArrayList<Integer> result =bso.solve();

        long tempit2=System.currentTimeMillis();
        temps_execution=(tempit2-tempit1);
        sat.setVal(result);
        nbnonsatisfait=sat.getListeclause().size()-sat.NBSatisfait();
        valeurresult=new ArrayList<>(result);

    }
    void solverPSO(int nbswarm, int vitesse_initial, int max_int, float c1, float c2, float w, SAT sat)
    {
        PSO pso = new PSO(nbswarm,vitesse_initial,max_int,c1,c2,w,1,2,sat.getListeclause());
        //sauvegarde le temps aux début de l'execution d'une itération
        long tempit1=System.currentTimeMillis();

        ArrayList<Integer> result =pso.solvePso();

        long tempit2=System.currentTimeMillis();
        temps_execution=(tempit2-tempit1);
        sat.setVal(result);
        nbnonsatisfait=sat.getListeclause().size()-sat.NBSatisfait();
        valeurresult=new ArrayList<>(result);

    }
    void solverGA(int size ,SAT sat,int nbtry)
    {
        Genitique gene = new Genitique(size,sat.getListeclause());
        long tempit1=System.currentTimeMillis();

        ArrayList<Integer> result =GA(gene,nbtry);

        long tempit2=System.currentTimeMillis();
        temps_execution=(tempit2-tempit1);
        sat.setVal(result);
        nbnonsatisfait=sat.getListeclause().size()-sat.NBSatisfait();
        valeurresult=new ArrayList<>(result);
    }


    public SolverSat() {
        /*LinkedList<sample.Clause> list=solver.lecteur("hadak chemain");
            sample.SAT s = new sample.SAT(list)
            solver.solverPSO(sat,nbtry,parametre de l'algorithme )
        *
        * */

    }

    // le mains de notre programme
    public static void main(String[] args) throws IOException
    {
        Genitique gene = null;
        LinkedList<Clause> list = new LinkedList<>();

        int nbsat = 0;// calcul ne nombre de sat satisfait
        boolean satisfait;
        int reussi[]= new int[101];
        long  tempsdebut=System.currentTimeMillis();
        long tempsit[] = new long[101],tempit1,tempit2;
/*
parametres e
* */

        int flip=20;
        int nbtry=500;
        int NbtryArea=2;
        int nbchance=20;
        int nbbees=100;
        System.out.println("donner le nombre d'instance  vous voulez exécuté sat \n");
        PSO pso = null;
        int nb,nbm=1;
        nbm=new Scanner(System.in).nextInt();
        System.out.println(nbm);
        //on parcours tout les fichier cnf du dossier
/*
       for ( nb = 1; nb <=nbm; nb++)
       {
            list = lecteur(nb);
            SAT s = new SAT(list);

            /*
            // crée notre objet gene avec le nombre de particule intiale et la list des clauses
            sample.BSO bso=new sample.BSO(s,flip,nbtry,NbtryArea,nbchance,nbbees);
           System.out.println("execution de l'instance numero  "+nb+"\n");
           //sauvegarde le temps aux début de l'execution d'une itération
            tempit1=System.currentTimeMillis();

          ArrayList<Integer> result =bso.solve();

           tempit2=System.currentTimeMillis();
           s.setVal(result);
            //calcul le temps  d'exécution d'une itération
           tempsit[nb]=tempit2-tempit1;
           satisfait=s.satisfait();
           System.out.println("meilleur résultat obtenu avec :"+s.getVal());

            if(satisfait)
            {

                nbsat++;
            }
            reussi[nb]=s.getListeclause().size()-s.NBSatisfait();*/

       }


  /*

       //calcul temps total de l'execution du programme
        long  tempsfin=System.currentTimeMillis();
        long temps=tempsfin-tempsdebut;
        System.out.println("le temps d'execution total est de "+temps);
        System.out.println("\n");
        //affichage tableau nb satisfait
        System.out.println("nombre  de clause non satisfaite de chaque instance  \n");
        long f=0;
        for (int i=1;i<nb;i++)
        {
            System.out.println(reussi[i]+"\t"+tempsit[i]);
            f=f+tempsit[i];


        }
        System.out.println(f);
    }

   */


}

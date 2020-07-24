package sample;

public class donnee {

    String Type_fichier;
    String Taux_satisfiabilité;
    String Temps_moyenne;

    public donnee(String type_fichier, String taux_satisfiabilité, String temps_moyenne) {
        Type_fichier = type_fichier;
        Taux_satisfiabilité = taux_satisfiabilité;
        Temps_moyenne = temps_moyenne;
    }

    public String getType_fichier() {
        return Type_fichier;
    }

    public void setType_fichier(String type_fichier) {
        Type_fichier = type_fichier;
    }

    public String getTaux_satisfiabilité() {
        return Taux_satisfiabilité;
    }

    public void setTaux_satisfiabilité(String taux_satisfiabilité) {
        Taux_satisfiabilité = taux_satisfiabilité;
    }

    public String getTemps_moyenne() {
        return Temps_moyenne;
    }

    public void setTemps_moyenne(String temps_moyenne) {
        Temps_moyenne = temps_moyenne;
    }
}

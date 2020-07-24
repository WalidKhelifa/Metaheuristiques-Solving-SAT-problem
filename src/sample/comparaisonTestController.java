package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;

public class comparaisonTestController implements Initializable {



    @FXML
    TableColumn typeFichier;
    @FXML
    TableColumn tauxSat;
    @FXML
    TableColumn tempsMoyen;

    @FXML
    TableView<donnee> table;




    @FXML
    TextField add_file;
    String path_file;
    int nbExecute=0;
    float time1,time2,time3;
    SolverSat ss1 =new SolverSat();
    SolverSat ss2 =new SolverSat();
    SolverSat ss3 =new SolverSat();
    String resultGa,resultBSO,resultPSO;
    ArrayList<String> listGA = new ArrayList<String>();
    ArrayList<String> listBSO = new ArrayList<String>();
    ArrayList<String> listPSO = new ArrayList<String>();

    public void AddFile(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            //imageSelected.setText(selectedFile.getName());
            path_file=selectedFile.getPath();
            add_file.setText(selectedFile.getPath());
            System.out.println(selectedFile.getPath());
        } else {
            System.out.println("erreur de selection");
        }

    }



    public void Execute(ActionEvent event) throws IOException {

        if(!add_file.getText().isEmpty()) {
            try {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Confirmation l'execusion");
                alert.setContentText("Voulez vraiment confirmer l'execusion ?");
                Optional<ButtonType> results = alert.showAndWait();
                if (results.get() == ButtonType.OK) {



                    LinkedList<Clause> listclause1 = new LinkedList<>(ss1.lecteur(path_file));
                    LinkedList<Clause> listclause2 = new LinkedList<>(ss2.lecteur(path_file));
                    LinkedList<Clause> listclause3 = new LinkedList<>(ss3.lecteur(path_file));
                    SAT s1 = new SAT(listclause1);
                    SAT s2 = new SAT(listclause2);
                    SAT s3 = new SAT(listclause3);




                    ss1.solverGA(33, s1, 1000);
                    float nb1GA = ss1.nbnonsatisfait * 100;
                    time1 = ss1.temps_execution / 1000;
                    float nb2GA = nb1GA / 325;
                    float tauxGA = 100 - nb2GA;
                    resultGa = String.valueOf(tauxGA) + " %";
                    listGA.add(String.valueOf(tauxGA));
                    System.out.println(resultGa);
                    //////
                    ss2.solverBSO(s2,75,1000,2,50,60);
                    float nb1BSO = ss2.nbnonsatisfait * 100;
                    time2 = ss2.temps_execution / 1000;
                    float nb2BSO = nb1BSO / 325;
                    float tauxBSO = 100 - nb2BSO;
                    resultBSO = String.valueOf(tauxBSO) + " %";
                    listBSO.add(String.valueOf(tauxBSO));
                    System.out.println(resultBSO);
                    //////
                    ss3.solverPSO(5, 1, 1000, 1.25f, 1.25f, 0.9f, s3);
                    float nb1PSO = ss3.nbnonsatisfait * 100;
                    time3 = ss3.temps_execution / 1000;
                    float nb2PSO = nb1PSO / 325;
                    float tauxPSO = 100 - nb2PSO;
                    resultPSO = String.valueOf(tauxPSO) + " %";
                    listPSO.add(String.valueOf(tauxPSO));
                    System.out.println(resultPSO);
                    nbExecute++;

                    // System.out.println(ss.nbnonsatisfait+"\n "+(ss.temps_execution)/1000+" \n"+ss.valeurresult);

                } else {
                    add_file.setText("");
                }

            } catch (Exception e) {

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerte");
            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Veuillez importer un fichier d'abord !");
            alert.show();
        }
        ArrayList<donnee> tv = new ArrayList<>();
        donnee d1 = new donnee("GA",resultGa,String.valueOf(time1));
        donnee d2 = new donnee("PSO",resultPSO,String.valueOf(time3));
        donnee d3 = new donnee("BSO",resultBSO,String.valueOf(time2));
        tv.add(d1);tv.add(d2);tv.add(d3);
        ObservableList<donnee> listObservable = FXCollections.observableArrayList(tv);
        table.setItems(listObservable);
    }

    public void passingDataGA(ActionEvent event) throws IOException {
        if(!add_file.getText().isEmpty()) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("fxml/histogramme.fxml"));
            Parent root = (Parent) loader.load();

            histogrammeController secController=loader.getController();
            secController.loadData(listGA);

            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerte");
            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Veuillez importer un fichier et l'executer d'abord !");
            alert.show();
        }
    }
    public void passingDataBSO(ActionEvent event) throws IOException {
        if(!add_file.getText().isEmpty()) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("fxml/histogrammeBSO.fxml"));
            Parent root = (Parent) loader.load();

            histogrammeBSOController secController=loader.getController();
            secController.loadData(listBSO);

            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }else
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Alerte");
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Veuillez importer un fichier et l'executer d'abord !");
        alert.show();
    }
    }
    public void passingDataPSO(ActionEvent event) throws IOException {
        if(!add_file.getText().isEmpty()) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("fxml/histogrammePSO.fxml"));
            Parent root = (Parent) loader.load();

            histogrammePSOController secController=loader.getController();
            secController.loadData(listPSO);

            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }else
        {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Alerte");
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Veuillez importer un fichier et l'executer d'abord !");
        alert.show();
        }
    }
    public void passingDataComparaison(ActionEvent event) throws IOException {
        if(!add_file.getText().isEmpty()) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("fxml/grapheComparaison.fxml"));
            Parent root = (Parent) loader.load();

            grapheComparaisonController secController=loader.getController();
            secController.loadData(listGA,listBSO,listPSO,nbExecute);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }else
        {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Alerte");
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Veuillez importer un fichier et l'executer d'abord !");
        alert.show();
        }
    }
    public void affichResult(ActionEvent event) throws IOException
    {
        Main.stage.close(); // Fermer la fenetre Principale

        Parent parent = FXMLLoader.load(getClass().getResource("fxml/comparaisonResult.fxml"));
        Scene scene= new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        Main.stage = stage;
        stage.setTitle("Interface PSO");
    }

    public void Tester(ActionEvent event) throws IOException
    {
        Main.stage.close(); // Fermer la fenetre Principale

        Parent parent = FXMLLoader.load(getClass().getResource("fxml/comparaisonTest.fxml"));
        Scene scene= new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        Main.stage = stage;
        stage.setTitle("Interface PSO");
    }







    public void Back(ActionEvent event) throws IOException {

        Main.stage.close(); // Fermer la fenetre d'acceuil
        // ouvrir la fenetre Principale
        Parent parent = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        Main.stage = stage;
        stage.setTitle("Interface PSO");

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        typeFichier.setCellValueFactory(new PropertyValueFactory<>("Type_fichier"));
        tauxSat.setCellValueFactory(new PropertyValueFactory<>("Taux_satisfiabilité"));
        tempsMoyen.setCellValueFactory(new PropertyValueFactory<>("Temps_moyenne"));



    }
}

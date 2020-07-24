package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;

public class gaTestController implements Initializable {

    @FXML
    TextField t1;
    @FXML
    TextField t2;
    @FXML
    TextField t3;
    @FXML
    TextField t4;
    @FXML
    TextField t5;
    @FXML
    TextField t6;
    @FXML
    TextArea tAresult;


    @FXML
    TextField add_file;

    @FXML
    TextField nbtry;

    @FXML
    private BarChart<?, ?> graphe;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;


    String path_file;
    SolverSat ss =new SolverSat();
    String result;
    ArrayList<String> list = new ArrayList<String>();






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

            LinkedList<Clause> listclause = new LinkedList<>(ss.lecteur(path_file));
            SAT s = new SAT(listclause);
            int nbtryy = Integer.parseInt(nbtry.getText());
            //System.out.println(nbtryy);
            ss.solverGA(33, s, nbtryy);
            float time = ss.temps_execution / 1000;
            float nb1 = ss.nbnonsatisfait * 100;
            float nb2 = nb1 / 325;
            float taux = 100 - nb2;
            result = String.valueOf(taux) + " %";
            t5.setText(result);
            list.add(String.valueOf(taux));
            System.out.println(String.valueOf(taux));
            t6.setText(String.valueOf(time));
            tAresult.setText(ss.valeurresult.toString());
            // System.out.println(ss.nbnonsatisfait+"\n "+(ss.temps_execution)/1000+" \n"+ss.valeurresult);

                } else {
                    add_file.setText("");
                }

            } catch (Exception e) {

            }
        }else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerte");
            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Veuillez importer un fichier d'abord !");
            alert.show();
        }


    }



    public void passingData(ActionEvent event) throws IOException {

        if(!add_file.getText().isEmpty()) {
        try {


            FXMLLoader loader=new FXMLLoader(getClass().getResource("fxml/histogramme.fxml"));
            Parent root = (Parent) loader.load();

            histogrammeController secController=loader.getController();
            secController.loadData(list);

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

        Parent parent = FXMLLoader.load(getClass().getResource("fxml/gaResult.fxml"));
        Scene scene= new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        Main.stage = stage;
        stage.setTitle("Interface Génétique");
    }

    public void Tester(ActionEvent event) throws IOException
    {
        Main.stage.close(); // Fermer la fenetre Principale

        Parent parent = FXMLLoader.load(getClass().getResource("fxml/gaTest.fxml"));
        Scene scene= new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        Main.stage = stage;
        stage.setTitle("Interface Génétique");
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
        stage.setTitle("Accueil");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    t1.setText("33");
    t2.setText("70%");
    t3.setText("1000");
    t4.setText("2");
    nbtry.setText("1000");
    }
}

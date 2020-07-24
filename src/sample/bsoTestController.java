package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;

public class bsoTestController implements Initializable {

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
    TextField nbtry;


    @FXML
    TextField add_file;


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


        LinkedList<Clause> listclause=new LinkedList<>( ss.lecteur(path_file));
        SAT s =new SAT(listclause);
        int nbtryy = Integer.parseInt(nbtry.getText());
        ss.solverBSO(s,75,nbtryy,2,50,60);

                    float time = ss.temps_execution /1000;
                    float nb1 = ss.nbnonsatisfait * 100;
                    float nb2 = nb1 / 325;
                    float taux = 100 - nb2;
                    result = String.valueOf(taux) + " %";
                    t5.setText(result);
                    list.add(String.valueOf(taux));
                    System.out.println(String.valueOf(taux));
                    t6.setText(String.valueOf(time));
                    tAresult.setText(ss.valeurresult.toString());


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
            FXMLLoader loader=new FXMLLoader(getClass().getResource("fxml/histogrammeBSO.fxml"));
            Parent root = (Parent) loader.load();

            histogrammeBSOController secController=loader.getController();
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

        Parent parent = FXMLLoader.load(getClass().getResource("fxml/bsoResult.fxml"));
        Scene scene= new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        Main.stage = stage;
        stage.setTitle("Interface BSO");
    }

    public void Tester(ActionEvent event) throws IOException
    {
        Main.stage.close(); // Fermer la fenetre Principale

        Parent parent = FXMLLoader.load(getClass().getResource("fxml/bsoTest.fxml"));
        Scene scene= new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        Main.stage = stage;
        stage.setTitle("Interface BSO");
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
        stage.setTitle("Interface BSO");

    }









    @Override
    public void initialize(URL location, ResourceBundle resources) {

        t1.setText("75");
        t2.setText("60");
        t3.setText("50");
        t4.setText("2");
        nbtry.setText("1000");
    }
}

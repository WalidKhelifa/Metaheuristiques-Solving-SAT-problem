package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class psoResultController implements Initializable {
    @FXML
    TextField t1;
    @FXML
    TextField t2;
    @FXML
    TextField t3;
    @FXML
    TextField t4;


    @FXML
    ComboBox fichier;

    @FXML
    TableColumn typeFichier;
    @FXML
    TableColumn tauxSat;
    @FXML
    TableColumn tempsMoyen;

    @FXML
    TableView<donnee> table;


    public void affichResult(ActionEvent event) throws IOException {
        Main.stage.close(); // Fermer la fenetre Principale

        Parent parent = FXMLLoader.load(getClass().getResource("fxml/psoResult.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        Main.stage = stage;
        stage.setTitle("Interface PSO");
    }

    public void Tester(ActionEvent event) throws IOException {
        Main.stage.close(); // Fermer la fenetre Principale

        Parent parent = FXMLLoader.load(getClass().getResource("fxml/psoTest.fxml"));
        Scene scene = new Scene(parent);
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

        t1.setText("5");
        t2.setText("1.25");
        t3.setText("0.9");
        t4.setText("1.25");


        fichier.getItems().addAll("UF75", "UUF75");
        fichier.setValue("UF75");

        typeFichier.setCellValueFactory(new PropertyValueFactory<>("Type_fichier"));
        tauxSat.setCellValueFactory(new PropertyValueFactory<>("Taux_satisfiabilité"));
        tempsMoyen.setCellValueFactory(new PropertyValueFactory<>("Temps_moyenne"));

        ArrayList<donnee> tv = new ArrayList<>();
        donnee d1 = new donnee("UF75", "98.66 %", "1,32");
        donnee d2 = new donnee("UUF75", "98.31 %", "1,31");
        tv.add(d1);
        tv.add(d2);
        ObservableList<donnee> listObservable = FXCollections.observableArrayList(tv);
        table.setItems(listObservable);

    }

    public void graphePSO(ActionEvent event) throws IOException {

        //Main.stage.close(); // Fermer la fenetre d'acceuil
        // ouvrir la fenetre Principale
        Parent parent = FXMLLoader.load(getClass().getResource("fxml/graphePSO.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setTitle("Graphe PSO");

    }
}
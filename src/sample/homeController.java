package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController implements Initializable {


    public void GA(ActionEvent event) throws IOException
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
    public void BSO(ActionEvent event) throws IOException
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
    public void PSO(ActionEvent event) throws IOException
    {
        Main.stage.close(); // Fermer la fenetre Principale

        Parent parent = FXMLLoader.load(getClass().getResource("fxml/psoResult.fxml"));
        Scene scene= new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        Main.stage = stage;
        stage.setTitle("Interface PSO");
    }

    public void comparaison(ActionEvent event) throws IOException
    {
        Main.stage.close(); // Fermer la fenetre Principale

        Parent parent = FXMLLoader.load(getClass().getResource("fxml/comparaisonResult.fxml"));
        Scene scene= new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        Main.stage = stage;
        stage.setTitle("Interface Comparaison");
    }















    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

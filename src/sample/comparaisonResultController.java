package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class comparaisonResultController implements Initializable {

    @FXML
    TableColumn typeFichier;
    @FXML
    TableColumn tauxSat;
    @FXML
    TableColumn tempsMoyen;

    @FXML
    TableView<donnee> table;

    @FXML
    private BarChart<?, ?> graphe;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeFichier.setCellValueFactory(new PropertyValueFactory<>("Type_fichier"));
        tauxSat.setCellValueFactory(new PropertyValueFactory<>("Taux_satisfiabilité"));
        tempsMoyen.setCellValueFactory(new PropertyValueFactory<>("Temps_moyenne"));

        ArrayList<donnee> tv = new ArrayList<>();
        donnee d1 = new donnee("GA","99.28 %","1,8");
        donnee d2 = new donnee("PSO","98.66 %","1,31");
        donnee d3 = new donnee("BSO","99.81 %","2,8");
        tv.add(d1);tv.add(d2);tv.add(d3);
        ObservableList<donnee> listObservable = FXCollections.observableArrayList(tv);
        table.setItems(listObservable);

        XYChart.Series series1 = new XYChart.Series();
        //series1.setName("Numero de fichier");


        y.setAutoRanging(false);
        y.setLowerBound(98);
        y.setUpperBound(100);
        y.setTickUnit(0.2);

        //x.setAutoRanging(false);
        graphe.setLegendVisible(false);



        series1.getData().add(new XYChart.Data("GA", 99.28));
        series1.getData().add(new XYChart.Data("PSO", 98.66));
        series1.getData().add(new XYChart.Data("BSO", 99.81));



        graphe.getData().addAll(series1);

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
}

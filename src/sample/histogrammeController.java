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
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class histogrammeController implements Initializable {


    @FXML
    private BarChart<?, ?> graphe;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;




    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void loadData(ArrayList<String> l)
    {
        XYChart.Series series1 = new XYChart.Series();
        //series1.setName("nombre d'individu");
        y.setAutoRanging(false);
        y.setLowerBound(97);
        y.setUpperBound(100);
        y.setTickUnit(0.2);
        graphe.setLegendVisible(false);
        int i=0;
        while (i<l.size()) {
            Float yf = Float.parseFloat(l.get(i));
            series1.getData().add(new XYChart.Data("Execusion "+(i+1)+" ="+l.get(i)+"%", yf));
            i++;
        }
        series1.getData().add(new XYChart.Data("", 0));

        graphe.getData().addAll(series1);
    }
}

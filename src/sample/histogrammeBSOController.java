package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class histogrammeBSOController implements Initializable {
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
        graphe.setLegendVisible(true);
        series1.setName("BSO");

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

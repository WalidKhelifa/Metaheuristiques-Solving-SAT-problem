package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class graphePSOController implements Initializable {
    @FXML
    private BarChart<?, ?> graphe;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        XYChart.Series series1 = new XYChart.Series();
        //series1.setName("Numero de fichier");

        /*
        y.setAutoRanging(false);
        y.setLowerBound(0);
        y.setUpperBound(24);
        y.setTickUnit(3);
*/
        //x.setAutoRanging(false);

        y.setAutoRanging(false);
        y.setLowerBound(97);
        y.setUpperBound(100);
        y.setTickUnit(0.2);
        graphe.setLegendVisible(true);
        series1.setName("PSO");




        series1.getData().add(new XYChart.Data("1", 98.46));
        series1.getData().add(new XYChart.Data("5", 97.84));
        series1.getData().add(new XYChart.Data("10", 98.76));
        series1.getData().add(new XYChart.Data("15", 98.46));
        series1.getData().add(new XYChart.Data("20", 98.76));
        series1.getData().add(new XYChart.Data("25", 98.46));
        series1.getData().add(new XYChart.Data("30", 98.46));
        series1.getData().add(new XYChart.Data("35", 97.84));
        series1.getData().add(new XYChart.Data("40", 98.15));
        series1.getData().add(new XYChart.Data("45", 97.23));
        series1.getData().add(new XYChart.Data("50", 98.15));
        series1.getData().add(new XYChart.Data("55", 98.46));
        series1.getData().add(new XYChart.Data("60", 97.84));
        series1.getData().add(new XYChart.Data("65", 98.15));
        series1.getData().add(new XYChart.Data("70", 98.76));
        series1.getData().add(new XYChart.Data("75", 98.15));
        series1.getData().add(new XYChart.Data("80", 99.38));
        series1.getData().add(new XYChart.Data("85", 98.76));
        series1.getData().add(new XYChart.Data("90", 98.46));
        series1.getData().add(new XYChart.Data("95", 98.46));
        series1.getData().add(new XYChart.Data("100", 97.84));

        graphe.getData().addAll(series1);

    }
}

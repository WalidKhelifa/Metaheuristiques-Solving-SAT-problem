package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class grapheGAController implements Initializable {



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
        series1.setName("GA");



        series1.getData().add(new XYChart.Data("1", 98.769));
        series1.getData().add(new XYChart.Data("5", 99.076));
        series1.getData().add(new XYChart.Data("10", 100));
        series1.getData().add(new XYChart.Data("15", 99.38));
        series1.getData().add(new XYChart.Data("20", 99.07));
        series1.getData().add(new XYChart.Data("25", 100));
        series1.getData().add(new XYChart.Data("30", 98.76));
        series1.getData().add(new XYChart.Data("35", 99.07));
        series1.getData().add(new XYChart.Data("40", 99.38));
        series1.getData().add(new XYChart.Data("45", 100));
        series1.getData().add(new XYChart.Data("50", 100));
        series1.getData().add(new XYChart.Data("55", 99.07));
        series1.getData().add(new XYChart.Data("60", 99.076));
        series1.getData().add(new XYChart.Data("65", 100));
        series1.getData().add(new XYChart.Data("70", 99.38));
        series1.getData().add(new XYChart.Data("75", 99.07));
        series1.getData().add(new XYChart.Data("80", 100));
        series1.getData().add(new XYChart.Data("85", 99.69));
        series1.getData().add(new XYChart.Data("90", 99.07));
        series1.getData().add(new XYChart.Data("95", 98.76));
        series1.getData().add(new XYChart.Data("100", 99.07));

        graphe.getData().addAll(series1);

    }
}

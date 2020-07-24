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

public class grapheComparaisonController implements Initializable {
    @FXML
    private BarChart<?, ?> graphe;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void loadData(ArrayList<String> ga ,ArrayList<String> bso,ArrayList<String> pso,int nbExecute) {
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        //series1.setName("nombre d'individu");
        y.setAutoRanging(false);
        y.setLowerBound(97);
        y.setUpperBound(100);
        y.setTickUnit(0.2);
        graphe.setLegendVisible(true);
        series1.setName("GA");
        series2.setName("BSO");
        series3.setName("PSO");


        int i = 0;
        float sommeGA=0;
        float moyenneGA=0;
        while (i < ga.size()) {

            sommeGA=sommeGA+Float.parseFloat(ga.get(i));
            i++;
        }
        moyenneGA=sommeGA/ga.size();
        series1.getData().add(new XYChart.Data("GA", moyenneGA));

        ///////////////////////////
        float sommeBSO=0;
        float moyenneBSO=0;
        int j = 0;
        while (j < bso.size()) {
            sommeBSO = sommeBSO+ Float.parseFloat(bso.get(j));

            j++;
        }
        moyenneBSO=sommeBSO/bso.size();
        series2.getData().add(new XYChart.Data("BSO", moyenneBSO));

        ////////
        int k = 0;
        float sommePSO=0;
        float moyennePSO=0;
        while (k < pso.size()) {
            sommePSO = sommePSO+ Float.parseFloat(pso.get(k));

            k++;
        }
        moyennePSO=sommePSO/pso.size();
        series3.getData().add(new XYChart.Data("PSO", moyennePSO));


        graphe.getData().addAll(series1,series2,series3);
    }

}

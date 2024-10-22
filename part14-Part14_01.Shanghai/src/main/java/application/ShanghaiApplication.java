package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.Scene;
public class ShanghaiApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        NumberAxis xAxis = new NumberAxis(2007, 2017, 1);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);

        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        XYChart.Series lineDot = new XYChart.Series();
        lineDot.getData().add(new XYChart.Data(2007, 73));
        lineDot.getData().add(new XYChart.Data(2008, 68));
        lineDot.getData().add(new XYChart.Data(2009, 72));
        lineDot.getData().add(new XYChart.Data(2010, 72));
        lineDot.getData().add(new XYChart.Data(2011, 74));
        lineDot.getData().add(new XYChart.Data(2012, 73));
        lineDot.getData().add(new XYChart.Data(2013, 76));
        lineDot.getData().add(new XYChart.Data(2014, 73));
        lineDot.getData().add(new XYChart.Data(2015, 67));
        lineDot.getData().add(new XYChart.Data(2016, 56));
        lineDot.getData().add(new XYChart.Data(2017, 56));
        
        lineChart.getData().add(lineDot);
        
        Scene scene = new Scene(lineChart, 640, 480);
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

}

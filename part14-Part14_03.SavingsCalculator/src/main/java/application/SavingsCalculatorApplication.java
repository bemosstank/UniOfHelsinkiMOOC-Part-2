package application;

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        BorderPane savingPane = new BorderPane();

        Slider savingSlider = new Slider(25, 250, 25);
        savingSlider.setSnapToTicks(true);
        savingSlider.setBlockIncrement(500);
        savingSlider.setShowTickMarks(true);
        savingSlider.setShowTickLabels(true);

        Label savingLabel = new Label();
        savingLabel.setText("" + savingSlider.getValue());

        savingPane.setLeft(new Label("Monthly savings"));
        savingPane.setCenter(savingSlider);
        savingPane.setRight(savingLabel);
        savingPane.setPadding(new Insets(10));

        BorderPane interestPane = new BorderPane();

        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setMinorTickCount(10);
        interestSlider.setShowTickMarks(true);
        interestSlider.setShowTickLabels(true);

        Label interestLabel = new Label();
        interestLabel.setText("" + interestSlider.getValue());

        interestPane.setLeft(new Label("Yearly interest rate"));
        interestPane.setCenter(interestSlider);
        interestPane.setRight(interestLabel);
        interestPane.setPadding(new Insets(10));

        VBox sliderBox = new VBox();
        sliderBox.getChildren().addAll(savingPane, interestPane);
        sliderBox.setSpacing(10);

        layout.setTop(sliderBox);

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setAnimated(false);
        lineChart.setLegendVisible(false);
        lineChart.setTitle("Savings Calculator");

        XYChart.Series savingChart = new XYChart.Series();
        XYChart.Series interestChart = new XYChart.Series();

        lineChart.getData().add(savingChart);
        lineChart.getData().add(interestChart);

        layout.setCenter(lineChart);

        savingSlider.setOnMouseClicked((events) -> {
            double saving = savingSlider.getValue();
            savingLabel.setText("" + saving);
            update(savingSlider.getValue(), interestSlider.getValue(), savingChart, interestChart);
        });
        
        interestSlider.setOnMouseClicked((events) -> {
            double interest = interestSlider.getValue();
            interestLabel.setText("" +interest);
            update(savingSlider.getValue(), interestSlider.getValue(), savingChart, interestChart);
        });

        Scene scene = new Scene(layout, 640, 480);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    private static void update(double saving, double interest, XYChart.Series savingSeries, XYChart.Series interestSeries) {
        savingSeries.getData().clear();
        interestSeries.getData().clear();
        double annualSavings = 12 * saving;
        double interestFactor = 1 + interest / 100;
        double saved = 0.0;
        double savedWithInterest = 0.0;

        for (int i = 0; i < 31; i++) {
            savingSeries.getData().add(new XYChart.Data(i, saved));
            interestSeries.getData().add(new XYChart.Data(i, savedWithInterest));
            saved += annualSavings;
            savedWithInterest = (savedWithInterest + annualSavings) * interestFactor;
        }
    }

}

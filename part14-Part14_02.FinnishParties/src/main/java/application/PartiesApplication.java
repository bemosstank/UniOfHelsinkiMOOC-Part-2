package application;

import java.nio.file.Paths;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.chart.XYChart;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Scene;
public class PartiesApplication extends Application {

    private HashMap<String, Map<Integer, Double>> values;

    public PartiesApplication() {
        this.values = readVoterFile("partiesdata.tsv");

    }

    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        this.values.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            this.values.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });
            
            lineChart.getData().add(data);
        });
        
        Scene scene = new Scene(lineChart, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
       launch(PartiesApplication.class);
    }

    public HashMap<String, Map<Integer, Double>> readVoterFile(String fileName) {
        HashMap<String, Map<Integer, Double>> values1 = new HashMap<>();
        ArrayList<Integer> yearList = new ArrayList<>();
        try (Scanner file = new Scanner(Paths.get(fileName))) {
            String row = file.nextLine();
            String[] splitRow = row.split("\t");
            for (int i = 1; i < splitRow.length; i++) {
                yearList.add(Integer.parseInt(splitRow[i]));
            }
            
            while(file.hasNext()) {
                String next = file.nextLine();
                splitRow = next.split("\t");
                String party = splitRow[0];
                HashMap<Integer, Double> map = new HashMap<>();
                for(int i =1; i < splitRow.length; i++){
                    if(!splitRow[i].equals("-")) {
                        int year = yearList.get(i-1);
                        String dat = splitRow[i];
                        double number = Double.parseDouble(dat);
                        map.put(year, number);      
                    }
                }
                values1.put(party, map);
            }

        } catch (IOException exe) {
            System.out.println("Error: " + exe.getMessage());
        }
        return values1;
    }

}

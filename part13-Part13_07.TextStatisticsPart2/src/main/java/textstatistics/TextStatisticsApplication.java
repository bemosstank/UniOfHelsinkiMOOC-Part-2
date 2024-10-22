package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.Scene;

public class TextStatisticsApplication extends Application {

    public void start(Stage window) {
        HBox box = new HBox();
        BorderPane layout = new BorderPane();
        TextArea textArea = new TextArea("");
        layout.setCenter(textArea);
        box.setSpacing(10);
         Label longestWordComponent = new Label();
         Label wordLengthComponent = new Label();
         Label letterLengthComponent = new Label();
       
        textArea.textProperty().addListener((change, oldvalue, newValue) -> {
            int charactersCount = newValue.length();
            String parts[] = newValue.split(" ");
           int length = parts.length;
           String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
           longestWordComponent.setText("The longest word is: " + longest);
           wordLengthComponent.setText("Words: " + length);
           letterLengthComponent.setText("Letters: " + charactersCount);        
        });
        
        box.getChildren().addAll(letterLengthComponent, wordLengthComponent, longestWordComponent);
        layout.setBottom(box);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}

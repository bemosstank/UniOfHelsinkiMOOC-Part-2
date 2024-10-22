package textstatistics;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.Scene;
public class TextStatisticsApplication extends Application{
    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        layout.setCenter(new TextArea(""));
        HBox box = new HBox();
        box.setSpacing(10);
        box.getChildren().add(new Label("Letters: 0"));
        box.getChildren().add(new Label("Words: 0"));
        box.getChildren().add(new Label("The longest word is:"));
        layout.setBottom(box);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
       launch(TextStatisticsApplication.class);
    }

}

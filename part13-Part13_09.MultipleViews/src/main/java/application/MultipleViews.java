package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class MultipleViews extends Application {
     @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        GridPane gridPane = new GridPane();
        VBox box = new VBox();

        layout.setTop(new Label("First View!"));
        Button firstView = new Button("To the second view!");
        layout.setCenter(firstView);

        Button secondView = new Button("To the third view");
        box.getChildren().addAll(secondView, new Label("Second View!"));

        Button thirdView = new Button("To the first View!");
        gridPane.add(new Label("Third View!"), 0, 0);
        gridPane.add(thirdView, 1, 1);
        
        Scene firstScene = new Scene(layout);
        Scene secondScene = new Scene(box);
        Scene thirdScene = new Scene(gridPane);
        
        firstView.setOnAction(events -> {
           window.setScene(secondScene);
        });
        
        secondView.setOnAction(events ->  {
            window.setScene(thirdScene);
        });
        
        thirdView.setOnAction(events -> {
            window.setScene(firstScene);
        });
        
        window.setScene(firstScene);
        window.show();       
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}

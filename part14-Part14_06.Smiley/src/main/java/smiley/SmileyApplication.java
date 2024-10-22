package smiley;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        Canvas paintingCanvas = new Canvas(300, 300);
        GraphicsContext drawer = paintingCanvas.getGraphicsContext2D();
        layout.setCenter(paintingCanvas);

        drawer.setFill(Color.BLACK);
        drawer.fillRect(70, 60, 25, 25);
        drawer.fillRect(200, 60, 25, 25);
        drawer.fillRect(75, 200, 150, 25);
        drawer.fillRect(75, 175, 25, 25);
        drawer.fillRect(200, 175, 25, 25);
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}

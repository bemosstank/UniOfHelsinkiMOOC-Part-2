package borderpane;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.Scene;
public class BorderPaneApplication extends Application {

    @Override 
    public void start(Stage window){
        BorderPane layout = new BorderPane();
        layout.setTop(new Label("NORTH"));
        layout.setBottom(new Label("SOUTH"));
        layout.setRight(new Label("EAST"));
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
    }

}

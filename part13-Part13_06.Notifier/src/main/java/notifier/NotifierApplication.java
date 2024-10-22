package notifier;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
public class NotifierApplication extends Application {
    @Override
    public void start(Stage window){
        TextField textfield = new TextField("");
        Button button = new Button("Update");  
        Label textComponent = new Label();
        VBox box = new VBox();
        box.getChildren().addAll(textfield, button, textComponent);
        
        button.setOnAction(events -> {
            textComponent.setText(textfield.getText());
        });
        
        Scene scene = new Scene(box);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}

package buttonandtextfield;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;
public class ButtonAndTextFieldApplication extends Application {
    
    @Override
    public void start(Stage window){
        Button buttonComponent = new Button();
        TextField textfieldComponent = new TextField();
        
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(buttonComponent);
        componentGroup.getChildren().add(textfieldComponent);
        
        Scene scene = new Scene(componentGroup);
        window.setScene(scene);
        window.show();
        
        
    }

    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

}

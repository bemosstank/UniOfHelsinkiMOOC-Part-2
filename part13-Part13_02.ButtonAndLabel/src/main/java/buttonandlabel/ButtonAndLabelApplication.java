package buttonandlabel;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class ButtonAndLabelApplication extends Application {
    @Override
    public void start(Stage window){
        Button buttonComponent = new Button("This is a button");
        Label labelComponent  = new Label("text element");
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(buttonComponent);
        componentGroup.getChildren().add(labelComponent);
        
        Scene scene = new Scene(componentGroup);
        window.setScene(scene);
        window.show();
    }
    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}

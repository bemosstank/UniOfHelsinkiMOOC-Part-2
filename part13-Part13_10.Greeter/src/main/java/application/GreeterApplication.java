package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.Scene;

public class GreeterApplication extends Application {

    @Override
    public void start(Stage window) {
        Label textComponent = new Label("Enter your name and start");
        TextField textField = new TextField("");
        Button button = new Button("start");
        Label error = new Label();
        
        GridPane gridPane = new GridPane();
        gridPane.add(textComponent, 0, 0);
        gridPane.add(textField, 0, 1);
        gridPane.add(button, 0, 2);
        gridPane.add(error, 0, 3);

        gridPane.setPrefSize(400, 400);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        Scene firstScene = new Scene(gridPane);

        Label welcomeLabel = new Label();
        GridPane welcomeLayout = new GridPane();
        welcomeLayout.add(welcomeLabel, 0, 0);

        welcomeLayout.setPrefSize(400, 400);
        welcomeLayout.setAlignment(Pos.CENTER);
        welcomeLayout.setVgap(10);
        welcomeLayout.setHgap(10);
        welcomeLayout.setPadding(new Insets(20, 20, 20, 20));

        Scene welcomeScene = new Scene(welcomeLayout);

        button.setOnAction(events -> {
           if(textField.getText().isEmpty()) {
               error.setText("This text field is empty");
               return;
           }
           
           String textInput = textField.getText();
           welcomeLabel.setText("Welcome " + textInput + "!");
           
           window.setScene(welcomeScene);
        });
        
        window.setScene(firstScene);
        window.show();
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}

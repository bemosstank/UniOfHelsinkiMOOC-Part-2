package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.Scene;

public class JokeApplication extends Application {

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");
        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);

        

        StackPane jokeStack = Joke("What do you call a bear with no teeth?");
        StackPane answerStack = Joke("A gummy bear.");
        StackPane explanationStack = Joke("N/A");

        jokeButton.setOnAction(events -> {
            layout.setCenter(jokeStack);
        });

        answerButton.setOnAction(events -> {
            layout.setCenter(answerStack);
        });

        explanationButton.setOnAction(events -> {
            layout.setCenter(explanationStack);
        });
        
        layout.setTop(menu);
        layout.setCenter(jokeStack);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
       launch(JokeApplication.class);
    }

    public static StackPane Joke(String joke) {
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(joke));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}

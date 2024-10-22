package ticTacToe;

import javafx.application.Application;
import javafx.scene.control.Button;
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.geometry.Insets;

public class TicTacToeApplication extends Application {

    private String currentPlayer = "X";
    private ArrayList<Button> buttons = new ArrayList<>();

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        GridPane gameBoard = new GridPane();
        Label status = new Label("Turn: " + this.currentPlayer);
        status.setFont(Font.font("Manospaced", 25));

        gameBoard.setPadding(new Insets(10, 10, 10, 10));
        gameBoard.setVgap(10);
        gameBoard.setHgap(10);

        for (int i = 0; i < 9; i++) {
            Button button = new Button();
            button.setFont(Font.font("Manospaced", 25));
            button.setMinSize(70, 70);
            button.setMaxSize(70, 70);

            button.setOnMouseClicked(events -> {
                if (status.getText().startsWith("Winner: ") || status.getText().equals("It's a draw")) {

                    button.disarm();

                } else if (button.getText().isEmpty()) {

                    button.setText(this.currentPlayer);

                    if (checkIfWinner()) {

                        status.setText("The end!");

                    } else if (allBoxesFilled()) {

                        status.setText("It is a draw");

                    } else {
                        takeTurn();
                        status.setText("Turn: " + this.currentPlayer);
                    }

                }
            });
            this.buttons.add(button);
        }

        gameBoard.add(this.buttons.get(0), 0, 0);
        gameBoard.add(this.buttons.get(1), 0, 1);
        gameBoard.add(this.buttons.get(2), 0, 2);
        gameBoard.add(this.buttons.get(3), 1, 0);
        gameBoard.add(this.buttons.get(4), 1, 1);
        gameBoard.add(this.buttons.get(5), 1, 2);
        gameBoard.add(this.buttons.get(6), 2, 0);
        gameBoard.add(this.buttons.get(7), 2, 1);
        gameBoard.add(this.buttons.get(8), 2, 2);

        layout.setTop(status);
        layout.setCenter(gameBoard);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    public boolean checkIfWinner() {
        return checkVerticalColumn() || checkHorizontalColumn() || checkDigonalColumn();
    }

    public boolean checkVerticalColumn() {
        if (!this.buttons.get(0).getText().isEmpty() && ((this.buttons.get(0).getText().equals(this.buttons.get(1).getText())))
                && this.buttons.get(0).getText().equals(this.buttons.get(2).getText())) {
            return true;
        }
        if (!this.buttons.get(3).getText().isEmpty() && ((this.buttons.get(3).getText().equals(this.buttons.get(4).getText())))
                && this.buttons.get(3).getText().equals(this.buttons.get(5).getText())) {
            return true;
        }
        if (!this.buttons.get(6).getText().isEmpty() && ((this.buttons.get(6).getText().equals(this.buttons.get(7).getText())))
                && this.buttons.get(6).getText().equals(this.buttons.get(8).getText())) {
            return true;
        }
        return false;
    }

    public boolean checkHorizontalColumn() {
        if (!this.buttons.get(0).getText().isEmpty() && ((this.buttons.get(0).getText().equals(this.buttons.get(3).getText())))
                && this.buttons.get(0).getText().equals(this.buttons.get(6).getText())) {
            return true;
        }
        if (!this.buttons.get(1).getText().isEmpty() && ((this.buttons.get(1).getText().equals(this.buttons.get(4).getText())))
                && this.buttons.get(1).getText().equals(this.buttons.get(7).getText())) {
            return true;
        }
        if (!this.buttons.get(2).getText().isEmpty() && ((this.buttons.get(2).getText().equals(this.buttons.get(5).getText())))
                && this.buttons.get(2).getText().equals(this.buttons.get(8).getText())) {
            return true;

        }
        return false;
    }

    public boolean checkDigonalColumn() {
        if (!this.buttons.get(0).getText().isEmpty() && ((this.buttons.get(0).getText().equals(this.buttons.get(4).getText())))
                && this.buttons.get(0).getText().equals(this.buttons.get(8).getText())) {
            return true;
        }
        if (!this.buttons.get(2).getText().isEmpty() && ((this.buttons.get(2).getText().equals(this.buttons.get(4).getText())))
                && this.buttons.get(2).getText().equals(this.buttons.get(6).getText())) {
            return true;
        }
        return false;
    }

    public boolean allBoxesFilled() {
        for (Button button : this.buttons) {
            if (button.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void takeTurn() {
        if (this.currentPlayer.equals("X")) {
            this.currentPlayer = "O";
        } else if (this.currentPlayer.equals("O")) {
            this.currentPlayer = "X";
        }
    }

}

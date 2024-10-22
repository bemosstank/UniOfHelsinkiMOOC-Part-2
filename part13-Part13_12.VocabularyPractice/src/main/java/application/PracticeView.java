/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author ensia
 */
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
public class PracticeView {
    
    private Dictionary dictionary;
    private String word;
    
    public PracticeView(Dictionary dictionary){
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
    }
    
    public Parent getView(){
        GridPane layout = new GridPane();
        Label wordInstruction = new Label("Translate the word " + this.word);
        TextField translationField = new TextField();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        Button checkButton = new Button("Check");
        Label feedback = new Label("");
        layout.add(wordInstruction, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(checkButton, 0, 2);
        layout.add(feedback, 0, 3);
        checkButton.setOnMouseClicked(event -> {
            String translation = translationField.getText();
            if(this.dictionary.get(this.word).equals(translation)) {
                feedback.setText("Correct!");
            }else{
                feedback.setText("Incorrect! The translation of the word '" + this.dictionary.get(this.word));
            }
            
           this.word = this.dictionary.getRandomWord();
           wordInstruction.setText("Translate the word '" + this.word);
           translationField.clear();
        });
        return layout;
    }
}

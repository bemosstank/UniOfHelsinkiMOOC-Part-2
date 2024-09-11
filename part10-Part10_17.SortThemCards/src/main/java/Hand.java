/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ensia
 */
import java.util.Collections;
import java.util.ArrayList;

public class Hand implements Comparable<Hand> {

    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void add(Card card) {
        this.hand.add(card);
    }

    public void sort() {
        Collections.sort(this.hand);
    }
    
    public void sortBySuit(){
        Collections.sort(this.hand, new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand otherHand) {
        int thisValues = this.hand.stream().map(card -> card.getValue()).reduce(0, (a, b) -> a + b);
        int otherValues = otherHand.hand.stream().map(card -> card.getValue()).reduce(0, (a, b) -> a + b);
        return thisValues - otherValues;
    }

    public void print() {
        for (Card card : this.hand) {
            System.out.println(card.toString());
        }
    }
}

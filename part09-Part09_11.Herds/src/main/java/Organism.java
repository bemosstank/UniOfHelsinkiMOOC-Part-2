/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ensia
 */
public class Organism implements Movable {

    private int x;
    private int y;

    public Organism(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    public void move(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    @Override
    public String toString() {
        return "x: " + this.x + "; " + "y: " + this.y;
    }
}

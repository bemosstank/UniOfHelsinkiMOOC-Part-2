/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

/**
 *
 * @author ensia
 */
import java.util.concurrent.ThreadLocalRandom;

public class Asteroid extends Character {

    private double rotationalMovement;
    public boolean alive;

    public Asteroid(int x, int y) {
        super(new PolygonFactory().createPolygon(), x, y);
        super.getCharacter().setRotate(ThreadLocalRandom.current().nextInt(360));
        int accelerationAmount = 1 + ThreadLocalRandom.current().nextInt(10);
        for (int i = 0; i < accelerationAmount; i++) {
            this.accelerate();
        }
        this.rotationalMovement = 0.5 - ThreadLocalRandom.current().nextDouble();
        this.alive = true;
    }

    public void setAlive(boolean isAlive) {
        this.alive = isAlive;
    }

    public boolean isAlive() {
        return this.alive;
    }

    @Override
    public void move() {
        super.move();
        super.getCharacter().setRotate(super.getCharacter().getRotate() + this.rotationalMovement);
    }
}

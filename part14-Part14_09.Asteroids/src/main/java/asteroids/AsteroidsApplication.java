package asteroids;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.scene.text.Text;


public class AsteroidsApplication extends Application {

    public static int WIDTH = 300;
    public static int HEIGHT = 200;

    @Override
    public void start(Stage stage) throws Exception {
        Map<KeyCode, Boolean> pressedKey = new HashMap<>();
        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);

        List<Asteroid> asteroids = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Asteroid asteriod = new Asteroid(ThreadLocalRandom.current().nextInt(WIDTH / 3), ThreadLocalRandom.current().nextInt(HEIGHT));
            asteroids.add(asteriod);
        }
        List<Projectiles> projectiles = new ArrayList<>();

        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        
        Text text = new Text(10, 20, "Points: 0");
        
        pane.getChildren().add(text);
        pane.getChildren().add(ship.getCharacter());
        asteroids.forEach(asteriod -> pane.getChildren().add(asteriod.getCharacter()));
        
        AtomicInteger points = new AtomicInteger();

        Scene scene = new Scene(pane);
        scene.setOnKeyPressed((events) -> {
            pressedKey.put(events.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased((events) -> {
            pressedKey.put(events.getCode(), Boolean.FALSE);
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {              
                if(ThreadLocalRandom.current().nextDouble() < 0.005){
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if(!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }
                if (pressedKey.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }
                if (pressedKey.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
                if (pressedKey.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
                if(pressedKey.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3){
                    
                    Projectiles projectile = new Projectiles((int)ship.getCharacter().getTranslateX(),(int)ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);
                    
                     

                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));

                    pane.getChildren().add(projectile.getCharacter());
                }
                
                ship.move();
                asteroids.forEach(asteriod -> asteriod.move());
                projectiles.forEach(projectile -> projectile.move());
                asteroids.forEach(asteriod -> {
                    if (ship.collide(asteriod)) {
                        stop();
                    }
                });
                
                
               projectiles.forEach(projectile -> {
                   asteroids.forEach(asteroid -> {
                       if(asteroid.collide(projectile)) {
                           projectile.setAlive(false);
                           asteroid.setAlive(false);
                       }
                   });
                   if(!projectile.isAlive()) {
                       text.setText("Points: " + points.addAndGet(1000));
                   }
               });
               
               
               
                  projectiles.stream()
                             .filter(projectile -> !projectile.isAlive())
                             .forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));
                  projectiles.removeAll(projectiles.stream()
                                                    .filter(projectile -> !projectile.isAlive())
                                                    .collect(Collectors.toList()));
                asteroids.stream()
                         .filter(asteroid -> !asteroid.isAlive())
                         .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
                
                asteroids.removeAll(asteroids.stream()
                            .filter(asteroid -> !asteroid.isAlive())
                            .collect(Collectors.toList()));
            }
        }.start();

        stage.setScene(scene);

        stage.setTitle("Asteroids!");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static double partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }

}

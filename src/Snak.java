

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.texture.Texture;
import com.almasb.fxgl.time.TimerAction;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.LinkedList;


public class Snak implements EntityFactory {
    static int speed = 4;
    static int width = 20;
    static int height = 25;
    static int foodX = 0;
    static int foodY = 0;
    static int lenght = 20;
    static LinkedList<Entity> snake = new LinkedList<>();
    static Direction direction = Direction.north;
    static boolean gameOver = false;

    static int countFood = 0;
    static int Coin = 0;
    static TimerAction timerAction;
    static Text gameover = new Text("");
static boolean snakeOpen;

    public enum Direction {
        west, east, north, south;
    }


    public void gameStart() {

        Texture space = FXGL.getAssetLoader().loadTexture("space.jpg", 400, 200);
        Entity backround = FXGL.entityBuilder().view(space).buildAndAttach();
        backround.setZ(1);
        Texture x = FXGL.getAssetLoader().loadTexture("black.png", 400, 500);
        Entity e = FXGL.entityBuilder().view(x).at(0, 200).buildAndAttach();


        snake.add(MyEntityFactory.newCell(300, 400));
        snake.add(MyEntityFactory.newCell((int) snake.getLast().getX() + 20, (int) snake.getLast().getY()));
        snake.add(MyEntityFactory.newCell((int) snake.getLast().getX() + 20, (int) snake.getLast().getY()));
        snake.add(MyEntityFactory.newCell((int) snake.getLast().getX() + 20, (int) snake.getLast().getY()));
        snake();

    }

    public void snake() {
        Text text2 = new Text(260, 170, "Score:");
        text2.setFont(new Font("", 30));
        text2.setFill(Color.WHITE);

        Text text = new Text(350, 170, "");
        text.setFont(new Font("", 30));
        text.setFill(Color.WHITE);


        FXGL.getGameScene().addUINodes(text,text2);
        text.textProperty().bind(FXGL.getGameState().intProperty("Coin").asString());


        newFood();
        timerAction = FXGL.getEngineTimer().runAtInterval(() -> {
            switch (direction) {
                case north:
                    snake.getLast().removeFromWorld();
                    snake.remove(snake.getLast());
                    snake.addFirst(MyEntityFactory.newCell((int) snake.getFirst().getX(), (int) snake.getFirst().getY() - 20));
                    break;
                case south:
                    snake.getLast().removeFromWorld();
                    snake.remove(snake.getLast());
                    snake.addFirst(MyEntityFactory.newCell((int) snake.getFirst().getX(), (int) snake.getFirst().getY() + 20));
                    break;
                case west:
                    snake.getLast().removeFromWorld();
                    snake.remove(snake.getLast());
                    snake.addFirst(MyEntityFactory.newCell((int) snake.getFirst().getX() - 20, (int) snake.getFirst().getY()));
                    break;
                case east:
                    snake.getLast().removeFromWorld();
                    snake.remove(snake.getLast());
                    snake.addFirst(MyEntityFactory.newCell((int) snake.getFirst().getX() + 20, (int) snake.getFirst().getY()));
                    break;
            }

            for (int i = 2; i < snake.size(); i++) {
                if (snake.getFirst().getX() == snake.get(i).getX() && snake.getFirst().getY() == snake.get(i).getY()) {
                    gameOver = true;
                    gameover.setText("Why did you want to eat your tail ?");
                    gameover.setTranslateX(7);
                }

            }
            if (snake.getFirst().getX() < 0 || snake.getFirst().getX() >= width * lenght || snake.getFirst().getY() < 200 || snake.getFirst().getY() >= (height * lenght) + 200) {
                gameOver = true;
                gameover.setText("You hit the wall badly");
                gameover.setTranslateX(75);
            }
            if (gameOver) {
                timerAction.expire();
                gameover.setFont(new Font(25));
                gameover.setFill(Color.SNOW);

                gameover.setTranslateY(450);
                FXGL.addUINode(gameover);
            }

            if (foodX == (int) snake.getFirst().getX() && foodY == (int) snake.getFirst().getY()) {
                MyEntityFactory.removeFood();
                newFood();
                for (int i = 0; i <snake.size() ; i++) {
                    if (snake.get(i).getX()==foodX &&snake.get(i).getY()==foodY){
                        MyEntityFactory.removeFood();
                        newFood();
                    }
                }

                FXGL.play("eating.wav");
                switch (direction) {
                    case north:
                        snake.addFirst(MyEntityFactory.newCell((int) snake.getFirst().getX(), (int) snake.getFirst().getY() - 20));
                        break;
                    case south:
                        snake.addFirst(MyEntityFactory.newCell((int) snake.getFirst().getX(), (int) snake.getFirst().getY() + 20));
                        break;
                    case east:
                        snake.addFirst(MyEntityFactory.newCell((int) snake.getFirst().getX() + 20, (int) snake.getFirst().getY()));
                        break;
                    case west:
                        snake.addFirst(MyEntityFactory.newCell((int) snake.getFirst().getX() - 20, (int) snake.getFirst().getY()));
                        break;

                }
                Coin++;
                FXGL.getGameState().increment("Coin", 1);
            }


        }, Duration.seconds(0.3 - (Snak.speed * 0.02)));

    }


    public void newFood() {

        foodX = FXGL.random(0, width - 1) * lenght;
        foodY = FXGL.random(0, height - 1) * lenght + 200;

        Dino.frame1 = FXGL.random(1, 3);
        Dino.frame2 = Dino.frame1;
        container.creating(container.anim, 150, 10);
        container.player.setZ(3);

        MyEntityFactory.newFood(foodX, foodY, Color.GREEN);
        Snak.speed++;

    }
    public static void Attributes() {
        if (Coin < 5) {
            Dino.frame1 = 3;
            Dino.frame2 = 3;
        }
        if (Coin > 5 && Coin < 15) {
            Dino.frame1 = 0;
            Dino.frame2 = 1;
        }
        if (Coin >= 15) {
            Dino.frame1 = 1;
            Dino.frame2 = 2;
            container.anim = true;
        }
        container.creating(container.anim, 75, 150);
    }


    public void closegame() {
        Dino.coins =Dino.coins+Coin;
        FXGL.getGameState().setValue("coins",Dino.coins);
        FXGL.getGameScene().clear();
        FXGL.getGameState().setValue("Coin", 0);
        snake.clear();
        gameOver = false;
        speed = 5;
        width = 20;
        height = 25;
        foodX = 0;
        foodY = 0;
        lenght = 20;
        direction = Direction.west;
        countFood = 0;


    }


}
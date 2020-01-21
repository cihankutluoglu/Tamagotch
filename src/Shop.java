
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import com.almasb.fxgl.time.TimerAction;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;



import static com.almasb.fxgl.dsl.FXGL.getAssetLoader;


public class Shop {

    static int counter =0;
    static boolean goBed;
    TimerAction sleepTimer;
    static TimerAction hehu;
    public void shopMenu() {
         Button bt = new Button();
         Button Friesbt = new Button();
         Button closebt = new Button();
         Button bananasbt = new Button();
         Button broccolibt = new Button();
         Button chocolatebt = new Button();
         Button kebabbt = new Button();
         Button salmonbt = new Button();
         Button coffeecupbt = new Button();
         Button eggbt = new Button();
         Button beerbt = new Button();
         Group root = new Group();
         Dino dino = new Dino();
         container c;
        Texture backround = getAssetLoader().loadTexture("backround.png", 270, 300);
        Texture shop = getAssetLoader().loadTexture("food.png", 60, 60);
        Texture broccoli = getAssetLoader().loadTexture("broccoli.png", 64, 64);
        Texture closeButton = getAssetLoader().loadTexture("x_logo.png", 32, 32);
        Texture fries = getAssetLoader().loadTexture("chips.png", 64, 64);
        Texture chocolate = getAssetLoader().loadTexture("chocolate.png", 64, 64);
        Texture coffeecup = getAssetLoader().loadTexture("coffee-cup.png", 64, 64);
        Texture kebab = getAssetLoader().loadTexture("skewer.png", 64, 64);
        Texture salmon = getAssetLoader().loadTexture("salmon.png", 64, 64);
        Texture bananas = getAssetLoader().loadTexture("bananas.png", 64, 64);
        Texture egg = getAssetLoader().loadTexture("boiled-egg.png", 64, 64);
        Texture beer = getAssetLoader().loadTexture("beer.png", 64, 64);
        HBox box = new HBox();
        Pane pane = new Pane();

        if (!RandomEvent.Random) {
            RandomEvent.random();
            RandomEvent.gameAttributes();
        }
        try {
            Dino.saveState();
        } catch (IOException e) {
            e.printStackTrace();
        }
        backround.setTranslateX(50);
        backround.setTranslateY(100);
        Text menuName = new Text("Shop");
        menuName.setFont(Font.font("Verdana", FontWeight.BOLD, 25));

        menuName.setStroke(Color.BLACK);
        menuName.setFill(Color.RED);
        menuName.setTranslateX(150);
        menuName.setTranslateY(125);

        try {
            RandomEvent.poop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        eggbt.setManaged(false);
        eggbt.setGraphic(egg);
        eggbt.setTranslateX(250);
        eggbt.setTranslateY(350);

        eggbt.setOnMouseEntered(acton -> {
            pane.setTranslateX(0);
            box.setTranslateX(120);
            pane.setTranslateY(550);
            box.setTranslateY(555);
            Rectangle rec = new Rectangle(400, 150, Color.BISQUE);
            Text text1 = new Text("Coin:           -15 \nHealth:        -5 \nFullness:      +5 \nHappiness:  -5 \nEnergy:        -5 ");
            text1.setFont(new Font("", 20));
            pane.getChildren().add(rec);
            box.getChildren().addAll(text1);
            FXGL.getGameScene().addUINode(pane);
            FXGL.getGameScene().addUINode(box);
        });
        eggbt.setOnMouseExited(action -> {
            box.getChildren().clear();
            pane.getChildren().clear();
            FXGL.getGameScene().removeUINode(box);
            FXGL.getGameScene().removeUINode(pane);
        });

        beerbt.setManaged(false);
        beerbt.setGraphic(beer);
        beerbt.setTranslateX(250);
        beerbt.setTranslateY(280);

        beerbt.setOnMouseEntered(acton -> {
            pane.setTranslateX(0);
            box.setTranslateX(120);
            pane.setTranslateY(550);
            box.setTranslateY(555);
            Rectangle rec = new Rectangle(400, 150, Color.BISQUE);
            Text text1 = new Text("Coin:           -20 \nHealth:        -15 \nFullness:      -10 \nHappiness:  +15 \nEnergy:        -5 ");
            text1.setFont(new Font("", 20));
            pane.getChildren().add(rec);
            box.getChildren().addAll(text1);
            FXGL.getGameScene().addUINode(pane);
            FXGL.getGameScene().addUINode(box);
        });

        beerbt.setOnMouseExited(action -> {
            box.getChildren().clear();
            pane.getChildren().clear();

            FXGL.getGameScene().removeUINode(box);
            FXGL.getGameScene().removeUINode(pane);

        });

        chocolatebt.setManaged(false);
        chocolatebt.setGraphic(chocolate);
        chocolatebt.setTranslateX(110);
        chocolatebt.setTranslateY(210);

        chocolatebt.setOnMouseEntered(acton -> {
            pane.setTranslateX(0);
            box.setTranslateX(120);
            pane.setTranslateY(550);
            box.setTranslateY(555);
            Rectangle rec = new Rectangle(400, 150, Color.BISQUE);
            Text text1 = new Text("Coin:           -10 \nHealth:        -10 \nFullness:      -5 \nHappiness:  +10 \nEnergy:        +5 ");
            text1.setFont(new Font("", 20));
            pane.getChildren().add(rec);
            box.getChildren().addAll(text1);
            FXGL.getGameScene().addUINode(pane);
            FXGL.getGameScene().addUINode(box);
        });
        chocolatebt.setOnMouseExited(action -> {
            box.getChildren().clear();
            pane.getChildren().clear();
            FXGL.getGameScene().removeUINode(box);
            FXGL.getGameScene().removeUINode(pane);
        });

        coffeecupbt.setManaged(false);
        coffeecupbt.setGraphic(coffeecup);
        coffeecupbt.setTranslateX(180);
        coffeecupbt.setTranslateY(210);

        coffeecupbt.setOnMouseEntered(acton -> {
            pane.setTranslateX(0);
            box.setTranslateX(120);
            pane.setTranslateY(550);
            box.setTranslateY(555);
            Rectangle rec = new Rectangle(400, 150, Color.BISQUE);
            Text text1 = new Text("Coin:           -10 \nHealth:        -5 \nFullness:      -10 \nHappiness:  +10 \nEnergy:        +10 ");
            text1.setFont(new Font("", 20));
            pane.getChildren().add(rec);
            box.getChildren().addAll(text1);
            FXGL.getGameScene().addUINode(pane);
            FXGL.getGameScene().addUINode(box);
        });
        coffeecupbt.setOnMouseExited(action -> {
            box.getChildren().clear();
            pane.getChildren().clear();
            FXGL.getGameScene().removeUINode(box);
            FXGL.getGameScene().removeUINode(pane);
        });

        kebabbt.setManaged(false);
        kebabbt.setGraphic(kebab);
        kebabbt.setTranslateX(250);
        kebabbt.setTranslateY(210);

        kebabbt.setOnMouseEntered(acton -> {
            pane.setTranslateX(0);
            box.setTranslateX(120);
            pane.setTranslateY(550);
            box.setTranslateY(555);
            Rectangle rec = new Rectangle(400, 150, Color.BISQUE);
            Text text1 = new Text("Coin:           -25 \nHealth:        -10 \nFullness:      +15 \nHappiness:  +15 \nEnergy:        -15 ");
            text1.setFont(new Font("", 20));
            pane.getChildren().add(rec);
            box.getChildren().addAll(text1);
            FXGL.getGameScene().addUINode(pane);
            FXGL.getGameScene().addUINode(box);
        });
        kebabbt.setOnMouseExited(action -> {
            box.getChildren().clear();
            pane.getChildren().clear();
            FXGL.getGameScene().removeUINode(box);
            FXGL.getGameScene().removeUINode(pane);
        });

        salmonbt.setManaged(false);
        salmonbt.setGraphic(salmon);
        salmonbt.setTranslateX(110);
        salmonbt.setTranslateY(280);

        salmonbt.setOnMouseEntered(acton -> {
            pane.setTranslateX(0);
            box.setTranslateX(120);
            pane.setTranslateY(550);
            box.setTranslateY(555);
            Rectangle rec = new Rectangle(400, 150, Color.BISQUE);
            Text text1 = new Text("Coin:           -25 \nHealth:        +5 \nFullness:      +10 \nHappiness:  +5 \nEnergy:        -5 ");
            text1.setFont(new Font("", 20));
            pane.getChildren().add(rec);
            box.getChildren().addAll(text1);
            FXGL.getGameScene().addUINode(pane);
            FXGL.getGameScene().addUINode(box);
        });
        salmonbt.setOnMouseExited(action -> {
            box.getChildren().clear();
            pane.getChildren().clear();
            FXGL.getGameScene().removeUINode(box);
            FXGL.getGameScene().removeUINode(pane);
        });

        bananasbt.setManaged(false);
        bananasbt.setGraphic(bananas);
        bananasbt.setTranslateX(180);
        bananasbt.setTranslateY(280);

        bananasbt.setOnMouseEntered(acton -> {
            pane.setTranslateX(0);
            box.setTranslateX(120);
            pane.setTranslateY(550);
            box.setTranslateY(555);
            Rectangle rec = new Rectangle(400, 150, Color.BISQUE);
            Text text1 = new Text("Coin:           -10 \nHealth:        -5 \nFullness:      +5 \nHappiness:  -5 \nEnergy:        +10 ");
            text1.setFont(new Font("", 20));
            pane.getChildren().add(rec);
            box.getChildren().addAll(text1);
            FXGL.getGameScene().addUINode(pane);
            FXGL.getGameScene().addUINode(box);
        });
        bananasbt.setOnMouseExited(action -> {
            box.getChildren().clear();
            pane.getChildren().clear();
            FXGL.getGameScene().removeUINode(box);
            FXGL.getGameScene().removeUINode(pane);
        });

        closebt.setGraphic(closeButton);
        closebt.setManaged(false);
        closebt.setTranslateX(290);
        closebt.setTranslateY(120);

        Friesbt.setGraphic(fries);
        Friesbt.setManaged(false);
        Friesbt.setTranslateY(350);
        Friesbt.setTranslateX(110);

        Friesbt.setOnMouseEntered(acton -> {
            pane.setTranslateX(0);
            box.setTranslateX(120);
            pane.setTranslateY(550);
            box.setTranslateY(555);
            Rectangle rec = new Rectangle(400, 150, Color.BISQUE);
            Text text1 = new Text("Coin:           -5 \nHealth:        -10 \nFullness:      +5 \nHappiness:  +10 \nEnergy:        -5 ");
            text1.setFont(new Font("", 20));
            pane.getChildren().add(rec);
            box.getChildren().addAll(text1);
            FXGL.getGameScene().addUINode(pane);
            FXGL.getGameScene().addUINode(box);
        });
        Friesbt.setOnMouseExited(action -> {
            box.getChildren().clear();
            pane.getChildren().clear();
            FXGL.getGameScene().removeUINode(box);
            FXGL.getGameScene().removeUINode(pane);
        });

        bt.setManaged(false);
        bt.setTranslateX(360);
        bt.setTranslateY(500);
        bt.setGraphic(shop);

        broccolibt.setManaged(false);
        broccolibt.setTranslateY(350);
        broccolibt.setTranslateX(180);
        broccolibt.setGraphic(broccoli);

        broccolibt.setOnMouseEntered(acton -> {
            pane.setTranslateX(0);
            box.setTranslateX(120);
            pane.setTranslateY(550);
            box.setTranslateY(555);
            Rectangle rec = new Rectangle(400, 150, Color.BISQUE);
            Text text1 = new Text("Coin:           -5 \nHealth:        +15 \nFullness:      -10 \nHappiness:  -15 \nEnergy:        -15 ");
            text1.setFont(new Font("", 20));
            pane.getChildren().add(rec);
            box.getChildren().addAll(text1);
            FXGL.getGameScene().addUINode(pane);
            FXGL.getGameScene().addUINode(box);
        });
        broccolibt.setOnMouseExited(action -> {
            box.getChildren().clear();
            pane.getChildren().clear();
            FXGL.getGameScene().removeUINode(box);
            FXGL.getGameScene().removeUINode(pane);
        });

        Button snakeButton = new Button();
        Texture snake = FXGL.getAssetLoader().loadTexture("snake.png", 50, 50);
        snakeButton.setGraphic(snake);
        snakeButton.setManaged(false);
        snakeButton.setTranslateX(270);
        snakeButton.setTranslateY(500);
        FXGL.addUINode(snakeButton);
        c = new container();
        snakeButton.setOnAction(e -> {
            if (goBed){

            }else if (!RandomEvent.ayran) {
                FXGL.getGameScene().clearUINodes();

                FXGL.getGameState().increment("happiness", +10);
                Dino.happiness += 10;
                FXGL.getGameState().increment("energy", -10);
                Dino.energy -= 10;
                FXGL.getGameState().increment("fullness", -10);
                Dino.fullness -= 10;
                if (Dino.isOver()) {
                    FXGL.getGameScene().clear();
                }
                c.snake();
            }
            else{
                Text text = new Text("How you can you play snake in this mood?");
                if(counter<1) {
                    text.setFont(new Font(20));
                    text.setTranslateX(10);
                    text.setTranslateY(600);
                    text.setFill(Color.WHITE);
                    FXGL.addUINode(text);
                    counter++;
                }
               hehu =FXGL.getEngineTimer().runOnceAfter(()->{
                   FXGL.getGameScene().removeUINode(text);
                   counter--;
               },Duration.seconds(5));
            }
        });

        Button blackJack = new Button("blackjackk");
        Texture bjimage = FXGL.getAssetLoader().loadTexture("blackjack.png", 50, 50);
        blackJack.setGraphic(bjimage);
        blackJack.setManaged(false);
        blackJack.setTranslateX(170);
        blackJack.setTranslateY(500);
        FXGL.addUINode(blackJack);
        blackJack.setOnAction(event -> {
            if(!goBed) {
                container.player.removeFromWorld();
                c.blackJack();
            }

        });
        Button gosleep = new Button("bed");
        Texture bed = FXGL.getAssetLoader().loadTexture("bed.png", 50, 50);
        gosleep.setGraphic(bed);
        gosleep.setManaged(false);
        gosleep.setTranslateX(100);
        gosleep.setTranslateY(500);
        FXGL.addUINode(gosleep);
        gosleep.setOnAction(actionEvent -> {
            if (!goBed) {
                sleeping();
            } else {
                wakeUp();
            }
        });


        Button save = new Button("save");
        Texture saveIcon = FXGL.getAssetLoader().loadTexture("save.png", 50, 50);
        save.setManaged(false);
        save.setGraphic(saveIcon);
        save.setTranslateX(20);
        save.setTranslateY(500);
        save.setOnMouseClicked(mouseEvent -> {
            try {
                Dino.saveState();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        FXGL.getGameScene().addUINode(save);


        root.getChildren().addAll(backround, beerbt, eggbt, salmonbt, coffeecupbt, kebabbt,
                chocolatebt, bananasbt, bt, broccolibt, Friesbt, closebt, menuName);

        FXGL.getGameScene().addUINode(bt);
        bt.setOnAction(actionEvent -> {
            if(!goBed) {
                try {
                    FXGL.getGameScene().addUINode(root);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        });

        beerbt.setOnAction(actionEvent -> {
            if (dino.coins >= 20) {


                if (Dino.happiness <= 85) {
                    FXGL.getGameState().increment("happiness", +15);
                    dino.happiness += 15;
                }
                dino.health -= 15;
                dino.coins -= 20;
                dino.fullness -= 10;
                dino.energy -= 5;

                FXGL.getGameState().increment("health", -15);
                FXGL.getGameState().increment("coins", -20);
                FXGL.getGameState().increment("fullness", -10);
                FXGL.getGameState().increment("energy", -5);

                Dino.setFrame();
                if (Dino.frameChange) {
                    container.creating(container.anim, 75, 150);
                    Dino.frameChange = false;
                }
            }
            if (Dino.isOver()) {
                FXGL.getGameScene().removeUINodes(box, pane);
                FXGL.getGameScene().clear();
            }
        });
        eggbt.setOnAction(actionEvent -> {
            if (dino.coins >= 15) {
                if (Dino.health <= 95) {
                    FXGL.getGameState().increment("health", +5);
                    dino.health += 5;
                }

                if (Dino.fullness <= 95) {
                    FXGL.getGameState().increment("fullness", +5);
                    dino.fullness += 5;
                }
                dino.coins -= 15;
                dino.happiness -= 5;
                dino.energy -= 5;

                FXGL.getGameState().increment("coins", -15);
                FXGL.getGameState().increment("happiness", -5);
                FXGL.getGameState().increment("energy", -5);

                Dino.setFrame();
                if (Dino.frameChange) {
                    container.creating(container.anim, 75, 150);
                    Dino.frameChange = false;
                }
                if (Dino.isOver()) {
                    FXGL.getGameScene().removeUINodes(box, pane);
                    FXGL.getGameScene().clear();
                }
            }
        });
        salmonbt.setOnAction(actionEvent -> {
            if (dino.coins >= 25) {
                if (Dino.health <= 95) {
                    FXGL.getGameState().increment("health", +5);
                    dino.health += +5;
                }

                if (Dino.fullness <=90) {
                    FXGL.getGameState().increment("fullness", +10);
                    dino.fullness += 10;
                }
                dino.coins -= 25;
                dino.happiness -= 5;
                dino.energy -= 5;

                FXGL.getGameState().increment("coins", -25);
                FXGL.getGameState().increment("happiness", -5);
                FXGL.getGameState().increment("energy", -5);

            }
            if (Dino.isOver()) {
                FXGL.getGameScene().removeUINodes(box, pane);
                FXGL.getGameScene().clear();
            }
            Dino.setFrame();
            if (Dino.frameChange) {
                container.creating(container.anim, 75, 150);
                Dino.frameChange = false;
            }
        });
        coffeecupbt.setOnAction(actionEvent -> {
            if (dino.coins >= 10) {

                if (Dino.happiness <= 95) {
                    FXGL.getGameState().increment("happiness", +5);
                    dino.happiness += 5;
                }
                if (Dino.energy <= 90) {
                    FXGL.getGameState().increment("energy", +10);
                    dino.energy += 10;
                }
                dino.health -= 5;
                dino.coins -= 10;
                dino.fullness -= 10;

                FXGL.getGameState().increment("health", -5);
                FXGL.getGameState().increment("coins", -10);
                FXGL.getGameState().increment("fullness", -10);

            }
            if (Dino.isOver()) {
                FXGL.getGameScene().removeUINodes(box, pane);
                FXGL.getGameScene().clear();
            }
            Dino.setFrame();
            if (Dino.frameChange) {
                container.creating(container.anim, 75, 150);
                Dino.frameChange = false;
            }

        });
        kebabbt.setOnAction(actionEvent -> {
            if (dino.coins >= 25) {

                if (Dino.fullness <= 85) {
                    FXGL.getGameState().increment("fullness", +15);
                    dino.fullness += 15;
                }
                if (Dino.happiness <= 85) {
                    FXGL.getGameState().increment("happiness", +15);
                    dino.happiness += 15;
                }
                dino.health -= 10;
                dino.coins -= 25;
                dino.energy -= 15;

                FXGL.getGameState().increment("health", -10);
                FXGL.getGameState().increment("coins", -25);
                FXGL.getGameState().increment("energy", -15);
            }
            if (Dino.isOver()) {
                FXGL.getGameScene().removeUINodes(box, pane);
                FXGL.getGameScene().clear();
            }
            Dino.setFrame();
            if (Dino.frameChange) {
                container.creating(container.anim, 75, 150);
                Dino.frameChange = false;
            }

        });
        chocolatebt.setOnAction(actionEvent -> {
            if (dino.coins >= 10) {

                if (Dino.happiness <= 95) {
                    FXGL.getGameState().increment("happiness", +5);

                    dino.happiness += 5;
                }
                if (Dino.energy <= 95) {
                    FXGL.getGameState().increment("energy", +5);
                    dino.energy += 5;
                }

                dino.health -= 5;
                dino.coins -= 10;
                dino.fullness -= 5;
                FXGL.getGameState().increment("health", -5);
                FXGL.getGameState().increment("coins", -10);
                FXGL.getGameState().increment("fullness", -5);


            }
            if (Dino.isOver()) {
                FXGL.getGameScene().removeUINodes(box, pane);
                FXGL.getGameScene().clear();
            }
            Dino.setFrame();
            if (Dino.frameChange) {
                container.creating(container.anim, 75, 150);
                Dino.frameChange = false;
            }

        });
        bananasbt.setOnAction(actionEvent -> {
            if (dino.coins >= 10) {

                if (Dino.fullness <= 95) {
                    dino.fullness += 5;
                    FXGL.getGameState().increment("fullness", +5);
                }

                if (Dino.energy <=90) {
                    dino.energy += 10;
                    FXGL.getGameState().increment("energy", +10);
                }
                dino.health -= 5;
                dino.coins -= 10;
                dino.happiness -= 5;
                FXGL.getGameState().increment("health", -5);
                FXGL.getGameState().increment("coins", -10);
                FXGL.getGameState().increment("happiness", -5);


            }
            if (Dino.isOver()) {
                FXGL.getGameScene().removeUINodes(box, pane);
                FXGL.getGameScene().clear();
            }
            Dino.setFrame();
            if (Dino.frameChange) {
                container.creating(container.anim, 75, 150);
                Dino.frameChange = false;
            }

        });
        broccolibt.setOnAction(actionEvent -> {
            if (dino.coins >= 5) {
                if (Dino.health <= 85) {
                    FXGL.getGameState().increment("health", +15);
                    dino.health += 15;
                }
                dino.coins -= 5;
                if (Dino.fullness <= 85) {
                    FXGL.getGameState().increment("fullness", +15);
                    dino.fullness += 15;
                }
                dino.happiness -= 25;
                dino.energy -= 15;


                FXGL.getGameState().increment("coins", -5);
                FXGL.getGameState().increment("happiness", -25);
                FXGL.getGameState().increment("energy", -15);
                System.out.println(Dino.frame1);
            }
            if (Dino.isOver()) {
                FXGL.getGameScene().removeUINodes(box, pane);
                FXGL.getGameScene().clear();
            }
            Dino.setFrame();
            if (Dino.frameChange) {
                container.creating(container.anim, 75, 150);
                Dino.frameChange = false;
            }


        });
        Friesbt.setOnAction(actionEvent -> {
            if (dino.coins >= 5) {
                dino.health -= 10;
                dino.coins -= 5;
                if (Dino.fullness <= 95) {
                    dino.fullness += 5;
                    FXGL.getGameState().increment("fullness", +5);
                }
                if (Dino.happiness <= 90) {
                    dino.happiness += 10;
                    FXGL.getGameState().increment("happiness", +10);
                }
                dino.energy -= 5;
                FXGL.getGameState().increment("health", -10);
                FXGL.getGameState().increment("coins", -5);
                FXGL.getGameState().increment("energy", -5);
            }
            if (Dino.isOver()) {
                FXGL.getGameScene().removeUINodes(box, pane);
                FXGL.getGameScene().clear();
            }
            Dino.setFrame();
            if (Dino.frameChange) {
                container.creating(container.anim, 75, 150);
                Dino.frameChange = false;
            }

        });
        closebt.setOnAction(actionEvent -> {
            FXGL.getGameScene().removeUINode(root);
        });
        dino.texts();

    }

    public void sleeping() {
        if(!RandomEvent.ayran) {
            goBed = true;
            Dino.setFrame();
            container.creating(container.anim, 75, 150);
            sleepTimer = FXGL.getEngineTimer().runAtInterval(() -> {
                if (Dino.energy < 100) {
                    Dino.energy += 1;
                    FXGL.getGameState().increment("energy", 1);
                }
                Dino.fullness -= 1;
                FXGL.getGameState().increment("fullness", -1);
            }, Duration.seconds(1));
        }
    }

    public void wakeUp() {
        goBed = false;
        Dino.setFrame();
        container.creating(container.anim, 75, 150);
        try {
            Dino.saveState();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sleepTimer.pause();
    }


}



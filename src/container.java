import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import com.sun.jdi.request.DuplicateRequestException;
import javafx.scene.Group;
import javafx.scene.control.Button;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

import static com.almasb.fxgl.dsl.FXGL.getAssetLoader;


public class container {
    static Shop shop = new Shop();
    Group MainMenu = new Group();
    Button Game;
    private Button SaveLoad;
    Button Load;
    Button Exit;



    Character character;
    static boolean anim=false;
    static boolean aliG;
    static boolean burakG;
    static boolean ciyoG;
    static Entity player;
    static Text game;
    static boolean scene = false;


    Texture backround = getAssetLoader().loadTexture("backround1.jpeg",400,700);


    public container() {


        Texture create1 = getAssetLoader().loadTexture("create.png");
        Texture create2 = getAssetLoader().loadTexture("create2.png");
        Texture load1 = getAssetLoader().loadTexture("Load2.png");
        Texture load2 = getAssetLoader().loadTexture("Load.png");
        Texture exit1 = getAssetLoader().loadTexture("exit2.png");
        Texture exit2 = getAssetLoader().loadTexture("exit.png");


        Game = new Button();
        Game.setTranslateX(200);
        Game.setTranslateY(200);
        Game.setGraphic(create1);
        Game.setManaged(false);
        Game.setOnMouseEntered(mouseEvent -> {
            Game.setGraphic(create2);
        });
        Game.setOnMouseExited(mouseEvent -> {
            Game.setGraphic(create1);
        });
        Game.setOnMouseClicked(mouseEvent -> {


            FXGL.getGameScene().removeUINode(MainMenu);
            chooseMenu();
            FXGL.getGameScene().removeUINode(backround);
        });


        SaveLoad = new Button();
        SaveLoad.setTranslateX(200);
        SaveLoad.setTranslateY(300);
        SaveLoad.setGraphic(load1);
        SaveLoad.setOnMouseEntered(mouseEvent -> {
            SaveLoad.setGraphic(load2);
        });
        SaveLoad.setOnMouseExited(mouseEvent -> {
            SaveLoad.setGraphic(load1);
        });
        SaveLoad.setManaged(false);
        SaveLoad.setOnMouseClicked(mouseEvent -> {
            FXGL.getGameScene().removeUINode(MainMenu);
            FXGL.getGameScene().addUINode(saveMenu());
        });


        Exit = new Button();
        Exit.setTranslateX(200);
        Exit.setTranslateY(400);
        Exit.setGraphic(exit1);
        Exit.setOnMouseEntered(mouseEvent -> {
            Exit.setGraphic(exit2);
        });
        Exit.setOnMouseExited(mouseEvent -> {
            Exit.setGraphic(exit1);
        });
        Exit.setManaged(false);
        Exit.setOnAction(actionEvent -> {
            FXGL.getGameController().exit();
        });
        MainMenu.getChildren().addAll(backround, SaveLoad, Exit, Game);


    }

    public void chooseMenu() {
        Group group = new Group();
        Texture back = getAssetLoader().loadTexture("backround.jpeg", 400, 700);

        Texture one = getAssetLoader().loadTexture("ali.png", 150, 150);
        Texture tree = getAssetLoader().loadTexture("burak.png", 150, 150);
        Texture two = getAssetLoader().loadTexture("ciyos.png", 150, 150);
        Texture one1 =getAssetLoader().loadTexture("aliprofile.png",150,150);
        Texture tree1 =getAssetLoader().loadTexture("burak2.png",150,150);
        Texture two1 =getAssetLoader().loadTexture("ciyos2.png",150,150);
        Button bt1 = new Button("1");
        bt1.setGraphic(one);
        bt1.setTranslateX(125);
        bt1.setTranslateY(150);
        bt1.setManaged(false);
        bt1.setOnMouseEntered(mouseEvent -> {
            bt1.setGraphic(one1);
        });
        bt1.setOnMouseExited(mouseEvent -> {
            bt1.setGraphic(one);
        });
        bt1.setOnAction(event -> {
            character = new Character(false,Dino.frame1,Dino.frame2,anim);
            if (player != null) {
                player.removeFromWorld();
            }
            MyEntityFactory.newBackround();

            FXGL.removeUINode(group);
            aliG = true;
            burakG = false;
            ciyoG = false;
            player = MyEntityFactory.newChar(character, 75, 150);

            try {

                shop.shopMenu();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        });
        Button bt2 = new Button("2");
        bt2.setOnMouseEntered(mouseEvent -> {
            bt2.setGraphic(tree1);
        });
        bt2.setOnMouseExited(mouseEvent -> {
            bt2.setGraphic(tree);
        });
        bt2.setOnAction(event -> {

            character = new Character(true, false,Dino.frame1,Dino.frame2,scene);
            if (player != null) {
                player.removeFromWorld();
            }
            MyEntityFactory.newBackround();
            player = MyEntityFactory.newChar(character, 75, 150);
            FXGL.removeUINode(group);
            aliG = false;
            burakG = true;
            ciyoG = false;
            try {

                shop.shopMenu();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        });
        bt2.setTranslateX(125);
        bt2.setTranslateY(330);
        bt2.setManaged(false);
        bt2.setGraphic(tree);
        Button bt3 = new Button("3");
        bt3.setGraphic(two);
        bt3.setTranslateX(125);
        bt3.setTranslateY(510);
        bt3.setManaged(false);
        bt3.setOnMouseEntered(mouseEvent -> {
            bt3.setGraphic(two1);
        });
        bt3.setOnMouseExited(mouseEvent -> {
            bt3.setGraphic(two);
        });
        bt3.setOnAction(event -> {
            character = new Character(3, false,Dino.frame1,Dino.frame2,scene);
            if (player != null) {
                player.removeFromWorld();
            }
            MyEntityFactory.newBackround();
            player = MyEntityFactory.newChar(character, 75, 150);
            FXGL.removeUINode(group);

            aliG = false;
            burakG = false;
            ciyoG = true;
            try {

                shop.shopMenu();
            } catch (DuplicateRequestException e) {
                e.printStackTrace();
            }
        });
        group.getChildren().addAll(back, bt1, bt2, bt3);
        FXGL.addUINode(group);


    }

    public void blackJack() {
        Texture goBackF =FXGL.getAssetLoader().loadTexture("goBack.png",90,60);
        Texture stopF =FXGL.getAssetLoader().loadTexture("stop.png",90,60);
        Texture hitF =FXGL.getAssetLoader().loadTexture("hit.png",90,60);
        Texture againF =FXGL.getAssetLoader().loadTexture("again.png",90,60);
        Texture betF =FXGL.getAssetLoader().loadTexture("bet.png",90,60);
        scene = true;
        FXGL.getGameScene().clear();
        FXGL.getGameScene().setBackgroundColor(Color.SEAGREEN);

        Button increaseBet = new Button();
        FXGL.addUINode(increaseBet);
        increaseBet.setTranslateX(200);
        increaseBet.setTranslateY(260);
        Texture increment =FXGL.getAssetLoader().loadTexture("increase.png",60,60);
        increaseBet.setGraphic(increment);
        increaseBet.setManaged(false);
        increaseBet.setOnAction(event -> {
            PlayBlack.setBet(5);

        });

        Button goBack = new Button();
        goBack.setGraphic(goBackF);
        goBack.setTranslateX(50);
        goBack.setTranslateY(40);
        goBack.setManaged(false);
        FXGL.addUINode(goBack);
        goBack.setOnAction(even -> {
            if(PlayBlack.handOpen||PlayBlack.player.isEmpty()) {
                scene = false;
                FXGL.getGameScene().setBackgroundColor(Color.WHITE);
                FXGL.getGameScene().clear();
                PlayBlack.reset();
                if (RandomEvent.ayran) {
                    RandomEvent.animal();
                    shop.shopMenu();

                    System.out.println(PlayBlack.countRan);
                } else {
                    RandomEvent.action.resume();
                    shop.shopMenu();
                    Dino.setFrame();
                    creating(anim, 75, 150);
                }
                MyEntityFactory.newBackround();
            }
        });

        Button decreaseBet = new Button();
        FXGL.addUINode(decreaseBet);
        decreaseBet.setTranslateY(325);
        decreaseBet.setTranslateX(200);
        Texture decrease =FXGL.getAssetLoader().loadTexture("decrease.png",60,60);
        decreaseBet.setGraphic(decrease);
        decreaseBet.setManaged(false);
        decreaseBet.setOnAction(event -> {
            if (PlayBlack.bet > 5)
                PlayBlack.setBet(-5);
        });
        Text bets =new Text("Bet :");
        bets.setFont(new Font(20));
        bets.setTranslateY(300);
        bets.setTranslateX(152);
        game = new Text(197, 300,"" );
        game.setFont(new Font(20));


        game.textProperty().bind(FXGL.getGameState().intProperty("bet").asString());
        FXGL.addUINode(game);
        FXGL.addUINode(bets);

        Button openGame = new Button();
        openGame.setGraphic(betF);
        openGame.setManaged(false);
        openGame.setTranslateX(300);
        openGame.setTranslateY(290);
        openGame.setOnAction(event -> {
            FXGL.play("cardShuffle.wav");
            FXGL.getGameScene().removeUINodes(increaseBet, decreaseBet, game, openGame,bets);
            try {
                Dino.saveState();
            } catch (IOException e) {
                e.printStackTrace();
            }
            PlayBlack.game();
            Button hit = new Button();
            hit.setGraphic(hitF);
            hit.setManaged(false);
            hit.setTranslateX(330);
            hit.setTranslateY(440);
            FXGL.addUINode(hit);
            hit.setOnAction(even -> {
                if (!PlayBlack.handOpen)
                    PlayBlack.hitPlayer();
            });

            Button stop = new Button();
            stop.setGraphic(stopF);
            stop.setManaged(false);
            stop.setTranslateX(330);
            stop.setTranslateY(310);

            stop.setOnAction(even -> {
                if (!PlayBlack.handOpen) {
                    PlayBlack.stop();

                }

            });
            Button reset = new Button("");
            reset.setGraphic(againF);
            reset.setManaged(false);
            reset.setTranslateX(350);
            reset.setTranslateY(40);
            FXGL.addUINode(reset);
            reset.setOnAction(even -> {
                if (PlayBlack.handOpen) {
                    PlayBlack.reset();
                    FXGL.getGameScene().removeUINodes(hit, stop, reset, PlayBlack.hand,PlayBlack.computerHand,PlayBlack.tcom,PlayBlack.tplayer);
                    game.textProperty().bind(FXGL.getGameState().intProperty("bet").asString());
                    FXGL.getGameScene().addUINodes(increaseBet, decreaseBet, openGame, game,bets);


                    openGame.setOnAction(e -> {
                        FXGL.play("cardShuffle.wav");
                        FXGL.getGameScene().addUINodes(hit, stop, reset);
                        FXGL.getGameScene().removeUINodes(increaseBet, decreaseBet, game, openGame,bets);
                        PlayBlack.game();

                    });
                }
            });
            FXGL.addUINode(stop);






        });
        FXGL.getGameScene().addUINode(openGame);


    }


    public void snake() {
        FXGL.getGameScene().clear();

        Texture goBackF =FXGL.getAssetLoader().loadTexture("goBack.png",90,60);
        scene = true;
        Snak snake = new Snak();
        snake.gameStart();
        Snak.snakeOpen =true;
        Button goBack = new Button();
        goBack.setTranslateY(40);
        goBack.setTranslateX(50);
        goBack.setGraphic(goBackF);
        goBack.setManaged(false);
        Dino.setFrame();
        if (Dino.frameChange) {
            container.creating(container.anim, 150, 10);
            Dino.frameChange = false;
            container.player.setZ(3);
        }

        FXGL.getGameScene().addUINode(goBack);
        goBack.setOnAction(event -> {
            if (Snak.gameOver) {
                Snak.snakeOpen =false;
                scene = false;
                snake.closegame();
                if (RandomEvent.ayran) {
                    RandomEvent.animal();
                } else {
                    shop.shopMenu();
                    Snak.Attributes();
                }
                Snak.Coin=0;

                MyEntityFactory.newBackround();
            }
        });

        FXGL.getGameState().setValue("coins", FXGL.getGameState().getInt("Coin") + FXGL.getGameState().getInt("coins"));

//        FXGL.getGameScene().addUINode(text2);
    }


    public Group saveMenu() {
        Group saveLoadMenu = new Group();


            try{
                Dino.loadState();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        MyEntityFactory.newBackround();
            Dino.setFrame();
           creating(anim,75,150);
            shop.shopMenu();
            FXGL.getGameScene().removeUINode(saveLoadMenu);

        return saveLoadMenu;
    }

    public static void creating(boolean anim,int x,int y) {
        Character dudeControl;
        if (aliG) {
            dudeControl = new Character(anim,Dino.frame1,Dino.frame2,scene);
            if (player != null) {
                player.removeFromWorld();
            }

            player = MyEntityFactory.newChar(dudeControl, x,y );
            aliG = true;
            burakG = false;
            ciyoG = false;
            if (anim)
                dudeControl.animate();
        } else if (burakG) {
            dudeControl = new Character(true, anim,Dino.frame1,Dino.frame2,scene);
            if (player != null) {
                player.removeFromWorld();
            }

            player = MyEntityFactory.newChar(dudeControl, x,y );
            aliG = false;
            burakG = true;
            ciyoG = false;
            if (anim)
                dudeControl.animate(true);
        } else if (ciyoG) {
            dudeControl = new Character(1, anim,Dino.frame1,Dino.frame2,scene);
            if (player != null) {
                player.removeFromWorld();
            }

            player = MyEntityFactory.newChar(dudeControl, x,y );
            aliG = false;
            burakG = false;
            ciyoG = true;
            if (anim)
                dudeControl.animate(1);
        }
    }




}

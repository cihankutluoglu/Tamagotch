import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import com.almasb.fxgl.time.TimerAction;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;

public class PlayBlack {
    static int random;
    static ArrayList<Integer> player = new ArrayList<>();
    static ArrayList<Integer> computer = new ArrayList<>();
    static int randomBack;
    static int comX = 50;
    static int comY = 120;
    static int comBackX = 0;
    static int playerX = 50;
    static int playerY = 520;
    static int playerHand = 0;
    static int comHand = 0;
    static int hasplayerAs = 0;
    static int hascomAs = 0;
    static int win = 5;
    static boolean handOpen = false;
    static boolean back = false;
    static DecksCom decksCom;
    static MyEntityFactory fac = new MyEntityFactory();
    static Entity card;
    static ArrayList<Entity> lists = new ArrayList<>();
    static int flag = 0;
    static TimerAction timerAction;
    static Text text = new Text();
    static int bet = 5;
    static Text hand;
    static Text computerHand;
    static int countRan = 0;
    static int cshow = 0;
    static Text tcom = new Text(20, 320, "Com Hand:");
    static Text tplayer = new Text(20, 450, "Your Hand:");

    public static void game() {

        timerAction = FXGL.getEngineTimer().runOnceAfter(() -> {

            tplayer.setFont(new Font(30));
            tplayer.setFill(Color.BLACK);
            hand = new Text(170, 450, "");
            hand.setFont(new Font("", 30));
            hand.setFill(Color.BLACK);

            hand.textProperty().bind(FXGL.getGameState().intProperty("Player").asString());
            tcom.setFont(new Font(30));
            tcom.setFill(Color.BLACK);

            computerHand = new Text(170, 320, "");
            computerHand.setFont(new Font("", 30));
            computerHand.setFill(Color.BLACK);
            text.setFont(new Font(35));


            FXGL.getGameScene().addUINodes(computerHand, hand, tcom, tplayer);
            computerHand.textProperty().bind(FXGL.getGameState().intProperty("ShowCom").asString());

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    random = FXGL.random(0, 51);
                    cshow = random;

                    decksCom = new DecksCom(random);
                    card = fac.newCard(decksCom, comX, comY);
                    card.setZ(0);
                    if (random % 13 > 9) {
                        computer.add(10);
                    } else if (random % 13 == 0) {
                        computer.add(11);
                        hascomAs++;
//                        c = i;
                    } else {
                        computer.add((random % 13) + 1);
                    }
                    cshow = computer.get(0);
                    comX += 50;
                    lists.add(card);

                } else {

                    randomBack = FXGL.random(0, 51);
                    decksCom = new DecksCom(true);
                    card = fac.newCard(decksCom, comX, comY);
                    card.setZ(1);
                    MyEntityFactory.anim = FXGL.animationBuilder().duration(Duration.millis(250));
                    comBackX = comX;
                    if (randomBack % 13 > 9) {
                        computer.add(10);
                    } else if (randomBack % 13 == 0) {
                        computer.add(11);
                        hascomAs++;

                    } else {
                        computer.add((randomBack % 13) + 1);
                    }
                    comX += 50;
                    lists.add(card);
                }
                getCom();
            }
            for (int i = 0; i < 2; i++) {
                random = FXGL.random(0, 51);

                decksCom = new DecksCom(random);
                card = fac.newCard(decksCom, playerX, playerY);
                card.setZ(i);
                MyEntityFactory.anim = FXGL.animationBuilder().duration(Duration.millis(250));
                if (random % 13 > 9) {
                    player.add(10);
                } else if (random % 13 == 0) {
                    player.add(11);
                    hasplayerAs++;

                } else {
                    player.add((random % 13) + 1);
                }
                playerX += 50;
                lists.add(card);
            }


            if (hasplayerAs >= 2) {
                player.set(0, 1);
            }
            if (hascomAs >= 2) {
                computer.set(0, 1);
            }

            if (getplayer() == 21) {
                gameOver();
                FXGL.addUINode(text);
            }

        }, Duration.millis(500));


    }

    public static void gameOver() {

//        if (playerHand > 21) {
//            if (hasplayerAs >= 1) {
//                player.set(p,player.get(p)-10);
//                hasplayerAs--;
//            }
//        else {
        if (getplayer() > 21) {

            win = -1;
            openBack();
//            }
//            }
            flag++;

        } else
//            if (comHand > 21) {
//            if (hascomAs >= 1) {
//                computer.set(c,computer.get(c)-10);
//                hascomAs--;
//            } else {
            if (getCom() > 21) {

                win = 1;
                openBack();
//            }

                flag++;
            } else if (getplayer() == 21) {

                if (flag >= 1) {
                    hitCom();
                }
                openBack();
                if (getCom() == 21) {

                    win = 0;
                } else

                    win = 1;
                flag++;

            } else if (getCom() == 21) {
                openBack();
                win = -1;

                flag++;
            } else if (getplayer() > getCom()) {
                openBack();
                win = 1;

                flag++;
            } else if (getplayer() == getCom()) {
                openBack();
                win = 0;
                flag++;
            } else {
                win = -1;

                openBack();
                flag++;
            }

        if (!handOpen) {
            FXGL.getGameState().setValue("ShowCom", cshow);
        } else {

            FXGL.getGameState().setValue("ShowCom", comHand);
        }
        if (win == 1) {
            text.setText("You win");
            text.setTranslateX(150);
            text.setTranslateY(380);
            text.setFill(Color.RED);

            FXGL.getGameState().increment("coins", bet);
            Dino.coins += bet;
            countRan++;
        }
        if (win == 0) {
            text.setText("Draw");
            text.setTranslateX(150);
            text.setTranslateY(380);
            text.setFill(Color.RED);

            FXGL.getGameState().increment("coins", 0);
        }
        if (win == -1) {
            text.setText("You lost");
            text.setTranslateX(150);
            text.setTranslateY(380);
            text.setFill(Color.RED);

            FXGL.getGameState().increment("coins", -bet);
            Dino.coins -= bet;
            if (countRan >= 0)
                countRan--;

        }
        if (countRan > 0) {
            RandomEvent.ridMaan();
            countRan = 0;
        }

    }

    public static void hitPlayer() {
        flag++;
        FXGL.play("cardtake.wav");
        random = FXGL.random(0, 51);


        decksCom = new DecksCom(random);
        card = fac.newCard(decksCom, playerX, playerY);
        card.setZ(player.size());
        MyEntityFactory.anim = FXGL.animationBuilder().duration(Duration.millis(250));
        if (random % 13 > 9) {
            player.add(10);
        } else if (random % 13 == 0) {
            player.add(11);
            hasplayerAs++;

        } else {
            player.add((random % 13) + 1);
        }
        playerX += 50;
        lists.add(card);
        getplayer();
        getCom();
        if (playerHand >= 21) {
            gameOver();
            FXGL.addUINode(text);

        }


    }

    public static void hitCom() {


        FXGL.play("cardtake.wav");
        random = FXGL.random(0, 51);

        decksCom = new DecksCom(random);
        card = fac.newCard(decksCom, comX, comY);
        card.setZ(computer.size() + 2);
        MyEntityFactory.anim = FXGL.animationBuilder().duration(Duration.millis(250));
        if (random % 13 > 9) {
            computer.add(10);
        } else if (random % 13 == 0) {
            computer.add(11);
            hascomAs++;

        } else {
            computer.add((random % 13) + 1);
        }
        comX += 50;
        lists.add(card);
        getplayer();
        getCom();
        if (comHand >= 21) {
            gameOver();
        }


    }

    public static void stop() {
        handOpen = true;
        while (getCom() <= 16) {
            hitCom();
        }
        getplayer();
        getCom();
        gameOver();
        FXGL.addUINode(text);
    }

    public static void reset() {
        FXGL.getGameScene().removeUINode(text);
        FXGL.getGameScene().clearGameViews();

        lists.clear();
        player.clear();
        computer.clear();
        back = false;
        comX = 50;
        comY = 100;
        comBackX = 0;
        playerX = 50;
        playerY = 500;
        playerHand = 0;
        comHand = 0;

        hasplayerAs = 0;
        hascomAs = 0;
        win = 5;
        handOpen = false;
        flag = 0;
        bet = 5;

        FXGL.getGameState().setValue("bet", bet);


    }

    public static int getplayer() {


        playerHand = 0;
        FXGL.getGameState().setValue("Player", 0);


        for (Integer s : player) {
            playerHand += s;

        }

        if (playerHand > 21) {
            if (hasplayerAs >= 1) {
                player.set(0, player.get(0) - 10);
                playerHand -= 10;
                hasplayerAs--;
            }
        }

        FXGL.getGameState().setValue("Player", playerHand);

        return playerHand;
    }

    public static void openBack() {
        handOpen = true;
        back = true;
        decksCom = new DecksCom(randomBack);
        card = fac.newCard(decksCom, comBackX, comY);
        card.setZ(3);
        lists.add(card);
        back = false;
    }

    public static int getCom() {


        if (comHand > 21) {
            if (hascomAs >= 1) {
                computer.set(0, computer.get(0) - 10);
                comHand -= 10;
                hascomAs--;
            }
        }
        comHand = 0;
        FXGL.getGameState().setValue("Com", 0);

        for (Integer s : computer) {
            comHand += s;

        }
        FXGL.getGameState().increment("Com", comHand);
        if (!handOpen) {
            FXGL.getGameState().setValue("ShowCom", cshow);
        } else {

            FXGL.getGameState().setValue("ShowCom", comHand);
        }

        return comHand;
    }

    public static void setBet(int i) {
        if (Dino.coins > bet) {
            bet += i;
            FXGL.getGameState().increment("bet", i);
        }
    }


}

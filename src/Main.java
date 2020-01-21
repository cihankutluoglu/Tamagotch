import com.almasb.fxgl.app.*;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Map;


public class Main extends GameApplication {

    Dino dino = new Dino();
    container c;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    protected void initSettings(GameSettings gameSettings) {

        gameSettings.setTitle("action");
        gameSettings.setHeight(700);
        gameSettings.setWidth(400);
        gameSettings.setCloseConfirmation(false);
        gameSettings.setIntroEnabled(false);
        gameSettings.setMenuEnabled(false);
        gameSettings.setFullScreenAllowed(false);
        gameSettings.setManualResizeEnabled(false);


    }

    @Override
    protected void initGame() {

        FXGL.getEngineTimer().runAtInterval(() -> {
            if (Dino.isOver()) {

                if (!RandomEvent.ayran)
                    RandomEvent.action.expire();
                if (!Snak.snake.isEmpty())
                    Snak.timerAction.expire();
                if (!RandomEvent.shit)
                    RandomEvent.pooptime.expire();
                if (Shop.counter == 1)
                    Shop.hehu.expire();
                container.scene = false;
                FXGL.getGameScene().setBackgroundColor(Color.WHITE);
                FXGL.getGameScene().clear();
                Dino.setFrame();
                container.creating(container.anim, 75, 150);
            }
        }, Duration.seconds(1));


    }

    @Override
    protected void initInput() {

        Input input = FXGL.getInput();

        try {
            input.addAction(new UserAction("hiii") {
                @Override
                protected void onActionBegin() {
                    if (!container.scene) {
                        if (container.aliG) {
                            container.player.getComponent(Character.class).onUpdate();
                        } else if (container.burakG) {
                            container.player.getComponent(Character.class).onUpdate(true);
                        } else if (container.ciyoG) {
                            container.player.getComponent(Character.class).onUpdate(1);
                        }
                    }
                }

                @Override
                protected void onActionEnd() {
                    if (!container.scene) {
                        if (container.aliG)
                            container.player.getComponent(Character.class).animate();
                        else if (container.burakG)
                            container.player.getComponent(Character.class).animate(true);
                        else if (container.ciyoG)
                            container.player.getComponent(Character.class).animate(1);
                    }
                }
            }, MouseButton.PRIMARY);

        } catch (
                IllegalArgumentException e) {
            System.out.println("hi");
        } catch (
                NullPointerException e) {
            System.out.println("hi null");
        }

        if (!Snak.gameOver) {
            input.addAction(new UserAction("left") {
                @Override
                protected void onActionBegin() {
                    if (Snak.direction != Snak.Direction.east) {
                        Snak.direction = Snak.Direction.west;
                    }
                }
            }, KeyCode.A);
            input.addAction(new UserAction("right") {
                @Override
                protected void onActionBegin() {
                    if (Snak.direction != Snak.Direction.west) {
                        Snak.direction = Snak.Direction.east;
                    }
                }
            }, KeyCode.D);
            input.addAction(new UserAction("up") {
                @Override
                protected void onActionBegin() {
                    if (Snak.direction != Snak.Direction.south) {
                        Snak.direction = Snak.Direction.north;
                    }
                }
            }, KeyCode.W);
            input.addAction(new UserAction("down") {
                @Override
                protected void onActionBegin() {
                    if (Snak.direction != Snak.Direction.north) {
                        Snak.direction = Snak.Direction.south;
                    }
                }
            }, KeyCode.S);


        }
        FXGL.onKeyDown(KeyCode.F, "Pause Timer", () ->

        {
            if (Snak.timerAction.isPaused())
                Snak.timerAction.resume();
            else
                Snak.timerAction.pause();
        });

        FXGL.onKeyDown(KeyCode.E, "Expire Timer", () ->

        {
            Snak.Coin=16;
            FXGL.getGameState().setValue("Coin",16);
            Snak.gameOver = true;
            Snak.timerAction.expire();
        });
        FXGL.onKeyDown(KeyCode.B, " For null", () ->

        {
                RandomEvent.ayran=true;
                RandomEvent.maan();
        });
    }


    @Override
    protected void initUI() {
        c = new container();
        FXGL.getGameScene().addUINode(c.MainMenu);


    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("health", dino.getHealth());
        vars.put("happiness", dino.getHappiness());
        vars.put("energy", dino.getEnergy());
        vars.put("fullness", dino.getFullness());
        vars.put("coins", dino.getCoins());
        vars.put("Coin", Snak.Coin);
        vars.put("Com", PlayBlack.comHand);
        vars.put("Player", PlayBlack.playerHand);
        vars.put("bet", PlayBlack.bet);
        vars.put("ShowCom", PlayBlack.cshow);
        vars.put("Day", Dino.Day);
    }


}






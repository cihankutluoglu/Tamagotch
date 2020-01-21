import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import com.almasb.fxgl.time.TimerAction;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.awt.dnd.DnDConstants;
import java.io.IOException;


public class RandomEvent {

    static Text text = new Text();
    static boolean ayran = false;
    static TimerAction action;
    static boolean Random = false;
    static boolean shit = false;
    static TimerAction pooptime;

    public static void maan() {
        try {
            ayran = true;

            Dino.energy /= 2;
            FXGL.getGameState().setValue("energy", Dino.energy);
            Dino.health /= 2;
            FXGL.getGameState().setValue("health", Dino.health);
            Dino.fullness /= 2;
            FXGL.getGameState().setValue("fullness", Dino.fullness);
            Dino.happiness /= 2;
            FXGL.getGameState().setValue("happiness", Dino.happiness);
            Dino.coins /= 2;
            FXGL.getGameState().setValue("coins", Dino.coins);
            try {
                Dino.saveState();
            } catch (IOException e) {
                e.printStackTrace();
            }
            animal();


        } catch (IllegalArgumentException e) {
            System.out.println("hi");
        }
    }

    public static void ridMaan() {
        ayran = false;
        Random = false;
        FXGL.getGameScene().removeUINode(text);
    }

    public static void random() {

        action = FXGL.getEngineTimer().runAtInterval(() -> {
            if (!Random && !ayran&&!Shop.goBed) {
                if (!container.scene) {
                    int random = 1;
                    int ran = FXGL.random(0, 60);
                    if (random == ran) {
                        Random = true;
                        action.pause();
                        maan();

                    }
                }
            }
        }, Duration.seconds(2));


    }

    public static void poop() throws InterruptedException {
        Texture poop = FXGL.getAssetLoader().loadTexture("poop.png", 64, 64);
        pooptime = FXGL.getEngineTimer().runAtInterval(() -> {
            if (!shit) {
                if (!container.scene) {
                    shit = true;
                    poop.setTranslateX(75);
                    poop.setTranslateY(325);
                    FXGL.addUINode(poop);
                    Dino.fullness -= 5;
                    FXGL.getGameState().increment("fullness", -5);
                    Dino.setFrame();
                    if (Dino.frameChange) {
                        container.creating(container.anim, 75, 150);
                        Dino.frameChange = false;
                    }

                    pooptime.pause();

                }
            }
        }, Duration.seconds(30));
        if (!Shop.goBed) {
            poop.setOnMouseClicked(mouseEvent -> {
                shit = false;
                Dino.happiness += 5;
                Dino.health += 2;
                FXGL.getGameState().increment("happiness", 5);
                FXGL.getGameState().increment("health", 2);
                FXGL.removeUINode(poop);
                Dino.setFrame();
                if (Dino.frameChange) {
                    container.creating(container.anim, 75, 150);
                    Dino.frameChange = false;
                }
                pooptime.resume();
            });
        }
    }


    public static void animal() {
        text.setText("Can Başladı Çürümeye...");
        text.setFont(new Font("", 30));
        text.setTranslateX(50);
        text.setTranslateY(425);
        text.setFill(Color.WHITE);
        if (container.player != null)
            container.player.removeFromWorld();
        Dino.setFrame();
        container.creating(container.anim, 75, 150);
        FXGL.getGameScene().addUINode(text);
    }

    public static void gameAttributes() {

        FXGL.getEngineTimer().runAtInterval(() -> {
            if (!container.scene && !Shop.goBed) {
                Dino.health -= 10;
                Dino.coins -= 10;
                Dino.fullness -= 10;
                Dino.happiness -= 10;
                Dino.energy -= 10;
                Dino.Day++;
                FXGL.getGameState().increment("health", -10);
                FXGL.getGameState().increment("coins", -10);
                FXGL.getGameState().increment("fullness", -10);
                FXGL.getGameState().increment("happiness", -10);
                FXGL.getGameState().increment("energy", -10);
                FXGL.getGameState().increment("Day", +1);

                Dino.setFrame();
                if (Dino.frameChange) {
                    container.creating(container.anim, 75, 150);
                    Dino.frameChange = false;
                }

            }
        }, Duration.seconds(60));

    }
}

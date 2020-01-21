
import com.almasb.fxgl.core.serialization.Bundle;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.saving.DataFile;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Dino {

    static boolean over = false;
    static boolean frameChange = false;
    static int coins = 250;
    static int happiness = 70;
    static int fullness = 70;
    static int energy = 70;
    static int health = 70;
    static int frame1 = 0;
    static int frame2 = 1;
    static int Day =1;

    public static void loadState() throws FileNotFoundException {

        File file = new File("C:\\Users\\burak kaya\\IdeaProjects\\Tamagotch\\src\\assets\\text\\file.txt");
        Scanner sc = new Scanner(file);
        String[] arr = new String[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLine();
        }

        happiness = Integer.parseInt(arr[0]);
        fullness = Integer.parseInt(arr[1]);
        health = Integer.parseInt(arr[2]);
        energy = Integer.parseInt(arr[3]);
        coins = Integer.parseInt(arr[4]);
        Day =Integer.parseInt(arr[5]);
        FXGL.getGameState().setValue("happiness", Integer.parseInt(arr[0]));
        FXGL.getGameState().setValue("fullness", Integer.parseInt(arr[1]));
        FXGL.getGameState().setValue("health", Integer.parseInt(arr[2]));
        FXGL.getGameState().setValue("energy", Integer.parseInt(arr[3]));
        FXGL.getGameState().setValue("coins", Integer.parseInt(arr[4]));
        FXGL.getGameState().setValue("Day", Integer.parseInt(arr[5]));
        if (arr[6].equals("true")) {
            container.aliG = true;
        }
        if (arr[7].equals("true")) {
            container.burakG = true;
        }
        if (arr[8].equals("true")) {
            container.ciyoG = true;
        }
        if (arr[9].equals("true")) {
            RandomEvent.ayran = true;
        }
        if (RandomEvent.ayran){
            RandomEvent.animal();
        }
    }

    public static void saveState() throws IOException {

        File file = new File("C:\\Users\\burak kaya\\IdeaProjects\\Tamagotch\\src\\assets\\text\\file.txt");

        PrintWriter writer = new PrintWriter(new FileWriter(file, false));

        writer.write(Integer.toString(happiness));
        writer.println();
        writer.write(Integer.toString(fullness));
        writer.println();
        writer.write(Integer.toString(health));
        writer.println();
        writer.write(Integer.toString(energy));
        writer.println();
        writer.write(Integer.toString(coins));
        writer.println();
        writer.write(Integer.toString(Day));
        writer.println();
        if (container.aliG) {
            writer.write(("true"));
            writer.println();
        } else {

            writer.write(("false"));
            writer.println();
        }
        if (container.burakG) {
            writer.write("true");
            writer.println();
        } else {
            writer.write(("false"));
            writer.println();
        }
        if (container.ciyoG) {
            writer.write("true");
            writer.println();
        } else {
            writer.write(("false"));
            writer.println();
        }
        if (RandomEvent.ayran) {
            writer.write("true");
            writer.println();
        } else {
            writer.write(("false"));
            writer.println();
        }
        writer.close();
    }

    public void texts() {
        Group root = new Group();


        Text health = new Text();
        health.setFill(Color.WHITE);

        health.setFont(new Font(18));
        health.setTranslateX(220);
        health.setTranslateY(30);

        Text hptext = new Text("HP");
        hptext.setFill(Color.WHITE);

        hptext.setFont(new Font(18));
        hptext.setTranslateX(190);
        hptext.setTranslateY(30);

        Text coins = new Text();
        coins.setFill(Color.WHITE);
        coins.setFont(new Font(18));
        coins.setTranslateX(340);
        coins.setTranslateY(30);

        Text coinstext = new Text("Coin");
        coinstext.setFill(Color.WHITE);
        coinstext.setFont(new Font(18));
        coinstext.setTranslateX(295);
        coinstext.setTranslateY(30);


        Text happiness = new Text();
        happiness.setFill(Color.WHITE);
        happiness.setFont(new Font(18));
        happiness.setTranslateX(120);
        happiness.setTranslateY(30);

        Text happytext = new Text("Happiness");
        happytext.setFont(new Font(18));
        happytext.setFill(Color.WHITE);
        happytext.setTranslateY(30);
        happytext.setTranslateX(30);

        Text energy = new Text();
        energy.setFill(Color.WHITE);
        energy.setFont(new Font(18));
        energy.setTranslateX(160);
        energy.setTranslateY(60);

        Text energytext = new Text("Energy");
        energytext.setFont(new Font(18));
        energytext.setFill(Color.WHITE);
        energytext.setTranslateY(60);
        energytext.setTranslateX(100);

        Text fullness = new Text();
        fullness.setFill(Color.WHITE);
        fullness.setFont(new Font(18));
        fullness.setTranslateX(320);
        fullness.setTranslateY(60);

        Text fullnesstext = new Text("Fullness");
        fullnesstext.setFill(Color.WHITE);
        fullnesstext.setFont(new Font(18));
        fullnesstext.setTranslateY(60);
        fullnesstext.setTranslateX(250);

        Text day = new Text();
        day.setFill(Color.WHITE);
        day.setFont(new Font(18));
        day.setTranslateX(50);
        day.setTranslateY(90);

        Text dayText = new Text("Day ");
        dayText.setFill(Color.WHITE);
        dayText.setFont(new Font(18));
        dayText.setTranslateY(90);
        dayText.setTranslateX(15);

        root.getChildren().addAll(health, hptext, coins, coinstext, happiness, happytext, energy, energytext, fullness, fullnesstext,day,dayText);

        day.textProperty().bind(FXGL.getGameState().intProperty("Day").asString());

        health.textProperty().bind(FXGL.getGameState().intProperty("health").asString());

        coins.textProperty().bind(FXGL.getGameState().intProperty("coins").asString());

        happiness.textProperty().bind(FXGL.getGameState().intProperty("happiness").asString());

        energy.textProperty().bind(FXGL.getGameState().intProperty("energy").asString());

        fullness.textProperty().bind(FXGL.getGameState().intProperty("fullness").asString());

        FXGL.getGameScene().addUINode(root);


    }

    public Dino() {

    }

    public int getCoins() {
        return coins;
    }


    public int getHappiness() {
        return happiness;
    }


    public int setHappiness(int amount) {
        return happiness + amount;
    }


    public int setFullness(int amount) {
        return happiness + amount;
    }


    public int getFullness() {
        return fullness;
    }


    public int setEnergy(int amount) {
        return happiness + amount;
    }


    public int getEnergy() {
        return energy;
    }


    public int setHealth(int amount) {
        return happiness + amount;
    }

    public int getHealth() {
        return health;
    }

    public static boolean isOver() {
        if (energy <= 0) {
            over = true;
            Text dead = new Text("GAME OVER");
            dead.setFont(new Font("",50));
            dead.setTranslateX(75);
            dead.setTranslateY(500);
            dead.setFill(Color.RED);

            FXGL.getGameScene().addUINode(dead);
        }
        if (happiness <= 0) {
            over = true;
            Text dead = new Text("GAME OVER");
            dead.setFont(new Font("",50));
            dead.setTranslateX(75);
            dead.setTranslateY(500);
            dead.setFill(Color.RED);

            FXGL.getGameScene().addUINode(dead);
        }
        if (health <= 0) {
            over = true;
            Text dead = new Text("GAME OVER");
            dead.setFont(new Font("",50));
            dead.setTranslateX(75);
            dead.setTranslateY(500);
            dead.setFill(Color.RED);

            FXGL.getGameScene().addUINode(dead);
        }
        if (fullness <= 0) {
            over = true;
            Text dead = new Text("GAME OVER");
            dead.setFont(new Font("",50));
            dead.setTranslateX(75);
            dead.setTranslateY(500);
            dead.setFill(Color.RED);

            FXGL.getGameScene().addUINode(dead);
        }

        return over;
    }

    public static void setFrame() {
        if (isOver()) {
            frame1 = 4;
            frame2 = 4;
            frameChange = true;
            container.anim =false;
        } else if (RandomEvent.ayran) {
            frame1 = 10;
            frame2 = 11;
            frameChange = true;
            container.anim =true;
            Shop.goBed=false;
        } else if (Shop.goBed) {
            frame1 = 6;
            frame2 = 6;
            frameChange = true;
            container.anim =false;
        } else if (happiness > 40 && health > 40 && energy > 40 && fullness > 40) {
            if (happiness >= 90 && health >= 90 && energy >= 90 && fullness >= 90) {
                frame1 = 2;
                frame2 = 2;

            }else {
                frame1 = 0;
                frame2 = 1;
            }
            container.anim =false;
            frameChange = true;
        }  else if (health <= 40) {
            if (happiness <= 40) {
                frame1 = 8;
                frame2 = 9;
                container.anim =true;
            } else {
                frame1 = 7;
                frame2 = 7;
                container.anim =false;
            }
            frameChange = true;
        } else if (energy <= 40) {
            frame1 = 5;
            frame2 = 5;
            frameChange = true;
            container.anim =false;
        } else if (happiness <= 40) {
            frame1 = 3;
            frame2 = 3;
            frameChange = true;
            container.anim =false;
        } else if (fullness < 40) {
            frame1 = 3;
            frame2 = 3;
            frameChange = true;
            container.anim =false;
        }



    }
}

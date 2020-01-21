import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.util.Duration;


public class Character extends Component {
    AnimatedTexture texture;
    AnimationChannel animIdle, animStop, animIdle1, animIdle2, animStop1, animStop2;

    public Character(boolean anim, int start, int end, boolean scene) {
        if (scene) {
            animIdle = new AnimationChannel(FXGL.image("ali2.png"), 12, 150, 150, Duration.millis(400), start, end);
            animStop = new AnimationChannel(FXGL.image("ali2.png"), 12, 150, 150, Duration.millis(400), start, start);
            texture = new AnimatedTexture(animStop);

        } else if (!anim) {
            animIdle = new AnimationChannel(FXGL.image("aliframes.png"), 12, 275, 275, Duration.millis(400), start, end);
            animStop = new AnimationChannel(FXGL.image("aliframes.png"), 12, 275, 275, Duration.millis(400), start, start);
            texture = new AnimatedTexture(animStop);
        } else {
            animIdle = new AnimationChannel(FXGL.image("aliframes.png"), 12, 275, 275, Duration.millis(400), start, end);
            animStop = new AnimationChannel(FXGL.image("aliframes.png"), 12, 275, 275, Duration.millis(400), start, end);
            texture = new AnimatedTexture(animStop);
        }
    }


    public Character(boolean burak, boolean anim, int start, int end, boolean scene) {
        if (scene) {
            animIdle1 = new AnimationChannel(FXGL.image("burakSnake.png"), 12, 150, 150, Duration.millis(400), start, end);
            animStop1 = new AnimationChannel(FXGL.image("burakSnake.png"), 12, 150, 150, Duration.millis(400), start, start);
            texture = new AnimatedTexture(animStop1);
        } else if (!anim) {
            animIdle1 = new AnimationChannel(FXGL.image("burakframe2.png"), 12, 275, 275, Duration.millis(400), start, end);
            animStop1 = new AnimationChannel(FXGL.image("burakframe2.png"), 12, 275, 275, Duration.millis(400), start, start);
            texture = new AnimatedTexture(animStop1);
        } else {
            animIdle1 = new AnimationChannel(FXGL.image("burakframe2.png"), 12, 275, 275, Duration.millis(400), start, end);
            animStop1 = new AnimationChannel(FXGL.image("burakframe2.png"), 12, 275, 275, Duration.millis(400), start, end);
            texture = new AnimatedTexture(animStop1);
        }


    }

    public Character(int a, boolean anim, int start, int end, boolean scene) {
        if (scene) {
            animIdle2 = new AnimationChannel(FXGL.image("ciyoSnake.png"), 12, 150, 150, Duration.millis(400), start, end);
            animStop2 = new AnimationChannel(FXGL.image("ciyoSnake.png"), 12, 150, 150, Duration.millis(400), start, start);
            texture = new AnimatedTexture(animStop2);
        } else if (!anim) {
            animIdle2 = new AnimationChannel(FXGL.image("ciyo.png"), 12, 275, 275, Duration.millis(400), start, end);
            animStop2 = new AnimationChannel(FXGL.image("ciyo.png"), 12, 275, 275, Duration.millis(400), start, start);
            texture = new AnimatedTexture(animStop2);
        } else {
            animIdle2 = new AnimationChannel(FXGL.image("ciyo.png"), 12, 275, 275, Duration.millis(400), start, end);
            animStop2 = new AnimationChannel(FXGL.image("ciyo.png"), 12, 275, 275, Duration.millis(400), start, end);
            texture = new AnimatedTexture(animStop2);
        }
    }


    @Override
    public void onAdded() {
        entity.getTransformComponent().setScaleOrigin(new Point2D(16, 21));
        entity.getViewComponent().addChild(texture);
    }


    public void onUpdate() {
        texture.loopAnimationChannel(animIdle);
    }//ali

    public void onUpdate(boolean snake) {
        texture.loopAnimationChannel(animIdle1);
    }//burak

    public void onUpdate(int a) {
        texture.loopAnimationChannel(animIdle2);
    }//ciyo


    public void animate() {
        texture.loopAnimationChannel(animStop);
    }//ali

    public void animate(boolean snake) {
        texture.loopAnimationChannel(animStop1);
    }//burak

    public void animate(int a) {
        texture.loopAnimationChannel(animStop2);
    }//ciyo


}
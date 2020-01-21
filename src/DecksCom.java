import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.util.Duration;

public class DecksCom extends Component {
    AnimationChannel cart;
    AnimatedTexture texture;

    public DecksCom(int random){
        if (random<=12)
            cart = new AnimationChannel(FXGL.image("card1.png"), 13, 94, 132, Duration.seconds(1), random, random);
        if (random >=13&&random<=25)
            cart = new AnimationChannel(FXGL.image("card2.png"), 13, 94, 132, Duration.seconds(1), random-13, random-13);
        if (random >=26&&random<=38)
            cart = new AnimationChannel(FXGL.image("card3.png"), 13, 94, 132, Duration.seconds(1), random - 26, random - 26);
        if (random >=39&&random<=51)
            cart = new AnimationChannel(FXGL.image("card4.png"), 13, 94, 132, Duration.seconds(1), random - 39, random - 39);
        assert cart != null;
        texture = new AnimatedTexture(cart);
    }

    public DecksCom(boolean back) {
        cart = new AnimationChannel(FXGL.image("cardback.png"), 13, 94, 132, Duration.seconds(1), 0, 0);
        texture = new AnimatedTexture(cart);
    }

    @Override
    public void onAdded() {
        entity.getTransformComponent().setScaleOrigin(new Point2D(16, 21));
        entity.getViewComponent().addChild(texture);

    }


}

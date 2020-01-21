import com.almasb.fxgl.dsl.AnimationBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;




public class MyEntityFactory implements EntityFactory {
    static Entity food;
    static AnimationBuilder anim=new AnimationBuilder() ;
    public static Entity newChar( Component component,int x,int y){
        return FXGL.entityBuilder()
                .at(x,y)
                .with(component)
                .buildAndAttach();
    }
    public static void newBackround(){
        Texture space = FXGL.getAssetLoader().loadTexture("space.jpg", 400,700);
        Entity backround =FXGL.entityBuilder().view(space).buildAndAttach();
        backround.setZ(-1);
    }
    public static Entity newCell( int x, int y){
        Rectangle rec =newRec(20,20,Color.RED);
        return FXGL.entityBuilder()
                .at(x,y)
                .view(rec)
                .buildAndAttach();
    }

    public static Rectangle newRec(int width, int height, Color color) {
        Rectangle rec =new Rectangle(width, height,color);
        rec.setStroke(Color.BLACK);
        return rec;
    }

    public static void newFood(int ranx, int rany, Color color) {
        Rectangle rec =new Rectangle(20,20,color);
         food=FXGL.entityBuilder()
                .at(ranx,rany)
                .view(rec)
                .buildAndAttach();
    }
    public static void removeFood(){
        food.removeFromWorld();
    }

    public static Entity newCard(Component component,int x, int y) {

        Entity e =FXGL.entityBuilder()
                .at(new Point2D(x,y))
                .viewWithBBox(newRec(98,134,Color.BLACK))
                .with(component)
                .rotate(14)
                .buildAndAttach();
        if (!PlayBlack.back) {
            anim.translate(e).from(new Point2D(100, 0)).to(new Point2D(x, y)).buildAndPlay();

        }

         return e;
    }

}

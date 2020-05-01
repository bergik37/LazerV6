
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Laser extends BaseActor {


    public Laser(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("assets/Line11.png");
        //Actions.sizeBy(400,600);

        setSize(30,10);
        //Actions.sizeBy(400,600);
        setMaxSpeed(800);
        setBoundaryPolygon(8);
        setSpeed(10);

    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
        //setSpeed(30);
        //moveLine(2);
       // boundToWorld();
        //wrapAroundWorld();

    }

}
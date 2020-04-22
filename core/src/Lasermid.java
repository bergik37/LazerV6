import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Lasermid extends BaseActor {
    public Vector2 position = new Vector2();


    public Lasermid(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("assets/Line111.png");


        setSize(30, 10);



    }
    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
        //setSpeed(0);
        //setSize(30*dt, 10);


    }
}

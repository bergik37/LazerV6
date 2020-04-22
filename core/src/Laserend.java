import com.badlogic.gdx.scenes.scene2d.Stage;

public class Laserend extends BaseActor {
    public Laserend(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("assets/Line1111.png");
        setSize(30, 10);
        //setBoundaryPolygon(8);
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

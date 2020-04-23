import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;


public class LevelScreen extends BaseScreen {
    private Label messageLabel;
    private Triangle triangle;
    private Quad quad;
    private Laser laser;
    private Lasermid lasermid;
    private Laserend laserend;

    @Override
    public void initialize() {
        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("assets/background.jpg");
        int numberRows = 8;
        int numberCols = 8;

        Texture texture = new Texture(Gdx.files.internal("assets/sun.jpg"), true);

        triangle = new Triangle(20, 20, mainStage);
        quad = new Quad(20, 100, mainStage);

        int imageWidth = texture.getWidth();
        int imageHeight = texture.getHeight();
        int pieceWidth = imageWidth / numberCols;
        int pieceHeight = imageHeight / numberRows;

        for (int r = 0; r < numberRows; r++) {
            for (int c = 0; c < numberCols; c++) {
                int marginX = (400 - imageWidth) / 2;
                int marginY = (600 - imageHeight) / 2;
                int areaX = (400 + marginX) + pieceWidth * c;
                int areaY = (600 - marginY - pieceHeight) - pieceHeight * r;
                PuzzleArea pa = new PuzzleArea(areaX, areaY, mainStage);
                pa.setSize(pieceWidth, pieceHeight);
                pa.setBoundaryRectangle();
                pa.setRow(r);
                pa.setCol(c);
            }
        }


        laser = new Laser(455, 200, mainStage);


        //  lasermid=new Lasermid(455,200,mainStage);
        //  laserend=new Laserend(455,200,mainStage);




        /*messageLabel = new Label("...", BaseGame.labelStyle);
        messageLabel.setColor( Color.CYAN );
        uiTable.add(messageLabel).expandX().expandY().bottom().pad(50);
        messageLabel.setVisible(false);*/
    }

    @Override
    public void update(float dt) {
        //laser.setSize(distance,laser.getHeight());
        // lasermid.setSize(distance,laserend.getHeight());
        //lasermid.getPosition(distance,laserend.getHeight());

        int x = 1;
        int y = 0;

        //laser.setSpeed(10);

        //System.out.println(x);



        for (BaseActor quadActor : BaseActor.getList(mainStage, "Quad")) {
            Quad quad = (Quad) quadActor;
            //if (laserend.overlaps(quad) && !quad.collected)
            if (laser.overlaps(quad) && x > 0 && y == 0) {
                //laser.addAction(Actions.removeAction(Actions.rotateBy(90)));
                //laser.addAction(Actions.rotateBy(90));
                laser.setPosition(laser.getX(), laser.getY());
                //if (laser.getSpeed() > 0){
                x = 0;
                y = 1;
               // laser.getSpeed();
                laser.getSpeedY();
                System.out.println("X1 = "+x);
                System.out.println("Y1 = "+y);
            }
            else if (laser.overlaps(quad) && x == 0 && y > 0) {
                //laser.addAction(Actions.removeAction(Actions.rotateBy(90)));
                //laser.addAction(Actions.rotateBy(90));
                laser.setPosition(laser.getX(), laser.getY());
                //if (laser.getSpeed() > 0){
                x = -1;
                y = 0;
                laser.setSpeed(0);
                laser.setSpeedY(0);

                System.out.println("X2 = "+x);
                System.out.println("Y2 = "+y);

                //laser.setSpeedY(30);
                //laser.addAction(Actions.rotateBy(90));
                // laser.addAction(Actions.removeAction(Actions.rotateBy(90)));
                // } else if (laser.getSpeed() > 0) {
                //laser.setSpeedY(30);
                // laser.addAction(Actions.rotateBy(90));
                //laser.addAction(Actions.removeAction(Actions.rotateBy(90)));
                // }

                // quad.collected = true;
                //lasermid.addAction(Actions.rotateBy(90));
                // laser.addAction(Actions.rotateBy(90));
                // laser.addAction(Actions.removeAction(Actions   .rotateBy(90)));

                //laserend.addAction(Actions.moveBy(0,30));
                // laser.setMotionAngle(90);
                // laser.setSpeed(30);
   /*             laser.setPosition(laserend.getX()+laserend.getWidth()+laserend.getHeight(),laserend.getY());
                laser.setPosition(quad.getX(),quad.getY());
                laser.addAction(Actions.rotateBy(90));
                laser.setMotionAngle(90);
                laser.setSize(lasermid.getWidth(),lasermid.getHeight());
*/
            }
        }
    }
}





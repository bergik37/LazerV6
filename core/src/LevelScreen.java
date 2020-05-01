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

    float x =1;
    float y=0;
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

        for (BaseActor quadActor : BaseActor.getList(mainStage, "Quad")) {
            Quad quad = (Quad) quadActor;
            if (laser.overlaps(quad) && x > 0 && y == 0) {
                laser.addAction(Actions.rotateBy(90));
                laser.setMotionAngle(90);
                x = 0;
                y = 1;
            }
            else if (laser.overlaps(quad) && x == 0 && y > 0) {

                laser.addAction(Actions.rotateBy(90));
                laser.setMotionAngle(180);
                x = -1;
                y = 0;
            }
                else if (laser.overlaps(quad) && x < 0 && y == 0) {
                    laser.addAction(Actions.rotateBy(90));
                    laser.setMotionAngle(270);
                    x = 1;
                    y = -1;
            }
            else if (laser.overlaps(quad) && x > 0 && y <0) {
                laser.addAction(Actions.rotateBy(90));
                laser.setMotionAngle(360);
                x = 1;
                y = 0;

            }
        }
    }
}





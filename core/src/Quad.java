import com.badlogic.gdx.scenes.scene2d.Stage;

public class Quad extends DragAndDropActor {

    public boolean collected;
    private PuzzleArea puzzleArea;
    private int row;
    private int col;
    public Quad(float x, float y, Stage s)
    {
        super(x,y,s);
        loadTexture("assets/quad.png");
        setSize(30,30);
        setBoundaryPolygon(8);
    }
    public void setRow(int r)
    { row = r; }
    public void setCol(int c)
    { col = c; }
    public int getRow()
    { return row; }
    public int getCol()
    { return col; }
    public void setPuzzleArea(PuzzleArea pa)
    { puzzleArea = pa; }
    public PuzzleArea getPuzzleArea()
    { return puzzleArea; }
    public void clearPuzzleArea()
    { puzzleArea = null; }
    public boolean hasPuzzleArea()
    { return puzzleArea != null; }

    public boolean isCorrectlyPlaced()
    {
        return hasPuzzleArea()
                && this.getRow() == puzzleArea.getRow()
                && this.getCol() == puzzleArea.getCol();
    }
    public void onDragStart()
    {
        if ( hasPuzzleArea() )
        {
            PuzzleArea pa = getPuzzleArea();
            pa.setTargetable(true);
            clearPuzzleArea();
        }
    }
    public void onDrop()
    {
        if ( hasDropTarget() )
        {
            PuzzleArea pa = (PuzzleArea)getDropTarget();
            moveToActor(pa);
            setPuzzleArea(pa);
            pa.setTargetable(false);
        }
    }
}

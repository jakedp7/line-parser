package utility;

/**
 * Created by Jacob on 8/29/2015.
 */
public class FieldBounds {

    private int startPos;
    private int endPos;

    public FieldBounds(int startPos, int endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }
}

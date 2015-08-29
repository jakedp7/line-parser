import junit.framework.TestCase;
import org.junit.Test;
import utility.FieldBounds;

import static org.junit.Assert.*;

/**
 * Created by Jacob on 8/29/2015.
 */
public class FieldBoundsTest extends TestCase {

    @Test
    public void testGetStartPos() throws Exception {
        FieldBounds fieldBounds = new FieldBounds(1, 5);
        assertEquals(fieldBounds.getStartPos(), 1);
    }

    @Test
    public void testSetStartPos() throws Exception {
        FieldBounds fieldBounds = new FieldBounds(0, 5);
        fieldBounds.setStartPos(1);
        assertEquals(fieldBounds.getStartPos(), 1);
    }

    @Test
    public void testGetEndPos() throws Exception {
        FieldBounds fieldBounds = new FieldBounds(1, 5);
        assertEquals(fieldBounds.getEndPos(), 5);
    }

    @Test
    public void testSetEndPos() throws Exception {
        FieldBounds fieldBounds = new FieldBounds(1, 0);
        fieldBounds.setEndPos(5);
        assertEquals(fieldBounds.getEndPos(), 5);
    }
}
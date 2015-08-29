package tests;

import junit.framework.TestCase;
import org.junit.Test;
import utility.FieldBounds;
import utility.LineFormat;

import static org.junit.Assert.*;

/**
 * Created by Jacob on 8/29/2015.
 */
public class LineFormatTest extends TestCase {

    @Test
    public void testEntryMethods() throws Exception {

        //Create and populate an object object
        LineFormat lineFormat = new LineFormat();
        lineFormat.addEntry("domicile", new FieldBounds(1,5));
        lineFormat.addEntry("tripNumber", new FieldBounds(6, 10));
        lineFormat.addEntry("startDate", new FieldBounds(11, 19));
        lineFormat.addEntry("associatedLine", new FieldBounds(20, 23));
        lineFormat.addEntry("tripCountInLine", new FieldBounds(24, 26));

        //Test for correct bounds in entries
        assertEquals("addEntry/getEntryIndices failed - start index",
                lineFormat.getEntryIndices("domicile").getStartPos(), 1);
        assertEquals("addEntry/getEntryIndices failed - end index",
                lineFormat.getEntryIndices("tripCountInLine").getEndPos(), 26);

        //Test entry removal
        lineFormat.removeEntry("tripCountInLine");
        assertNull("removeEntry failed",
                lineFormat.getEntryIndices("tripCountInLine"));

    }
}
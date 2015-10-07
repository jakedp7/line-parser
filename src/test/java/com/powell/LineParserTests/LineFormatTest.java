package com.powell.LineParserTests;

import com.powell.FixedWidthLineParser.utility.FieldFormat;
import com.powell.FixedWidthLineParser.utility.LineFormat;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Jacob on 8/29/2015.
 */
public class LineFormatTest extends TestCase {

    @Test
    public void testFormatEntryMethods() throws Exception {

        //Create and populate an object object
        LineFormat lineFormat = new LineFormat();
        lineFormat.addEntry(new FieldFormat("domicile", 1,5));
        lineFormat.addEntry(new FieldFormat("tripNumber", 6, 10));
        lineFormat.addEntry(new FieldFormat("startDate", 11, 19));
        lineFormat.addEntry(new FieldFormat("associatedLine", 20, 23));
        lineFormat.addEntry(new FieldFormat("tripCountInLine", 24, 26));

        //Test for correct bounds in entries
        assertEquals("addEntry/getEntryIndices failed - start index",
                lineFormat.getEntry("domicile").getStartPos(), 1);
        assertEquals("addEntry/getEntryIndices failed - end index",
                lineFormat.getEntry("tripCountInLine").getEndPos(), 26);

        //Test entry removal
        lineFormat.removeEntry("tripCountInLine");
        assertNull("removeEntry failed",
                lineFormat.getEntry("tripCountInLine"));

    }
}
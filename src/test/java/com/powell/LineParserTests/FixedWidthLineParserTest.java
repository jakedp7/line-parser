package com.powell.LineParserTests;

import com.powell.FixedWidthLineParser.utility.FieldBounds;
import com.powell.FixedWidthLineParser.utility.LineFormat;
import junit.framework.TestCase;
import com.powell.FixedWidthLineParser.FixedWidthLineParser;
import org.junit.Test;

/**
 * Created by Jacob on 8/29/2015.
 */
public class FixedWidthLineParserTest extends TestCase {

    @Test
    public void testAnnotationReader() throws Exception {

        //Create a correct LineFormat to test against
        LineFormat expectedLineFormat = new LineFormat();
        expectedLineFormat.addEntry("domicile", new FieldBounds(1, 5));
        expectedLineFormat.addEntry("tripNumber", new FieldBounds(6, 10));
        expectedLineFormat.addEntry("startDate", new FieldBounds(11, 19));
        expectedLineFormat.addEntry("associatedLine", new FieldBounds(20, 23));
        expectedLineFormat.addEntry("tripCountInLine", new FieldBounds(24, 26));

        //Parse the class into a fixed width parser, then save the generated LineFormat
        FixedWidthLineParser parser = new FixedWidthLineParser(TripOccurrence.class);
        LineFormat actualLineFormat = parser.getLineFormat();

        assertEquals(expectedLineFormat, actualLineFormat);
    }

    @Test
    public void testParseLine() throws Exception {

    }
}
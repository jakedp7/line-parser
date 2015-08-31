package com.powell.LineParserTests;

import com.powell.FixedWidthLineParser.utility.FieldFormat;
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
        expectedLineFormat.addEntry(new FieldFormat("domicile", 1, 5));
        expectedLineFormat.addEntry(new FieldFormat("tripNumber", 6, 10));
        expectedLineFormat.addEntry(new FieldFormat("startDate", 11, 19));
        expectedLineFormat.addEntry(new FieldFormat("associatedLine", 20, 23));
        expectedLineFormat.addEntry(new FieldFormat("tripCountInLine", 24, 26));

        //Parse the class into a fixed width parser, then save the generated LineFormat
        FixedWidthLineParser parser = new FixedWidthLineParser(TripOccurrence.class);
        LineFormat actualLineFormat = parser.getLineFormat();

        assertEquals(expectedLineFormat, actualLineFormat);
    }

    @Test
    public void testParseLine() throws Exception {

    }
}
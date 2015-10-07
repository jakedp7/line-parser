package com.powell.LineParserTests;

import com.powell.FixedWidthLineParser.FixedWidthLineParser;
import com.powell.FixedWidthLineParser.utility.FieldFormat;
import com.powell.FixedWidthLineParser.utility.LineFormat;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

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
        expectedLineFormat.addEntry(new FieldFormat("tripCountInLine", 24, true));

        //Parse the class into a fixed width parser, then save the generated LineFormat
        FixedWidthLineParser parser = new FixedWidthLineParser(TripOccurrence.class);
        LineFormat actualLineFormat = parser.getLineFormat();

        assertEquals(expectedLineFormat, actualLineFormat);
    }

    @Test
    public void testParseLine() throws Exception {
        final String testLineToParse =
                "SDF  0001 20150915 20151027 06:10 02:10 006:00 004:10 02 008:11 0 Y M";

        TripSummary expectedParsedObject = new TripSummary();
        expectedParsedObject.setDomicile("SDF");
        expectedParsedObject.setTripNumber(1);
        expectedParsedObject.setEffecStartDate("20150915");
        expectedParsedObject.setEffecEndDate("20151027");
        expectedParsedObject.setUtcReportTime("06:10");
        expectedParsedObject.setLocalReportTime("02:10");
        expectedParsedObject.setCreditHours("006:00");
        expectedParsedObject.setBlockHours("004:10");
        expectedParsedObject.setLandings(2);
        expectedParsedObject.setTimeAwayFromBase("008:11");

        FixedWidthLineParser lineParser =  new FixedWidthLineParser(TripSummary.class);
        TripSummary actualParsedObject = lineParser.parse(testLineToParse);

        assertEquals("Line parsing failed", expectedParsedObject, actualParsedObject);
    }

    @Test
    public void testFileParse() throws Exception {

        BufferedReader fileReader = new BufferedReader(
                new FileReader("src/test/resources/TripSummaries.txt"));

        FixedWidthLineParser lineParser =  new FixedWidthLineParser(TripSummary.class);

        ArrayList<TripSummary> parsedObjects = new ArrayList();

        while(fileReader.ready()) {
            String currentLine = fileReader.readLine();
            if(currentLine.length() > 1) {
                parsedObjects.add(lineParser.parse(currentLine));
            }
        }

        assertEquals("File parsing failed", parsedObjects.size(), 20);
    }
}
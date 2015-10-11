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

        final String tripOccurrenceTestLineToParse =
                "SDF  0001 20151020 002 15";

        TripOccurrence expectedParsedTripOccurrence = new TripOccurrence();
        expectedParsedTripOccurrence.setDomicile("SDF");
        expectedParsedTripOccurrence.setTripNumber(1);
        expectedParsedTripOccurrence.setStartDate("20151020");
        expectedParsedTripOccurrence.setAssociatedLine(2);
        expectedParsedTripOccurrence.setTripCountInLine(15);

        FixedWidthLineParser tripOccurrenceLineParser =  new FixedWidthLineParser(TripOccurrence.class);
        TripOccurrence actualParsedTripOccurrence = tripOccurrenceLineParser.parse(tripOccurrenceTestLineToParse);

        assertEquals("Line parsing failed", expectedParsedTripOccurrence, actualParsedTripOccurrence);


        
        final String tripSummaryTestLineToParse =
                "SDF  0001 20150915 20151027 06:10 02:10 006:00 004:10 02 008:11 0 Y M";

        TripSummary expectedParsedTripSummary = new TripSummary();
        expectedParsedTripSummary.setDomicile("SDF");
        expectedParsedTripSummary.setTripNumber(1);
        expectedParsedTripSummary.setEffecStartDate("20150915");
        expectedParsedTripSummary.setEffecEndDate("20151027");
        expectedParsedTripSummary.setUtcReportTime("06:10");
        expectedParsedTripSummary.setLocalReportTime("02:10");
        expectedParsedTripSummary.setCreditHours("006:00");
        expectedParsedTripSummary.setBlockHours("004:10");
        expectedParsedTripSummary.setLandings(2);
        expectedParsedTripSummary.setTimeAwayFromBase("008:11");

        FixedWidthLineParser tripSummaryLineParser =  new FixedWidthLineParser(TripSummary.class);
        TripSummary actualParsedTripSummary = tripSummaryLineParser.parse(tripSummaryTestLineToParse);

        assertEquals("Line parsing failed", expectedParsedTripSummary, actualParsedTripSummary);
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
package com.powell.LineParserTests;

import junit.framework.TestCase;
import com.powell.FixedWidthLineParser.FixedWidthLineParser;
import org.junit.Test;

/**
 * Created by Jacob on 8/29/2015.
 */
public class FixedWidthLineParserTest extends TestCase {

    @Test
    public void testAnnotationReader() throws Exception {
        FixedWidthLineParser parser = new FixedWidthLineParser(TripOccurrence.class);
    }

    @Test
    public void testParseLine() throws Exception {

    }
}
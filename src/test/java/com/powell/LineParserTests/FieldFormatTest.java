package com.powell.LineParserTests;

import com.powell.FixedWidthLineParser.utility.FieldFormat;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Jacob on 8/30/2015.
 */
public class FieldFormatTest extends TestCase {

    @Test
    public void testGettersAndSetters() throws Exception {
        FieldFormat fieldFormat = new FieldFormat();

        fieldFormat.setName("domicile");
        fieldFormat.setStartPos(1);
        fieldFormat.setEndPos(5);
        fieldFormat.setEndAtEol(true);

        assertEquals("domicile", fieldFormat.getName());
        assertEquals(1, fieldFormat.getStartPos());
        assertEquals(5, fieldFormat.getEndPos());
        assertEquals(true, fieldFormat.getEndAtEol());
    }
}
package com.powell.LineParserTests;

import com.powell.FixedWidthLineParser.utility.FieldFormat;
import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

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

        assertEquals("domicile", fieldFormat.getName());
        assertEquals(1, fieldFormat.getStartPos());
        assertEquals(5, fieldFormat.getEndPos());
    }
}
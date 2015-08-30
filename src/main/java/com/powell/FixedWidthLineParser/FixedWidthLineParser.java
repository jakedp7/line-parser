package com.powell.FixedWidthLineParser;

import com.powell.FixedWidthLineParser.utility.FieldBounds;
import com.powell.FixedWidthLineParser.utility.LineFormat;

import java.lang.reflect.Field;

/**
 * Created by Jacob on 8/28/2015.
 */
public class FixedWidthLineParser {

    /**
     * javaBean annotated with each member's position in the
     * fixed-width line format - parsed lines will be output
     * as an object from this class, and the class'
     * annotations define how to parse each line.
     */
    protected Class javaBean;

    /**
     * com.powell.FixedWidthLineParser.LineFormatdthLineParser.utility.LineFormat stores names and positions of fields in a
     * fixed-width line of data.
     */
    private LineFormat lineFormat;

    public FixedWidthLineParser(Class javaBean) {

        //Store the input bean into the new object
        this.javaBean = javaBean;

        //Extract lineFormat from annotations in the bean through com.powell.FixedWidthLineParser.LineFormatdthLineParser.utility.LineFormat
        this.lineFormat = lineFormatFromAnnotations(javaBean);
    }

    public Object parseLine(String line) throws IllegalAccessException, InstantiationException {

        return this.javaBean.newInstance();
    }

    private LineFormat lineFormatFromAnnotations(Class javaBean) {

        LineFormat lineFormat = new LineFormat();

        /* For each field, check if there is a position annotation, and
         * if so, add an entry to the lineFormat */
        for (Field field : javaBean.getDeclaredFields()) {

            PositionInLine positionAnnotation = field.getAnnotation(PositionInLine.class);

            if (positionAnnotation != null) {
                FieldBounds flatWidthFieldBounds = new FieldBounds(
                        positionAnnotation.start(), positionAnnotation.end());
                lineFormat.addEntry(field.getName(), flatWidthFieldBounds);
            }
        }

        return lineFormat;
    }
}

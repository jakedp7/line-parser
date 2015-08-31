package com.powell.FixedWidthLineParser;

import com.powell.FixedWidthLineParser.utility.FieldFormat;
import com.powell.FixedWidthLineParser.utility.LineFormat;

import java.lang.reflect.Field;
//TODO: Comments. Check them, and add jDoc comments
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
     * LineFormat stores names and positions of fields in a
     * fixed-width line of data.
     */
    private LineFormat lineFormat;

    public FixedWidthLineParser(Class javaBean) {

        //Store the input bean into the new object
        this.javaBean = javaBean;

        //Extract lineFormat from annotations in the bean through com.powell.FixedWidthLineParser.LineFormatdthLineParser.utility.LineFormat
        this.lineFormat = lineFormatFromAnnotations(javaBean);
    }

    //TODO: parseLine. How am I going to deal with type? How will I assign values to a bean's object?
    public Object parseLine(String line) throws IllegalAccessException, InstantiationException {



        return this.javaBean.newInstance();
    }

    public LineFormat getLineFormat() {
        return lineFormat;
    }

    private LineFormat lineFormatFromAnnotations(Class javaBean) {

        LineFormat lineFormat = new LineFormat();

        /* For each field, check if there is a position annotation, and
         * if so, add an entry to the lineFormat */
        for (Field field : javaBean.getDeclaredFields()) {

            PositionInLine positionAnnotation = field.getAnnotation(PositionInLine.class);

            if (positionAnnotation != null) {
                lineFormat.addEntry(new FieldFormat(field.getName(),
                        positionAnnotation.start(), positionAnnotation.end()));
            }
        }

        return lineFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FixedWidthLineParser that = (FixedWidthLineParser) o;

        if (javaBean != null ? !javaBean.equals(that.javaBean) : that.javaBean != null) return false;
        return !(getLineFormat() != null ? !getLineFormat().equals(that.getLineFormat()) : that.getLineFormat() != null);

    }

    @Override
    public int hashCode() {
        int result = javaBean != null ? javaBean.hashCode() : 0;
        result = 31 * result + (getLineFormat() != null ? getLineFormat().hashCode() : 0);
        return result;
    }
}

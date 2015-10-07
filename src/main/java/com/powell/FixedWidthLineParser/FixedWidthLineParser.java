package com.powell.FixedWidthLineParser;

import com.powell.FixedWidthLineParser.utility.FieldFormat;
import com.powell.FixedWidthLineParser.utility.LineFormat;
import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

/**
 * A Fixed-Width single-line parser that uses an annotated
 * JavaBean to extract data into an object of the bean.
 *
 * The positions of each data field in a line is stored
 * upon construction, and parsing a line results in a
 * data-filled object of the original stored bean.
 *
 * The parsed lineFormat can be viewed through a getter.
 * @author jakedp7
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

    /**
     * Constructs a LineParser from the input JavaBean
     * and stores the bean for later object creation.
     * @param javaBean
     */
    public FixedWidthLineParser(Class javaBean) {

        //Store the input bean into the new object
        this.javaBean = javaBean;

        //Extract lineFormat from annotations in the bean through com.powell.FixedWidthLineParser.LineFormatdthLineParser.utility.LineFormat
        this.lineFormat = lineFormatFromAnnotations(javaBean);
    }

    /**
     * Parses a single line in a string into a javaBean.
     * Returns null if errors occur - if the Bean can't be
     * instantiated, or if the data schema of the bean and
     * the LineFormat don't match up.
     * @param line
     * @param <T>
     * @return (T)parsedJavaBean
     */
    public <T> T parse(String line) {

        //Created an empty Map to store parsed data in
        LinkedHashMap parsedData = new LinkedHashMap();

        //Loop through each FieldFormat in the LineFormat
        for(FieldFormat fieldFormat : lineFormat) {

            String parsedSegment;

            try {
                if (fieldFormat.getEndAtEol()) {
                    //Extract the data field from the start string index until the End-of-Line
                    parsedSegment = line.substring(
                            (fieldFormat.getStartPos() - 1), (line.length()));
                } else {
                    //Extract the data field from the start string index to the end string index
                    parsedSegment = line.substring(
                            (fieldFormat.getStartPos() - 1), (fieldFormat.getEndPos() - 1));
                }
            } catch (IndexOutOfBoundsException exception) {
                parsedSegment = "";
            }

            //Clean the extracted data
            parsedSegment = parsedSegment.trim();

            //Add it to the data Map
            parsedData.put(fieldFormat.getName(), parsedSegment);
        }

        //Create the bean and map the parsedData to it
        try {
            Object newBean = javaBean.newInstance();
            BeanUtilsBean.getInstance().populate(newBean, parsedData);
            return (T)(newBean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get the extracted LineFormat object
     * @return LineFormat
     */
    public LineFormat getLineFormat() {
        return lineFormat;
    }

    /**
     * Parse the javaBean for PositionInLine annotations and
     * add them to a LineFormat object.
     * @param javaBean
     * @return LineFormat
     */
    private LineFormat lineFormatFromAnnotations(Class javaBean) {

        //Instantiate a blank LineFormat
        LineFormat lineFormat = new LineFormat();

        //Loop through each declared field in the class
        for (Field field : javaBean.getDeclaredFields()) {

            //For each field, store it's PositionInLine annotation
            PositionInLine positionAnnotation = field.getAnnotation(PositionInLine.class);

            //If annotation exists, create a FieldFormat and add it to the LineFormat
            if (positionAnnotation != null) {

                lineFormat.addEntry(new FieldFormat(field.getName(), positionAnnotation.start(),
                        positionAnnotation.end(), positionAnnotation.endAtEol()));
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

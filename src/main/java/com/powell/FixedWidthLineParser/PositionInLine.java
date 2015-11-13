package com.powell.FixedWidthLineParser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to be applied to fields in a JavaBean that indicates the position of
 * a data point in a fixed-width line of data.
 * @author jakedp7
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PositionInLine {

    /**
     * The starting index of a piece of data in a single line of fixed-width
     * text. Defaults to 0.
     * @return int representing the start location of an entry
     */
    int start() default 0;
    /**
     * The ending index of a piece of data in a single line of fixed-width
     * text. Defaults to 1.
     * @return int representing the end location of an entry
     */
    int end() default 1;
    /**
     * Indicates whether or not this entry should be parsed until the end
     * of the line of fixed-width text is reached. If so, an "end()" value
     * is unnecessary.
     * @return boolean indicating if this entry ends with the line
     */
    boolean endAtEol() default false;
}

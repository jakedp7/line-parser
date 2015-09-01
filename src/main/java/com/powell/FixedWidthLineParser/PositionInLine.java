package com.powell.FixedWidthLineParser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation to be applied to fields in a JavaBean
 * that indicates the position of of a data point in a
 * fixed-width line of data.
 * @author jakedp7
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PositionInLine {

    int start() default 0;
    int end();
}

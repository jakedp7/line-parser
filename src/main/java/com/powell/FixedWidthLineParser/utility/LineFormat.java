package com.powell.FixedWidthLineParser.utility;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Jacob on 8/28/2015.
 */
public class LineFormat {

    /**
     * Hashmap contains the line format - the string corresponds
     * to the name of the entry, and the bounds of the field in
     * a fixed-width line of data
     */
    private ArrayList<FieldFormat> lineFormat;

    /**
     * Empty constructor creates HashMap for later addition of entries.
     */
    public LineFormat() {
        this.lineFormat = new ArrayList<FieldFormat>();
    }

    public void addEntry(FieldFormat fieldFormat) {

        //Store the object into the arraylist
        lineFormat.add(fieldFormat);
    }

    public FieldFormat getEntry(String entryName) {

        Iterator<FieldFormat> formatIterator = lineFormat.iterator();

        while(formatIterator.hasNext()) {
            FieldFormat currentFormat = formatIterator.next();

            if(currentFormat.getName() == entryName) {
                return currentFormat;
            }
        }
        return new FieldFormat();
    }

    public void removeEntry(String entryName) {

        Iterator<FieldFormat> formatIterator = lineFormat.iterator();

        while(formatIterator.hasNext()) {
            FieldFormat currentFormat = formatIterator.next();

            if(currentFormat.getName() == entryName) {
                lineFormat.remove(currentFormat);
                return;
            }
        }
    }

    public void removeEntry(FieldFormat entry) {

        //Remove entry with specific entryName
        lineFormat.remove(entry);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineFormat that = (LineFormat) o;

        return !(lineFormat != null ? !lineFormat.equals(that.lineFormat) : that.lineFormat != null);

    }

    @Override
    public int hashCode() {
        return lineFormat != null ? lineFormat.hashCode() : 0;
    }
}

package com.powell.FixedWidthLineParser.utility;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The iterable LineFormat class consists of an ArrayList of FieldFormats that define
 * a single line of Fixed-Width data. Each FieldFormat can be accessed or deleted
 * through it's name.
 * @author jakedp7
 */
public class LineFormat implements Iterable<FieldFormat> {

    private ArrayList<FieldFormat> lineFormat;

    /**
     * Empty constructor instantiates the member ArrayList and leaves it blank.
     */
    public LineFormat() {

        //Instantiate the ArrayList
        this.lineFormat = new ArrayList<>();
    }

    /**
     * Adds a fieldFormat to the larger LineFormat
     * @param fieldFormat Data entry to store
     */
    public void addEntry(FieldFormat fieldFormat) {

        //Store the FieldFormat
        lineFormat.add(fieldFormat);
    }

    /**
     * Get an individual FieldFormat with a specific title.
     * @param entryName Entry name to retrieve
     * @return format is the retrieved FieldFormat with matching entryName
     */
    public FieldFormat getEntry(String entryName) {

        //Loop through the ArrayList
        for(FieldFormat format : lineFormat) {
            //When the entry with a matching entryName is found
            if(format.getName().equals(entryName)) {
                //Return it
                return format;
            }
        }
        //If none are found, return null
        return null;
    }

    /**
     * Deletes an entry from the LineFormat based on the entry name.
     * @param entryName Entry name to delete
     */
    public void removeEntry(String entryName) {

        //Loop through the ArrayList
        for(FieldFormat format : lineFormat) {
            //When the entry with the matching entryName is found
            if(format.getName().equals(entryName)) {
                //Delete it and break the loop
                lineFormat.remove(format);
                break;
            }
        }
    }

    /**
     * Delete an entry from the LineFormat based on the parametrized object itself.
     * @param entry FieldFormat object to be deleted.
     */
    public void removeEntry(FieldFormat entry) {

        //Remove entry
        lineFormat.remove(entry);
    }

    @Override
    public Iterator<FieldFormat> iterator() {

        return lineFormat.iterator();
    }

    @Override
    public String toString() {
        return "LineFormat{" +
                "lineFormat=" + lineFormat +
                '}';
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

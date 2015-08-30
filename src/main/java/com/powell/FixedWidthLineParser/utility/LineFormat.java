package com.powell.FixedWidthLineParser.utility;

import javax.sound.sampled.Line;
import java.util.HashMap;
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
    private HashMap<String, FieldBounds> lineFormat;

    /**
     * Empty constructor creates HashMap for later addition of entries.
     */
    public LineFormat() {
        this.lineFormat = new HashMap<String, FieldBounds>();
    }

    public void addEntry(String entryName, FieldBounds fieldBounds) {

        //Store the name and indices to the object
        lineFormat.put(entryName, fieldBounds);
    }

    public FieldBounds getEntryIndices(String entryName) {

        //Return the indices of the specific entryName requested
        return lineFormat.get(entryName);
    }

    public void removeEntry(String entryName) {

        //Remove entry with specific entryName
        lineFormat.remove(entryName);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + this.lineFormat.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        LineFormat lineFormatToCompare = (LineFormat)object;

        Iterator<String> keyIterator = this.lineFormat.keySet().iterator();
        while (keyIterator.hasNext()) {
            String currentKey = keyIterator.next();

            if (!this.getEntryIndices(currentKey).equals(
                    lineFormatToCompare.getEntryIndices(currentKey))) {
                return false;
            }
        }
        return true;
    }
}

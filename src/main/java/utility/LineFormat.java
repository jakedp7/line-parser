package main.java.utility;

import java.util.HashMap;

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
}

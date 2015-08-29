package utility;

import java.util.HashMap;
import java.util.logging.FileHandler;

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
     * Empty constructor for later addition of entries.
     */
    public LineFormat() {
        this.lineFormat = new HashMap<String, FieldBounds>();
    }

    /**
     * Constructor creates line format by extracting fixed-width
     * format positions from class annotations.
     * @param javaBean
     */
    public LineFormat(Class javaBean) {

        this.lineFormat = extractAnnotationsToHashmap(javaBean);
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

    private HashMap<String, FieldBounds> extractAnnotationsToHashmap(Class javaBean) {
        return new HashMap<>();
    }
}

import java.util.HashMap;

/**
 * Created by Jacob on 8/28/2015.
 */
public class LineFormat {

    /**
     * Hashmap contains the line format - the string corresponds
     * to the name of the entry, and the array has two elements:
     * the start and end indices in a fixed-width line of data
     */
    private HashMap<String, Integer[]> lineFormat;

    /**
     * Empty constructor for later addition of entries.
     */
    public LineFormat() {}

    /**
     * Constructor creates line format by extracting fixed-width
     * format positions from class annotations.
     * @param javaBean
     */
    public LineFormat(Class javaBean) {

    }

    public void addEntry(String entryName, Integer entryStartIndex,
                         Integer entryEndIndex) {

        //Create a small array of fixed-width format indices
        Integer[] entryBounds = {entryStartIndex, entryEndIndex};

        //Store the name and indices to the object
        lineFormat.put(entryName, entryBounds);
    }

    public Integer[] getEntryIndices(String entryName) {

        //Return the indices of the specific entryName requested
        return lineFormat.get(entryName);
    }

    public void removeEntry(String entryName) {

        //Remove entry with specific entryName
        lineFormat.remove(entryName);
    }
}

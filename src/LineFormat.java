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

    public void addEntry() {

    }

    public void removeEntry() {

    }
}

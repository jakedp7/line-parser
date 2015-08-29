import utility.LineFormat;

/**
 * Created by Jacob on 8/28/2015.
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
     * utility.LineFormat stores names and positions of fields in a
     * fixed-width line of data.
     */
    private LineFormat lineFormat;

    public FixedWidthLineParser(Class javaBean) {

        //Store the input bean into the new object
        this.javaBean = javaBean;

        //Extract lineFormat from annotations in the bean through utility.LineFormat
        this.lineFormat = new LineFormat(javaBean);
    }

    public Object parseLine(String line) throws IllegalAccessException, InstantiationException {

        return this.javaBean.newInstance();
    }
}

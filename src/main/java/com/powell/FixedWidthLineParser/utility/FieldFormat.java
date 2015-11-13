package com.powell.FixedWidthLineParser.utility;

/**
 * A JavaBean container for a specific data field and its position indices
 * in a fixed-width line of text.
 * @author jakedp7
 */
public class FieldFormat {

    private String name;
    private int startPos;
    private int endPos;
    private boolean endAtEol = false;

    /**
     * Creates an empty FieldFormat
     */
    public FieldFormat() {}

    /**
     * Creates a FieldFormat with endAtEol at its default value of false
     * @param name Indicates the title of the entry in a line.
     * @param startPos Indicates the starting place of the entry in a line.
     * @param endPos Indicates the ending place of the entry in a line.
     */
    public FieldFormat(String name, Integer startPos, Integer endPos) {
        this.name = name;
        this.startPos = startPos;
        this.endPos = endPos;
    }

    /**
     * Creates a FieldFormat that can take endAtEol as a parameter, and
     * defaults endPos to 1.
     * @param name Indicates the title of the entry in a line.
     * @param startPos Indicates the starting place of the entry in a line.
     * @param endAtEol Indicates if the entry should be parsed until EOL is reached.
     */
    public FieldFormat(String name, int startPos, Boolean endAtEol) {
        this.name = name;
        this.startPos = startPos;
        this.endPos = 1;
        this.endAtEol = endAtEol;
    }

    /**
     * Creates a FieldFormat with all members parametrized.
     * @param name Indicates the title of the entry in a line.
     * @param startPos Indicates the starting place of the entry in a line.
     * @param endPos Indicates the ending place of the entry in a line.
     * @param endAtEol Indicates if the entry should be parsed until EOL is reached.
     */
    public FieldFormat(String name, int startPos, int endPos, Boolean endAtEol) {
        this.name = name;
        this.startPos = startPos;
        this.endPos = endPos;
        this.endAtEol = endAtEol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }

    public boolean getEndAtEol() {
        return endAtEol;
    }

    public void setEndAtEol(Boolean endAtEol) {
        this.endAtEol = endAtEol;
    }

    @Override
    public String toString() {
        return "FieldFormat{" +
                "name='" + name + '\'' +
                ", startPos=" + startPos +
                ", endPos=" + endPos +
                ", endAtEol=" + endAtEol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FieldFormat that = (FieldFormat) o;

        if (startPos != that.startPos) return false;
        if (endPos != that.endPos) return false;
        if (endAtEol != that.endAtEol) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + startPos;
        result = 31 * result + endPos;
        result = 31 * result + (endAtEol ? 1 : 0);
        return result;
    }
}

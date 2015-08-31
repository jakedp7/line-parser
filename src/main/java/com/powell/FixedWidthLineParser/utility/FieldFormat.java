package com.powell.FixedWidthLineParser.utility;

/**
 * Created by Jacob on 8/29/2015.
 */
public class FieldFormat {

    private String name;

    private int startPos;
    private int endPos;

    public FieldFormat() {}

    public FieldFormat(String name, int startPos, int endPos) {
        this.name = name;
        this.startPos = startPos;
        this.endPos = endPos;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FieldFormat that = (FieldFormat) o;

        if (startPos != that.startPos) return false;
        if (endPos != that.endPos) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + startPos;
        result = 31 * result + endPos;
        return result;
    }
}

package com.powell.FixedWidthLineParser.utility;

import java.lang.reflect.Field;

/**
 * Created by Jacob on 8/29/2015.
 */
public class FieldBounds {

    private int startPos;
    private int endPos;

    public FieldBounds(int startPos, int endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
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
    public int hashCode() {
        int hash = 13;
        hash = 53 * hash + this.getStartPos();
        hash = 53 * hash + this.getEndPos();
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
        FieldBounds fieldBoundsToCompare = (FieldBounds)object;

        if ((this.getStartPos() == fieldBoundsToCompare.getStartPos())
            && (this.getEndPos() == fieldBoundsToCompare.getEndPos())) {
            return true;
        }

        return false;
    }
}

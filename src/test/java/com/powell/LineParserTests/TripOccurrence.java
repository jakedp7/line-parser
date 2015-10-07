package com.powell.LineParserTests;

import com.powell.FixedWidthLineParser.PositionInLine;

/**
 * Created by Jacob on 8/29/2015.
 */
public class TripOccurrence {

    @PositionInLine(start = 1, end = 5)
    private String domicile;

    @PositionInLine(start=6, end=10)
    private Integer tripNumber;

    @PositionInLine(start=11, end=19)
    private String startDate;

    @PositionInLine(start=20, end=23)
    private Integer associatedLine;

    @PositionInLine(start=24, endAtEol=true)
    private Integer tripCountInLine;

    public TripOccurrence() {}

    public TripOccurrence(String domicile, Integer tripNumber,
                          String startDate, Integer associatedLine, Integer tripCountInLine) {

        this.domicile = domicile;
        this.tripNumber = tripNumber;
        this.startDate = startDate;
        this.associatedLine = associatedLine;
        this.tripCountInLine = tripCountInLine;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public Integer getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(Integer tripNumber) {
        this.tripNumber = tripNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getAssociatedLine() {
        return associatedLine;
    }

    public void setAssociatedLine(Integer associatedLine) {
        this.associatedLine = associatedLine;
    }

    public Integer getTripCountInLine() {
        return tripCountInLine;
    }

    public void setTripCountInLine(Integer tripCountInLine) {
        this.tripCountInLine = tripCountInLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripOccurrence that = (TripOccurrence) o;

        if (domicile != null ? !domicile.equals(that.domicile) : that.domicile != null) return false;
        if (tripNumber != null ? !tripNumber.equals(that.tripNumber) : that.tripNumber != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (associatedLine != null ? !associatedLine.equals(that.associatedLine) : that.associatedLine != null)
            return false;
        return !(tripCountInLine != null ? !tripCountInLine.equals(that.tripCountInLine) : that.tripCountInLine != null);

    }

    @Override
    public int hashCode() {
        int result = domicile != null ? domicile.hashCode() : 0;
        result = 31 * result + (tripNumber != null ? tripNumber.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (associatedLine != null ? associatedLine.hashCode() : 0);
        result = 31 * result + (tripCountInLine != null ? tripCountInLine.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TripOccurrence{" +
                "domicile='" + domicile + '\'' +
                ", tripNumber=" + tripNumber +
                ", startDate='" + startDate + '\'' +
                ", associatedLine=" + associatedLine +
                ", tripCountInLine=" + tripCountInLine +
                '}';
    }
}
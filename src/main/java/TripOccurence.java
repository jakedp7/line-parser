package main.java;

/**
 * Created by Jacob on 8/29/2015.
 */
public class TripOccurence {

    @PositionInLine(start = 1, end = 5)
    private String domicile;

    @PositionInLine(start=6, end=10)
    private Integer tripNumber;

    @PositionInLine(start=11, end=19)
    private String startDate;

    @PositionInLine(start=20, end=23)
    private Integer associatedLine;

    @PositionInLine(start=24, end=26)
    private Integer tripCountInLine;

    public TripOccurence() {}

    public TripOccurence(String domicile, Integer tripNumber,
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
}
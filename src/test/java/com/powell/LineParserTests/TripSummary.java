package com.powell.LineParserTests;

import com.powell.FixedWidthLineParser.PositionInLine;

/**
 * Created by Jacob on 8/31/2015.
 */
public class TripSummary {

    /** The home domicile that this trip is based from */
    @PositionInLine(start=1, end=5)
    private String domicile;

    /** The relational id number of this trip */
    @PositionInLine(start=6, end=10)
    private Integer tripNumber;

    /** The first date this trip was allowed, formatted YYYYMMDD */
    @PositionInLine(start=11, end=19)
    private String effecStartDate;

    /** The last date this trip was allowed, formatted YYYYMMDD */
    @PositionInLine(start=20, end=28)
    private String effecEndDate;

    /** The time a pilot should report the the airport at, UTC, formatted HH:MM */
    @PositionInLine(start=29, end=34)
    private String utcReportTime;

    /** The time a pilot should report the airport, local time, formatted HH:MM */
    @PositionInLine(start=35, end=40)
    private String localReportTime;

    /** Total number of credit hours attained from this trip, formatted HH:MM */
    @PositionInLine(start=41, end=47)
    private String creditHours;

    /** Total number of block hours attained from this trip, formatted HH:MM */
    @PositionInLine(start=48, end=54)
    private String blockHours;

    /** Total number of landings on the trip */
    @PositionInLine(start=55, end=57)
    private Integer landings;

    /** Total time away from home on the trip, formatted HH:MM*/
    @PositionInLine(start=58, end=64)
    private String timeAwayFromBase;

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

    public String getEffecStartDate() {
        return effecStartDate;
    }

    public void setEffecStartDate(String effecStartDate) {
        this.effecStartDate = effecStartDate;
    }

    public String getEffecEndDate() {
        return effecEndDate;
    }

    public void setEffecEndDate(String effecEndDate) {
        this.effecEndDate = effecEndDate;
    }

    public String getUtcReportTime() {
        return utcReportTime;
    }

    public void setUtcReportTime(String utcReportTime) {
        this.utcReportTime = utcReportTime;
    }

    public String getLocalReportTime() {
        return localReportTime;
    }

    public void setLocalReportTime(String localReportTime) {
        this.localReportTime = localReportTime;
    }

    public String getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(String creditHours) {
        this.creditHours = creditHours;
    }

    public String getBlockHours() {
        return blockHours;
    }

    public void setBlockHours(String blockHours) {
        this.blockHours = blockHours;
    }

    public Integer getLandings() {
        return landings;
    }

    public void setLandings(Integer landings) {
        this.landings = landings;
    }

    public String getTimeAwayFromBase() {
        return timeAwayFromBase;
    }

    public void setTimeAwayFromBase(String timeAwayFromBase) {
        this.timeAwayFromBase = timeAwayFromBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripSummary that = (TripSummary) o;

        if (domicile != null ? !domicile.equals(that.domicile) : that.domicile != null) return false;
        if (tripNumber != null ? !tripNumber.equals(that.tripNumber) : that.tripNumber != null) return false;
        if (effecStartDate != null ? !effecStartDate.equals(that.effecStartDate) : that.effecStartDate != null)
            return false;
        if (effecEndDate != null ? !effecEndDate.equals(that.effecEndDate) : that.effecEndDate != null) return false;
        if (utcReportTime != null ? !utcReportTime.equals(that.utcReportTime) : that.utcReportTime != null)
            return false;
        if (localReportTime != null ? !localReportTime.equals(that.localReportTime) : that.localReportTime != null)
            return false;
        if (creditHours != null ? !creditHours.equals(that.creditHours) : that.creditHours != null) return false;
        if (blockHours != null ? !blockHours.equals(that.blockHours) : that.blockHours != null) return false;
        if (landings != null ? !landings.equals(that.landings) : that.landings != null) return false;
        return !(timeAwayFromBase != null ? !timeAwayFromBase.equals(that.timeAwayFromBase) : that.timeAwayFromBase != null);

    }

    @Override
    public int hashCode() {
        int result = domicile != null ? domicile.hashCode() : 0;
        result = 31 * result + (tripNumber != null ? tripNumber.hashCode() : 0);
        result = 31 * result + (effecStartDate != null ? effecStartDate.hashCode() : 0);
        result = 31 * result + (effecEndDate != null ? effecEndDate.hashCode() : 0);
        result = 31 * result + (utcReportTime != null ? utcReportTime.hashCode() : 0);
        result = 31 * result + (localReportTime != null ? localReportTime.hashCode() : 0);
        result = 31 * result + (creditHours != null ? creditHours.hashCode() : 0);
        result = 31 * result + (blockHours != null ? blockHours.hashCode() : 0);
        result = 31 * result + (landings != null ? landings.hashCode() : 0);
        result = 31 * result + (timeAwayFromBase != null ? timeAwayFromBase.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TripSummary{" +
                "domicile='" + domicile + '\'' +
                ", tripNumber=" + tripNumber +
                ", effecStartDate='" + effecStartDate + '\'' +
                ", effecEndDate='" + effecEndDate + '\'' +
                ", utcReportTime='" + utcReportTime + '\'' +
                ", localReportTime='" + localReportTime + '\'' +
                ", creditHours='" + creditHours + '\'' +
                ", blockHours='" + blockHours + '\'' +
                ", landings=" + landings +
                ", timeAwayFromBase='" + timeAwayFromBase + '\'' +
                '}';
    }
}

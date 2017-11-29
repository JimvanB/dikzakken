package com.jim.spring.domain;

/**
 * Created by jim on 28-11-17.
 */
public enum DatumGroepering {

    DAY, WEEK, MONTH, YEAR;

    static DatumGroepering findByString(String value) {
        switch (value) {
            case "day":
                return DAY;
            case "week":
                return WEEK;
            case "month":
                return MONTH;
            case "year":
                return YEAR;
            default:
                return null;
        }
    }
}

package com.company.studyConditions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class OncePerMonth implements AttendByDays {

    @Override
    public boolean isPossibleToVisit(LocalDate date) {
        LocalDate lastInMonth = date.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
        return date.isEqual(lastInMonth);
    }

}
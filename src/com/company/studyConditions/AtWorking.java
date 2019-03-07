package com.company.studyConditions;

import java.time.LocalDate;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class AtWorking implements AttendByDays {

    @Override
    public boolean isPossibleToVisit(LocalDate date) {
        return date.getDayOfWeek() != SATURDAY && date.getDayOfWeek() != SUNDAY;
    }

}

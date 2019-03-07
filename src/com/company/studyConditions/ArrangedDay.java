package com.company.studyConditions;

import java.time.LocalDate;

public class ArrangedDay implements AttendByDays {

    private LocalDate arrangedDay;

    public ArrangedDay(LocalDate arrangedDay) {
        this.arrangedDay = arrangedDay;
    }

    @Override
    public boolean isPossibleToVisit(LocalDate date) {
        return this.arrangedDay.isEqual(date);
    }

}

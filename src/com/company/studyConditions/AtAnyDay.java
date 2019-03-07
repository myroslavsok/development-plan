package com.company.studyConditions;

import java.time.LocalDate;

public class AtAnyDay implements AttendByDays{
    @Override
    public boolean isPossibleToVisit(LocalDate date) {
        return true;
    }
}

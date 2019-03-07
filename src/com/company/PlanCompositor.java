package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanCompositor {

    private LocalDate beginningDate = LocalDate.now();

    private ArrayList<DevelopmentActivity> schedule = new ArrayList<>();
    private ArrayList<LocalDate> howLong = new ArrayList<>();

    public void addToSchedule(DevelopmentActivity event, LocalDate howLong) {
        this.schedule.add(event);
        this.howLong.add(howLong);
    }

    public void setBeginningDate(LocalDate date) {
        this.beginningDate = date;
    }

    public void applyScheduleForStudent(Student student) {
        for (int i = 0; i < this.schedule.size(); i++) {
            LocalDate progressDate = this.beginningDate;
            do {
                if (this.schedule.get(i).canAttend(progressDate)) {
                    this.schedule.get(i).educate(student);
                }
                progressDate = progressDate.plusDays(1);
            } while (progressDate.isBefore(this.howLong.get(i)));
        }
    }
}

package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanCompositor {

    LocalDate planDeadline;
    ArrayList<DevelopmentActivity> schedule = new ArrayList<>();

    public PlanCompositor(LocalDate deadline) {
        this.planDeadline = deadline;
    }

    public void addToSchedule(DevelopmentActivity event) {
        schedule.add(event);
    }

    public void applyScheduleForStudent(Student student) {
        this.schedule.forEach(event -> {
            LocalDate progressDate = LocalDate.now();
            do {
//                System.out.println("date = " + progressDate + " " + progressDate.getDayOfWeek());
                if (event.canAttend(progressDate))
                    event.educate(student);
                progressDate = progressDate.plusDays(1);
            } while (progressDate.isBefore(this.planDeadline));
        });
    }
}
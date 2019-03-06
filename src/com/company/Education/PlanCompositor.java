package com.company.Education;

import com.company.Student;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanCompositor {

    LocalDate planDeadline;
    ArrayList<KnowledgeSource> schedule = new ArrayList<>();

    public PlanCompositor(LocalDate deadline) {
        this.planDeadline = deadline;
    }

    public void addToSchedule(KnowledgeSource event) {
        schedule.add(event);
    }

    public void applyScheduleForStudent(Student student) {
        this.schedule.forEach(event -> {
            LocalDate progressDate = LocalDate.now();
            do {
                System.out.println("date = " + progressDate);
                event.educate(student);
                progressDate = progressDate.plusDays(1);
            } while (progressDate.isBefore(this.planDeadline));
        });
    }
}

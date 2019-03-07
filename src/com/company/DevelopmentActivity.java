package com.company;

import com.company.Education.KnowledgeSource;
import com.company.studyConditions.AttendByDays;

import java.time.LocalDate;

public class DevelopmentActivity {

    private KnowledgeSource knowledgeSource;
    private AttendByDays attendByDays;

    public DevelopmentActivity(KnowledgeSource knowledgeSource, AttendByDays attendByDays) {
        this.knowledgeSource = knowledgeSource;
        this.attendByDays = attendByDays;
    }

    boolean canAttend(LocalDate day) {
        return attendByDays.isPossibleToVisit(day);
    }

    void educate(Student student) {
        knowledgeSource.giveKnowledge(student);
    }

}

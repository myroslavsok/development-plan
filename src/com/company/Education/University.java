package com.company.Education;

import com.company.Student;

public class University implements KnowledgeSource {

    private double knowledgeLevel;
    private double experienceLevel;

    public University(int knowledge, int experience) {
        this.knowledgeLevel = knowledge;
        this.experienceLevel = experience;
    }

    @Override
    public void giveKnowledge(Student student) {
        if (student.getIsInUniversity()) {
            student.improveSkills(this.knowledgeLevel, this.experienceLevel);
        }
    }
}

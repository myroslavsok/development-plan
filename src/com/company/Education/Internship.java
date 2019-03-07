package com.company.Education;

import com.company.Student;

public class Internship implements KnowledgeSource {

    private double knowledgeLevel;
    private double experienceLevel;

    public Internship(int knowledge, int experience) {
        this.knowledgeLevel = knowledge;
        this.experienceLevel = experience;
    }

    @Override
    public void giveKnowledge(Student student) {
        if (student.getIsInInternship()) {
            student.improveSkills(this.knowledgeLevel, this.experienceLevel);
        }
    }

}
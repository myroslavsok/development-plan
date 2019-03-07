package com.company.Education;

import com.company.Student;

public class Meetup implements KnowledgeSource {

    private double knowledgeLevel;
    private double experienceLevel;

    public Meetup(int knowledge, int experience) {
        this.knowledgeLevel = knowledge;
        this.experienceLevel = experience;
    }

    @Override
    public void giveKnowledge(Student student) {
        if (student.gethasLaptop()) {
            giveKnowledgeAndExperience(student);
        } else {
            giveKnowledgeOnly(student);
        }
    }

    private void giveKnowledgeAndExperience(Student student) {
        student.improveSkills(this.knowledgeLevel, this.experienceLevel);
    }

    private void giveKnowledgeOnly(Student student) {
        student.improveSkills(this.knowledgeLevel, 0);
    }

}
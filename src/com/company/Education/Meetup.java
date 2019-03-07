package com.company.Education;

import com.company.Student;

public class Meetup extends Knowledge implements KnowledgeSource {

    public Meetup(int knowledge, int experience) {
        super(knowledge, experience);
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
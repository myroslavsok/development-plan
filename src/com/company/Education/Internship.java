package com.company.Education;

import com.company.Student;

public class Internship extends Knowledge implements KnowledgeSource {

    public Internship(int knowledge, int experience) {
        super(knowledge, experience);
    }

    @Override
    public void giveKnowledge(Student student) {
        if (student.getIsInInternship()) {
            student.improveSkills(this.knowledgeLevel, this.experienceLevel);
        }
    }

}
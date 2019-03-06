package com.company.Education;

import com.company.Student;

public class University implements KnowledgeSource {

    private int knowledgeLevel;
    private int experienceLevel;

    public University(int knowledge, int experience) {
        this.knowledgeLevel = knowledge;
        this.experienceLevel = experience;
    }

    @Override
    public void educate(Student student) {
        student.improveSkills(this.knowledgeLevel, this.experienceLevel);
    }
}

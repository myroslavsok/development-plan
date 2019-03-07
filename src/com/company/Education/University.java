package com.company.Education;

import com.company.Student;

public class University extends Knowledge implements KnowledgeSource {

    public University(int knowledge, int experience) {
        super(knowledge, experience);
    }

    @Override
    public void giveKnowledge(Student student) {
        if (student.getIsInUniversity()) {
            student.improveSkills(this.knowledgeLevel, this.experienceLevel);
        }
    }

}

package com.company.Education;

import com.company.Student;

public class SelfDevelopment extends Knowledge implements KnowledgeSource {


    public SelfDevelopment(int knowledge, int experience) {
        super(knowledge, experience);
    }

    @Override
    public void giveKnowledge(Student student) {
        student.improveSkills(this.knowledgeLevel, this.experienceLevel);
    }

}

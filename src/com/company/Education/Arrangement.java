package com.company.Education;

import com.company.Student;

public class Arrangement extends Knowledge implements KnowledgeSource {

    public Arrangement(int knowledge, int experience) {
        super(knowledge, experience);
    }

    public Arrangement(Student student) {
        super( 0, 0);
        this.knowledgeLevel = calculatePassedSkill(student.getKnowledge());
        this.experienceLevel = calculatePassedSkill(student.getExperience());
    }

    private double calculatePassedSkill(double skiil) {
        return skiil * 20 / 100;
    }

    @Override
    public void giveKnowledge(Student student) {
        student.improveSkills(this.knowledgeLevel, this.experienceLevel);
    }
}

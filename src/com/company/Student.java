package com.company;

public class Student {
    private double knowledge = 0;
    private double experience = 0;
    private double abilityToStudy;

    private boolean hasLaptop;
    private boolean isInUniversity;
    private boolean isInInternship;


    public Student() {
        this(1, false, false, false);
    }

    public Student(double abilityToStudy, boolean hasLaptop) {
        this(abilityToStudy, hasLaptop, false, false);
    }

    public Student(double abilityToStudy, boolean hasLaptop, boolean isInUniversity) {
        this(abilityToStudy, hasLaptop, isInUniversity, false);
    }

    public Student(double abilityToStudy, boolean hasLaptop, boolean isInUniversity, boolean isInInternship) {
        this.abilityToStudy = abilityToStudy;
        this.hasLaptop = hasLaptop;
        this.isInUniversity = isInUniversity;
        this.isInInternship = isInInternship;
    }

    public void improveSkills(double knowledge, double experience) {
        this.knowledge += knowledge;
        this.experience += experience;
    }

    public double getKnowledge() {
        return this.knowledge * this.abilityToStudy;
    }

    public double getExperience() {
        return this.experience * this.abilityToStudy;
    }

}

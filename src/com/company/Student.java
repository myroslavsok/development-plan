package com.company;

public class Student {
    private double knowledge = 0;
    private double experience = 0;
    private double abilityToStudy;
    private double abilityToGetExperience;

    private boolean hasLaptop;
    private boolean isInUniversity;
    private boolean isInInternship;


    public Student() {
        this(1, 1, false, false, false);
    }

    public Student(double abilityToStudy, double abilityToGetExperience, boolean hasLaptop) {
        this(abilityToStudy, abilityToGetExperience, hasLaptop, false, false);
    }

    public Student(double abilityToStudy, double abilityToGetExperience, boolean hasLaptop, boolean isInUniversity) {
        this(abilityToStudy, abilityToGetExperience, hasLaptop, isInUniversity, false);
    }

    public Student(double abilityToStudy, double abilityToGetExperience, boolean hasLaptop, boolean isInUniversity, boolean isInInternship) {
        this.abilityToStudy = abilityToStudy;
        this.abilityToGetExperience = abilityToGetExperience;
        this.hasLaptop = hasLaptop;
        this.isInUniversity = isInUniversity;
        this.isInInternship = isInInternship;
    }

    public void improveSkills(double knowledge, double experience) {
        this.knowledge += knowledge;
        this.experience += experience;
    }

    public void showSkills() {
        System.out.println("knowledge = " + Math.round(getKnowledge()));
        System.out.println("experience = " + Math.round(getExperience()));
    }

    public double getKnowledge() {
        return this.knowledge * this.abilityToStudy;
    }

    public double getExperience() {
        return this.experience * this.abilityToGetExperience;
    }

    public boolean gethasLaptop() {
        return this.hasLaptop;
    }

    public boolean getIsInUniversity() {
        return this.isInUniversity;
    }

    public boolean getIsInInternship() {
        return this.isInInternship;
    }

}

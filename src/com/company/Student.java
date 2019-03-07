package com.company;

public class Student {

    private double knowledge = 0;
    private double experience = 0;

    private double abilityToStudy;
    private double abilityToGetExperience;
    private boolean hasLaptop;
    private boolean isInUniversity;
    private boolean isInInternship;
    private String name;


    public Student(StudentBuilder builder) {
        this.abilityToStudy = builder.abilityToStudy;
        this.abilityToGetExperience = builder.abilityToGetExperience;
        this.hasLaptop = builder.hasLaptop;
        this.isInUniversity = builder.isInUniversity;
        this.isInInternship = builder.isInInternship;
        this.name = builder.name;
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

    public String getName() {
        return this.name;
    }

    // Builder class
    public static class StudentBuilder {

        // optional parameters
        private double abilityToStudy = 1;
        private double abilityToGetExperience = 1;
        private boolean hasLaptop = false;
        private boolean isInUniversity = false;
        private boolean isInInternship = false;
        private String name = "";

        public StudentBuilder setAbilityToStudy(int abilityToStudy) {
            this.abilityToStudy = abilityToStudy;
            return this;
        }

        public StudentBuilder setAbilityToGetExperience(int abilityToGetExperience) {
            this.abilityToGetExperience = abilityToGetExperience;
            return this;
        }

        public StudentBuilder setHasLaptop(boolean hasLaptop) {
            this.hasLaptop = hasLaptop;
            return this;
        }

        public StudentBuilder setIsInUniversity(boolean inUniversity) {
            this.isInUniversity = inUniversity;
            return this;
        }

        public StudentBuilder setIsInInternship(boolean inInternship) {
            this.isInInternship = inInternship;
            return this;
        }

        public StudentBuilder setIName(String name) {
            this.name = name;
            return this;
        }

        public Student build() {
            return new Student(this);
        }

    }

}

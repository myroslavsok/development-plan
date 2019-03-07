package com.company;

import com.company.Education.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        LocalDate beginnigOfPlanDate = LocalDate.of(2019, 9,1);

        University chdtu = new University(3, 2);
        Internship interlink = new Internship(3, 4);
        SelfDevelopment solvindLogicalQuizes = new SelfDevelopment(3, 3);
        Meetup ITintroduction = new Meetup(4, 3);

        Student Alice = new Student.StudentBuilder()
                            .setHasLaptop(true)
                            .build();
        Student Bob = new Student.StudentBuilder()
                            .setHasLaptop(true)
                            .setIsInInternship(true)
                            .build();
        Student Connor = new Student.StudentBuilder()
                            .build();
        Student Den = new Student.StudentBuilder()
                            .setHasLaptop(true)
                            .setIsInUniversity(true)
                            .setIsInInternship(true)
                            .build();

//        PlanCompositor palnPacifist = new PlanCompositor(beginnigOfPlanDate.plusYears(7));

//        Arrangement codePartyWithFriends = new Arrangement()


    }
}

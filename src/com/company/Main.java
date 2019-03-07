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

//        Student Alice = new Student();

        PlanCompositor palnPacifist = new PlanCompositor(beginnigOfPlanDate.plusYears(7));


//        Arrangement codePartyWithFriends = new Arrangement()


    }
}

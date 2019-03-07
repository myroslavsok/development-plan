package com.company;

import com.company.Education.*;
import com.company.studyConditions.ArrangedDay;
import com.company.studyConditions.AtAnyDay;
import com.company.studyConditions.AtWorkingDays;
import com.company.studyConditions.OncePerMonth;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        LocalDate beginnigOfPlanDate = LocalDate.of(2019, 9,1);

        University bachelorDegree = new University(3, 2);
        University magesterDegree = new University(2, 3);
        Internship interlink = new Internship(3, 4);
        SelfDevelopment solvindLogicalQuizes = new SelfDevelopment(3, 3);
        Meetup ITinteractive = new Meetup(4, 3);

        DevelopmentActivity gettingBachelor = new DevelopmentActivity(bachelorDegree, new AtWorkingDays());
        DevelopmentActivity gettingMagister = new DevelopmentActivity(magesterDegree, new AtWorkingDays());
        DevelopmentActivity studingAtInternship = new DevelopmentActivity(interlink, new AtWorkingDays());
        DevelopmentActivity selfDeveloping = new DevelopmentActivity(solvindLogicalQuizes, new AtAnyDay());
        DevelopmentActivity attendingMeetups = new DevelopmentActivity(ITinteractive, new OncePerMonth());


        Student Alice = new Student.StudentBuilder()
                            .setIName("Alice")
                            .setHasLaptop(true)
                            .setIsInUniversity(true)
                            .build();
        Student Bob = new Student.StudentBuilder()
                            .setIName("Bob")
                            .setHasLaptop(true)
                            .setIsInInternship(true)
                            .build();
        Student Connor = new Student.StudentBuilder()
                            .setIName("Connor")
                            .setIsInUniversity(true)
                            .build();
        Student Den = new Student.StudentBuilder()
                            .setIName("Den")
                            .setHasLaptop(true)
                            .setIsInUniversity(true)
                            .setIsInInternship(true)
                            .build();

        PlanCompositor planPacifist = new PlanCompositor();
        planPacifist.setBeginningDate(beginnigOfPlanDate);
        planPacifist.addToSchedule(gettingBachelor, beginnigOfPlanDate.plusYears(5));
        planPacifist.addToSchedule(gettingMagister, beginnigOfPlanDate.plusYears(2));
        planPacifist.applyScheduleForStudent(Alice);

        PlanCompositor planSelfDevelopment = new PlanCompositor();
        planSelfDevelopment.setBeginningDate(beginnigOfPlanDate);
        planSelfDevelopment.addToSchedule(selfDeveloping, beginnigOfPlanDate.plusYears(7));
        planSelfDevelopment.addToSchedule(attendingMeetups, beginnigOfPlanDate.plusYears(7));
        planSelfDevelopment.addToSchedule(studingAtInternship, beginnigOfPlanDate.plusMonths(3));
        planSelfDevelopment.applyScheduleForStudent(Bob);

        PlanCompositor planLearnMeAbsolutely = new PlanCompositor();
        planLearnMeAbsolutely.addToSchedule(gettingBachelor, beginnigOfPlanDate.plusYears(5));
        planLearnMeAbsolutely.addToSchedule(attendingMeetups, beginnigOfPlanDate.plusYears(7));
        planLearnMeAbsolutely.applyScheduleForStudent(Connor);


        PlanCompositor planSelfConsiderate = new PlanCompositor();
        planSelfConsiderate.addToSchedule(gettingBachelor, beginnigOfPlanDate.plusYears(3));
        planSelfConsiderate.addToSchedule(attendingMeetups, beginnigOfPlanDate.plusYears(7));
        planSelfConsiderate.addToSchedule(selfDeveloping, beginnigOfPlanDate.plusYears(7));
        planSelfConsiderate.addToSchedule(studingAtInternship, beginnigOfPlanDate.plusMonths(3));

        Arrangement ITparty = new Arrangement(Alice);
        Arrangement askExpertForAdvise = new Arrangement(Bob);
        Arrangement ITComunity = new Arrangement(Connor);

        DevelopmentActivity visitingParties = new DevelopmentActivity(ITparty, new ArrangedDay(beginnigOfPlanDate.plusYears(5)));
        DevelopmentActivity comunicationWithExperts = new DevelopmentActivity(askExpertForAdvise,
                                                                              new ArrangedDay(beginnigOfPlanDate.plusYears(6)));
        DevelopmentActivity onlineComunication = new DevelopmentActivity(ITComunity, new ArrangedDay(beginnigOfPlanDate.plusYears(7)));
        planSelfConsiderate.applyScheduleForStudent(Den);
        
        ArrayList<Student> students = new ArrayList<>();
        students.add(Alice);
        students.add(Bob);
        students.add(Connor);
        students.add(Den);

        students.forEach(student -> {
            System.out.println(student.getName() + ": ");
            student.showSkills();
            System.out.println();
        });

    }
}

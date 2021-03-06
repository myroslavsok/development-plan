import com.company.DevelopmentActivity;
import com.company.Education.*;
import com.company.PlanCompositor;
import com.company.Student;
import com.company.studyConditions.ArrangedDay;
import com.company.studyConditions.AtAnyDay;
import com.company.studyConditions.AtWorkingDays;
import com.company.studyConditions.OncePerMonth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class studentPlanTest {

    private Student student;
    private Student studentAllInclusive;

    private PlanCompositor plan;
    private DevelopmentActivity universityStuding,
                                meetupAttending,
                                selfDev,
                                internshipStuding,
                                meetingWithFriend;

    private University chdtu;
    private final int UnivKnowledge = 3;
    private final int UnivExp = 2;

    private Meetup OOPMeetup;
    private final int meetupKnowledge = 4;
    private final int meetupExperience = 3;


    private SelfDevelopment doingHakerRank;
    private final int selfDevKnowledge = 3;
    private final int selfDevExperience = 3;

    private Internship interlink;
    private final int interlinkKnowledge = 3;
    private final int interlinkExperience = 4;

    private ArrangedDay explainingOOPMeeting;

    private LocalDate startPlanDate;

    @BeforeEach
    void setUp() {
        startPlanDate = LocalDate.of(2019, 3, 1);

        student = new Student.StudentBuilder().build();
        studentAllInclusive = new Student.StudentBuilder()
                                    .setHasLaptop(true)
                                    .setIsInInternship(true)
                                    .setIsInUniversity(true)
                                    .build();

        OOPMeetup = new Meetup(meetupKnowledge, meetupExperience);
        doingHakerRank = new SelfDevelopment(selfDevKnowledge, selfDevExperience);
        chdtu = new University(UnivKnowledge, UnivExp);
        interlink = new Internship(interlinkKnowledge, interlinkExperience);

        universityStuding = new DevelopmentActivity(chdtu, new AtWorkingDays());
        meetupAttending = new DevelopmentActivity(OOPMeetup, new OncePerMonth());
        selfDev = new DevelopmentActivity(doingHakerRank, new AtAnyDay());
        internshipStuding = new DevelopmentActivity(interlink, new AtWorkingDays());
    }

    @Test
    void applyPlan__university__anyDay__isNotParticipant() {
        plan = new PlanCompositor();
        plan.setBeginningDate(startPlanDate);
        plan.addToSchedule(universityStuding, startPlanDate.plusMonths(1));
        plan.applyScheduleForStudent(student);

        assertThat(student.getKnowledge(), is(0.0));
        assertThat(student.getExperience(), is(0.0));
    }

    @Test
    void applyPlan__university__anyDay__isParticipant() {
        plan = new PlanCompositor();
        plan.setBeginningDate(startPlanDate);
        plan.addToSchedule(universityStuding, startPlanDate.plusMonths(1));
        plan.applyScheduleForStudent(studentAllInclusive);

        assertThat(studentAllInclusive.getKnowledge(), is(63.0));
        assertThat(studentAllInclusive.getExperience(), is(42.0));
    }

    @Test
    void applyPlan__meetup__noLaptop() {
        plan = new PlanCompositor();
        plan.addToSchedule(meetupAttending, startPlanDate.plusMonths(2));
        plan.applyScheduleForStudent(student);

        assertThat(student.getKnowledge(), is(8.0));
        assertThat(student.getExperience(), is(0.0));
    }

    @Test
    void applyPlan__meetup__hasLaptop() {
        plan = new PlanCompositor();
        plan.addToSchedule(meetupAttending, startPlanDate.plusMonths(2));
        plan.applyScheduleForStudent(studentAllInclusive);

        assertThat(studentAllInclusive.getKnowledge(), is(8.0));
        assertThat(studentAllInclusive.getExperience(), is(6.0));
    }

    @Test
    void applyPlan__internship__isParticipant() {
        plan = new PlanCompositor();
        plan.setBeginningDate(startPlanDate);
        plan.addToSchedule(internshipStuding, startPlanDate.plusMonths(1));
        plan.applyScheduleForStudent(studentAllInclusive);

        assertThat(studentAllInclusive.getKnowledge(), is(63.0));
        assertThat(studentAllInclusive.getExperience(), is(84.0));
    }

    @Test
    void applyPlan__internship__isNotParticipant() {
        plan = new PlanCompositor();
        plan.setBeginningDate(startPlanDate);
        plan.addToSchedule(internshipStuding, startPlanDate.plusMonths(1));
        plan.applyScheduleForStudent(student);

        assertThat(student.getKnowledge(), is(0.0));
        assertThat(student.getExperience(), is(0.0));
    }

    @Test
    void applyPlan__meetup__fewActivities() {
        plan = new PlanCompositor();
        plan.setBeginningDate(startPlanDate); // 21 working day 31 total
        plan.addToSchedule(selfDev, startPlanDate.plusMonths(1));
        plan.addToSchedule(universityStuding, startPlanDate.plusMonths(1));
        plan.applyScheduleForStudent(studentAllInclusive);

        assertThat(studentAllInclusive.getKnowledge(), is(156.0));
        assertThat(studentAllInclusive.getExperience(), is(135.0));
    }

    @Test
    void applyPlan__arrangement_arrangedDay() {
        plan = new PlanCompositor();
        plan.setBeginningDate(startPlanDate);
        plan.addToSchedule(selfDev, startPlanDate.plusDays(10));
        plan.applyScheduleForStudent(studentAllInclusive); // result: studentAllInclusive knowledge 30, exp 30

        Arrangement explainingOOP = new Arrangement(studentAllInclusive);
        DevelopmentActivity meetingWithFriends = new DevelopmentActivity(explainingOOP,
                                                 new ArrangedDay(startPlanDate.plusDays(10)));
        plan = new PlanCompositor();
        plan.setBeginningDate(startPlanDate);
        plan.addToSchedule(meetingWithFriends, startPlanDate.plusMonths(1));
        plan.applyScheduleForStudent(student);

        assertThat(student.getKnowledge(), is(6.0));
        assertThat(student.getExperience(), is(6.0));
    }

    @Test
    void applyPlan__differentDurationOfPlanEvents() {
        plan = new PlanCompositor();
        plan.setBeginningDate(startPlanDate);
        plan.addToSchedule(selfDev, startPlanDate.plusMonths(2));
        plan.addToSchedule(universityStuding, startPlanDate.plusMonths(1));
        plan.applyScheduleForStudent(studentAllInclusive);

        assertThat(studentAllInclusive.getKnowledge(), is(246.0));
        assertThat(studentAllInclusive.getExperience(), is(225.0));
    }

}
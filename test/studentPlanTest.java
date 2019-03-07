import com.company.DevelopmentActivity;
import com.company.Education.*;
import com.company.PlanCompositor;
import com.company.Student;
import com.company.studyConditions.ArrangedDay;
import com.company.studyConditions.AtAnyDay;
import com.company.studyConditions.AtWorking;
import com.company.studyConditions.OncePerMonth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
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

        student = new Student();
        studentAllInclusive = new Student(1, 1,true, true, true);

        chdtu = new University(UnivKnowledge, UnivExp);
        OOPMeetup = new Meetup(meetupKnowledge, meetupExperience);
        doingHakerRank = new SelfDevelopment(selfDevKnowledge, selfDevExperience);
        interlink = new Internship(interlinkKnowledge, interlinkExperience);
//        explainingOOPMeeting = new ArrangedDay();

        universityStuding = new DevelopmentActivity(chdtu, new AtWorking());
        meetupAttending = new DevelopmentActivity(OOPMeetup, new OncePerMonth());
        selfDev = new DevelopmentActivity(doingHakerRank, new AtAnyDay());
        internshipStuding = new DevelopmentActivity(interlink, new AtWorking());
//        meetingWithFriend = new DevelopmentActivity(explainingOOPMeeting, new ArrangedDay(LocalDate.of(2019, 2,3)));

    }

    @Test
    void applyPlan__university__anyDay__isNotParticipant() {
        plan = new PlanCompositor(startPlanDate.plusMonths(1)); // trouble
        plan.setBeginningDate(startPlanDate);
        plan.addToSchedule(universityStuding);
        plan.applyScheduleForStudent(student);

        assertThat(student.getKnowledge(), is(0.0));
        assertThat(student.getExperience(), is(0.0));
    }

    @Test
    void applyPlan__university__anyDay__isParticipant() {
        plan = new PlanCompositor(startPlanDate.plusMonths(1)); // 21 working day
        plan.setBeginningDate(startPlanDate);
        plan.addToSchedule(universityStuding);
        plan.applyScheduleForStudent(studentAllInclusive);

        assertThat(studentAllInclusive.getKnowledge(), is(63.0));
        assertThat(studentAllInclusive.getExperience(), is(42.0));
    }

    @Test
    void applyPlan__meetup__noLaptop() {
        plan = new PlanCompositor(LocalDate.now().plusMonths(2));
        plan.addToSchedule(meetupAttending);
        plan.applyScheduleForStudent(student);

        assertThat(student.getKnowledge(), is(8.0));
        assertThat(student.getExperience(), is(0.0));
    }

    @Test
    void applyPlan__meetup__hasLaptop() {
        plan = new PlanCompositor(LocalDate.now().plusMonths(2));
        plan.addToSchedule(meetupAttending);
        plan.applyScheduleForStudent(studentAllInclusive);

        assertThat(studentAllInclusive.getKnowledge(), is(8.0));
        assertThat(studentAllInclusive.getExperience(), is(6.0));
    }

    @Test
    void applyPlan__internship__isParticipant() {
        plan = new PlanCompositor(startPlanDate.plusMonths(1)); // 21 working day
        plan.setBeginningDate(startPlanDate);
        plan.addToSchedule(internshipStuding);
        plan.applyScheduleForStudent(studentAllInclusive);

        assertThat(studentAllInclusive.getKnowledge(), is(63.0));
        assertThat(studentAllInclusive.getExperience(), is(84.0));
    }

    @Test
    void applyPlan__internship__isNotParticipant() {
        plan = new PlanCompositor(startPlanDate.plusMonths(1)); // 21 working day
        plan.setBeginningDate(startPlanDate);
        plan.addToSchedule(internshipStuding);
        plan.applyScheduleForStudent(student);

        assertThat(student.getKnowledge(), is(0.0));
        assertThat(student.getExperience(), is(0.0));
    }

    @Test
    void applyPlan__meetup__fewActivities() {
        plan = new PlanCompositor(startPlanDate.plusMonths(1)); // 21 working day 31 total
        plan.setBeginningDate(startPlanDate);
        plan.addToSchedule(selfDev);
        plan.addToSchedule(universityStuding);
        plan.applyScheduleForStudent(studentAllInclusive);

        assertThat(studentAllInclusive.getKnowledge(), is(156.0));
        assertThat(studentAllInclusive.getExperience(), is(135.0));
    }

    @Test
    void applyPlan__arrangement_arrangedDay() {
        plan = new PlanCompositor(startPlanDate.plusDays(10));
        plan.setBeginningDate(startPlanDate);
        plan.addToSchedule(selfDev);
        plan.applyScheduleForStudent(studentAllInclusive); // result: studentAllInclusive knowledge 30, exp 30

        Arrangement explainingOOP = new Arrangement(studentAllInclusive);
        DevelopmentActivity meetingWithFriends = new DevelopmentActivity(explainingOOP,
                                                 new ArrangedDay(startPlanDate.plusDays(10)));
        plan = new PlanCompositor(startPlanDate.plusMonths(1));
        plan.setBeginningDate(startPlanDate);
        plan.addToSchedule(meetingWithFriends);
        plan.applyScheduleForStudent(student);

        assertThat(student.getKnowledge(), is(6.0));
        assertThat(student.getExperience(), is(6.0));
    }

}
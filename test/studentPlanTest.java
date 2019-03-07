import com.company.DevelopmentActivity;
import com.company.Education.Meetup;
import com.company.Education.University;
import com.company.PlanCompositor;
import com.company.Student;
import com.company.studyConditions.AtAnyDay;
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
                                meetupAttending;

    private University chdtu;
    private final int UnivKnowledge = 3;
    private final int UnivExp = 2;

    private Meetup OOPMeetup;
    private final int meetupKnowledge = 4;
    private final int meetupExperience = 3;

//    private Meetup WorkshopMeetup;
//    private final int


    @BeforeEach
    void setUp() {
        student = new Student();
        studentAllInclusive = new Student(1, true, true, true);

        chdtu = new University(UnivKnowledge, UnivExp);
        OOPMeetup = new Meetup(meetupKnowledge, meetupExperience);

        universityStuding = new DevelopmentActivity(chdtu, new AtAnyDay());
        meetupAttending = new DevelopmentActivity(OOPMeetup, new OncePerMonth());
    }

    @Test
    void applyPlan__university__anyDay__isNotParticipant() {
        plan = new PlanCompositor(LocalDate.now().plusDays(5)); // trouble
        plan.addToSchedule(universityStuding);
        plan.applyScheduleForStudent(student);

        assertThat(student.getKnowledge(), is(0.0));
        assertThat(student.getExperience(), is(0.0));
    }

    @Test
    void applyPlan__university__anyDay__isParticipant() {
        plan = new PlanCompositor(LocalDate.now().plusDays(5)); // trouble
        plan.addToSchedule(universityStuding);
        plan.applyScheduleForStudent(studentAllInclusive);

        assertThat(studentAllInclusive.getKnowledge(), is(15.0));
        assertThat(studentAllInclusive.getExperience(), is(10.0));
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


}
import com.company.Education.PlanCompositor;
import com.company.Education.University;
import com.company.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class studentPlanTest {

    private Student student;
    private University chdtu;
    private PlanCompositor fastPlan;

    private int UnivKnowledge = 3;
    private int UnivExp = 2;

    @BeforeEach
    void setUp() {
        student = new Student();
        chdtu = new University(UnivKnowledge,UnivExp);
        fastPlan = new PlanCompositor(LocalDate.now().plusDays(5));
    }

    @Test
    void createStudent() {
        fastPlan.addToSchedule(chdtu);
        fastPlan.applyScheduleForStudent(student);

        assertThat(student.getKnowledge(), is(15.0));
        assertThat(student.getExperience(), is(10.0));
    }

}
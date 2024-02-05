package br.dev.hebio.entranceexamregistrationapi.domain.model.course;

import br.dev.hebio.entranceexamregistrationapi.domain.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testSaveAndFindCourse() {
        Course course = new Course();
        course.setName("Direito");
        course.setModality("Graduação");
        course.setDuration("5 anos");
        course.setMode("Presencial");
        course.setUnit("HebIO Dev");
        course.setPeriod("Noturno");
        course.setMonthlyFee("R$ 780,00");
        course.setDescription("O curso de Direito da HebIO Dev tem como objetivo geral o desenvolvimento de um curso de Ciências Jurídicas, voltado para o conhecimento jurídico com formação humanista.");
        course.setActive(true);

        courseRepository.save(course);

        Course courseFound = courseRepository.findById(course.getId()).get();

        assertThat(courseFound).isNotNull();
        assertThat(courseFound.getId()).isNotNull();
        assertThat(courseFound.getName()).isEqualTo(course.getName());
        assertThat(courseFound.getModality()).isEqualTo(course.getModality());
        assertThat(courseFound.getDuration()).isEqualTo(course.getDuration());
        assertThat(courseFound.getMode()).isEqualTo(course.getMode());
        assertThat(courseFound.getUnit()).isEqualTo(course.getUnit());
        assertThat(courseFound.getPeriod()).isEqualTo(course.getPeriod());
        assertThat(courseFound.getMonthlyFee()).isEqualTo(course.getMonthlyFee());
        assertThat(courseFound.getDescription()).isEqualTo(course.getDescription());
        assertThat(courseFound.getActive()).isEqualTo(course.getActive());
    }
}

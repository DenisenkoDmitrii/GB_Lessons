package Lesson_04;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    //1.29
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @DisplayName("Расчёт площади треугольника")
    void GetSquareTestValid() throws My_isTriangleException {
        Triangle triangle = new Triangle(4, 4, 4);
        assertEquals(6.928203230275509, triangle.getSquare());
    }

    @Test//(expected = My_isTriangleException.class) не работает expected
    public void GetSquareTestException1() {
        Triangle triangle = new Triangle(-4, 4, 4);
        Throwable exception = null;
        try {
            triangle.getSquare();
        } catch (My_isTriangleException e) {
            exception = new My_isTriangleException();
        }
        assertEquals(exception.getMessage(), "ОШИБКА");
    }

    @Test
    void GetSquareTestException2() {
        Triangle triangle = new Triangle(4, 4, 100);
        Throwable exception = assertThrows(My_isTriangleException.class, triangle::getSquare);
        //Вариант через лямбду:
        //Throwable exception = assertThrows(My_isTriangleException.class, () -> {triangle.getSquare();});
        assertNotNull(exception.getMessage());
    }

    //AssertJ / catch-throwable (http://barancev.github.io/junit-catch-throwable/)
    @Test
    void GetSquareTestException3() {
        Triangle triangle = new Triangle(4, 4, 100);
        Throwable exception = catchThrowable(() -> {
            triangle.getSquare();
        });
        assertThat(exception).isInstanceOf(My_isTriangleException.class);
        assertThat(exception.getMessage()).isNotBlank();
    }


}

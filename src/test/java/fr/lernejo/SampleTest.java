package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

    @Test
    void op_test() {
        Sample sample = new Sample();

        int a = 5;
        int b = 10;

        int expectedAdd = 15;
        int expectedMul = 50;

        Assertions.assertThat(sample.op(Sample.Operation.ADD, a, b))
            .isEqualTo(expectedAdd);
        Assertions.assertThat(sample.op(Sample.Operation.MULT, a, b))
            .isEqualTo(expectedMul);
    }

    @Test
    void fact_throws() {
        Sample sample = new Sample();

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> sample.fact(-1))
            .withMessage("N should be positive");
    }

    @Test
    void fact_calc() {
        Sample sample = new Sample();

        Assertions.assertThat(sample.fact(10))
            .isEqualTo(3628800);
    }
}

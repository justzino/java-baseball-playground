package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class StringCalculatorTest {

    private StringCalculator sc;

    @BeforeEach
    void setUp() {
        // given
        sc = new StringCalculator();
    }

    private static Stream<Arguments> provideSuccessStringToCalculate() {
        return Stream.of(
                Arguments.of("1 + 2", 3),
                Arguments.of("2 + 3", 5),
                Arguments.of("3 - 1", 2),
                Arguments.of("10 * 3", 30),
                Arguments.of("39 / 3 + 5 - 2", 16),
                Arguments.of("39 / 2 + 1", 20.5),
                Arguments.of("39 - 3 / 3 + 4", 16)
        );
    }

    @ParameterizedTest
    @MethodSource("provideSuccessStringToCalculate")
    @DisplayName("복잡한 성공 케이스 연산 테스트")
    void complexCalculation(String str, double expected) {
        assertThat(sc.calculate(str)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + + 2 - ", "+ 2 + 1"})
    @DisplayName("이상한 문자열이 들어오는 경우")
    void failStringException(String str) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> sc.calculate(str));
    }

    @Test
    @DisplayName("예외 처리: int 0 으로 나누기")
    void divideByIntZeroException() {
        // when
        String formula = "5 / 0";
        //then
        assertDoesNotThrow(() -> sc.calculate(formula));
    }

    @Test
    @DisplayName("예외 처리: double 0 으로 나누기")
    void divideByDoubleZeroException() {
        // given
        String formula = " 5.6 / 0";

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> sc.calculate(formula));
    }
}

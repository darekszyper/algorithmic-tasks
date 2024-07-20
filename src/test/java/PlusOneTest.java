import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {

    PlusOne underTest;

    @BeforeEach
    void setUp() {
        underTest = new PlusOne();
    }


    @ParameterizedTest
    @MethodSource("provideDigitsAndResult")
    @DisplayName("Given array of digits should return correct result")
    void plusOne_ArrayOfDigits_CorrectResult(int[] digits, int[] expectedResult) {
        // When
        int[] result = underTest.plusOne(digits);

        // Then
        assertArrayEquals(expectedResult, result);
    }

    private static Stream<Arguments> provideDigitsAndResult() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, new int[]{1,2,4}),
                Arguments.of(new int[]{4,3,2,1}, new int[]{4,3,2,2}),
                Arguments.of(new int[]{9}, new int[]{1,0}),
                Arguments.of(new int[]{9,8,9}, new int[]{9,9,0})
        );
    }
}
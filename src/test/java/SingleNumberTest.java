import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumberTest {

    SingleNumber underTest;

    @BeforeEach
    void setUp() {
        underTest = new SingleNumber();
    }

    @ParameterizedTest
    @MethodSource("provideArraysAndResults")
    @DisplayName("Given arrays will return unique number")
    void singleNumber_Array_UniqueNumber(int[] nums, int expectedResult) {
        // When
        int result = underTest.singleNumber(nums);

        // Then
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> provideArraysAndResults() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 1}, 1),
                Arguments.of(new int[]{4, 1, 2, 1, 2}, 4),
                Arguments.of(new int[]{1}, 1)
        );
    }

}
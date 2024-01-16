import exception.NotEnoughNumbersException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MaximumProductTest {

    MaximumProduct sut;

    @BeforeEach
    void setUp() {
        sut = new MaximumProduct();
    }

    @ParameterizedTest
    @MethodSource("provideArraysAndResults")
    @DisplayName("Given array of unsorted numbers should return maximum product of two numbers")
    void findMaximumProductOfTwoNumbers_ArrayOfUnsortedNumbers_MaximumProduct(int[] nums, int expectedResult) {
        // When
        var result = sut.findMaximumProductOfTwoNumbers(nums);

        // Then
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> provideArraysAndResults() {
        return Stream.of(
                Arguments.of(new int[]{5, 3, 2, 5, 7, 0}, 35),
                Arguments.of(new int[]{-2, -1, -3, 4, -8, 0}, 24)
        );
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Given empty array should throw NotEnoughNumbersException")
    void findMaximumProductOfTwoNumbers_EmptyArray_NotEnoughNumbersException(int[] nums) {
        assertThrows(NotEnoughNumbersException.class, () -> sut.findMaximumProductOfTwoNumbers(nums));
    }

    @Test
    @DisplayName("Given empty with one number should throw NotEnoughNumbersException")
    void findMaximumProductOfTwoNumbers_ArrayWithNotEnoughNumbers_NotEnoughNumbersException() {
        // Given
        int[] nums = new int[1];
        assertThrows(NotEnoughNumbersException.class, () -> sut.findMaximumProductOfTwoNumbers(nums));
    }
}
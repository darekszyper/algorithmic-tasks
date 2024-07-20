import exception.NoSolutionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TwoSumTest {

    private TwoSum underTest;

    @BeforeEach
    void setUp() {
        underTest = new TwoSum();
    }

    @ParameterizedTest
    @MethodSource("provideArraysTargetsAndResults")
    @DisplayName("Given array should return indices that summed return target")
    void twoSum_ArrayAndTarget_IndicesThatSumEqualsTarget(int[] nums, int target, int[] expectedResult) {
        // When
        int[] result = underTest.twoSum(nums, target);

        // Then
        assertArrayEquals(expectedResult, result);
    }


    private static Stream<Arguments> provideArraysTargetsAndResults() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Given null array should return NullPointerException")
    void twoSum_Null_NullPointerException(int[] nums) {
        // Given
        int target = 0;

        // Then
        assertThrows(NullPointerException.class, () -> underTest.twoSum(nums, target));
    }

    @Test
    @DisplayName("Give array without solution should return NoSolutionException")
    void twoSum_NoSolutionArray_NoSolutionException() {
        // Given
        int[] nums = new int[]{3, 2, 4};
        int target = 9;

        // Then
        assertThrows(NoSolutionException.class, () -> underTest.twoSum(nums, target));
    }

}
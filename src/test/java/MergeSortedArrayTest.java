import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArrayTest {

    private MergeSortedArray mergeSortedArray;

    @BeforeEach
    void setUp() {
        mergeSortedArray = new MergeSortedArray();
    }

    @ParameterizedTest
    @MethodSource("provideArrays")
    void shouldMergeArrays(int[] inputA, int m, int[] inputB, int n, int[] expectedResult) {
        // when
        mergeSortedArray.merge(inputA, m, inputB, n);

        // then
        assertArrayEquals(expectedResult, inputA);
    }

    private static Stream<Arguments> provideArrays() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3, new int[]{1,2,2,3,5,6}),
                Arguments.of(new int[]{1}, 1, new int[]{}, 0, new int[]{1}),
                Arguments.of(new int[]{0}, 0, new int[]{1}, 1, new int[]{1})
        );
    }

}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    private RemoveDuplicates removeDuplicates;

    @BeforeEach
    void setUp() {
        removeDuplicates = new RemoveDuplicates();
    }

    @ParameterizedTest
    @MethodSource("provideInputAndResultArray")
    void shouldRemoveDuplicatesInPlace(int[] input, int[] expectedResult) {
        // when
        removeDuplicates.removeDuplicates(input);

        // then
        assertArrayEquals(expectedResult, input);
    }

    private static Stream<Arguments> provideInputAndResultArray() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{1,1,2}, new int[]{1,2,2}),
                Arguments.of(new int[]{0,0,1,1,1,2,2,3,3,4}, new int[]{0,1,2,3,4,2,2,3,3,4})
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputAndNumberOfUniqueElements")
    void shouldReturnNumberOfUniqueElements(int[] input, int expectedResult) {
        // when
        final int result = removeDuplicates.removeDuplicates(input);

        // then
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> provideInputAndNumberOfUniqueElements() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1,1,2}, 2),
                Arguments.of(new int[]{0,0,1,1,1,2,2,3,3,4}, 5)
        );
    }
}
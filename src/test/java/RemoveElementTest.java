import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {

    private RemoveElement removeElement;

    @BeforeEach
    void setUp() {
        removeElement = new RemoveElement();
    }

    @ParameterizedTest
    @MethodSource("provideInputAndNumberOfElementsNotEqualToVal")
    void shouldReturnNumberOfElementsNotEqualToVal(
            int[] inputArray,
            int inputValue,
            int expectedResult
    ) {
        // when
        int result = removeElement.removeElement(inputArray, inputValue);

        // then
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> provideInputAndNumberOfElementsNotEqualToVal() {
        return Stream.of(
                Arguments.of(new int[]{3,2,2,3}, 3, 2),
                Arguments.of(new int[]{0,1,2,2,3,0,4,2}, 2, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputAndArrayAfterRemoval")
    void shouldRemoveElementsEqualToVal(
            int[] inputArray,
            int inputValue,
            int[] expectedResult
    ) {
        // when
        removeElement.removeElement(inputArray, inputValue);

        // then
        assertArrayEquals(expectedResult, inputArray);
    }

    private static Stream<Arguments> provideInputAndArrayAfterRemoval() {
        return Stream.of(
                Arguments.of(new int[]{3,2,2,3}, 3, new int[]{2,2}),
                Arguments.of(new int[]{0,1,2,2,3,0,4,2}, 2, new int[]{0,1,4,0,3})
        );
    }

}
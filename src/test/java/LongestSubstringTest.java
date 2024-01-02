import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LongestSubstringTest {

    private LongestSubstring underTest;

    @BeforeEach
    public void setUp() {
        underTest = new LongestSubstring();
    }

    @ParameterizedTest
    @MethodSource("provideRegularStringsAndResults")
    @DisplayName("Given example strings should return correct length")
    void lengthOfLongestSubstring_RegularString_CorrectLength(
            String input,
            int expectedResult
    ) {
        // When
        int result = underTest.lengthOfLongestSubstring(input);

        // Then
        assertEquals(expectedResult, result);

    }

    private static Stream<Arguments> provideRegularStringsAndResults() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("dvdf", 3),
                Arguments.of("p", 1)
        );
    }

    @Disabled
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    @DisplayName("Given blank strings should return 0")
    void lengthOfLongestSubstring_AllKindOfBlankStrings_Zero(String input) {
        // When
        int result = underTest.lengthOfLongestSubstring(input);

        //Then
        assertEquals(0, result);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Given null input should return NullPointerException")
    void lengthOfLongestSubstring_Null_NullPointerException(String input) {
        assertThrows(NullPointerException.class, () -> underTest.lengthOfLongestSubstring(input));
    }

}
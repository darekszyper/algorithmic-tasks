import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLastWordTest {

    LengthOfLastWord underTest;

    @BeforeEach
    void setUp() {
        underTest = new LengthOfLastWord();
    }

    @ParameterizedTest
    @MethodSource("provideStringsAndResults")
    @DisplayName("Given String should return correct length of the last word")
    void lengthOfLastWord_String_CorrectLength(String s, int expectedResult) {
        // When
        int result = underTest.lengthOfLastWord(s);

        // Then
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> provideStringsAndResults() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6)
        );
    }

}
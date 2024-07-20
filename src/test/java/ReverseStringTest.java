import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    ReverseString reverseString;

    @BeforeEach
    void setUp() {
        reverseString = new ReverseString();
    }

    @ParameterizedTest
    @MethodSource("provideStrings")
    void shouldReverseString(char[] input, char[] expectedResult) {
        // when
        System.out.println(input);
        reverseString.reverseString(input);
        System.out.println(input);

        // then
        assertArrayEquals(expectedResult, input);
    }

    private static Stream<Arguments> provideStrings() {
        return Stream.of(
                Arguments.of(new char[]{'h','e','l','l','o'}, new char[]{'o','l','l','e','h'}),
                Arguments.of(new char[]{'H','a','n','n','a','h'}, new char[]{'h','a','n','n','a','H'})
        );
    }

}
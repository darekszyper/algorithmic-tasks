import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class VowelAndConsonantCounterTest {

    VowelAndConsonantCounter sut;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        sut = new VowelAndConsonantCounter();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @ParameterizedTest
    @MethodSource("provideStringsAndResults")
    @DisplayName("Given String should print correct number of vowels and consonants")
    void vowelAndConsonantCounter_String_PrintCorrectNumbersOfVowelsAndConsonants(
            String input,
            String expectedResult
    ) {
        // When
        sut.vowelAndConsonantCounter(input);

        // Then
        assertEquals(expectedResult, outputStreamCaptor.toString().trim());
    }

    private static Stream<Arguments> provideStringsAndResults() {
        return Stream.of(
                of("HellO", "vowels: 2" + System.lineSeparator() + "consonants: 3"),
                of("there is a quiet Mouse", "vowels: 10" + System.lineSeparator() + "consonants: 8"),
                of("I am happy", "vowels: 4" + System.lineSeparator() + "consonants: 4")
        );
    }

    @ParameterizedTest
    @DisplayName("Given String should return String wthout whitespaces and only lowercase")
    @MethodSource("provideStringsToSimplifyAndResults")
    void simplifyString_String_SimplifiedString(String input, String expectedResult) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Given
        // Using reflection to change method access modifier
        Method simplifyStringMethod = sut.getClass().getDeclaredMethod("simplifyString", String.class);
        simplifyStringMethod.setAccessible(true);
        // When
        var result = simplifyStringMethod.invoke(sut, input);

        // Then
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> provideStringsToSimplifyAndResults() {
        return Stream.of(
                of("HellO", "hello"),
                of("there is a quiet Mouse", "thereisaquietmouse"),
                of("I am happy", "iamhappy")
        );
    }
}
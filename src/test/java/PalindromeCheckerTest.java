import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    @Test
    void isPalindrome_Palindrome_True() {
        // given
        final var palindrome = "A man, a plan, a canal: Panama";
        // when
        final var result = PalindromeChecker.isPalindrome(palindrome);
        // then
        assertTrue(result);
    }

    @Test
    void isPalindrome_NotPalindrome_False() {
        // given
        final var palindrome = "A man, a plan, a canal: Panama not";
        // when
        final var result = PalindromeChecker.isPalindrome(palindrome);
        // then
        assertFalse(result);
    }

    @Test
    void simplifyString_String_SimplifiedString() {
        // given
        final var string = "A man, a plan, a canal: Panama not123";
        final var simplifiedString = "amanaplanacanalpanamanot123";
        // when
        final var result = PalindromeChecker.simplifyString(string);
        // then
        assertEquals(simplifiedString, result);
    }
}
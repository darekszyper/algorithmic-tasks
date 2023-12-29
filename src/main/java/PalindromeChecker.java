public class PalindromeChecker {

    public static boolean isPalindrome(String s) {
        String simplifiedString = simplifyString(s);
        StringBuilder stringBuilder = new StringBuilder();

        return simplifiedString.contentEquals(stringBuilder.append(simplifiedString).reverse());
    }

    public static String simplifyString(String stringToSimplify) {
        return stringToSimplify.toLowerCase().replaceAll("[^a-z1-9]", "");
    }
}

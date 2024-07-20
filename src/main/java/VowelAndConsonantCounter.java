import java.util.HashSet;
import java.util.Set;

public class VowelAndConsonantCounter {

    private final HashSet<Character> VOWELS = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u', 'y'));

    //create parametrized test
    public void vowelAndConsonantCounter(String s) {
        int vowels = 0;
        int consonants = 0;

        String simplifiedString = simplifyString(s);

        for (int i = 0; i < simplifiedString.length(); i++) {
            if (VOWELS.contains(simplifiedString.charAt(i))) {
                vowels++;
            } else {
                consonants++;
            }
        }

        System.out.printf("vowels: %d%n", vowels);
        System.out.printf("consonants: %d%n", consonants);
    }

    private String simplifyString(String s) {
        return s.toLowerCase().replaceAll(" ", "");
    }
}

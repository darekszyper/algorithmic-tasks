import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int maxValue = 0;
        int startPointer = 0;
        Set<Character> uniqueLetters = new HashSet<>();

        for (int endPointer = 0; endPointer < s.length(); endPointer++) {
            if (!uniqueLetters.contains(s.charAt(endPointer))) {
                uniqueLetters.add(s.charAt(endPointer));
                maxValue = Math.max(maxValue, uniqueLetters.size());
            } else {
                while (uniqueLetters.contains(s.charAt(endPointer))) {
                    uniqueLetters.remove(s.charAt(startPointer));
                    startPointer++;
                }
                uniqueLetters.add(s.charAt(endPointer));
            }
        }

        return maxValue;
    }
}

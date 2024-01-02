import java.util.ArrayList;
import java.util.List;

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
        int max = 0;

        if (s.length() == 1) return 1;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (j == s.length() || s.substring(i, j).indexOf(s.charAt(j - 1)) != -1) {
                    max = Math.max(j - i, max);
                    break;
                }
            }
        }

        return max;
    }
}

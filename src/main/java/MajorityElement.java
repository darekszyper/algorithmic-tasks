import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int halfLengthOfArray = nums.length / 2;
        Map<Integer, Integer> countOfUniqueElements = new HashMap<>();
        int majorityElement = 0;

        for (int element : nums) {
            if (countOfUniqueElements.putIfAbsent(element, 1) != null) {
                countOfUniqueElements.replace(element, countOfUniqueElements.get(element) + 1);
            }
        }

        Set<Integer> elements = countOfUniqueElements.keySet();
        for (int element : elements) {
            if (countOfUniqueElements.get(element) > halfLengthOfArray) {
                majorityElement = element;
                break;
            }
        }

        return majorityElement;
    }
}

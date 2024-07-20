public class Brackets {

//    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//    You must write an algorithm with O(log n) runtime complexity.

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middlePosition;
        int element;

        while (low <= high) {
            middlePosition = (low + high) / 2;
            element = nums[middlePosition];

            if (target == element) {
                return middlePosition;
            } else if (target > element) {
                low = middlePosition + 1;
            } else {
                high = middlePosition - 1;
            }
        }

        return low;
    }
}

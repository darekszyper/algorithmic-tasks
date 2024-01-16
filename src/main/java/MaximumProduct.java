import exception.NotEnoughNumbersException;

import java.util.Arrays;

public class MaximumProduct {

    public int findMaximumProductOfTwoNumbers(int[] nums) {
        //int[] sortedArray = Arrays.stream(nums).sorted().toArray();
        Arrays.sort(nums);

        if (nums.length < 2) {
            throw new NotEnoughNumbersException("There must be at least two numbers in the array");
        }

        return Math.max(nums[0] * nums[1], nums[nums.length - 1] * nums[nums.length - 2]);
    }
}

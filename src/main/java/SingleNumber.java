/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 */
public class SingleNumber {

    /*
    public int singleNumber(int[] nums) {
        int temp;
        boolean isUnique;

        for (int i = 0; i < nums.length - 1; i++) {
            temp = nums[i];
            isUnique = false;
            for (int num : nums) {
                if (temp == num) {
                    isUnique = !isUnique;
                }
            }
            if (isUnique) {
                return temp;
            }
        }
        return nums[nums.length - 1];
    }
    */

    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}

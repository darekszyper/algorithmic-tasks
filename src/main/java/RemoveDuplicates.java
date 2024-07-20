//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
//
//Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
//
//Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
//Return k.
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int k = 1;
        int lastUniqueElementIndex = 0;

        if (nums == null) return 0;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return k;

        // we take second element and compare it to previous one
        // if they are the same we do nothing
        // if they are different we check if this element is right after previous unique element
        // if yes then we don't change an array, we only increment num of unique elements (k)
        // and we also increment lastUniqueElementIndex
        // but if this unique element is not right after previous unique element then we assign it
        // to lastUniqueElementIndex + 1, and we increment k
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i -1]) {
                k++;
                lastUniqueElementIndex++;
                if (lastUniqueElementIndex != i) {
                    nums[lastUniqueElementIndex] = nums[i];
                }
            }
        }
        return k;
    }
}

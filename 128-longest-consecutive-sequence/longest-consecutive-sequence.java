import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);   // sort the array

        int longest = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            // skip duplicates
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            // consecutive element
            else if (nums[i] == nums[i - 1] + 1) {
                count++;
            }
            // reset sequence
            else {
                count = 1;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }
}
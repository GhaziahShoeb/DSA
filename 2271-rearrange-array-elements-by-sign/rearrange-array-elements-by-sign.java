import java.util.*;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        // Result array
        int[] ans = new int[n];

        // Even index → positive, Odd index → negative
        int posIndex = 0, negIndex = 1;

        // Traverse array
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                ans[negIndex] = nums[i];
                negIndex += 2;
            } else {
                ans[posIndex] = nums[i];
                posIndex += 2;
            }
        }

        return ans;
    }
}
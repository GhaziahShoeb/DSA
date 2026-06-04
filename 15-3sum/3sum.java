import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // step 1 — sort the array
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // found a triplet!
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // move pointers first
                    left++;
                    right--;

                    // then skip duplicates by looking behind
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < 0) {
                    left++;    // sum too small, need bigger number
                } else {
                    right--;   // sum too big, need smaller number
                }
            }
        }

        return result;
    }
}
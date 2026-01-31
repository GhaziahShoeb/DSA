class Solution {
    public int[] twoSum(int[] nums, int target) {
//hello
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{ map.get(complement), i };
            }

            map.put(nums[i], i); // put AFTER checking
        }

        return new int[]{}; // only if no solution found
    }
}

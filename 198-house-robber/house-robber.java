class Solution {

    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return rob(nums, nums.length - 1, dp);
    }

    private int rob(int[] nums, int i, Integer[] dp) {
        if (i < 0) return 0;

        if (dp[i] != null) return dp[i];

        int pick = rob(nums, i - 2, dp) + nums[i];
        int skip = rob(nums, i - 1, dp);

        dp[i] = Math.max(pick, skip);
        return dp[i];
    }
}


class Solution {
    public int maxSubArray(int[] nums) {
        int curr_sumsofar = nums[0];
        int max_sumsofar = nums[0];

        for(int i = 1;i<nums.length;i++){
            curr_sumsofar = Math.max(nums[i],nums[i]+curr_sumsofar);
            max_sumsofar = Math.max(curr_sumsofar,max_sumsofar);
        }
        return max_sumsofar;
    }
}
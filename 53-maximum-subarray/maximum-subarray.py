class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curr = nums[0]
        max_sum = nums[0]

        for i in range(1,len(nums)):
            curr = max(nums[i], nums[i]+curr)
            max_sum = max(max_sum , curr)
        return max_sum

        
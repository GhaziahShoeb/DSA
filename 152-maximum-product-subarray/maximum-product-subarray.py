class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        curr_max = curr_min = result = nums[0]

        for i in range(1, len(nums)):

            new_curr_max = max(nums[i], curr_max * nums[i] , curr_min * nums[i])
            new_curr_min = min(nums[i], curr_max * nums[i] , curr_min * nums[i])

            curr_max = new_curr_max
            curr_min = new_curr_min

            result = max(result , curr_max)
        return result
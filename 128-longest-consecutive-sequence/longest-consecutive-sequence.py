class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:

        if not nums:
            return 0

        count = 1
        longest = 1
        nums.sort()

        for i in range(1,len(nums)):
            if nums[i] == nums[i-1]:
                continue
            if nums[i] == nums[i-1] + 1:
                count += 1
                longest = max(longest , count)
            elif nums[i] != nums[i-1] + 1:
                count = 1
        return longest
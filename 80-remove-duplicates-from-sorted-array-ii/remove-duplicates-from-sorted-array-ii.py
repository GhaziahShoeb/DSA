class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        k = 0
        for x in range(len(nums)):
            if k < 2 or nums[x] != nums[k-2]:
                nums[k] = nums[x]
                k += 1
        return k
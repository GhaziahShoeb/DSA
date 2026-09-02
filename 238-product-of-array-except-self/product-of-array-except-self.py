class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        zero_count = nums.count(0)
        if zero_count > 1:
            return[0] * len(nums)
        total = 1
        for n in nums:
            if n!=0:
                total = total * n
        if zero_count == 1:
            return[total if n==0 else 0 for n in nums]
        return[total // n for n in nums]
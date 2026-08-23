class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        result = []
        for x in nums:
            if len(result) < 2 or result[-2] != x:
                result.append(x)
        k = len(result)
        for i in range(k):
            nums[i]  = result[i]
        return k 

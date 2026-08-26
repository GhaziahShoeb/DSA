class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        freq = {}
        for x in nums:
            if x in freq:
                freq[x] += 1
            else:
                freq[x] = 1
        nums[:]= [0] * freq.get(0,0)+ [1] * freq.get(1,0) +[2] * freq.get(2,0)

        
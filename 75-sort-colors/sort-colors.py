class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        count_0 = 0
        count_1 = 0
        count_2 = 0

        for x in nums :
            if x == 0:
                count_0 += 1
            elif x == 1:
                count_1 += 1
            else :
                count_2 += 1

        nums[:] = [0] * count_0 + [1] * count_1 + [2] * count_2
            


class Solution:
    def search(self, nums: list[int], target: int) -> int:
        left = 0
        right = len(nums) - 1

        while left <= right :
            mid = left + (right - left ) // 2

            if nums[mid] == target :
                return mid 
            elif nums[mid] < target :
                 # right side 
                 left = mid + 1
            else :
                # left side 
                right = mid - 1

        return -1



        
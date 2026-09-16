class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        first = bisect.bisect_left(nums,target)
        last =  bisect.bisect_right(nums , target) - 1

        if first <= last :
            return [first , last]
        return [-1 , -1 ]
        
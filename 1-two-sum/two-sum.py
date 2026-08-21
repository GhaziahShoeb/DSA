class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        paired = []
        for idx in range(len(nums)):
            value = nums[idx]
            paired.append([value,idx])
        paired.sort()

        left = 0
        right = len(paired) -1 

        while left < right :
            left_value = paired[left][0]
            right_value = paired[right][0]
            curr_sum = left_value + right_value

            if curr_sum == target:
                left_index = paired[left][1]
                right_index = paired[right][1]
                result = [left_index , right_index ]
                result.sort()
                return result
            elif curr_sum < target:
                left += 1
            else:
                right -= 1
        return []

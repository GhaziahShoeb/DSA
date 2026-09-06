class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        seen = {0: -1}
        curr_sum = 0

        for i , num in enumerate(nums):
            curr_sum = curr_sum + num
            remainder = curr_sum % k

            if remainder in seen:
                if i - seen[remainder] >= 2:
                    return True
            else:
                seen[remainder] = i
        return False

        
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = {0:1}
        running_sum = 0
        result = 0

        for num in nums:
            running_sum = running_sum + num

            if (running_sum - k) in count : 
                result = result + count[running_sum - k]

            count[running_sum] = count.get(running_sum , 0) + 1
        return result
        
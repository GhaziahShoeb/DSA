class Solution:

    def canSplit(self, nums, max_sum, k):

        subarrays = 1
        current_sum = 0

        for num in nums:

            if current_sum + num > max_sum:
                subarrays += 1
                current_sum = 0

            current_sum += num

        return subarrays <= k

    def splitArray(self, nums, k):

        left = max(nums)
        right = sum(nums)

        while left < right:

            mid = left + (right - left) // 2

            if self.canSplit(nums, mid, k):
                right = mid
            else:
                left = mid + 1

        return left   
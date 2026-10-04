class Solution:
    def rob(self, nums):
        # If there's only one house, just rob it
        if len(nums) == 1:
            return nums[0]

        # Solve for a straight line of houses
        def rob_line(houses):
            take = 0   # best money if we rob the previous house
            skip = 0   # best money if we skip the previous house

            for money in houses:
                new_take = skip + money      # rob this house
                new_skip = max(take, skip)   # skip this house
                take, skip = new_take, new_skip

            return max(take, skip)

        # Option 1: skip the last house
        option1 = rob_line(nums[:-1])

        # Option 2: skip the first house
        option2 = rob_line(nums[1:])

        return max(option1, option2)
        
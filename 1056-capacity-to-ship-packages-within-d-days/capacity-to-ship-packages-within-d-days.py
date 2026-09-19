class Solution:

    def canShip(self, weights, capacity, days):

        current_weight = 0
        days_needed = 1

        for weight in weights:

            if current_weight + weight > capacity:
                days_needed += 1
                current_weight = 0

            current_weight += weight

        return days_needed <= days

    def shipWithinDays(self, weights, days):

        left = max(weights)
        right = sum(weights)

        while left < right:

            mid = left + (right - left) // 2

            if self.canShip(weights, mid, days):
                right = mid
            else:
                left = mid + 1

        return left
class Solution:

    def canEatAll(self, piles, speed, h):

        hours = 0

        for pile in piles:
            hours += pile // speed

            if pile % speed != 0:
                hours += 1

        return hours <= h

    def minEatingSpeed(self, piles, h):

        left = 1
        right = max(piles)

        while left < right:

            mid = left + (right - left) // 2

            if self.canEatAll(piles, mid, h):
                right = mid
            else:
                left = mid + 1

        return left
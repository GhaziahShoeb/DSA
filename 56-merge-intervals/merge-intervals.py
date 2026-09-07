class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals:
            return[]

        intervals.sort()
        result = [intervals[0]]

        for interval in intervals[1:]:
            last = result[-1]

            if interval[0] <= last[1]:
                last[1] = max(last[1],interval[1])
            else:
                result.append(interval)
        return result
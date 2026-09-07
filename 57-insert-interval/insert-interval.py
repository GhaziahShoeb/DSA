class Solution:
    def insert(self, interval: List[List[int]], newinterval: List[int]) -> List[List[int]]:
        result = []
        i = 0
        n = len(interval)

        while i < n and interval[i][1] < newinterval[0]:
            result.append(interval[i])
            i+=1

        while i < n and interval[i][0] <= newinterval[1]:
            newinterval[0] = min(newinterval[0] , interval[i][0])
            newinterval[1] = max(newinterval[1], interval[i][1])
            i+=1
        result.append(newinterval)

        while i< n:
            result.append(interval[i])
            i+=1
        return result
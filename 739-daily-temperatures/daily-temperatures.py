class Solution:
    def dailyTemperatures(self, temp: List[int]) -> List[int]:
        result = [0] * len(temp)
        stack = []

        for i in range(len(temp)):
            while stack and temp[i] > temp[stack[-1]]:
                j = stack.pop()
                result[j] = i - j
            stack.append(i)
        return result 
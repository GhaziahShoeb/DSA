class Solution:
    def permute(self, nums: list[int]) -> list[list[int]]:
        n = len(nums)

        result = []

        for candidate in product(nums , repeat = n):
            if len(set(candidate)) == n:
                result.append(list(candidate))
        return result


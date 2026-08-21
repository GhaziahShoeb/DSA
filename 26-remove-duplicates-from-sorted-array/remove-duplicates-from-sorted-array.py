class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        unique = []
        for num in nums:
            if len(unique) == 0:
                unique.append(num)
            elif num != unique[-1]:
                unique.append(num) # since it is sorted so duplicates are aaju baju so the one going into the list and the last went is same if duplicate
        for i in range(len(unique)):
            nums[i] = unique[i]

        return len(unique)
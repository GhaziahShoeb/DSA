class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        left = 0
        max_len = 0
        freq = {}

        for right in range(len(fruits)):
            if fruits[right] in freq:
                freq[fruits[right]] += 1
            else:
                freq[fruits[right]] = 1

            while len(freq) > 2:
                freq[fruits[left]] -= 1

                if freq[fruits[left]] == 0:
                    freq.pop(fruits[left])
                left += 1
            length = right - left + 1
            if length > max_len:
                max_len = length
        return max_len
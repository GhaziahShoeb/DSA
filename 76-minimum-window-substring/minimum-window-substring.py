class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""

        window_count = {}
        have = 0
        left = 0
        min_len = float('inf')
        min_left = 0

        t_count = {}
        for ch in t:
            if ch in t_count:
                t_count[ch] += 1
            else:
                t_count[ch] = 1

        need = len(t_count)

        for right in range(len(s)):
            char = s[right]
            if char in window_count:
                window_count[char] += 1
            else:
                window_count[char] = 1

            if char in t_count and window_count[char] == t_count[char]:
                have += 1

            while have == need:
                current_len = right - left + 1
                if current_len < min_len:
                    min_len = current_len
                    min_left = left

                left_char = s[left]
                window_count[left_char] -= 1
                if left_char in t_count and window_count[left_char] < t_count[left_char]:
                    have -= 1
                left += 1

        if min_len == float('inf'):
            return ""
        return s[min_left : min_left + min_len]
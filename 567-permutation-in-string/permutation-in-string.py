class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1_freq = {}
        window_len = len(s1)

        for ch in s1:
            if ch in s1_freq:
                s1_freq[ch] += 1
            else:
                s1_freq[ch] = 1
        if len(s2) < len(s1):
            return False

        window_freq = {}
        for i in range(0, window_len):
            if s2[i] in window_freq:
                window_freq[s2[i]] += 1
            else:
                window_freq[s2[i]] = 1

        if window_freq == s1_freq:
            return True

        for i in range(window_len, len(s2)):
            if s2[i] in window_freq:
                window_freq[s2[i]] += 1
            else:
                window_freq[s2[i]] = 1

            # Now remove leaving character
            leaving_char = s2[i - window_len]
            window_freq[leaving_char] -= 1

            if window_freq[leaving_char] == 0:
                del window_freq[leaving_char]

            if window_freq == s1_freq:
                return True

        return False

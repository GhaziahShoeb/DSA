class Solution:
    def letterCombinations(self, digits: str) -> list[str]:
        if len(digits) == 0:
            return []

        result = []
        path = []

        mp = {
            '2': "abc",
            '3': "def",
            '4': "ghi",
            '5': "jkl",
            '6': "mno",
            '7': "pqrs",
            '8': "tuv",
            '9': "wxyz"
        }

        def backtrack(idx):
            if idx == len(digits):
                result.append("".join(path))
                return

            letters = mp[digits[idx]]

            for letter in letters:
                path.append(letter)
                backtrack(idx+1)
                path.pop()

        backtrack(0)
        return result
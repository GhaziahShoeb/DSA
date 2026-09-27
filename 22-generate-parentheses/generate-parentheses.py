class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        result = []

        def isvalid(s):
            count = 0
            for ch in s:
                if ch == '(':
                    count += 1
                else:
                    count -= 1
                if count < 0 :
                    return False
            return count == 0

        def solve(curr):
            if len(curr) == 2 * n :
                if isvalid(curr):
                    result.append(curr)
                return
            
            solve(curr + '(')
            solve(curr + ')')

        solve("")
        return result
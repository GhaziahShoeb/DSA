class Solution:
    def rob(self, cost: list[int]) -> int:
        n = len(cost)
        if n == 1:
            return cost[0]
        dp = [0] * (n+1)
        dp[0] = cost[0]
        dp[1] = max(cost[0], cost[1])

        for i in range(2, n):
            dp[i] = max(dp[i-1] , cost[i] + dp[i-2] )

        return dp[n-1]
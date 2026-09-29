class Solution:
    def countArrangement(self, n: int) -> int:
        def count(pos, remaining):
            if pos > n:
                return 1

            total = 0

            for num in remaining:
                if num % pos == 0 or pos % num == 0:
                    total += count(pos + 1 , remaining - {num})
            return total 
        return count(1, set(range(1, n+ 1)))
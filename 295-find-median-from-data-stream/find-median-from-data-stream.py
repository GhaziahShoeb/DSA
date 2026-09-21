import heapq

class MedianFinder:
    def __init__(self):
        self.small = []   # max-heap (negated) — smaller half
        self.large = []   # min-heap (normal) — larger half

    def addNum(self, num: int) -> None:
        # Step 1: always push to small first
        heapq.heappush(self.small, -num)

        # Step 2: move small's max over to large (self-corrects any misplacement)
        val = -heapq.heappop(self.small)
        heapq.heappush(self.large, val)

        # Step 3: rebalance if large has grown bigger than small
        if len(self.large) > len(self.small):
            val = heapq.heappop(self.large)
            heapq.heappush(self.small, -val)

    def findMedian(self) -> float:
        if len(self.small) > len(self.large):
            return -self.small[0]
        else:
            return (-self.small[0] + self.large[0]) / 2


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
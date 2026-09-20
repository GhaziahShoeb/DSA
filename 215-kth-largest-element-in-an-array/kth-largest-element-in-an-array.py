import random

class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        target_index = len(nums) - k

        def quickselect(left, right):
            if left == right:
                return nums[left]

            pivot_index = random.randint(left, right)
            pivot = nums[pivot_index]

            # 3-way partition: < pivot | == pivot | > pivot
            lt = left       # everything before lt is < pivot
            gt = right      # everything after gt is > pivot
            i = left

            while i <= gt:
                if nums[i] < pivot:
                    nums[i], nums[lt] = nums[lt], nums[i]
                    lt += 1
                    i += 1
                elif nums[i] > pivot:
                    nums[i], nums[gt] = nums[gt], nums[i]
                    gt -= 1
                    # don't increment i here — the swapped-in value hasn't been checked yet
                else:
                    i += 1

            # after this loop:
            # nums[left:lt] are all < pivot
            # nums[lt:gt+1] are all == pivot
            # nums[gt+1:right+1] are all > pivot

            if target_index < lt:
                return quickselect(left, lt - 1)
            elif target_index > gt:
                return quickselect(gt + 1, right)
            else:
                return nums[target_index]   # target falls within the "== pivot" block

        return quickselect(0, len(nums) - 1)
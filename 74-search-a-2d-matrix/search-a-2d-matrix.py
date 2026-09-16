class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:

        row_idx = self.searchPotentialRow(matrix, target)

        if row_idx != -1:
            return self.binarySearchOverRow(row_idx, matrix, target)

        else:
            return False

    def searchPotentialRow(self, matrix, target):

        low = 0
        high = len(matrix) - 1

        while low <= high:

            mid = low + (high - low) // 2

            if matrix[mid][0] <= target <= matrix[mid][-1]:
                return mid

            elif matrix[mid][0] <= target:
                low = mid + 1

            else:
                high = mid - 1

        return -1

    def binarySearchOverRow(self, row_idx, matrix, target):

        low = 0
        high = len(matrix[row_idx]) - 1

        while low <= high:

            mid = low + (high - low) // 2

            if matrix[row_idx][mid] == target:
                return True

            elif matrix[row_idx][mid] > target:
                high = mid - 1

            else:
                low = mid + 1

        return False

        
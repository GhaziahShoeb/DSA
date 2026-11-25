# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def searchBST(self, root: TreeNode | None, val: int) -> TreeNode | None:
        if root is None:
            return None
        if root.val == val:
            return root

        left_result = self.searchBST(root.left, val)
        if left_result is not None:
            return left_result

        return self.searchBST(root.right, val)
        
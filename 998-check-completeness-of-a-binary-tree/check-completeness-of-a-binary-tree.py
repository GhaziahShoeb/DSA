# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCompleteTree(self, root: TreeNode | None) -> bool:
        if root is None:
            return None
        queue = deque([root])
        gap_found = False

        while queue:
            node = queue.popleft()

            if node is None:
                gap_found = True
            else:
                if gap_found:
                    return False
                queue.append(node.left)
                queue.append(node.right)
        return True

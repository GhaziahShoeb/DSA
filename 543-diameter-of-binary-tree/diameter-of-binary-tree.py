# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: TreeNode | None) -> int:
        
        def maxDepth(node):
            if node is None:
                return 0
            return 1 + max(maxDepth(node.left), maxDepth(node.right))
        
        def diameter(node):
            if node is None:
                return 0
            
            # longest path THROUGH this node
            through_node = maxDepth(node.left) + maxDepth(node.right)
            
            # longest path found in left subtree, or right subtree, or through this node
            return max(through_node, diameter(node.left), diameter(node.right))
        
        return diameter(root)
        
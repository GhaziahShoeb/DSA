from collections import deque

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        # 1. Empty tree: nothing to connect
        if root is None:
            return None

        # 2. Queue holds nodes waiting to be processed
        queue = deque([root])

        # 3. Go level by level
        while queue:
            level_size = len(queue)

            # 4. Process every node in this level
            for i in range(level_size):
                node = queue.popleft()

                # 5. If not the last node, point to the next one
                if i < level_size - 1:
                    node.next = queue[0]

                # 6. Add children for the next level
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        # 7. Return the same tree, now with next pointers
        return root
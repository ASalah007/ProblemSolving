# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
      return self.sum_nums(root)[0]

    def sum_nums(self, root: TreeNode | None) -> tuple[int, int]:
      if not root: 
        return (0, 0)
      
      v1, w1 = self.sum_nums(root.left)
      v2, w2 = self.sum_nums(root.right)
      new_weight = (w1 + w2) or 1
      new_val = v1 + v2 + new_weight*root.val
      
      return new_val, new_weight*10
      

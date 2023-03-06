class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
      b = 0
      for i in arr: 
        s = i - b - 1
        k -= s
        if k <= 0:
          return i + k -1 
        b = i
      
      return arr[-1] + k

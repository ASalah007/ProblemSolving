class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
      if len(nums) == 1: 
        return nums[0]
      
      count = len(nums)//2
      mid = (count//2) * 2 + 1
      if nums[mid] == nums[mid-1]:
        return self.singleNonDuplicate(nums[mid+1:])
      else: 
        return self.singleNonDuplicate(nums[:mid])

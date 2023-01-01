class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
      ss = s.split(" ")

      if len(ss) != len(pattern):
        return False
        
      m = {}
      p = {} 

      for i in range(len(ss)):
        if m.get(pattern[i]) and m.get(pattern[i]) != ss[i]:
          return False
        
        if p.get(ss[i]) and p.get(ss[i]) != pattern[i]:
          return False
        
        m[pattern[i]] = ss[i]
        p[ss[i]] = pattern[i]
      
      return True

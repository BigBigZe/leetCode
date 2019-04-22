class Solution:
  def backspaceCompare(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: bool
        """
        s = list()
        t = list()
        for i in S:
            if i=='#' and len(s)>0:
                s.pop()
            elif i!='#':
                s.append(list(i))
        
        for i in T:
            if i =='#' and len(t)>0:
                t.pop()
            elif i!='#':
                t.append(list(i))
        
        if len(s)!=len(t):
            return False
        else:
            for i in range(len(s)):
                if s[i]!=t[i]:
                    return False
            return True

obj = Solution()
print(obj.backspaceCompare("y#fo##f","y#f#o##f"))

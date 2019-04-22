class Solution:
    def nextGreaterElement(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        d = {}
        for i in range(len(nums2)):
            d[nums2[i]] = i
        l = list(nums1)
        for i in range(len(nums1)):
            index = d[nums1[i]]
            j = index+1
            while j<len(nums2):
                if nums2[j]>nums1[i]:
                    l[i] = nums2[j]
                    break
                else:
                    j = j+1
            if j>=len(nums2):
                l[i] = -1
        
        return l

        
        
        
        
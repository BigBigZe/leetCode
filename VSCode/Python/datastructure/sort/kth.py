def kthNum(nums,k):
    l = list(nums[0:k])

    l = sorted(l,reverse=True)
    print(l)
    for i in range(len(nums)-k):
        if nums[i+k]>l[k-1]:
            j = 0
            while j<len(l):
                if nums[i+k]>l[j]:
                    break
                j = j+1
            m = len(l)-1
            while m>j:
                l[m] = l[m-1]
                m = m-1
            l[j] = nums[i+k]
                
    
    print(l)

nums = [3,12,2,4,5,6,1,2,7,0]
kthNum(nums,5)

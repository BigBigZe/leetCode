import numpy as np
l = [4,4.1,5,6,7,8,9]
print(l)

i = 5.1
left = 0
right = len(l)-1
while left<=right:
    mid = (left+right)//2
    if l[mid]<=i:
        left = mid + 1
    else:
        right = mid - 1
l.insert(left,i)

print(l)
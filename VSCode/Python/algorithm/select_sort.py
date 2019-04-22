def smallest(arr):
    smallnum = arr[0]
    smallindex = 0
    for i in range(1,len(arr)):
        if arr[i]<smallnum:
            smallindex = i
            smallnum = arr[i]
    
    return smallindex

def sort(arr):
    newarr = []
    for i in range(len(arr)):
        num = smallest(arr)
        newarr.append(arr.pop(num)) 
    
    return newarr

print(sort([4,2,1,5,7,6]))


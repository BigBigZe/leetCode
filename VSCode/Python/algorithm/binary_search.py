def binary_search(list,item):
    low = 0 
    high = len(list)-1
    
    while low<high-1:
        mid = int((low+high)/2)
        guess = list[mid]
        if guess == item:
            return mid
        elif guess > item:
            high = mid - 1
        else:
            low = mid +1
    
    if(list[low]==item):
        return low
    else:
        return None


list = [1,2,3,4,6,7,8,10,22,33,44,55,66,77,220]

print(binary_search(list,22))
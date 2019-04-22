def quicksort(array):
    if len(array)<2:
        return array
    else :
        pivot = array[0]
        less = []
        more = []
        for i in array[1:]:
            if i<=pivot:
                less.append(i)
            else:
                more.append(i)
        
        return quicksort(less)+[pivot]+quicksort(more)

print(quicksort([10,5,2,3,1,4,7]))
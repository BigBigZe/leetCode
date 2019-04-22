def divide(a,b):
    if a==b:
        return a
    elif a>b:
        if a%b==0:
            return b
        else :
            return divide(a%b,b)
    else:
        if b%a==0:
            return a
        else :
            return divide(b%a,a)

print(divide(1680,640))
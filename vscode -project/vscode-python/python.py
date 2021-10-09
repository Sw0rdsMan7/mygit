x = eval(input())
print(x, "divisible by 2 and 3? ", end=' ')
if x%2 ==0 and x%3 ==0:
    print("Ture")
else:
    print("False")
print(x, "divisible by 2 or 3?", end=' ')
if x%2 ==0 or x%3 ==0:
    print("Ture")
else:
    print("False")
print(x, "divisible by 2 or 3, but not both?", end=' ')
if x%2 ==0 and x%3 != 0 or x%3 ==0 and x%2 != 0:
    print("Ture")
else:
    print("False")

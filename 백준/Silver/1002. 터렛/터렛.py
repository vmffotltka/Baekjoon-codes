import math
case = int(input())

for i in range(case):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    
    cDistance = math.sqrt((x1-x2)**2 + (y1-y2)**2)
    if(r2 <= r1):
        big = r1
        small = r2
    else:
        big = r2
        small = r1

    if(x1 == x2 and y1 == y2 and r1 == r2):
        print(-1)
        continue
    if(cDistance < r1 + r2):
        if(cDistance - small < big < cDistance + small):
            print(2)
            continue
        if(cDistance + small == big):
            print(1)
            continue
        if(cDistance + small < big):
            print(0)
            continue
    if(cDistance == r1 + r2):print(1)
    if(cDistance > r1 + r2):print(0)
        
        

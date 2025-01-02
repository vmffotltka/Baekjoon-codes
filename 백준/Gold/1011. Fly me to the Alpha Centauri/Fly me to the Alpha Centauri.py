case = int(input())

for i in range(case):
    x, y = map(int, input().split())
    distance = y - x
    j = 1
    count = 0
    while(True):
        if(distance <= 0):break
        k = 0
        while(distance > 0 and k < 2):
            distance -= j
            count += 1
            k += 1
        j += 1

    print(count)

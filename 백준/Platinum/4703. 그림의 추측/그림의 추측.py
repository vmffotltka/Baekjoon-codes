import sys
input = lambda: sys.stdin.readline().strip()

while 1:
    a, b = map(int, input().split())
    if a == b == 0: break
    primeList = [set() for _ in range(b-a+1)]
    for i in range(b-a+1):
        div = 2
        num = i+a
        while div * div <= num:
            if num % div == 0:
                primeList[i].add(div)
                while num % div == 0:
                    num //= div
            div += 1
        if num != 1:
            primeList[i].add(num)
    res = [0] * (b-a+1)
    idx = 0
    pushed = False; trigger = False
    while idx < b-a+1:
        if res[idx] == 0:
            if trigger:
                for val in sorted(primeList[idx]):
                    pushed = True
                    trigger = False
                    for i in range(idx, b-a+1, val):
                        if val in primeList[i]:
                            primeList[i].remove(val)
                    for i in range(idx, -1, -val):
                        if val in primeList[i]:
                            primeList[i].remove(val)
                    res[idx] = val
                    break
            elif len(primeList[idx]) == 1:
                pushed = True
                val = list(primeList[idx])[0]
                res[idx] = val
                for i in range(idx, b-a+1, val):
                    if val in primeList[i]:
                        primeList[i].remove(val)
                for i in range(idx, -1, -val):
                    if val in primeList[i]:
                        primeList[i].remove(val)
        if idx == b-a and trigger: break
        elif idx == b-a and pushed:
            idx = 0
            pushed = False
        elif idx == b-a and not pushed:
            idx = 0
            trigger = True
        elif idx == b-a: idx = 0
        else: idx += 1

    print(*res)
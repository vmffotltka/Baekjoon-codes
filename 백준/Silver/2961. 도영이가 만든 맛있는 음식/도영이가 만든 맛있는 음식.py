import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
mn = float('inf')
arr = [tuple(map(int, input().split(" "))) for _ in range(n)]

for i in range(1, 1 << n):
    sour = 1
    bitter = 0
    for j in range(n):
        if i & (1 << j):
            sour *= arr[j][0]
            bitter += arr[j][1]
    mn = min(mn, abs(sour - bitter))

print(mn)
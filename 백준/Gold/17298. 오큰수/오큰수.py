import sys
input = lambda:sys.stdin.readline().strip()

n = int(input())
arr = tuple(map(int, input().split()))
ans = [-1]*n
stack = []
for i in range(n-1, -1, -1):
    while stack:
        if arr[i] >= stack[-1]: stack.pop()
        else:
            ans[i] = stack[-1]
            break
    stack.append(arr[i])
print(*ans)
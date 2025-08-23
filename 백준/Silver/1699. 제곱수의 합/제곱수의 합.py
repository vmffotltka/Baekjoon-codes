import math

n = int(input())
dp = [0 for _ in range(n+1)]
for i in range(1, int(math.sqrt(n))+1): dp[i**2] = 1

for i in range(2, n+1):
    if dp[i] != 1: 
        minn = float('inf')
        for j in range(1, i//2+1):
            top = i-j
            put = dp[j]+dp[top]
            if put < minn: minn = put
        dp[i] = minn

print(dp[n])
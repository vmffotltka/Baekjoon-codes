n = int(input())
line = [tuple(map(int, input().split())) for _ in range(n)]
dp = [0 for _ in range(n)]

def dfs(idx):
    put = idx[0]
    if dp[put] != 0: return dp[put]

    a, b = line[put]
    newidx = []
    for i in idx:
        a2, b2 = line[i]
        if a2 > a and b2 > b: newidx.append(i)

    if not newidx:
        dp[put] = 1
        return 1
    else:
        res = float('-inf')
        for i in range(len(newidx)):
            put2 = dfs(newidx[i:])
            if res < put2: res = put2
        dp[put] = res+1
        return res+1
res = float('-inf')
line = sorted(line, key=lambda x:(x[0], x[1]))
for i in range(n):
    if dp[i] == 0:
        idx = [j for j in range(i, n)]
        put = dfs(idx)
        if res < put: res = put
print(n-res)
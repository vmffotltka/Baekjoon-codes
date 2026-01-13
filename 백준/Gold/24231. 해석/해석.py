s = input()

dp = {}
def dfs(st):
    if st.count('1') != st.count('0'): return 0
    if not st: return 1
    if st == '01' or st == '10': return 1
    if st in dp: return dp[st]

    put = st[0]
    ret = 0
    for i in range(1, len(st), 2):
        if i == 1 and st[i] != put: ret += dfs(st[2:])
        elif st[i] != put: ret += dfs(st[1:i]) * dfs(st[i+1:])

    dp[st], dp[st[::-1]] = ret, ret
    return dp[st]
print(dfs(s)%(10**9+7))
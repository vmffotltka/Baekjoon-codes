import sys
input = lambda: sys.stdin.readline().strip()
sys.setrecursionlimit(10**6)

v = int(input())
edge = [[] for _ in range(v+1)]
for _ in range(v):
    node, *data = map(int, input().split())
    for i in range(0, len(data), 2):
        if data[i] == -1: break
        edge[node].append((data[i+1], data[i]))

res = float('-inf')
visited = [False]*(v+1)
def dfs(node, w):
    global res
    visited[node] = True
    li = []
    for wei, next_node in edge[node]:
        if not visited[next_node]: li.append(dfs(next_node, wei))

    if not li:
        res = max(res, w)
        return w
    if len(li) == 1:
        res = max(res, w+li[0])
        return li[0]+w
    else:
        li = sorted(li)
        res = max(res, w+li[-1], li[-2]+li[-1])
        return li[-1]+w
dfs(1, 0)
print(res)
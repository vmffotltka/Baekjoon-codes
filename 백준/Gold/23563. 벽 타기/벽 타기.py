import sys
from collections import deque
input = lambda: sys.stdin.readline().strip()

sero, garo = map(int, input().split())
dp = [[float('inf') for _ in range(garo)] for _ in range(sero)]
data = []
for i in range(sero):
    s =input()
    if 'S' in s: sty, stx = i, s.index('S')
    if 'E' in s: ey, ex = i, s.index('E')
    data.append(s)

dy = [-1, 1, 0, 0]
dx = [0, 0, 1, -1]

def bfs(start):
    que = deque([start])
    while que:
        y, x = que.popleft()
        for i in range(4):
            yy, xx = dy[i]+y, dx[i]+x
            if 0 <= yy < sero and 0 <= xx < garo and data[yy][xx] != '#':
                put1, put2 = False, False
                for i in range(4):
                    y3, x3 = dy[i]+y, dx[i]+x
                    y4, x4 = dy[i]+yy, dx[i]+xx
                    if 0 <= y3 < sero and 0 <= x3 < garo and data[y3][x3] == '#': put1 = True
                    if 0 <= y4 < sero and 0 <= x4 < garo and data[y4][x4] == '#': put2 = True

                if put1 and put2:
                    if dp[y][x] < dp[yy][xx]:
                        dp[yy][xx] = dp[y][x]
                        que.appendleft([yy, xx])
                else:
                    if dp[y][x]+1 < dp[yy][xx]:
                        dp[yy][xx] = dp[y][x]+1
                        que.append([yy, xx])
dp[sty][stx] = 0
bfs([sty, stx])
print(dp[ey][ex])
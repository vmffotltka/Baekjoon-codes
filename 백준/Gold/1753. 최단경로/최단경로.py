import sys
import heapq

v, e = map(int, sys.stdin.readline().strip().split())
k = int(sys.stdin.readline().strip())
edge = [[] for _ in range(v+1)]
res = [float('inf') for _ in range(v+1)]
for _ in range(e):
    start, end, w = map(int, sys.stdin.readline().strip().split())
    edge[start].append((w, end))

def dijkstra(k):
    heap = []
    heapq.heappush(heap, (0, k))
    while heap:
        weight, end = heapq.heappop(heap)
        if res[end] > weight: res[end] = weight
        else: continue
        for next_weight, next_end in edge[end]:
            if next_weight + weight < res[next_end]: heapq.heappush(heap, (next_weight+weight, next_end))
            else: continue

dijkstra(k)
for i in range(1, v+1):
    if i == k: print(0)
    elif res[i] == float('inf'): print("INF")
    else: print(res[i])
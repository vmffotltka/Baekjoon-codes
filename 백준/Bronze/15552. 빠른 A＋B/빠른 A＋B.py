import os, io, __pypy__
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
N = int(input())
ans = __pypy__.builders.StringBuilder()
for i in range(N):
    ans.append(str(sum(map(int, input().split())))+'\n')
os.write(1, ans.build().encode())
import sys
input = lambda: sys.stdin.readline().strip()
MOD = 1000003

k = int(input())
a = pow(2, k-1, MOD); b = pow(2, k, MOD)
a = (MOD + a - 1) % MOD
b = (MOD + b - 1) % MOD
A = a * b % MOD
res = A * 666669 % MOD
print(res)
import sys
lambda input: sys.stdin.readLine().strip()

def factorial(n):
    if n == 0 or n == 1:
        return 1
    result = 1
    for i in range(2, n + 1):
        result *= i
    return result

n, m, k = map(int, input().split())
sero = max(0, (k - 1)) // m
garo = max(0, (k - 1)) % m

way1 = factorial(sero + garo) // (factorial(sero) * factorial(garo))
way2 = factorial((n - 1 - sero) + (m - 1 - garo)) // (factorial(n - 1 - sero) * factorial(m - 1 - garo))
print(way1 * way2)
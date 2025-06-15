n = int(input())
m = int(input())
print(n, m, sep='\n')

ans = 0
pw = 1
while m:
    print(n * (m % 10), end='\n')
    ans += n * (m % 10) * pw
    pw *= 10
    m //= 10

print(ans)
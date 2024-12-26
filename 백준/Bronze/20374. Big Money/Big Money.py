import sys

data = sys.stdin.read().splitlines()

sum1 = 0
sum2 = 0

for n in data:
    p = 0
    for i in range(len(n)):
        if n[i] == '.':
            break
        p = p * 10 + int(n[i])
    sum1 += p
    sum2 += int(n[-2]) * 10 + int(n[-1])

whole_sum = sum1 + sum2 // 100
fraction_sum = sum2 % 100

print(f"{whole_sum}.{fraction_sum:02}")

def maxMoney(schedule, money_hap):
    global result
    for i in range(len(schedule)):
        day, money = schedule[i]
        if day > len(schedule[i:]): continue
        else: maxMoney(schedule[i+day:], money_hap+money)

    result.append(money_hap)

n = int(input())
schedule = [list(map(int, input().split())) for _ in range(n)]
result = []
maxMoney(schedule, 0)
print(max(result))
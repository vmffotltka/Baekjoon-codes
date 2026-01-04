n, k, q = map(int, input().split())
msg = [input().split() for i in range(k)]
human = [chr(i) for i in range(ord('A'), ord('A') + n)]
readhuman = ['A']
index = 0
for i in range(len(msg)):
    if msg[i][0] == msg[q-1][0]:
        index = i
        break

if msg[q-1][0] != '0':
    for i in range(index, len(msg)): readhuman.append(msg[i][1])

    human = set(human)
    readhuman = set(readhuman)
    output = sorted(human - readhuman)

    for i in output: print(i, end=' ')

else: print(-1)
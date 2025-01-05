import sys
MIS = lambda: map(int, sys.stdin.readline().strip().split())

sero, garo = MIS()
data = []; cam = []; empty = 0
for i  in range(sero):
    td = list(MIS())
    data.append(td)
    for j in range(garo):
        if td[j] != 0 and td[j] != 6: cam.append((i, j))
        elif td[j] == 0: empty += 1

def up(data, y, x):
    res = 0
    for i in range(y-1, -1, -1):
        if data[i][x] == 0:
            data[i][x] = '*'
            res += 1
        elif data[i][x] == 6: break
        else: continue
    return data, res
def down(data, y, x):
    res = 0
    for i in range(y+1, sero):
        if data[i][x] == 0:
            data[i][x] = '*'
            res += 1
        elif data[i][x] == 6: break
        else: continue
    return data, res
def left(data, y, x):
    res = 0
    for i in range(x-1, -1, -1):
        if data[y][i] == 0:
            data[y][i] = '*'
            res += 1
        elif data[y][i] == 6: break
        else: continue
    return data, res
def right(data, y, x):
    res = 0
    for i in range(x+1, garo):
        if data[y][i] == 0:
            data[y][i] = '*'
            res += 1
        elif data[y][i] == 6: break
        else: continue
    return data, res

def dfs(data, idx):
    if idx == len(cam): return 0

    res = float('-inf')
    y, x = cam[idx]
    if data[y][x] == 1:
        #위쪽 바라보기
        data2 = [item[:] for item in data]
        data2, count = up(data2, y, x)
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
        #아래쪽 바라보기
        data2 = [item[:] for item in data]
        data2, count = down(data2, y, x)
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
        #오른쪽 바라보기
        data2 = [item[:] for item in data]
        data2, count = right(data2, y, x)
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
        #왼쪽 바라보기
        data2 = [item[:] for item in data]
        data2, count = left(data2, y, x)
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
    elif data[y][x] == 2:
        #오른, 왼쪽 바라보기
        data2 = [item[:] for item in data]
        data2, count = right(data2, y, x)
        data2, c2 = left(data2, y, x)
        count += c2
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
        #아래, 위쪽 바라보기
        data2 = [item[:] for item in data]
        data2, count = up(data2, y, x)
        data2, c2 = down(data2, y, x)
        count += c2
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
    elif data[y][x] == 3:
        #위, 오른쪽 바라보기
        data2 = [item[:] for item in data]
        data2, count = right(data2, y, x)
        data2, c2 = up(data2, y, x)
        count += c2
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
        #오른, 아래쪽 바라보기
        data2 = [item[:] for item in data]
        data2, count = right(data2, y, x)
        data2, c2 = down(data2, y, x)
        count += c2
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
        #아래, 왼쪽 바라보기
        data2 = [item[:] for item in data]
        data2, count = down(data2, y, x)
        data2, c2 = left(data2, y, x)
        count += c2
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
        #왼쪽, 위쪽 바라보기
        data2 = [item[:] for item in data]
        data2, count = up(data2, y, x)
        data2, c2 = left(data2, y, x)
        count += c2
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
    elif data[y][x] == 4:
        #위쪽x 전부 바라보기
        data2 = [item[:] for item in data]
        data2, count = right(data2, y, x)
        data2, c2 = down(data2, y, x)
        data2, c3 = left(data2, y, x)
        count += c2 + c3
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
        #오른쪽x 전부 바라보기
        data2 = [item[:] for item in data]
        data2, count = up(data2, y, x)
        data2, c2 = down(data2, y, x)
        data2, c3 = left(data2, y, x)
        count += c2 + c3
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
        #아래쪽x 전부 바라보기
        data2 = [item[:] for item in data]
        data2, count = up(data2, y, x)
        data2, c2 = right(data2, y, x)
        data2, c3 = left(data2, y, x)
        count += c2 + c3
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
        #왼쪽x 전부 바라보기
        data2 = [item[:] for item in data]
        data2, count = up(data2, y, x)
        data2, c2 = right(data2, y, x)
        data2, c3 = down(data2, y, x)
        count += c2 + c3
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
    elif data[y][x] == 5:
        #전부 바라보기
        data2 = [item[:] for item in data]
        data2, count = up(data2, y, x)
        data2, c2 = right(data2, y, x)
        data2, c3 = down(data2, y, x)
        data2, c4 = left(data2, y, x)
        count += c2 + c3 + c4
        if count != 0:
            put = count + dfs(data2, idx+1)
            if res < put: res = put
    if res == float('-inf'): return dfs(data2, idx+1)
    return res
print(empty - dfs(data, 0))
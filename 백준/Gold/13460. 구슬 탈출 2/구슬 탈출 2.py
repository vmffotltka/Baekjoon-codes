sero, garo = map(int, input().split())
data = [list(input()) for _ in range(sero)]

def dfs(data, dir, count):
    if count == 10: return float('inf')

    ret = float('inf')
    data2 = [item[:] for item in data]
    ans = False
    #오른쪽으로 기울이기
    for i in range(sero):
        if 'R' in data2[i]: red = i
        if 'B' in data2[i]: blue = i

    red_idx = data2[red].index('R')
    blue_idx = data2[blue].index('B')

    if dir == 'up' or dir == 'down' or dir == '':
        while True:
            p1, p2 = data2[red][red_idx+1], data2[blue][blue_idx+1]
            if p1 == '.' or p2 == '.':
                if p1 == '.':
                    data2[red][red_idx+1], data2[red][red_idx] = data2[red][red_idx], p1
                    red_idx += 1
                if p2 == '.':
                    data2[blue][blue_idx+1], data2[blue][blue_idx] = data2[blue][blue_idx], p2
                    blue_idx += 1
            elif p1 == 'O':
                ans = True
                data2[red][red_idx] = '.'
                red_idx += 1
            elif p2 == 'O': break
            else: break

        if data2 == data or p2 == 'O': put = float('inf')
        elif ans: return count + 1
        else: put = dfs(data2, 'right', count+1)
        if ret > put: ret = put

    #왼쪽으로 기울이기
    data2 = [item[:] for item in data]
    red_idx = data2[red].index('R')
    blue_idx = data2[blue].index('B')

    if dir == 'up' or dir == 'down' or dir == '':
        while True:
            p1, p2 = data2[red][red_idx-1], data2[blue][blue_idx-1]
            if p1 == '.' or p2 == '.':
                if p1 == '.':
                    data2[red][red_idx-1], data2[red][red_idx] = data2[red][red_idx], p1
                    red_idx -= 1
                if p2 == '.':
                    data2[blue][blue_idx-1], data2[blue][blue_idx] = data2[blue][blue_idx], p2
                    blue_idx -= 1
            elif p1 == 'O':
                ans = True
                data2[red][red_idx] = '.'
                red_idx -= 1
            elif p2 == 'O': break
            else: break

        if data2 == data or p2 == 'O': put = float('inf')
        elif ans: return count + 1
        else: put = dfs(data2, 'left', count+1)
        if ret > put: ret = put

    #위로 기울이기
    data2 = [item[:] for item in data]

    for i in range(sero):
        for j in range(garo):
            if data2[i][j] == 'R':
                red = j
                red_idx = i
            if data2[i][j] == 'B':
                blue = j
                blue_idx = i

    if dir == 'right' or dir == 'left' or dir == '':
        while True:
            p1, p2 = data2[red_idx-1][red], data2[blue_idx-1][blue]
            if p1 == '.' or p2 == '.':
                if p1 == '.':
                    data2[red_idx-1][red], data2[red_idx][red] = data2[red_idx][red], p1
                    red_idx -= 1
                if p2 == '.':
                    data2[blue_idx-1][blue], data2[blue_idx][blue] = data2[blue_idx][blue], p2
                    blue_idx -= 1
            elif p1 == 'O':
                ans = True
                data2[red_idx][red] = '.'
                red_idx -= 1
            elif p2 == 'O': break
            else: break

        if data2 == data or p2 == 'O': put = float('inf')
        elif ans: return count + 1
        else: put = dfs(data2, 'up', count+1)
        if ret > put: ret = put

    # 아래로 기울이기
    data2 = [item[:] for item in data]

    for i in range(sero):
        for j in range(garo):
            if data2[i][j] == 'R':
                red = j
                red_idx = i
            if data2[i][j] == 'B':
                blue = j
                blue_idx = i

    if dir == 'right' or dir == 'left' or dir == '':
        while True:
            p1, p2 = data2[red_idx+1][red], data2[blue_idx+1][blue]
            if p1 == '.' or p2 == '.':
                if p1 == '.':
                    data2[red_idx+1][red], data2[red_idx][red] = data2[red_idx][red], p1
                    red_idx += 1
                if p2 == '.':
                    data2[blue_idx+1][blue], data2[blue_idx][blue] = data2[blue_idx][blue], p2
                    blue_idx += 1
            elif p1 == 'O':
                ans = True
                data2[red_idx][red] = '.'
                red_idx += 1
            elif p2 == 'O': break
            else: break

        if data2 == data or p2 == 'O': put = float('inf')
        elif ans: return count + 1
        else: put = dfs(data2, 'down', count+1)
        if ret > put: ret = put

    return ret
put = dfs(data, '', 0)
if put == float('inf'): print(-1)
else: print(put)
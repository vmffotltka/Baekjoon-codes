def is_queen_can_here(queen_coor, y_index):
    global n
    li = [True for _ in range(n)]

    for yy, xx in queen_coor:
        li[xx] = False
        dy = abs(y_index - yy)
        if xx + dy < n: li[xx+dy] = False
        if xx - dy >= 0: li[xx-dy] = False
   
    return li

def nQueen(n, queen_coordinate, y_index, queen_count):
    global count
    if len(queen_coordinate) == n:
        count += 1
        return

    queen_can_list = is_queen_can_here(queen_coordinate, y_index)
    for x in range(n):
        if queen_can_list[x]:
            new_coordinate = [item[:] for item in queen_coordinate]
            new_coordinate.append([y_index, x])
            nQueen(n, new_coordinate, y_index+1, queen_count+1)

n = int(input())
count = 0
queen_coordinate = []
nQueen(n, queen_coordinate, 0, 0)
print(count)
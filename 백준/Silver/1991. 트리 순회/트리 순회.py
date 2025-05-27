node = int(input())
tree = [input().split() for _ in range(node)]
visited = []

def adj(root):
    li = []
    for leaf in tree:
        if leaf[0] == root:
            li.extend(leaf[1:])
            break
    return li

def dfs(root):
    if root == '.': return
    else: visited.append(root)

    left, right = adj(root)
    dfs(left)
    dfs(right)
dfs('A')
print(*visited, sep="")

visited = []
def dfs2(root):
    if root == '.': return False

    left, right = adj(root)
    if dfs2(left) and not left in visited: visited.append(left)
    visited.append(root)
    if dfs2(right) and not right in visited: visited.append(right)
    
    return True
dfs2('A')
print(*visited, sep="")

visited = []
def dfs3(root):
    if root == '.': return False

    left, right = adj(root)
    if dfs3(left) and not left in visited: visited.append(left)
    if dfs3(right) and not right in visited: visited.append(right)
    visited.append(root)
    return True
dfs3('A')
print(*visited, sep="")
int sz[MAX], dep[MAX], par[MAX];

void dfs1(int cur, int parent = 0) {
    sz[cur] = 1;
    for (int& nxt : adj[cur]) {
        if (nxt == parent) continue;
        dep[nxt] = dep[cur] + 1;
        par[nxt] = cur;
        dfs1(nxt, cur);
        sz[cur] += sz[nxt];
		if (adj[cur][0] == parent || sz[nxt] > sz[adj[cur][0]])
            swap(nxt, adj[cur][0]);
    }
}

int in[MAX], top[MAX], timer = 0;

void dfs2(int cur, int parent = 0) {
    in[cur] = ++timer;
    for (int nxt : adj[cur]) {
        if (nxt == parent) continue;
        top[nxt] = (nxt == adj[cur][0]) ? top[cur] : nxt;
        dfs2(nxt, cur);
    }
}

ll tree[S * 2];

void update(int p, ll val) {
    p += S - 1;
    tree[p] = val;
	for (p /= 2; p > 0; p /= 2) {
        tree[p] = tree[p * 2] + tree[p * 2 + 1];
    }
}

ll query(int l, int r) {
    ll res = 0;
	l += S - 1, r += S - 1;
    while (l <= r) {
		if (l % 2 == 1) res += tree[l++];
		if (r % 2 == 0) res += tree[r--];
		l /= 2, r /= 2;
    }
    return res;
}

ll query_path(int u, int v) {
    ll ret = 0;
    while (top[u] != top[v]) {
        if (dep[top[u]] < dep[top[v]]) swap(u, v);
        ret += query(in[top[u]], in[u]);
		u = par[top[u]];
    }
	if (dep[u] > dep[v]) swap(u, v);

	ret += query(in[u], in[v]);
    return ret;
}

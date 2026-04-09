#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MAX = 30005;
const int S = 32768;
vector<int> adj[MAX];

struct DSU {
    int parent[MAX];
    DSU() {
        for (int i = 0; i < MAX; i++) parent[i] = i;
	}
    void init() {
        for (int i = 0; i < MAX; i++) parent[i] = i;
	}
    int find(int u) {
        if (parent[u] == u) return u;
		return parent[u] = find(parent[u]);
    }
    bool merge(int u, int v) {
        u = find(u), v = find(v);
        if (u == v) return false;
        parent[v] = u;
		return true;
    }
};

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

struct Query {
    string type;
    int u, v;
};

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n; cin >> n;
    vector<int> penguins(n + 1);
	for (int i = 1; i <= n; i++) cin >> penguins[i];

    int q; cin >> q;
	vector<Query> queries(q);
    for (int i = 0; i < q; i++)
		cin >> queries[i].type >> queries[i].u >> queries[i].v;

    DSU dsu;
    for (auto& q : queries) {
        if (q.type == "bridge") {
			if (dsu.merge(q.u, q.v)) {
                adj[q.u].push_back(q.v);
                adj[q.v].push_back(q.u);
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        if (!sz[i]) {
            dfs1(i);
			top[i] = i;
            dfs2(i);
        }
    }
    for (int i = 1; i <= n; i++)
		update(in[i], penguins[i]);

    DSU dsu2;
    for (auto& q : queries) {
        int u = q.u, v = q.v;
        if (q.type == "bridge") {
            if (dsu2.merge(u, v))
                cout << "yes\n";
            else
                cout << "no\n";
        }
        else if (q.type == "penguins")
            update(in[u], v);
        else {
            if (dsu2.find(u) != dsu2.find(v))
                cout << "impossible\n";
            else
				cout << query_path(u, v) << '\n';
        }
    }
}
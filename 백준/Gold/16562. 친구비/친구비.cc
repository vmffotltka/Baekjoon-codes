#include <bits/stdc++.h>
using namespace std;

int parent[10001], cost[10001], vis[10001];
int find(int n) {
    if (parent[n] == n) return n;
	return parent[n] = find(parent[n]);
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
	int n, m, k; cin >> n >> m >> k;
	for (int i = 1; i <= n; i++) cin >> cost[i];
	for (int i = 1; i <= n; i++) parent[i] = i;
	for (int i = 0; i < m; i++) {
		int u, v; cin >> u >> v;
		int pu = find(u), pv = find(v);
		if (pu != pv) {
			parent[pv] = pu;
			cost[pu] = min(cost[pu], cost[pv]);
		}
	}
	int ans = 0;
	for (int i = 1; i <= n; i++) {
		int p = find(i);
		if (vis[p]) continue;
		vis[p] = 1;
		ans += cost[p];
	}
	if (ans > k) cout << "Oh no";
	else cout << ans;
}
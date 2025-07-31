#include <bits/stdc++.h>
#define INF 1000000000
#define MOD 1000003
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

int order[20000], sccID[20000], inDegree[20000], p1 = 0, p2 = 0, N, M;
vector<int> edge[20000]; vector<vector<int>> SCC;
stack<int> st;
int scc(int node) {
	int ret = order[node] = p1++;
	st.push(node);
	for (auto next : edge[node]) {
		if (order[next] == -1)
			ret = min(ret, scc(next));
		else if (sccID[next] == -1)
			ret = min(ret, order[next]);
		inDegree[next]++;
	}
	if (ret == order[node]) {
		vector<int> tmp;
		while (true) {
			int p = st.top(); st.pop();
			sccID[p] = p2;
			tmp.push_back(p);
			if (p == node) break;
		}
		sort(tmp.begin(), tmp.end());
		SCC.push_back(tmp);
		p2++;
	}
	return ret;
}

void solve() {
	cin >> N >> M;
	memset(order, -1, sizeof(order)), memset(sccID, -1, sizeof(sccID));
	while (M--) {
		int u, v; cin >> u >> v;
		int nu = (u < 0 ? (-u - 1) * 2 + 1 : (u - 1) * 2);
		int nv = (v < 0 ? (-v - 1) * 2 + 1 : (v - 1) * 2);
		if (u < 0) edge[nu - 1].push_back(nv);
		else edge[nu + 1].push_back(nv);
		if (v < 0) edge[nv - 1].push_back(nu);
		else edge[nv + 1].push_back(nu);
	}
	for (int i = 0; i < N * 2; i++) {
		if (order[i] != -1) continue;
		scc(i);
	}
	for (auto i : SCC) {
		for (int j = 1; j < i.size(); j++) {
			if (i[j - 1] / 2 == i[j] / 2) { cout << 0; return; }
		}
	}
	cout << "1\n";
	vector<int> ans(N, -1);
	for (auto i : vector<vector<int>>(SCC.rbegin(), SCC.rend())) {
		for (auto j : i) {
			bool neg = (j % 2 == 1 ? true : false);
			int n = j / 2;
			if (ans[n] != -1) break;
			ans[n] = (neg ? 1 : 0);
		}
	}
	for (auto i : ans) cout << (!i ? 0 : 1) << " ";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
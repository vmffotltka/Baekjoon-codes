#include <bits/stdc++.h>
#define INF 1000000000
#define MOD 1000003
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

int order[2000], sccID[2000], p1, p2, N, M;
vector<vector<int>> edge, SCC;
stack<int> st;
int scc(int node) {
	int ret = order[node] = p1++;
	st.push(node);
	for (auto next : edge[node]) {
		if (order[next] == -1)
			ret = min(ret, scc(next));
		else if (sccID[next] == -1)
			ret = min(ret, order[next]);
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

void solve(int n, int m) {
	N = n, M = m;
	p1 = 0, p2 = 0;
	memset(order, -1, sizeof(order)), memset(sccID, -1, sizeof(sccID));
	edge = vector<vector<int>>(N * 2);
	vector<vector<int>>().swap(SCC);
	stack<int>().swap(st);
	edge[1].push_back(0);
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
			if (i[j - 1] / 2 == i[j] / 2) { cout << "no\n"; return; }
		}
	}
	cout << "yes\n";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m;
	while (cin >> n >> m) solve(n, m);
}
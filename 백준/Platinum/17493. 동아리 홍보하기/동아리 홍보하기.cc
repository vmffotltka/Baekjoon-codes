#include <iostream>
#include <cmath>
#include <set>
#include <cstring>
#include <vector>
#include <deque>
#include <queue>
#include <stack>
#include <algorithm>
#include <list>
#include <string>
#include <map>
#include <unordered_map>
#define INF 987654321
#define MOD 1000003
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

int n, m, ans = 0;
bool visited[200001], check[200001];
unordered_map<int, vector<int>> edge;

int dfs(int node, int root) {
	visited[node] = true;
	int checked = 0;
	for (auto i : edge[node]) {
		if (!visited[i]) {
			checked += dfs(i, node);
		}
	}
	if (checked) {
		ans++;
		check[root] = true; check[node] = true;
		for (auto i : edge[node]) {
			check[i] = true;
		}
	}
	if (node != root) {
		if (!check[node]) return 1;
		else return 0;
	}
	else {
		if (!check[node]) ans++;
		return 0;
	}
}

void solve() {
	cin >> n >> m;
	int a, b;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		edge[a].push_back(b);
		edge[b].push_back(a);
	}
	for (int i = 1; i <= n; i++) {
		if (!visited[i]) dfs(i, i);
	}
	cout << ans;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
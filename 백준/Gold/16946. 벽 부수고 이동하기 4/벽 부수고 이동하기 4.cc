#include <bits/stdc++.h>
#define INF 1000000000
#define MOD 1000000007
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

int sero, garo, arr[1000][1000], ans[1000][1000];
bool visited[1000][1000];
pii parent[1000][1000];
int dy[4] = { 0, 0, 1, -1 };
int dx[4] = { 1, -1, 0, 0 };
pii find(int y, int x) {
	if (parent[y][x].first == y && parent[y][x].second == x) return { y, x };
	return parent[y][x] = find(parent[y][x].first, parent[y][x].second);
}

int dfs(int y, int x, pii p) {
	int ret = 1;
	parent[y][x] = p;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i], nx = x + dx[i];
		if (0 <= ny && ny < sero && 0 <= nx && nx < garo && !visited[ny][nx] && !arr[ny][nx]) {
			visited[ny][nx] = true;
			ret += dfs(ny, nx, { y, x });
		}
	}
	return ret;
}

void solve() {
	cin >> sero >> garo;
	for (int i = 0; i < sero; i++) {
		string s; cin >> s;
		for (int j = 0; j < garo; j++)
			arr[i][j] = s[j] - '0';
	}
	for (int i = 0; i < sero; i++) {
		for (int j = 0; j < garo; j++)
			parent[i][j] = { i, j };
	}
	for (int i = 0; i < sero; i++) {
		for (int j = 0; j < garo; j++) {
			if (visited[i][j] || arr[i][j]) continue;
			visited[i][j] = true;
			ans[i][j] = dfs(i, j, { i, j });
		}
	}
	for (int i = 0; i < sero; i++) {
		for (int j = 0; j < garo; j++) {
			if (!arr[i][j]) { cout << 0; continue; }
			int ANS = 1;
			set<pii> v;
			for (int k = 0; k < 4; k++) {
				int ny = i + dy[k], nx = j + dx[k];
				if (0 <= ny && ny < sero && 0 <= nx && nx < garo && !arr[ny][nx]) {
					pii p = find(ny, nx);
					if (v.count(p)) continue;
					v.insert(p);
					ANS += ans[p.first][p.second];
				}
			}
			cout << ANS % 10;
		}
		cout << '\n';
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
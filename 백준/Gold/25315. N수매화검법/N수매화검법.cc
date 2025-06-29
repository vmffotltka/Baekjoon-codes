#include <iostream>
#include <cmath>
#include <set>
#include <unordered_set>
#include <map>
#include <unordered_map>
#include <cstring>
#include <vector>
#include <deque>
#include <queue>
#include <algorithm>
#include <list>
#include <string>
#define INF 2'000'000'000
#define PI 3.14159265358979323846264338327
#define MOD 1'000'000'003
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

struct Edge {
	ll sx, sy, ex, ey, w, idx;
};

ll ccw(pll a, pll b, pll c) {
	ll x1 = a.first, y1 = a.second, x2 = b.first, y2 = b.second, x3 = c.first, y3 = c.second;
	ll ret = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
	if (ret > 0) return 1;
	else if (ret < 0) return -1;
	else return 0;
}

bool comp(Edge a, Edge b) {
	if (a.w > b.w) return true;
	else return false;
}

ll n;
void solve() {
	cin >> n;
	ll sx, sy, ex, ey, w;
	vector<Edge> info(n);
	vector<vector<ll>> edge(n);
	for (ll i = 0; i < n; i++) {
		cin >> sx >> sy >> ex >> ey >> w;
		info[i] = { sx, sy, ex, ey, w, i };
		for (ll j = 0; j < i; j++) {
			pll a = { info[i].sx, info[i].sy }, b = { info[i].ex, info[i].ey };
			pll c = { info[j].sx, info[j].sy }, d = { info[j].ex, info[j].ey };
			if (ccw(a, b, c) * ccw(a, b, d) <= 0 && ccw(c, d, a) * ccw(c, d, b) <= 0) {
				edge[i].push_back(j);
				edge[j].push_back(i);
			}
		}
	}
	sort(info.begin(), info.end(), comp);
	vector<ll> inDegree(n);
	ll ans = 0;
	for (auto &i : info) {
		ll val = i.w, idx = i.idx;
		ans += (inDegree[idx] + 1) * val;
		for (auto j : edge[idx]) {
			inDegree[j]++;
		}
	}
	cout << ans;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
#include <bits/stdc++.h>
#define INF 1000000000
using namespace std;
typedef long long ll;
typedef pair<ll, ll> pii;

int N; stack<pii> st;
void solve() {
	cin >> N;
	ll ans = 0;
	while (N--) {
		int p, same = 1; cin >> p;
		while (!st.empty()) {
			if (st.top().first > p) break;
			if (st.top().first == p) same = st.top().second + 1;
			if (st.size() == 1) ans += st.top().second;
			else ans += st.top().second + 1;
			st.pop();
		}
		st.push({ p, same });
	}
	cout << ans + st.size() - 1;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
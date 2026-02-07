#include <bits/stdc++.h>
#define INF 2e18
#define MOD 1000000007
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

ll mpow(ll exp, ll n) {
	if (exp == 0) return 1;
	if (exp == 1) return n;
	ll ret = mpow(exp / 2, n * n % MOD);
	if (exp & 1) {
		ret *= n;
		ret %= MOD;
	}
	return ret;
}

ll cat(ll n) {
	ll up = 1, down1 = 1, down2 = 1;
	for (ll i = n * 2; i > 0; i--) {
		up *= i;
		up %= MOD;
	}
	for (ll i = n; i > 0; i--) {
		down1 *= i;
		down1 %= MOD;
	}
	for (ll i = n + 1; i > 0; i--) {
		down2 *= i;
		down2 %= MOD;
	}
	return up * mpow(MOD - 2, (down1 * down2) % MOD) % MOD;
}

ll n;
void solve() {
	cin >> n;
	cout << cat(n);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
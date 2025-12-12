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
#define MOD 1000000007
using namespace std;
typedef long long ll;

ll n;
vector<ll> f, val, GGG;

ll power(ll n, ll exp) {
	if (exp == 0) return 1;
	ll ans = power(n * n % MOD, exp / 2);
	if (exp % 2 == 1) {
		ans *= n;
		ans %= MOD;
	}
	return ans;
}

void input() {
	cin >> n;
	f.resize(n + 1);
	for (ll i = 0; i < n + 1; i++) {
		cin >> f[i];
	}
	val.resize(n + 1, 0);
	for (ll i = 0; i < n + 1; i++) {
		ll put = 0;
		for (ll j = 0; j < n + 1; j++) {
			put += f[j] * power(i, j);
			put %= MOD;
		}
		val[i] = put;
	}
	GGG.push_back(val[0]);
}

void solve() {
	input();
	while (n--) {
		vector<ll> tmp(n + 1);
		for (int i = 0; i < n + 1; i++) {
			tmp[i] = (MOD + val[i + 1] - val[i]) % MOD;
		}
		GGG.push_back(tmp[0] % MOD);
		val = tmp;
	}
	vector<ll>::iterator iter = GGG.begin();
	cout << "GGG<" << *iter;
	for (iter = iter + 1; iter != GGG.end(); iter++) {
		cout << ',' << *iter;
	}
	cout << '>';
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
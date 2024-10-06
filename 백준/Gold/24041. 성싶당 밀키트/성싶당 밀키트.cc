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
#define INF 987654321
#define MOD 1'000'000'007
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

struct Mkit {
	ll s, l, o;
};

ll n, g, k;
Mkit info[200000];

ll search() {
	ll s = 0, e = 2'000'000'000;
	while (true) {
		priority_queue<ll> sub;
		ll mid = (s + e) / 2;
		ll gsum1 = 0, gsum2 = 0;
		for (ll i = 0; i < n; i++) {
			ll p = info[i].s * max((ll)1, mid - info[i].l);
			if (info[i].o == 1) {
				if (!sub.empty() && sub.size() == k && -sub.top() < p) {
					gsum2 -= -sub.top();
					sub.pop();
					gsum2 += p;
					sub.push(-p);
				}
				else if (sub.size() < k) {
					sub.push(-p);
					gsum2 += p;
				}
				gsum1 += p;
			}
			else {
				gsum1 += p;
			}
		}
		ll res = gsum1 - gsum2;
		if (s == mid && e == mid && res <= g) {
			return mid;
		}
		else if (res <= g) {
			if (s == mid) s++;
			else s = mid;
		}
		else if (res > g) {
			if (e == mid) e--;
			else e = mid;
		}
	}
}

void solve() {
	cin >> n >> g >> k;
	ll s, l, o;
	for (int i = 0; i < n; i++) {
		cin >> s >> l >> o;
		info[i] = { s, l, o };
	}
	cout << search();
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
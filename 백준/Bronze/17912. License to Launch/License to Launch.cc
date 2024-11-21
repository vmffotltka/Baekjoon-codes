#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int mn = INT_MAX, ans, n; cin >> n;
	for (int i = 0; i < n; i++) {
		int p; cin >> p;
		if (mn > p) {
			mn = p;
			ans = i;
		}
	}
	cout << ans;
}
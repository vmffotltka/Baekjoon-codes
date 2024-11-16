#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int n, ans = 0; cin >> n;
	for (int i = 1; i <= n; i++) {
		int sum = 0, p = i;
		while (p) {
			sum += p % 10;
			p /= 10;
		}
		if (i % sum == 0) ans++;
	}
	cout << ans;
}
#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int t, ans = 0; cin >> t;
	while (t--) {
		int a, b, c; cin >> a >> b >> c;
		if ((a == -1 && (b >= 0 || c >= 0)) ||
			(b == -1 && c >= 0) || (a == -1 && b == -1 && c == -1)) continue;
		if (c != -1 && a <= b && b <= c) ans++;
		else if (c == -1 && a <= b) ans++;
		else if (b == -1 && a >= 0) ans++;
	}
	cout << ans;
}
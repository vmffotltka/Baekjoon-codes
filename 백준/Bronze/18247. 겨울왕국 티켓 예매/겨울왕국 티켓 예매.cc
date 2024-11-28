#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int t; cin >> t; while (t--) {
		int n, m; cin >> n >> m;
		int ans = 11 * m + 4;
		cout << (m < 4 || ans > n * m ? -1 : ans) << '\n';
	}
}
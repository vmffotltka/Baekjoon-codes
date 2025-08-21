#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int t; cin >> t; while (t--) {
		int cse, n; cin >> cse >> n;
		cout << cse << " " << n * (n + 1) / 2 + n << '\n';
	}
}
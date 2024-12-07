#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int n, m; cin >> n >> m;
	for (int i = 0; i < n; i++) {
		int cnt = 0;
		for (int j = 1; j <= m; j++) {
			char c; cin >> c;
			if (c == 'A') cnt++;
		}
		if (cnt != 1) { cout << "No"; return 0; }
	}
	cout << "Yes";
}
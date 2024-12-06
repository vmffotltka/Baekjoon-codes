#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int n, m; cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 1; j <= m; j++) {
			cout << i * m + j << (j == m ? "" : " ");
		}
		cout << '\n';
	}
}
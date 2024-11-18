#include <bits/stdc++.h>
using namespace std;

int N;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	cin >> N;
	int mx = -INT_MAX, ans = 0;
	for (int i = 0; i < N; i++) {
		int p; cin >> p;
		ans = max(ans + p, p);
		mx = max(ans, mx);
	}
	cout << mx;
}
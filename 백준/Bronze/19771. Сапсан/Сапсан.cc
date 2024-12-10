#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int n, cnt = 0; cin >> n;
	while (true) {
		int next = cnt + 4;
		int row = next / 2 + next / 4;
		if (row > n / 2) break;
		cnt += 4;
	}
	cout << cnt;
}
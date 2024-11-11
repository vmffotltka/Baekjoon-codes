#include <bits/stdc++.h>
using namespace std;

int main() {
	long long n, ans = 0, rage = 0; cin >> n;
	for (int i = 0; i < n; i++) {
		int p; cin >> p;
		if (!p) rage--;
		else rage++;
		ans += rage;
	}
	cout << ans;
}
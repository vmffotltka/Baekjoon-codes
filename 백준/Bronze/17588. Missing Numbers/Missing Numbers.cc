#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int t, cur = 1;
	bool tri = true;
	cin >> t; while (t--) {
		int p; cin >> p;
		if (cur != p) {
			tri = false;
			for (int i = cur; i < p; i++) cout << i << '\n';
		}
		cur = p + 1;
	}
	if (tri) cout << "good job";
}
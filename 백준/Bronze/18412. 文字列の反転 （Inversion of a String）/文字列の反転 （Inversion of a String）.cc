#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int n, a, b; cin >> n >> a >> b;
	string s; cin >> s;
	a--, b--;
	for (int i = 0; i < n; i++) {
		if (a <= i && i <= b) cout << s[a + b - i];
		else cout << s[i];
	}
}
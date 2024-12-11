#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int t; cin >> t; while (t--) {
		string s; cin >> s;
		int a = (s[0] - '0') * 10 + (s[1] - '0'), b = (s[2] - '0') * 10 + (s[3] - '0');
		cout << ((a * a + b * b) % 7 == 1 ? "YES\n" : "NO\n");
	}
}
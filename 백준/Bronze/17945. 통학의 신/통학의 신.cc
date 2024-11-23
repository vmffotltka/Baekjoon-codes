#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int b, c; cin >> b >> c;
	int ans1 = -b + sqrt(b * b - c), ans2 = -b - sqrt(b * b - c);
	if (ans1 == ans2) cout << ans1;
	else cout << ans2 << " " << ans1;
}
#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int d, e, w; cin >> d >> e >> w;
	int a = max(0, d - 100) * 25 + e * 15 + w * 20;
	int b = max(0, d - 250) * 45 + e * 35 + w * 25;
	cout << "Plan A costs " << a / 100 << "." << a % 100 << '\n';
	cout << "Plan B costs " << b / 100 << "." << b % 100 << '\n';
	if (a < b) cout << "Plan A is cheapest.";
	else if (a > b) cout << "Plan B is cheapest.";
	else cout << "Plan A and B are the same price.";
}
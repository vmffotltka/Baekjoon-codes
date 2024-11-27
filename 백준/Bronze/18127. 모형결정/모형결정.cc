#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	long long a, b; cin >> a >> b;
	cout << (a - 2) * (b + 1) * (b + 2) / 2 - (b + 1) * (a - 3);
}
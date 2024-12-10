#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int n; cin >> n;
	if (n % 3 == 1) cout << 'U';
	else if (n % 3 == 2) cout << 'O';
	else cout << 'S';
}
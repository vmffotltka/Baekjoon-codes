#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int n; cin >> n;
	cout << (n % 2024 == 0 && n <= 100000 ? "Yes" : "No");
}
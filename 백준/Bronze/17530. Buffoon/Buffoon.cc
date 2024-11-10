#include <bits/stdc++.h>
using namespace std;

int main() {
	int n, mx = -1, carlos; cin >> n >> carlos;
	for (int i = 0; i < n - 1; i++) {
		int p; cin >> p;
		mx = max(mx, p);
	}
	cout << (carlos >= mx ? "S" : "N");
}
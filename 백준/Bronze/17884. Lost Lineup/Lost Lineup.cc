#include <bits/stdc++.h>
using namespace std;

int idx[101];

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int n; cin >> n;
	idx[1] = 1;
	for (int i = 2; i <= n; i++) {
		int p; cin >> p;
		idx[p + 2] = i;
	}
	for (int i = 1; i <= n; i++)
		cout << idx[i] << " ";
}
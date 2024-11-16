#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	long long n, cnt = 0; cin >> n;
	while (true) {
		if (n == 1) break;
		if (n & 1) n++;
		else n /= 2;
		cnt++;
	}
	cout << cnt;
}
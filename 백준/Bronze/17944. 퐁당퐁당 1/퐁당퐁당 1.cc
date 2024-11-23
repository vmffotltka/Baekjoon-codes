#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int n, t, hand = 0, tri = 0; cin >> n >> t;
	for (int i = 0; i < t; i++) {
		if (!tri) hand++;
		else hand--;
		if (hand == n * 2) tri = 1;
		if (hand == 1) tri = 0;
	}
	cout << hand;
}
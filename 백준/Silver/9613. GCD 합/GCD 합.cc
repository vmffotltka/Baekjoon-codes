#include <bits/stdc++.h>
using namespace std;

int arr[100];

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int t; cin >> t; while (t--) {
		long long n, sum = 0; cin >> n;
		for (int i = 0; i < n; i++) cin >> arr[i];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int a = arr[i], b = arr[j], c;
				while (true) {
					c = a % b;
					if (!c) break;
					a = b, b = c;
				}
				sum += b;
			}
		}
		cout << sum << '\n';
	}
}
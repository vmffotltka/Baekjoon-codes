#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> pii;

int W, N, arr[5000];
vector<pii> v(400001, { -1, -1 });
void solve() {
	cin >> W >> N;
	for (int i = 0; i < N; i++) cin >> arr[i];
	for (int i = 0; i < N; i++) {
		for (int j = i + 1; j < N; j++) {
			v[arr[i] + arr[j]] = { i, j };
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = i + 1; j < N; j++) {
			if (W < arr[i] + arr[j] || W > arr[i] + arr[j] + 400000) continue;
			pii a = v[W - arr[i] - arr[j]];
			if (a.first == -1 || a.first == i || a.first == j || a.second == i || a.second == j) continue;
			cout << "YES"; return;
		}
	}
	cout << "NO";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
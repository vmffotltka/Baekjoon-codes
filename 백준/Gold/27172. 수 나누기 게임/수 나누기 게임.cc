#include <bits/stdc++.h>
using namespace std;

int N, arr[100000], cnt[1000001], ans[100000];
vector<int> idx(1000001, -1);
void solve() {
	cin >> N;
	int mx = -1;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
		mx = max(mx, arr[i]);
		idx[arr[i]] = i;
	}
	sort(arr, arr + N);
	for (int i = 0; i < N; i++) {
		int cur = arr[i];
		for (int j = cur * 2; j <= mx; j += cur) {
			if (idx[j] == -1) continue;
			cnt[j]--, cnt[cur]++;
		}
	}
	for (int i = 0; i < N; i++)
		ans[idx[arr[i]]] = cnt[arr[i]];
	for (int i = 0; i < N; i++)
		cout << ans[i] << " ";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
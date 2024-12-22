#include <bits/stdc++.h>
#define INF 987654321
#define MOD 1000000007
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

ll N, S, ans = 0;
vector<int> arr1, arr2, tmp1, tmp2;
unordered_map<ll, ll> com1, com2;
void dfs(int idx, int limit) {
	if (tmp1.size() == limit) {
		int sum = 0;
		for (auto i : tmp1)
			sum += i;
		com1[sum]++;
		if (sum == S) ans++;
		return;
	}
	for (int i = idx; i < N / 2; i++) {
		tmp1.push_back(arr1[i]);
		dfs(i + 1, limit);
		tmp1.pop_back();
	}
}

void dfs2(int idx, int limit) {
	if (tmp2.size() == limit) {
		int sum = 0;
		for (auto i : tmp2)
			sum += i;
		com2[sum]++;
		if (sum == S) ans++;
		return;
	}
	for (int i = idx; i < N - N / 2; i++) {
		tmp2.push_back(arr2[i]);
		dfs2(i + 1, limit);
		tmp2.pop_back();
	}
}

void solve() {
	cin >> N >> S;
	int put;
	for (int i = 0; i < N / 2; i++) {
		cin >> put;
		arr1.push_back(put);
	}
	for (int i = N / 2; i < N; i++) {
		cin >> put;
		arr2.push_back(put);
	}
	for (int i = 1; i <= N / 2; i++)
		dfs(0, i);
	for (int i = 1; i <= N - N / 2; i++)
		dfs2(0, i);
	for (auto i : com1) {
		ll val = i.first, cnt = i.second;
		ans += com2[S - val] * cnt;
	}
	cout << ans;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
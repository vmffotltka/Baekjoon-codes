#include <bits/stdc++.h>
#define INF 1000000000
#define MOD 1000000007
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

int N, W;
void solve() {
	cin >> N >> W;
	vector<vector<int>> arr(N + 1, vector<int>(2));
	for (int j = 0; j < 2; j++) {
		for (int i = 1; i <= N; i++) cin >> arr[i][j];
	}
	if (N == 1) {
		cout << (arr[1][0] + arr[1][1] <= W ? 1 : 2) << '\n';
		return;
	}
	int ans = INF;
	if (arr[1][0] + arr[N][0] <= W && arr[1][1] + arr[N][1] <= W) {
		vector<vector<int>> dp(N + 1, vector<int>(5, INF));
		dp[1][3] = 2, dp[2][0] = 4;
		if (arr[2][0] + arr[2][1] <= W) dp[2][4] = 3;
		for (int i = 3; i < N; i++) {
			int k0k4 = INF, k3 = INF;
			for (int j = 0; j < 5; j++) {
				k0k4 = min(k0k4, dp[i - 1][j]);
				k3 = min(k3, dp[i - 2][j]);
			}
			dp[i][0] = k0k4 + 2;
			if (arr[i][0] + arr[i - 1][0] <= W) dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + 1;
			if (arr[i][1] + arr[i - 1][1] <= W) dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + 1;
			if (arr[i][0] + arr[i - 1][0] <= W && arr[i][1] + arr[i - 1][1] <= W) dp[i][3] = k3 + 2;
			if (arr[i][0] + arr[i][1] <= W) dp[i][4] = k0k4 + 1;
		}
		for (int i = 0; i < 5; i++)
			ans = min(ans, dp[N - 1][i]);
	}
	if (arr[1][0] + arr[N][0] <= W) {
		vector<vector<int>> dp(N + 1, vector<int>(5, INF));
		dp[1][1] = 2, dp[2][0] = 4;
		if (arr[2][1] + arr[1][1] <= W) dp[2][2] = 3;
		if (arr[2][0] + arr[2][1] <= W) dp[2][4] = 3;
		for (int i = 3; i < N; i++) {
			int k0k4 = INF, k3 = INF;
			for (int j = 0; j < 5; j++) {
				k0k4 = min(k0k4, dp[i - 1][j]);
				k3 = min(k3, dp[i - 2][j]);
			}
			dp[i][0] = k0k4 + 2;
			if (arr[i][0] + arr[i - 1][0] <= W) dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + 1;
			if (arr[i][1] + arr[i - 1][1] <= W) dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + 1;
			if (arr[i][0] + arr[i - 1][0] <= W && arr[i][1] + arr[i - 1][1] <= W) dp[i][3] = k3 + 2;
			if (arr[i][0] + arr[i][1] <= W) dp[i][4] = k0k4 + 1;
		}
		for (int i = 0; i < 5; i++)
			ans = min(ans, dp[N - 1][i] + 1);
		if (arr[N - 1][1] + arr[N][1] <= W) ans = min(ans, min(dp[N - 1][0], dp[N - 1][1]));
	}
	if (arr[1][1] + arr[N][1] <= W) {
		vector<vector<int>> dp(N + 1, vector<int>(5, INF));
		dp[1][2] = 2, dp[2][0] = 4;
		if (arr[1][0] + arr[2][0] <= W) dp[2][1] = 3;
		if (arr[2][0] + arr[2][1] <= W) dp[2][4] = 3;
		for (int i = 3; i < N; i++) {
			int k0k4 = INF, k3 = INF;
			for (int j = 0; j < 5; j++) {
				k0k4 = min(k0k4, dp[i - 1][j]);
				k3 = min(k3, dp[i - 2][j]);
			}
			dp[i][0] = k0k4 + 2;
			if (arr[i][0] + arr[i - 1][0] <= W) dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + 1;
			if (arr[i][1] + arr[i - 1][1] <= W) dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + 1;
			if (arr[i][0] + arr[i - 1][0] <= W && arr[i][1] + arr[i - 1][1] <= W) dp[i][3] = k3 + 2;
			if (arr[i][0] + arr[i][1] <= W) dp[i][4] = k0k4 + 1;
		}
		for (int i = 0; i < 5; i++)
			ans = min(ans, dp[N - 1][i] + 1);
		if (arr[N - 1][0] + arr[N][0] <= W) ans = min(ans, min(dp[N - 1][0], dp[N - 1][2]));
	}
	vector<vector<int>> dp(N + 1, vector<int>(5, INF));
	dp[0][0] = 0, dp[1][0] = 2;
	if (arr[1][0] + arr[1][1] <= W) dp[1][4] = 1;
	for (int i = 2; i <= N; i++) {
		int k0k4 = INF, k3 = INF;
		for (int j = 0; j < 5; j++) {
			k0k4 = min(k0k4, dp[i - 1][j]);
			k3 = min(k3, dp[i - 2][j]);
		}
		dp[i][0] = k0k4 + 2;
		if (arr[i][0] + arr[i - 1][0] <= W) dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + 1;
		if (arr[i][1] + arr[i - 1][1] <= W) dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + 1;
		if (arr[i][0] + arr[i - 1][0] <= W && arr[i][1] + arr[i - 1][1] <= W) dp[i][3] = k3 + 2;
		if (arr[i][0] + arr[i][1] <= W) dp[i][4] = k0k4 + 1;
	}
	for (int i = 0; i < 5; i++)
		ans = min(ans, dp[N][i]);
	cout << ans << '\n';
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int t; cin >> t; while (t--) solve();
}
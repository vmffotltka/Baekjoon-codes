#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int N, M;
int dp[305][305][2][305], arr[305];

int solve(int left, int right, int pos, int remain) {
    if (remain == 0) return 0;
	if (dp[left][right][pos][remain] != -1) return dp[left][right][pos][remain];
	int curr = pos == 0 ? arr[left] : arr[right];
	int left_cost = 1e9, right_cost = 1e9;
    if (left > 0) {
		int dist = curr - arr[left - 1];
        int cost = dist * remain;
		left_cost = solve(left - 1, right, 0, remain - 1) + cost;
    }
    if (right < N) {
        int dist = arr[right + 1] - curr;
		int cost = dist * remain;
		right_cost = solve(left, right + 1, 1, remain - 1) + cost;
    }
	dp[left][right][pos][remain] = min(left_cost, right_cost);
	return dp[left][right][pos][remain];
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin >> N >> M;
    for (int i = 0; i < N; i++) cin >> arr[i];
    sort(arr, arr + N + 1);
	memset(dp, -1, sizeof(dp));
    
    int start_idx = 0;
    for (int i = 0; i <= N; i++) {
        if (arr[i] == 0) {
            start_idx = i;
            break;
        }
    }
    int ans = 0;
    for (int k = 0; k <= N; k++)
		ans = max(ans, (k * M) - solve(start_idx, start_idx, 0, k));

    cout << ans;
}
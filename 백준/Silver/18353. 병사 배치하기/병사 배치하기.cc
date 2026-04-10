#include <bits/stdc++.h>
using namespace std;

int arr[2000], dp[2000];

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n, ans = 0; cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    for (int i = 0; i < n; i++) {
        dp[i] = 1;
        for (int j = 0; j < i; j++) {
            if (arr[j] > arr[i])
                dp[i] = max(dp[i], dp[j] + 1);
		}
		ans = max(ans, dp[i]);
    }
    cout << n - ans;
}
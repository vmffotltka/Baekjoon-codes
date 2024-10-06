#include <bits/stdc++.h>
using namespace std;

const int MAX = (1 << 15);
int dp[MAX][5];

int main() {
    cin.tie(0)->sync_with_stdio(0);
    for (int i = static_cast<int>(sqrt(MAX)); i > 0; i--) {
        dp[i * i][1] = 1;
        for (int j = i * i + 1; j < MAX; j++) {
            dp[j][2] += dp[j - i * i][1];
            dp[j][3] += dp[j - i * i][2];
            dp[j][4] += dp[j - i * i][3];
        }
    }
    while (true) {
        int n; cin >> n;
        if (!n) break;
        cout << dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4] << '\n';
    }
}
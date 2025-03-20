#include <bits/stdc++.h>
#define INF 1000000000
using namespace std;

int N, K, dp[200][200], chk[200][200];
void solve() {
	cin >> N >> K;
	for (int i = 0; i < N; i++) {
		int p; cin >> p;
		chk[i][i] = (1 << p);
	}
	for (int k = 1; k < N; k++) {
		for (int i = 0; i < N - k; i++) {
			int p = INF, c = 0;
			for (int j = 0; j < k; j++) {
				int chk1 = chk[i][i + j], chk2 = chk[i + j + 1][i + k], put = dp[i][i + j] + dp[i + j + 1][i + k];
				if ((chk1 & chk2) == 0) put++;
				if (put < p) {
					p = put;
					c = (chk1 & chk2 ? chk1 & chk2 : chk1 | chk2);
				}
				else if (put == p) {
					c |= (chk1 & chk2 ? chk1 & chk2 : chk1 | chk2);
				}
			}
			dp[i][i + k] = p, chk[i][i + k] = c;
		}
	}
	cout << dp[0][N - 1];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
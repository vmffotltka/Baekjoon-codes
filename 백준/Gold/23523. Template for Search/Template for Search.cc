#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9;
int memo[505][505];
string s;

int dp(int l, int r) {
	if (l > r) return 0;
	if (l == r) {
		if (s[l] == '*') return 0;
		return 1;
	}
	if (memo[l][r] != -1) return memo[l][r];
	int res = INF;

	if (s[l] != '*' && s[r] != '*') {
		if (s[l] == s[r] || s[l] == '?' || s[r] == '?') {
			int val = dp(l + 1, r - 1);
			if (val != INF) res = min(res, 2 + val);
		}
	}

	if (s[l] == '*') {
		int val1 = dp(l + 1, r);
		if (val1 != INF) res = min(res, val1);

		if (s[r] != '*') {
			int val2 = dp(l, r - 1);
			if (val2 != INF) res = min(res, 2 + val2);
		}
	}

	if (s[r] == '*') {
		int val1 = dp(l, r - 1);
		if (val1 != INF) res = min(res, val1);

		if (s[l] != '*') {
			int val2 = dp(l + 1, r);
			if (val2 != INF) res = min(res, 2 + val2);
		}
	}
	return memo[l][r] = res;
}

string build(int l, int r) {
	if (l > r) return "";
	if (l == r) {
		if (s[l] == '*') return "";
		if (s[l] == '?') return "a";
		return string(1, s[l]);
	}
	int res = memo[l][r];

	if (s[l] != '*' && s[r] != '*') {
		if (s[l] == s[r] || s[l] == '?' || s[r] == '?') {
			int val = dp(l + 1, r - 1);
			if (val != INF && res == 2 + val) {
				char m = 'a';
				if (s[l] != '?') m = s[l];
				else if (s[r] != '?') m = s[r];
				return m + build(l + 1, r - 1) + m;
			}
		}
	}

	if (s[l] == '*') {
		int val1 = dp(l + 1, r);
		if (val1 != INF && res == val1)
			return build(l + 1, r);

		if (s[r] != '*') {
			int val2 = dp(l, r - 1);
			if (val2 != INF && res == 2 + val2) {
				char m = (s[r] == '?') ? 'a' : s[r];
				return m + build(l, r - 1) + m;
			}
		}
	}

	if (s[r] == '*') {
		int val1 = dp(l, r - 1);
		if (val1 != INF && res == val1)
			return build(l, r - 1);

		if (s[l] != '*') {
			int val2 = dp(l + 1, r);
			if (val2 != INF && res == 2 + val2) {
				char m = (s[l] == '?') ? 'a' : s[l];
				return m + build(l + 1, r) + m;
			}
		}
	}
	return "";
}

int main() {
	cin.tie(0)->sync_with_stdio(0);
	cin >> s;
	for (int i = 0; i < 505; ++i) {
		for (int j = 0; j < 505; ++j) {
			memo[i][j] = -1;
		}
	}
	int ans = dp(0, s.length() - 1);
	if (ans == INF)
		cout << "-1\n";
	else
		cout << build(0, s.length() - 1) << "\n";
}
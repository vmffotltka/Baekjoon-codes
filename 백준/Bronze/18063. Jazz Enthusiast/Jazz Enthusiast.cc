#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int n, c; cin >> n >> c;
	int answer = 0;
	for (int i = 0; i < n; i++) {
		string s; cin >> s;
		answer += (s[0] - '0') * 60 + (s[2] - '0') * 10 + (s[3] - '0');
	}
	int time = answer - (n - 1) * c;
	int h = time / 60 / 60, m = time / 60 % 60, s = time % 60;
	cout << (h < 10 ? "0" : "") << h << ":" << (m < 10 ? "0" : "") << m << ":" << (s < 10 ? "0" : "") << s;
}
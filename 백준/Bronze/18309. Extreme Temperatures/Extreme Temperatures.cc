#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	string s;
	int mn = 100, mx = -100;
	while (getline(cin, s)) {
		istringstream iss(s);
		string token;
		while (iss >> token) {
			if (token.length() < 4) {
				mn = min(mn, stoi(token));
				mx = max(mx, stoi(token));
			}
		}
	}
	cout << mn << " " << mx;
}
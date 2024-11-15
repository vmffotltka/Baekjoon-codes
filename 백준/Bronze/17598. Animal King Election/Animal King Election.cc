#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int cnt = 0;
	for (int i = 0; i < 9; i++) {
		string s; cin >> s;
		if (s == "Lion") cnt++;
	}
	cout << (cnt > 4 ? "Lion" : "Tiger");
}
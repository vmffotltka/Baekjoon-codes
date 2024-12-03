#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int s, a, b, c; cin >> s >> a >> b >> c;
	cout << (s <= a + b + c || s <= 240 ? "high speed rail" : "flight");
}
#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int a, b, c; cin >> a >> b >> c;
	if (a != 1 && a != 3) cout << "EI";
	else if (b != 6 && b != 8) cout << "EI";
	else if (c != 2 && c != 5) cout << "EI";
	else cout << "JAH";
}
#include <iostream>
#include <cmath>
#include <set>
#include <unordered_set>
#include <map>
#include <unordered_map>
#include <cstring>
#include <vector>
#include <deque>
#include <queue>
#include <algorithm>
#include <list>
#include <string>
#define INF 3000000000
#define MOD 1000
using namespace std;
typedef pair<int, int> pii;
typedef long long ll;

void solve() {
	double M, B, D, T;
	cin >> M >> B >> D >> T;
	double A, a, b, c, minD1, minD2, minD3, t;
	bool trigger = false;
	for (int i = 1; i <= 10; i++) {
		A = -5.5 - M * T;
		a = B * B + M * M;
		b = 2 * M * A - 2 * B * D;
		c = D * D + A * A;
		minD1 = sqrt((4 * a * c - b * b) / (4 * a));
		D += 1;

		b = 2 * M * A - 2 * B * D;
		c = D * D + A * A;
		minD2 = sqrt((4 * a * c - b * b) / (4 * a));
		D += 1;

		b = 2 * M * A - 2 * B * D;
		c = D * D + A * A;
		t = -b / (2 * a);
		minD3 = sqrt((4 * a * c - b * b) / (4 * a));
		D += 2;
		
		if (minD1 <= minD3 || minD3 - 0.5 < 0.0001 || minD2 - 0.5 < 0.0001 || minD1 - 0.5 < 0.0001) trigger = true;
		if (t - T <= 0.0001 || !trigger) continue;
		if (minD1 - 0.5 > 0.0001 && minD2 - 0.5 > 0.0001 && minD3 - 0.5 > 0.0001) {
			if (i == 1)
				cout << "Max beats the first bicycle\n";
			else
				cout << "Max crosses safely after bicycle " << i - 1 << '\n';
			return;
		}
		else if (minD1 - 0.5 <= 0.0001 || minD2 - 0.5 <= 0.0001 || minD3 - 0.5 <= 0.0001) {
			cout << "Collision with bicycle " << i << '\n';
			return;
		}
	}
	cout << "Max crosses safely after bicycle 10\n";
}

int t;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> t; // 1 ~ 100
	while (t--)
		solve();
}
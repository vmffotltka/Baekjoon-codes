#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <stack>
#include <unordered_map>
#include <queue>
#define INF 987654321;
using namespace std;

int sero, garo;
vector<string> v;
int min(int a, int b) { return (a <= b) ? a : b; }

void input() {
	cin >> sero >> garo;
	for (int i = 0; i < sero; i++) {
		string put;
		cin >> put;
		v.push_back(put);
	}
}

bool check(int y, int x) {
	for (int i = 1; i < 10; i++) {
		int y_start = y - i; int x_start = x - i;
		int y_end = y + i; int x_end = x + i;
		bool flag = false;
		for (int j = x_start; j <= x_end; j++) {
			if (0 > j || j >= garo) { continue; }
			if (y_start >= 0) {
				if (v[y_start][j] == '1') {
					if (!flag) {
						flag = true;
					}
					else {
						return false;
					}
				}
			}
			if (y_end < sero) {
				if (v[y_end][j] == '1') {
					if (!flag) {
						flag = true;
					}
					else {
						return false;
					}
				}
			}
		}
		for (int j = y_start + 1; j <= y_end - 1; j++) {
			if (0 > j || j >= sero) { continue; }
			if (x_start >= 0) {
				if (v[j][x_start] == '1') {
					if (!flag) {
						flag = true;
					}
					else {
						return false;
					}
				}
			}
			if (x_end < garo) {
				if (v[j][x_end] == '1') {
					if (!flag) {
						flag = true;
					}
					else {
						return false;
					}
				}
			}
		}
		if (!flag) { return false; }
	}
	return true;
}

void solve() {
	input();
	for (int i = 0; i < sero; i++) {
		for (int j = 0; j < garo; j++) {
			if (v[i][j] == '1') {
				if (check(i, j)) {
					cout << i << ' ' << j;
					return;
				}
			}
		}
	}
	cout << -1;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
#include <iostream>
#include <cmath>
#include <set>
#include <cstring>
#include <vector>
#include <deque>
#include <queue>
#include <stack>
#include <algorithm>
#include <list>
#include <string>
#include <map>
#include <unordered_map>
#define INF 987654321
#define MOD 1000003
using namespace std;
typedef long long ll;

int n;
string arr[1250];
bool visited[1250][1250];
vector<string> ans;

bool compare(string a, string b) {
	string y1, x1, y2, x2;
	bool t = true;
	for (auto i : a) {
		if (t && i == ' ') t = false;
		else if (!t && i == ' ') break;
		else if (t) y1 += i;
		else if (!t) x1 += i;
	}
	t = true;
	for (auto i : b) {
		if (t && i == ' ') t = false;
		else if (!t && i == ' ') break;
		else if (t) y2 += i;
		else if (!t) x2 += i;
	}
	int Y1 = stoi(y1), Y2 = stoi(y2), X1 = stoi(x1), X2 = stoi(x2);
	if (Y1 < Y2) return true;
	else if (Y1 == Y2) {
		if (X1 < X2) return true;
		else return false;
	}
	else return false;
}

void solve() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!visited[i][j] && arr[i][j] == '#') {
				int len = 1, s = 0, g = 0;
				bool sero = true, garo = true;
				for (int k = 0; i + k < n && j + k < n; k++) {
					if (!sero && !garo) break;
					if (garo && arr[i][j + k] == '#') g++;
					else garo = false;
					if (sero && arr[i + k][j] == '#') s++;
					else sero = false;
				}
				len = max(s, g);
				int s2 = 0, g2 = 0;
				sero = true, garo = true;
				for (int k = 0; k < len; k++) {
					if (garo && arr[i + len - 1][j + len - 1 - k] == '#') g2++;
					else garo = false;
					if (sero && arr[i + len - 1 - k][j + len - 1] == '#') s2++;
					else sero = false;
				}

				if (s == s2 && s == g2 && g == 1) {
					ans.push_back(to_string(i + len / 2 + 1) +" " + to_string(j + len / 2 + 1) + " " + to_string(len) + " UL");
				}
				else if (s == s2 && s == g2 && g != 1) {
					ans.push_back(to_string(i + len / 2 + 1) + " " + to_string(j + len / 2 + 1) + " " + to_string(len) + " UR");
				}
				else if (g == s2 && g == g2 && s == 1) {
					ans.push_back(to_string(i + len / 2 + 1) + " " + to_string(j + len / 2 + 1) + " " + to_string(len) + " LU");
				}
				else if (g == s2 && g == g2 && s != 1) {
					ans.push_back(to_string(i + len / 2 + 1) + " " + to_string(j + len / 2 + 1) + " " + to_string(len) + " LD");
				}
				else if (s == g && s == g2 && s2 == 1) {
					ans.push_back(to_string(i + len / 2 + 1) + " " + to_string(j + len / 2 + 1) + " " + to_string(len) + " RD");
				}
				else if (s == g && s == g2 && s2 != 1) {
					ans.push_back(to_string(i + len / 2 + 1) + " " + to_string(j + len / 2 + 1) + " " + to_string(len) + " RU");
				}
				else if (s == g && s == s2 && g2 == 1) {
					ans.push_back(to_string(i + len / 2 + 1) + " " + to_string(j + len / 2 + 1) + " " + to_string(len) + " DR");
				}
				else if (s == g && s == s2 && g2 != 1) {
					ans.push_back(to_string(i + len / 2 + 1) + " " + to_string(j + len / 2 + 1) + " " + to_string(len) + " DL");
				}

				for (int k = 0; k < len; k++) {
					for (int l = 0; l < len; l++) {
						visited[i + k][j + l] = true;
					}
				}
			}
		}
	}
	cout << ans.size() << '\n';
	sort(ans.begin(), ans.end(), compare);
	for (auto i : ans) {
		cout << i << '\n';
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
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
#define INF 2'000'000'000
#define PI 3.14159265358979323846264338327
#define MOD 1'000'000'003
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

int sero, garo, len;
string s;
void solve() {
	cin >> sero >> garo >> len;
	vector<string> arr(sero);
	for (int i = 0; i < sero; i++) cin >> arr[i];
	cin >> s;
	unordered_map<char, deque<pii>> idArr;
	unordered_set<char> id;
	for (int i = 0; i < len; i++)
		id.insert(s[i]);
	for (int i = 0; i < sero; i++) {
		for (int j = 0; j < garo; j++) {
			if (id.count(arr[i][j]))
				idArr[arr[i][j]].push_back({ i, j });
		}
	}
	int C = 0;
	string L = "";
	pii cur = { 0, 0 };
	bool ans = true;
	while (true) {
		string tmp = "";
		pii preCoor = cur;
		for (int i = 0; i < len; i++) {
			if (idArr[s[i]].empty()) { ans = false; break; }
			pii next = idArr[s[i]].front();
			idArr[s[i]].pop_front();
			int dy = next.first - preCoor.first, dx = next.second - preCoor.second;
			if (dx > 0) {
				string put(dx, 'R');
				tmp += put;
			}
			else if (dx < 0) {
				string put(-dx, 'L');
				tmp += put;
			}
			if (dy > 0) {
				string put(dy, 'D');
				tmp += put;
			}
			else if (dy < 0) {
				string put(-dy, 'U');
				tmp += put;
			}
			tmp += "P";
			preCoor = next;
		}
		if (!ans) break;
		C++;
		L += tmp;
		tmp = "";
		cur = preCoor;
	}
	int DX = garo - 1 - cur.second, DY = sero - 1 - cur.first;
	if (DX > 0) {
		string put(DX, 'R');
		L += put;
	}
	else if (DX < 0) {
		string put(-DX, 'L');
		L += put;
	}
	if (DY > 0) {
		string put(DY, 'D');
		L += put;
	}
	else if (DY < 0) {
		string put(-DY, 'U');
		L += put;
	}
	cout << C << ' ' << L.length() << '\n';
	cout << L;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
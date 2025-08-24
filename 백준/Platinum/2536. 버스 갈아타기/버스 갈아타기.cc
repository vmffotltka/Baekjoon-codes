#include <iostream>
#include <cmath>
#include <set>
#include <unordered_set>
#include <map>
#include <unordered_map>
#include <cstring>
#include <vector>
#include <deque>
#include <algorithm>
#include <list>
#include <string>
#define INF 987654321
#define MOD 1000
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
typedef tuple<int, int, int> tiii;

struct Bus {
	int start, end, busNum;
	Bus(int a, int b, int c) {
		start = a, end = b, busNum = c;
	}
};
struct BusInfo {
	int sx, sy, dx, dy;
	BusInfo(int a, int b, int c, int d) {
		sx = a, sy = b, dx = c, dy = d;
	}
	BusInfo() {}
};

int garo, sero, B, sx, sy, dx, dy;
vector<Bus> garoBus[100001], seroBus[100001];
// 0 -> start, 1 -> end, 2 -> busNum, 3 -> idx
bool visited[5001];
BusInfo info[5001];

void input() {
	cin >> garo >> sero;
	cin >> B;
	int num, x1, y1, x2, y2;
	for (int i = 0; i < B; i++) {
		cin >> num >> x1 >> y1 >> x2 >> y2;
		if (y1 > y2) swap(y1, y2);
		if (x1 > x2) swap(x1, x2);
		if (x1 == x2) seroBus[x1].push_back({ y1, y2, num });
		else if (y1 == y2) garoBus[y1].push_back({ x1, x2, num });
		info[num] = { x1, y1, x2, y2 };
	}
	cin >> sx >> sy >> dx >> dy;
}

int bfs() {
	deque<BusInfo> que, tmp;
	int ret = 1;
	for (auto bus : seroBus[sx]) {
		int start = bus.start, end = bus.end, busNum = bus.busNum;
		if (start <= sy && sy <= end) {
			que.push_back(info[busNum]);
			visited[busNum] = true;
		}
	}
	for (auto bus : garoBus[sy]) {
		int start = bus.start, end = bus.end, busNum = bus.busNum;
		if (start <= sx && sx <= end) {
			que.push_back(info[busNum]);
			visited[busNum] = true;
		}
	}
	while (!que.empty()) {
		int startx = que.front().sx, starty = que.front().sy, endx = que.front().dx, endy = que.front().dy;
		que.pop_front();
		if (startx == endx) { // sero bus
			if (startx == dx && starty <= dy && dy <= endy) return ret;
			for (int i = starty; i <= endy; i++) {
				for (auto bus : garoBus[i]) {
					int start = bus.start, end = bus.end, busNum = bus.busNum;
					if (!visited[busNum] && start <= startx && startx <= end) {
						visited[busNum] = true;
						tmp.push_back(info[busNum]);
					}
				}
			}
			for (auto bus : seroBus[startx]) {
				int start = bus.start, end = bus.end, busNum = bus.busNum;
				if (!visited[busNum] && !(start > endy || end < starty)) {
					visited[busNum] = true;
					tmp.push_back(info[busNum]);
				}
			}
		}
		else if (starty == endy) { // garo bus
			if (starty == dy && startx <= dx && dx <= endx) return ret;
			for (int i = startx; i <= endx; i++) {
				for (auto bus : seroBus[i]) {
					int start = bus.start, end = bus.end, busNum = bus.busNum;
					if (!visited[busNum] && start <= starty && starty <= end) {
						visited[busNum] = true;
						tmp.push_back(info[busNum]);
					}
				}
			}
			for (auto bus : garoBus[starty]) {
				int start = bus.start, end = bus.end, busNum = bus.busNum;
				if (!visited[busNum] && !(start > endx || end < startx)) {
					visited[busNum] = true;
					tmp.push_back(info[busNum]);
				}
			}
		}
		if (que.empty()) {
			swap(que, tmp);
			ret++;
		}
	}
}

void solve() {
	input();
	cout << bfs();
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
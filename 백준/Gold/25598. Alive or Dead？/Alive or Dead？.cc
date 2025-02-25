#include <bits/stdc++.h>
#define INF 2000000000
#define MOD 1000000
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

struct Zombie {
	int y, x, grade, dir, speed;
};

char ds[4] = { 'U', 'R', 'D', 'L' };
int dy[4] = { -1, 0, 1, 0 };
int dx[4] = { 0, 1, 0, -1 };
int N, W, Z, D, Y, X, arr[26][26];
string C; vector<Zombie> zombie;

void input() {
	cin >> N;
	cin >> C;
	cin >> Y >> X >> W;
	int wy, wx;
	for (int i = 0; i < W; i++) {
		cin >> wy >> wx;
		arr[wy][wx] = -1;
	}
	cin >> Z;
	int y, x, grade, ndir, speed; char dir;
	for (int i = 0; i < Z; i++) {
		cin >> y >> x >> grade;
		cin >> dir;
		for (int j = 0; j < 4; j++) {
			if (ds[j] != dir) continue;
			ndir = j;
			break;
		}
		cin >> speed;
		zombie.push_back({ y, x, grade, ndir, speed });
	}
	cin >> D;
}

void player_move(char cmd) {
	for (int i = 0; i < 4; i++) {
		if (ds[i] != cmd) continue;
		int ny = Y + dy[i], nx = X + dx[i];
		if (1 <= ny && ny <= N && 1 <= nx && nx <= N && arr[ny][nx] != -1) {
			Y = ny, X = nx;
			break;
		}
	}
}

bool zombie_move() {
	for (auto &z : zombie) {
		for (int i = 0; i < 4; i++) {
			if (i != z.dir) continue;
			bool out_ = false, wall = false;
			int move = z.speed;
			while (move--) {
				int ny = z.y + dy[i], nx = z.x + dx[i];
				if (1 <= ny && ny <= N && 1 <= nx && nx <= N) {
					if (arr[ny][nx] == -1) {
						wall = true;
						break;
					}
					z.y = ny, z.x = nx;
				}
				else {
					out_ = true;
					break;
				}
			}
			if (z.grade == 0) {
				if (out_ || wall) z.dir = (z.dir + 2) % 4;
			}
			else {
				if (wall) arr[z.y + dy[i]][z.x + dx[i]] = 0;
				int wmax = -1;
				for (int j = 0; j < 4; j++) {
					int n = 1, wcnt = 0;
					while (true) {
						int ny = z.y + dy[j] * n, nx = z.x + dx[j] * n;
						if (1 <= ny && ny <= N && 1 <= nx && nx <= N) {
							if (arr[ny][nx] == -1) wcnt++;
							n++;
						}
						else {
							if (wmax < wcnt) { z.dir = j; wmax = wcnt; }
							break;
						}
					}
				}
			}
			break;
		}
		if (z.y == Y && z.x == X) return false;
	}
	return true;
}

void solve() {
	input();
	int day = 1;
	for (auto cmd : C) {
		player_move(cmd);
		if (!zombie_move()) { day--; break; }
		day++;
	}
	if (day >= D) cout << "ALIVE!";
	else cout << day + 1 << '\n' << "DEAD...";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
}
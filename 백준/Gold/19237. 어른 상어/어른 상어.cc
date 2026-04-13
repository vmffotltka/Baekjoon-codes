#include <bits/stdc++.h>
using namespace std;

struct Shark {
    int y, x, dir;
    bool alive;
};

int dy[] = { 0, -1, 1, 0, 0 };
int dx[] = { 0, 0, 0, -1, 1 };

int N, M, K;
Shark sharks[401];
int smell_owner[20][20], smell_time[20][20];
int priority[401][5][5];


int main() {
    cin.tie(0)->sync_with_stdio(0);
	cin >> N >> M >> K;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            int id; cin >> id;
            if (id > 0) {
				sharks[id] = { i, j, 0, true };
				smell_owner[i][j] = id;
				smell_time[i][j] = K;
            }
        }
    }
    for (int i = 1; i <= M; i++) cin >> sharks[i].dir;
    for (int i = 1; i <= M; i++) {
        for (int d = 1; d <= 4; d++) {
            for (int k = 1; k <= 4; k++) {
                cin >> priority[i][d][k];
            }
		}
    }

    int left_sharks = M, time = 0;
    while (time < 1000) {
        time++;
		int next_board[20][20] = { 0 };
        for (int i = 1; i <= M; i++) {
            if (!sharks[i].alive) continue;
            
			int y = sharks[i].y, x = sharks[i].x, d = sharks[i].dir;
			int nextY = -1, nextX = -1, nextD = -1;
            for (int k = 1; k <= 4; k++) {
				int nd = priority[i][d][k], ny = y + dy[nd], nx = x + dx[nd];
                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if (smell_time[ny][nx] == 0) {
						nextY = ny; nextX = nx; nextD = nd;
                        break;
                    }
                }
            }
            if (nextY == -1) {
                for (int k = 1; k <= 4; k++) {
					int nd = priority[i][d][k], ny = y + dy[nd], nx = x + dx[nd];
                    if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                        if (smell_owner[ny][nx] == i) {
                            nextY = ny; nextX = nx; nextD = nd;
                            break;
                        }
                    }
                }
            }
			sharks[i].y = nextY; sharks[i].x = nextX; sharks[i].dir = nextD;

			if (next_board[nextY][nextX] == 0) {
                next_board[nextY][nextX] = i;
            }
            else {
                sharks[i].alive = false;
                left_sharks--;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smell_time[i][j] > 0) {
                    smell_time[i][j]--;
                    if (smell_time[i][j] == 0) {
                        smell_owner[i][j] = 0;
                    }
                }
			}
        }
		for (int i = 1; i <= M; i++) {
            if (!sharks[i].alive) continue;
            int y = sharks[i].y, x = sharks[i].x;
            smell_owner[y][x] = i;
            smell_time[y][x] = K;
        }
        if (left_sharks == 1) {
            cout << time;
			return 0;
        }
    }
    cout << -1;
}
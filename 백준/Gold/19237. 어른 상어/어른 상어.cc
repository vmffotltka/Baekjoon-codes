#include <bits/stdc++.h>
using namespace std;

const int MAX = 401;

int dy[] = { -1, 1, 0, 0 };
int dx[] = { 0, 0, -1, 1 };
int N, M, K;
int arr[20][20], t[20][20];
int priority[MAX][4][4];
int dir[MAX];
queue<int> shark[20][20];

void reduceSmell() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (arr[i][j]) {
                t[i][j]--;
                if (!t[i][j])
                    arr[i][j] = 0;
            }
        }
    }
}

void move() {
    vector<vector<bool>> canGo(N, vector<bool>(N));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
			canGo[i][j] = t[i][j] == 0;
        }
    }
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (!(!shark[i][j].empty() && t[i][j] == K)) continue;
			int curShark = shark[i][j].front();
            int d = dir[curShark];
            int backY = -1, backX = -1, backDir = -1;
            for (int k = 0; k < 4; k++) {
				int ny = i + dy[priority[curShark][d][k]];
				int nx = j + dx[priority[curShark][d][k]];
				if (0 > ny || ny >= N || 0 > nx || nx >= N) continue;
                if (arr[ny][nx] == curShark && backY == -1)
                    backY = ny, backX = nx, backDir = k;
                else if (canGo[ny][nx]) {
                    arr[ny][nx] = curShark;
					t[ny][nx] = K + 1;
                    dir[curShark] = priority[curShark][d][k];
					shark[ny][nx].push(curShark);
					shark[i][j].pop();
                    break;
                }
            }
            if (!shark[i][j].empty() && shark[i][j].front() == curShark) {
				arr[backY][backX] = curShark;
				t[backY][backX] = K + 1;
                dir[curShark] = priority[curShark][d][backDir];
				shark[backY][backX].push(curShark);
				shark[i][j].pop();
            }
        }
    }
}

int removeAndRemain() {
    int remain = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
			if (shark[i][j].empty()) continue;
            int mn = MAX;
            int size = shark[i][j].size();
            for (int k = 0; k < size; k++) {
                int curShark = shark[i][j].front();
                mn = min(mn, curShark);
                shark[i][j].pop();
            }
            arr[i][j] = mn;
			shark[i][j].push(mn);
            remain++;
        }
    }
	return remain;
}

void input() {
    cin >> N >> M >> K;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> arr[i][j];
            if (arr[i][j]) {
                shark[i][j].push(arr[i][j]);
				t[i][j] = K;
            }
        }
    }
    for (int i = 1; i <= M; i++) {
        cin >> dir[i];
        dir[i]--;
    }
    for (int i = 1; i <= M; i++) {
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                cin >> priority[i][j][k];
                priority[i][j][k]--;
            }
        }
    }
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    input();
    int time = 0;
    while (++time < 1001) {
        move();
        reduceSmell();
        if (removeAndRemain() == 1)
            break;
    }
	cout << (time == 1001 ? -1 : time);
}
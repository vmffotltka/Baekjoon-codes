#include <bits/stdc++.h>
using namespace std;

const int MAX_STATES = 5 * 5 * 5 * 5 * 5 * 5; // 최대 가능한 상태 수

// 상태 벡터를 정수로 변환하는 함수
int convertStateToInt(const vector<int>& stateVec) {
    int stateInt = 0;
    for (auto value : stateVec) stateInt = 5 * stateInt + value;
    return stateInt;
}

// 정수를 상태 벡터로 변환하는 함수
void convertIntToState(vector<int>& stateVec, int stateInt) {
    stateVec.resize(6);
    for (int i = 5; i >= 0; i--) {
        stateVec[i] = stateInt % 5;
        stateInt /= 5;
    }
}

vector<bool> visited(MAX_STATES), isWinning(MAX_STATES);

// 상태에 대한 재귀 DFS 탐색 함수
bool performDFS(int currentState) {
    vector<int> currentStateVec;
    convertIntToState(currentStateVec, currentState);

    // 이미 방문한 상태라면 그 상태의 승리 여부 반환
    if (visited[currentState]) return isWinning[currentState];

    visited[currentState] = true;
    int currentSum = 0;

    // 현재 상태의 합 계산
    for (int i = 0; i < 6; i++) {
        currentSum += (4 - currentStateVec[i]) * (i + 1);
    }

    // 가능한 모든 이동에 대해 재귀 탐색
    for (int i = 0; currentSum + i + 1 <= 31 && i <= 5; i++) {
        if (currentStateVec[i] > 0) {
            currentStateVec[i]--;
            // 상대방이 이길 수 없는 경우 현재 상태를 승리 상태로 기록
            if (!performDFS(convertStateToInt(currentStateVec))) isWinning[currentState] = true;
            currentStateVec[i]++;
        }
    }

    return isWinning[currentState];
}

// 입력을 처리하고 결과를 출력하는 함수
void solve() {
    string input;
    int testCases;
    cin >> testCases;
    while (testCases--) {
        cin >> input;
        vector<int> initialStateVec(6, 4);
        for (auto ch : input) {
            initialStateVec[ch - '1']--;
        }

        // 초기 상태를 정수로 변환한 후 DFS 호출
        cout << "BA"[performDFS(convertStateToInt(initialStateVec)) ^ (input.size() % 2)] << "\n";
    }
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    solve();
}
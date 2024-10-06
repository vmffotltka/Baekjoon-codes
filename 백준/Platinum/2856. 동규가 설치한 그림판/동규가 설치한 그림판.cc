#include <bits/stdc++.h>
using namespace std;

const int MAXN = 1100;      // 최대 행 수
const int MAXM = 100100;    // 최대 명령 수

// 사각형을 나타내는 구조체
struct Rectangle {
    int id, color, x1, y1, x2, y2; // 사각형의 ID, 색상, 좌표
    Rectangle() {}
    Rectangle(int _id, int _color, int _x1, int _y1, int _x2, int _y2) {
        id = _id; color = _color; x1 = _x1; y1 = _y1; x2 = _x2; y2 = _y2;
    }
};

// 사각형을 비교하기 위한 구조체
struct Compare {
    bool operator () (const Rectangle& A, const Rectangle& B) const {
        return A.id > B.id; // ID를 기준으로 비교
    }
};

int N, K, M, S; // 행, 열, 명령 수, 저장 수
enum { SAVE, LOAD, PAINT }; // 명령 종류
int command[MAXM]; // 명령 배열
int save[MAXM]; // 저장된 상태
int load[MAXM]; // 로드할 상태
Rectangle paint[MAXM]; // 그릴 사각형

vector<Rectangle> start[MAXN]; // 시작 지점에 그릴 사각형 목록
vector<Rectangle> finish[MAXN]; // 끝 지점에 그릴 사각형 목록

int isOdd = 1; // 홀수 여부
inline int getColorIndex(int x) { return (x & 1) ? isOdd : !isOdd; } // 색상 인덱스 반환

// 노드를 나타내는 구조체
struct Node {
    set<Rectangle, Compare> rectangles[2]; // 색상에 따른 사각형 집합
    Node() {}
};

// 세그먼트 트리를 나타내는 구조체
struct SegmentTree {
    Node tree[2 * MAXN]; // 트리 배열
    Rectangle rect; // 현재 처리 중인 사각형
    int a, b; // y1, y2 좌표

    // 구간에 사각형 추가 또는 삭제
    void apply(int index, int lo, int hi, int action) {
        if (lo > b || hi < a) return; // 범위 밖이면 종료

        if (a <= lo && hi <= b) { // 범위가 완전히 포함된 경우
            if (action) {
                tree[index].rectangles[getColorIndex(a)].insert(rect); // 추가
            }
            else {
                tree[index].rectangles[getColorIndex(a ^ (rect.x2 - rect.x1 + 1))].erase(rect); // 삭제
            }
            return;
        }

        apply(2 * index, lo, (lo + hi) / 2, action); // 왼쪽 자식 노드
        apply(2 * index + 1, (lo + hi) / 2 + 1, hi, action); // 오른쪽 자식 노드
    }

    // 사각형 추가
    void insert(Rectangle _rect) {
        rect = _rect; a = rect.y1; b = rect.y2;
        apply(1, 0, 1 << 10, 1); // 추가 동작
    }

    // 사각형 삭제
    void remove(Rectangle _rect) {
        rect = _rect; a = rect.y1; b = rect.y2;
        apply(1, 0, 1 << 10, 0); // 삭제 동작
    }

    // 쿼리 수행
    int query(int index, int lo, int hi) {
        int result = -1; // 결과 초기화
        if (lo > a || hi < a) return result; // 범위 밖이면 종료

        if (!tree[index].rectangles[getColorIndex(a)].empty())
            result = max(result, tree[index].rectangles[getColorIndex(a)].begin()->id); // 사각형 ID 비교

        if (lo == hi) return result; // 리프 노드이면 종료
        result = max(result, query(2 * index, lo, (lo + hi) / 2)); // 왼쪽 자식 쿼리
        result = max(result, query(2 * index + 1, (lo + hi) / 2 + 1, hi)); // 오른쪽 자식 쿼리
        return result;
    }

    // 색상 쿼리
    int query(int x) {
        a = x;
        int result = query(1, 0, 1 << 10);
        return (result == -1) ? 1 : paint[result].color; // 결과 반환
    }
} segmentTree;

int main(void) {
    cin.tie(0)->sync_with_stdio(false); // 빠른 입출력

    cin >> N >> K >> M; // 입력 받기

    for (int i = 0; i < M; ++i) {
        string commandStr; cin >> commandStr; // 명령어 입력
        char commandChar = commandStr[0];

        if (commandChar == 'S') {
            command[i] = SAVE;
            save[i] = ++S; // 저장 상태
        }
        else if (commandChar == 'L') {
            int x; cin >> x;
            command[i] = LOAD;
            load[i] = x; // 로드할 상태
        }
        else if (commandChar == 'P') {
            int color, x1, y1, x2, y2;
            cin >> color >> x1 >> y1 >> x2 >> y2;
            command[i] = PAINT;
            paint[i] = Rectangle(i, color, x1, y1, x2, y2); // 그릴 사각형 정보 저장
        }
    }

    // 명령어 역순 처리
    for (int i = M - 1; i >= 0; --i) {
        if (command[i] == SAVE) {
            // 저장 명령어 처리
        }
        else if (command[i] == LOAD) {
            int x = load[i];
            while (save[i] != x) --i; // 저장 명령어로 돌아가기
        }
        else if (command[i] == PAINT) {
            start[paint[i].x1].push_back(paint[i]); // 시작 지점에 추가
            finish[paint[i].x2 + 1].push_back(paint[i]); // 끝 지점에 추가
        }
    }

    // 행별 처리
    for (int row = 0; row < N; ++row, isOdd ^= 1) {
        for (const auto& rect : finish[row])
            segmentTree.remove(rect); // 끝 지점에서 제거
        for (const auto& rect : start[row])
            segmentTree.insert(rect); // 시작 지점에서 추가
        for (int col = 0; col < N; ++col)
            cout << segmentTree.query(col) << " "; // 쿼리 결과 출력
        cout << "\n"; // 행 구분
    }
}
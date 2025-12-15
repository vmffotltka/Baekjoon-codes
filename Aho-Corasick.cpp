#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <string>

using namespace std;

/**
 * @brief Aho-Corasick Algorithm Optimized Template
 * Time Complexity: O(Sum of Pattern Lengths + Text Length + Matches)
 */
struct AhoCorasick {
    static const int ALPHABETS = 26; // 알파벳 소문자 기준
    
    // 문자를 인덱스로 변환 (문제에 따라 수정: 'A', '0' 등)
    static int toIndex(char c) { return c - 'a'; }

    struct Node {
        int children[ALPHABETS];
        int fail;      // 실패 링크 (실패 시 이동할 노드 인덱스)
        bool isEnd;    // 패턴의 끝 여부 (필요 시 int count 등으로 변경)

        Node() {
            fill(children, children + ALPHABETS, 0); // 0은 더미/루트 노드를 의미하므로 nullptr 대신 사용
            fail = 0;
            isEnd = false;
        }
    };

    vector<Node> nodes;

    AhoCorasick() {
        init();
    }

    void init() {
        nodes.clear();
        nodes.emplace_back(); // Root 노드 (Index 0) 생성
    }

    // 패턴 삽입
    void insert(const string& s) {
        int curr = 0; // Root에서 시작
        for (char c : s) {
            int idx = toIndex(c);
            // 자식 노드가 없으면 생성
            if (nodes[curr].children[idx] == 0) {
                nodes[curr].children[idx] = nodes.size();
                nodes.emplace_back();
            }
            curr = nodes[curr].children[idx];
        }
        nodes[curr].isEnd = true; // 패턴 끝 표시
    }

    // 실패 링크 및 트라이 그래프 구축 (BFS)
    void build() {
        queue<int> q;
        
        // Root의 자식들을 큐에 삽입 (Root의 fail은 0)
        for (int i = 0; i < ALPHABETS; i++) {
            int nextNode = nodes[0].children[i];
            if (nextNode != 0) {
                nodes[nextNode].fail = 0; // Root의 직계 자식은 실패 시 Root로
                q.push(nextNode);
            }
        }

        while (!q.empty()) {
            int curr = q.front();
            q.pop();

            // 중요: 출력 링크 전파 (A 패턴이 B 패턴의 접미사일 경우, B를 찾으면 A도 찾은 것)
            // 예: "she"를 찾으면 "he"도 찾은 것으로 처리
            nodes[curr].isEnd |= nodes[nodes[curr].fail].isEnd;

            for (int i = 0; i < ALPHABETS; i++) {
                int nextNode = nodes[curr].children[i];
                
                if (nextNode != 0) {
                    // 자식이 있는 경우:
                    // 자식의 fail = (내 fail 노드)의 해당 자식
                    int dest = nodes[curr].fail;
                    nodes[nextNode].fail = nodes[dest].children[i];
                    q.push(nextNode);
                } else {
                    // [Trie Graph 최적화]
                    // 자식이 없는 경우: "내 fail 노드가 가리키는 곳"으로 바로 연결해버림
                    // 이렇게 하면 검색(query) 할 때 while 루프 없이 O(1) 이동 가능
                    int dest = nodes[curr].fail;
                    nodes[curr].children[i] = nodes[dest].children[i];
                }
            }
        }
    }

    // 텍스트에서 패턴 존재 여부 확인 (문제 로직에 따라 수정 가능)
    bool query(const string& s) {
        int curr = 0;
        bool found = false;
        
        for (char c : s) {
            int idx = toIndex(c);
            // Trie Graph 최적화 덕분에 while 루프 없이 바로 이동
            curr = nodes[curr].children[idx];
            
            if (nodes[curr].isEnd) {
                found = true;
                // 하나라도 찾으면 종료하는 문제라면 여기서 return true;
                // 모든 패턴을 찾아야 한다면 여기서 카운팅 로직 추가
            }
        }
        return found;
    }
};

// --- 사용 예시 (백준 문제 스타일) ---
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    if (!(cin >> N)) return 0;

    AhoCorasick ac;

    // 패턴 입력
    for (int i = 0; i < N; i++) {
        string s;
        cin >> s;
        ac.insert(s);
    }

    // 실패 링크 구축 (필수!)
    ac.build();

    // 텍스트 검색
    cin >> M;
    for (int i = 0; i < M; i++) {
        string s;
        cin >> s;
        if (ac.query(s)) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }

    return 0;
}

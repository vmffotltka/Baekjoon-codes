#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * @brief Bipartite Matching Algorithm (DFS based)
 * Time Complexity: O(V * E)
 * Optimization: Uses 'visit token' to avoid memset overhead
 */
struct BipartiteMatching {
    int n_left, n_right;       // 왼쪽 그룹 크기, 오른쪽 그룹 크기
    vector<vector<int>> adj;   // 인접 리스트 (Left -> Right)
    vector<int> matched;       // matched[right_node] = left_node (오른쪽 노드가 누구랑 매칭됐는지)
    vector<int> visited;       // 방문 체크용 (bool 대신 int 사용)
    int visitToken;            // 현재 DFS 턴의 방문 토큰

    // 초기화: 왼쪽 그룹 크기, 오른쪽 그룹 크기 (1-based indexing 고려하여 넉넉하게 잡거나 +1)
    void init(int left, int right) {
        n_left = left;
        n_right = right;
        adj.assign(n_left + 1, vector<int>());
        matched.assign(n_right + 1, -1);
        visited.assign(n_right + 1, 0);
        visitToken = 0;
    }

    // 간선 추가 (u: 왼쪽 그룹, v: 오른쪽 그룹)
    void addEdge(int u, int v) {
        adj[u].push_back(v);
    }

    // DFS로 매칭 시도
    bool dfs(int u) {
        for (int v : adj[u]) {
            // 이번 턴(visitToken)에 이미 방문했다면 패스
            if (visited[v] == visitToken) continue;
            visited[v] = visitToken;

            // v가 아직 매칭 안 됐거나, v의 기존 매칭 상대를 다른 곳으로 보낼 수 있다면
            if (matched[v] == -1 || dfs(matched[v])) {
                matched[v] = u; // 매칭 성공
                return true;
            }
        }
        return false;
    }

    // 전체 최대 매칭 수행
    int solve() {
        int matchCount = 0;
        for (int i = 1; i <= n_left; i++) {
            visitToken++; // 이번 턴의 고유 번호 증가 (memset 대체)
            if (dfs(i)) {
                matchCount++;
            }
        }
        return matchCount;
    }
    
    // (선택) 현재 매칭 상태 반환
    vector<pair<int, int>> getMatches() {
        vector<pair<int, int>> result;
        for(int i=1; i<=n_right; i++) {
            if(matched[i] != -1) result.push_back({matched[i], i});
        }
        return result;
    }
};

// --- 사용 예시 (백준 11375번: 열혈강호 등) ---
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M; // N: 직원(Left), M: 일(Right)
    if (!(cin >> N >> M)) return 0;

    BipartiteMatching bm;
    bm.init(N, M);

    for (int i = 1; i <= N; i++) {
        int cnt; cin >> cnt;
        for (int j = 0; j < cnt; j++) {
            int work; cin >> work;
            bm.addEdge(i, work);
        }
    }

    cout << bm.solve() << "\n";

    return 0;
}

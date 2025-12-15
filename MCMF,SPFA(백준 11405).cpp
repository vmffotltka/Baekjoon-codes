#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

const int INF = 1e9;
const long long LINF = 1e18; // 비용은 long long 범위일 수 있음

/**
 * @brief Min-Cost Max-Flow (MCMF) Implementation using SPFA
 * Time Complexity: O(V * E * F) in worst case, but usually much faster (O(kE))
 */
struct MCMF {
    struct Edge {
        int to;
        int capacity;
        int flow;
        int cost; // 비용
        int rev;  // 역방향 간선 인덱스
    };

    vector<vector<Edge>> adj;
    vector<long long> dist;
    vector<int> parent;
    vector<int> parentEdge;
    int n;

    // 초기화
    void init(int nodes) {
        n = nodes;
        adj.assign(n, vector<Edge>());
        dist.resize(n);
        parent.resize(n);
        parentEdge.resize(n);
    }

    // 간선 추가 (유향)
    void addEdge(int u, int v, int cap, int cost) {
        Edge a = { v, cap, 0, cost, (int)adj[v].size() };
        Edge b = { u, 0, 0, -cost, (int)adj[u].size() }; // 역방향 간선: 용량 0, 비용 -cost
        adj[u].push_back(a);
        adj[v].push_back(b);
    }

    // SPFA를 이용해 최단 경로(최소 비용 경로) 탐색
    bool spfa(int source, int sink) {
        fill(dist.begin(), dist.end(), LINF);
        fill(parent.begin(), parent.end(), -1);
        fill(parentEdge.begin(), parentEdge.end(), -1);
        vector<bool> inQueue(n, false);
        queue<int> q;

        dist[source] = 0;
        q.push(source);
        inQueue[source] = true;

        while (!q.empty()) {
            int u = q.front();
            q.pop();
            inQueue[u] = false;

            for (int i = 0; i < adj[u].size(); i++) {
                Edge& e = adj[u][i];
                // 용량이 남아있고, 더 적은 비용으로 갈 수 있다면 갱신
                if (e.capacity - e.flow > 0 && dist[e.to] > dist[u] + e.cost) {
                    dist[e.to] = dist[u] + e.cost;
                    parent[e.to] = u;
                    parentEdge[e.to] = i;

                    if (!inQueue[e.to]) {
                        q.push(e.to);
                        inQueue[e.to] = true;
                    }
                }
            }
        }

        return dist[sink] != LINF; // 싱크까지 가는 경로가 있으면 true
    }

    // 결과 반환: {최대 유량, 최소 비용}
    pair<int, long long> solve(int source, int sink) {
        int totalFlow = 0;
        long long totalCost = 0;

        while (spfa(source, sink)) {
            // 이번 경로에서 흘릴 수 있는 최대 유량 계산
            int flow = INF;
            for (int i = sink; i != source; i = parent[i]) {
                int u = parent[i];
                int idx = parentEdge[i];
                flow = min(flow, adj[u][idx].capacity - adj[u][idx].flow);
            }

            // 유량 흘리기 & 비용 계산
            for (int i = sink; i != source; i = parent[i]) {
                int u = parent[i];
                int idx = parentEdge[i];
                
                adj[u][idx].flow += flow;
                int revIdx = adj[u][idx].rev;
                adj[adj[u][idx].to][revIdx].flow -= flow;
            }

            totalFlow += flow;
            totalCost += (long long)flow * dist[sink];
        }

        return {totalFlow, totalCost};
    }
};

// --- 사용 예시 (User's Problem) ---
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    if (!(cin >> N >> M)) return 0;

    MCMF solver;
    // 노드 개수: 소스(0) + 서점(M) + 사람(N) + 싱크(1)
    // 인덱싱: 소스=0, 서점=1~M, 사람=M+1~M+N, 싱크=M+N+1
    int source = 0;
    int sink = N + M + 1;
    solver.init(sink + 1);

    // 1. 사람 -> 싱크 (수요)
    for (int i = 1; i <= N; i++) {
        int demand; cin >> demand;
        // 사람 노드: M + i
        solver.addEdge(M + i, sink, demand, 0);
    }

    // 2. 소스 -> 서점 (공급)
    for (int i = 1; i <= M; i++) {
        int supply; cin >> supply;
        // 서점 노드: i
        solver.addEdge(source, i, supply, 0);
    }

    // 3. 서점 -> 사람 (비용)
    // 주의: 입력은 사람 기준 비용 순서일 수 있으므로 문제 조건 확인 필요
    // 원본 코드: 서점 i에서 사람 j로 가는 비용
    for (int i = 1; i <= M; i++) {
        for (int j = 1; j <= N; j++) {
            int cost; cin >> cost;
            solver.addEdge(i, M + j, INF, cost);
        }
    }

    pair<int, long long> result = solver.solve(source, sink);
    
    cout << result.second << "\n"; // 최소 비용 출력

    return 0;
}

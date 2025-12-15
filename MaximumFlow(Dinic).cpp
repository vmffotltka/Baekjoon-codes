#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

const int INF = 1e9;

/**
 * @brief Dinic's Algorithm for Maximum Flow
 * Time Complexity: O(V^2 * E), or O(E * sqrt(V)) for unit networks
 */
struct Dinic {
    struct Edge {
        int to;
        int capacity;
        int flow;
        int rev; // 역방향 간선의 인덱스
    };

    vector<vector<Edge>> adj;
    vector<int> level; // 노드의 레벨 (BFS 탐색 깊이)
    vector<int> work;  // DFS 중 각 노드에서 몇 번째 간선까지 탐색했는지 저장 (Dead end pruning)
    int n;

    // 초기화
    void init(int nodes) {
        n = nodes;
        adj.assign(n, vector<Edge>());
        level.resize(n);
        work.resize(n);
    }

    // 간선 추가 (유향 그래프 기준)
    // u -> v 로 cap만큼 흐를 수 있음
    void addEdge(int u, int v, int cap) {
        Edge a = { v, cap, 0, (int)adj[v].size() };
        Edge b = { u, 0, 0, (int)adj[u].size() }; // 역방향 간선 (초기 용량 0)
        adj[u].push_back(a);
        adj[v].push_back(b);
    }

    // BFS: 레벨 그래프 생성 (Sink에 도달 가능한지 확인)
    bool bfs(int src, int sink) {
        fill(level.begin(), level.end(), -1);
        level[src] = 0;
        queue<int> q;
        q.push(src);

        while (!q.empty()) {
            int curr = q.front();
            q.pop();

            for (const auto& edge : adj[curr]) {
                if (edge.capacity - edge.flow > 0 && level[edge.to] == -1) {
                    level[edge.to] = level[curr] + 1;
                    q.push(edge.to);
                }
            }
        }
        return level[sink] != -1;
    }

    // DFS: 차단 유량(Blocking Flow) 찾기
    int dfs(int curr, int sink, int flow) {
        if (curr == sink) return flow;

        // work[curr]부터 탐색 시작 (이미 탐색해서 막힌 간선은 다시 보지 않음 -> 최적화 핵심)
        for (int& i = work[curr]; i < adj[curr].size(); i++) {
            Edge& edge = adj[curr][i];
            
            if (edge.capacity - edge.flow > 0 && level[edge.to] == level[curr] + 1) {
                int push = dfs(edge.to, sink, min(flow, edge.capacity - edge.flow));
                if (push > 0) {
                    edge.flow += push;
                    adj[edge.to][edge.rev].flow -= push;
                    return push;
                }
            }
        }
        return 0;
    }

    // 최대 유량 계산
    int maxFlow(int src, int sink) {
        int totalFlow = 0;
        while (bfs(src, sink)) { // Sink로 가는 경로가 있는 동안
            fill(work.begin(), work.end(), 0); // 매 단계마다 탐색 포인터 초기화
            while (true) {
                int flow = dfs(src, sink, INF);
                if (flow == 0) break;
                totalFlow += flow;
            }
        }
        return totalFlow;
    }
};

// --- 사용 예시 (User's Code Logic 적용) ---
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, P;
    if (!(cin >> N >> P)) return 0;

    // 정점 분할 (Vertex Splitting) 문제로 보임
    // i번 정점 -> In: i*2, Out: i*2+1
    // 총 정점 개수 대략 (N+1)*2 개
    Dinic dinic;
    dinic.init((N + 1) * 2 + 10);

    // 정점 자체의 용량 설정 (In -> Out)
    for (int i = 1; i <= N; i++) {
        int u_in = i * 2;
        int u_out = i * 2 + 1;
        
        if (i <= 2) dinic.addEdge(u_in, u_out, INF); // 1, 2번 노드는 무제한? (문제 조건 따름)
        else dinic.addEdge(u_in, u_out, 1);          // 나머지는 용량 1
    }

    // 간선 연결
    for (int i = 0; i < P; i++) {
        int u, v; cin >> u >> v;
        int u_in = u * 2, u_out = u * 2 + 1;
        int v_in = v * 2, v_out = v * 2 + 1;

        // 양방향 간선인 경우 (u -> v, v -> u)
        // u의 Out에서 v의 In으로 연결해야 함
        dinic.addEdge(u_out, v_in, 1);
        dinic.addEdge(v_out, u_in, 1);
    }

    // 1번 정점(Source) -> 2번 정점(Sink) 가정 (코드 기반 추측)
    // Source: 1_in, Sink: 2_in (또는 문제에 따라 2_out)
    // * 주의: 작성하신 코드에서 maxFlow(1*2, 2*2+1)로 호출했으므로
    // Source: 1_in, Sink: 2_out으로 설정
    cout << dinic.maxFlow(1 * 2, 2 * 2 + 1) << "\n";

    return 0;
}

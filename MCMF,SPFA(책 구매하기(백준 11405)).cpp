#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9;

struct Edge {
	int to, capacity, flow, cost, rev; // 목적지, 용량, 현재 유량, 비용, 역방향 간선 인덱스
};

vector<vector<Edge>> adj; // 인접 리스트
int N, M, source, sink; // N: 사람 수, M: 서점 수

void addEdge(int u, int v, int capacity, int cost) { // u -> v 용량 capacity, 비용 cost
	Edge a{ v, capacity, 0, cost, (int)adj[v].size() }; // u -> v 간선
	Edge b{ u, 0, 0, -cost, (int)adj[u].size() }; // v -> u 간선
	adj[u].push_back(a); // u -> v 간선 추가
	adj[v].push_back(b); // v -> u 간선 추가
}

int mcmf() {
	int total_cost = 0; // 총 비용
	while (true) {
		// SPFA
		vector<int> dist(N + M + 2, INF), parent(N + M + 2, -1), parentEdge(N + M + 2, -1);
		// dist: 최단 거리, parent: 부모 노드, parentEdge: 부모 노드의 간선 인덱스
		vector<bool> inQueue(N + M + 2, false);
		// inQueue: 큐에 있는지 여부
		queue<int> q;
		// 초기화

		dist[source] = 0; // 시작점 거리 0
		q.push(source); // 시작점 큐에 삽입
		inQueue[source] = true; // 시작점 큐에 있음
		while (!q.empty()) {
			int u = q.front(); // 큐에서 하나 꺼내기
			q.pop(); // 큐에서 제거
			inQueue[u] = false; // 큐에서 제거됨
			for (int i = 0; i < adj[u].size(); i++) {
				Edge& e = adj[u][i]; // u에서 나가는 간선
				if (e.flow < e.capacity && dist[u] + e.cost < dist[e.to]) { // 용량이 남아있고, 최단 거리 갱신 가능
					dist[e.to] = dist[u] + e.cost; // 최단 거리 갱신
					parent[e.to] = u; // 부모 노드 갱신
					parentEdge[e.to] = i; // 부모 노드의 간선 인덱스 갱신
					if (!inQueue[e.to]) { // 큐에 없으면
						q.push(e.to); // 큐에 삽입
						inQueue[e.to] = true; // 큐에 있음
					}
				}
			}
		}
		if (dist[sink] == INF) break; // 더 이상 경로가 없으면 종료
		int flow = INF; // 유량
		for (int u = sink; u != source; u = parent[u]) { // 경로 따라가며 유량 계산
			Edge& e = adj[parent[u]][parentEdge[u]]; // 부모 노드의 간선
			flow = min(flow, e.capacity - e.flow); // 유량 갱신
		}
		for (int u = sink; u != source; u = parent[u]) { // 경로 따라가며 유량 갱신
			Edge& e = adj[parent[u]][parentEdge[u]]; // 부모 노드의 간선
			e.flow += flow; // 유량 증가
			adj[e.to][e.rev].flow -= flow; // 역방향 간선 유량 감소
		}
		total_cost += flow * dist[sink]; // 총 비용 갱신
	}
	return total_cost; // 총 비용 반환
}

int main() {
	cin.tie(0)->sync_with_stdio(0);
	cin >> N >> M;
	adj.resize(N + M + 2); // 소스 = 0, 싱크 = N + M + 1
	source = 0; // 소스
	sink = N + M + 1; // 싱크

	for (int i = 1; i <= N; i++) { // 사람 -> 싱크
		int demand; cin >> demand; // 수요
		addEdge(M + i, sink, demand, 0); // 서점 -> 싱크
	}

	for (int i = 1; i <= M; i++) { // 소스 -> 서점
		int supply; cin >> supply; // 공급량
		addEdge(source, i, supply, 0); // 소스 -> 사람
	}

	for (int i = 1; i <= M; i++) {
		for (int j = 1; j <= N; j++) {
			int cost; cin >> cost; // 비용
			addEdge(i, M + j, INF, cost); // 사람 -> 서점
		}
	}
	cout << mcmf(); // 최소 비용 최대 유량
}

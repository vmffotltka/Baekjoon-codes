#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9;

struct Edge {
	int to, capacity, flow, cost, rev;
};

vector<vector<Edge>> adj;
int N, M, source, sink;

void addEdge(int u, int v, int capacity, int cost) {
	Edge a{v, capacity, 0, cost, (int)adj[v].size()};
	Edge b{u, 0, 0, -cost, (int)adj[u].size()};
	adj[u].push_back(a);
	adj[v].push_back(b);
}

int mcmf() {
	int total_cost = 0;
	while (true) {
		vector<int> dist(N + M + 2, INF), parent(N + M + 2, -1), parentEdge(N + M + 2, -1);
		vector<bool> inQueue(N + M + 2, false);
		queue<int> q;
		
		dist[source] = 0;
		q.push(source);
		inQueue[source] = true;
		while (!q.empty()) {
			int u = q.front();
			q.pop();
			inQueue[u] = false;
			for (int i = 0; i < adj[u].size(); i++) {
				Edge &e = adj[u][i];
				if (e.flow < e.capacity && dist[u] + e.cost < dist[e.to]) {
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
		if (dist[sink] == INF) break;
		int flow = INF;
		for (int u = sink; u != source; u = parent[u]) {
			Edge &e = adj[parent[u]][parentEdge[u]];
			flow = min(flow, e.capacity - e.flow);
		}
		for (int u = sink; u != source; u = parent[u]) {
			Edge &e = adj[parent[u]][parentEdge[u]];
			e.flow += flow;
			adj[e.to][e.rev].flow -= flow;
		}
		total_cost += flow * dist[sink];
	}
	return total_cost;
}

int main() {
	cin.tie(0)->sync_with_stdio(0);
	cin >> N >> M;
	adj.resize(N + M + 2);
	source = 0;
	sink = N + M + 1;

	for (int i = 1; i <= N; i++) {
		int demand; cin >> demand;
		addEdge(M + i, sink, demand, 0);
	}

	for (int i = 1; i <= M; i++) {
		int supply; cin >> supply;
		addEdge(source, i, supply, 0);
	}

	for (int i = 1; i <= M; i++) {
		for (int j = 1; j <= N; j++) {
			int cost; cin >> cost;
			addEdge(i, M + j, INF, cost);
		}
	}
	cout << mcmf();

}

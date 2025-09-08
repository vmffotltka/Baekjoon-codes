#include <bits/stdc++.h>
using namespace std;

struct Trie {
	map<char, Trie*> next; // 자식 노드
	Trie* fail = nullptr; // 매칭 실패 시 돌아갈 노드
	bool end = false; // 패턴이 끝났는지 여부
	Trie() = default;
	~Trie() {
		for (auto& [_, child] : next) {
			delete child;
		}
	}
	void insert(const string& s) { // 트라이 구성 함수
		Trie* node = this;
		for (char c : s) {
			if (!node->next.count(c)) {
				node->next[c] = new Trie();
			}
			node = node->next[c];
		}
		node->end = true;
	}
};

int N, M;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	cin >> N;
	Trie* root = new Trie();
	for (int i = 0; i < N; i++) {
		string s;
		cin >> s;
		root->insert(s);
	}

	queue<Trie*> q;
	root->fail = root;
	q.push(root);
	while (!q.empty()) { // BFS를 이용해 fail노드들 설정
		Trie* node = q.front();
		q.pop();
		for (auto& [c, child] : node->next) {
			if (node == root) { // 루트노드의 자식 노드인 경우
				child->fail = root; // fail노드는 루트
			}
			else {
				Trie* f = node->fail; // 현재 루트에 있지 않은 경우 fail노드
				while (f != root && !f->next.count(c)) { // f가 root가 되거나 f의 자식 노드 중 c가 있을 때까지 fail노드로 거슬러 올라감
					f = f->fail;
				}
				if (f->next.count(c)) { // f의 자식 노드 중 c가 있는 경우
					f = f->next[c];
				}
				child->fail = f; // c에서 실패 시 f로 돌아가게 설정
			}
			child->end |= child->fail->end; // 설정한 fail노드가 패턴이 끝나는 지점이라면 현재 지점도 끝나는 지점으로 설정
			q.push(child);
		}
	}

	cin >> M;
	for (int i = 0; i < M; i++) {
		string s;
		cin >> s;
		Trie* node = root;
		bool found = false;
		for (char c : s) {
			while (node != root && !node->next.count(c)) { // 매칭에 실패한 경우 node가 root가 되거나 node에서 c로 가는 경우가 있을 때까지 fail노드로 거슬러 올라감
				node = node->fail;
			}
			if (node->next.count(c)) { // 매칭된 경우 다음으로
				node = node->next[c];
			}
			if (node->end) { // 패턴이 매칭된 경우 (만약 패턴을 직접 출력하려면 fail노드를 계속 거슬러 올라가면서 end를 체크함. end는 vector형식으로 바꾸면 패턴 출력 가능.)
				found = true;
				break;
			}
		}
		cout << (found ? "YES\n" : "NO\n");
	}
}

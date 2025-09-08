#include <bits/stdc++.h>
using namespace std;

struct Trie {
	map<char, Trie*> next;
	Trie* fail = nullptr;
	bool end = false;
	Trie() = default;
	~Trie() {
		for (auto& [_, child] : next) {
			delete child;
		}
	}
	void insert(const string& s) {
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
	while (!q.empty()) {
		Trie* node = q.front();
		q.pop();
		for (auto& [c, child] : node->next) {
			if (node == root) {
				child->fail = root;
			}
			else {
				Trie* f = node->fail;
				while (f != root && !f->next.count(c)) {
					f = f->fail;
				}
				if (f->next.count(c)) {
					f = f->next[c];
				}
				child->fail = f;
			}
			child->end |= child->fail->end;
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
			while (node != root && !node->next.count(c)) {
				node = node->fail;
			}
			if (node->next.count(c)) {
				node = node->next[c];
			}
			if (node->end) {
				found = true;
				break;
			}
		}
		cout << (found ? "YES\n" : "NO\n");
	}
}

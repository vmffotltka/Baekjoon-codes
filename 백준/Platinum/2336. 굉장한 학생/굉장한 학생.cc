#include <bits/stdc++.h>
using namespace std;

/**
 * @brief Fenwick Tree (Binary Indexed Tree) Template
 * Time Complexity: O(log N) for update and query
 * Space Complexity: O(N)
 * Note: Uses 1-based indexing internally
 */
template <typename T = long long>
struct FenwickTree {
    int n;
    vector<T> tree;
    FenwickTree(int size) : n(size), tree(size + 1, INT_MAX) {}

    void update(int idx, T mn) {
        while (idx <= n) {
            tree[idx] = min(tree[idx], mn);
            idx += (idx & -idx);
        }
    }

    T query(int idx) {
		T minVal = tree[idx];
        while (idx > 0) {
            minVal = min(minVal, tree[idx]);
            idx -= (idx & -idx);
        }
		return minVal;
    }
};

int N;
int arr[500001];
int inx[500001];
int value[500001];

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin >> N;
    for (int i = 0; i < N; i++) cin >> arr[i];
    for (int i = 0; i < N; i++) {
        int x; cin >> x;
        inx[x] = i + 1;
    }
    for (int i = 0; i < N; i++) {
        int x; cin >> x;
        value[x] = i + 1;
    }
	FenwickTree<long long> fenw(N);
    int ans = 0;
    for (int i = 0; i < N; i++) {
        int cur = arr[i];
		int idx = inx[cur], val = value[cur];
        if (fenw.query(idx - 1) > val)
            ans++;
        fenw.update(idx, val);
    }
    cout << ans;
}
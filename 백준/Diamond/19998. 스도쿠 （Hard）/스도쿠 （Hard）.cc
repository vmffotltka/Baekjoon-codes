#include <bits/stdc++.h>
using namespace std;
const int MAX_NODES = 729 * 4 + 324 + 1;

int L[MAX_NODES], R[MAX_NODES], U[MAX_NODES], D[MAX_NODES];
int C[MAX_NODES];
int row_idx[MAX_NODES];
int S[325];
int sz;

int board[9][9];
vector<int> ans;

void init(int cols) {
    for (int i = 0; i <= cols; i++) {
        L[i] = i - 1;
        R[i] = i + 1;
        U[i] = i;
        D[i] = i;
        C[i] = i;
    }
    L[0] = cols;
    R[cols] = 0;
    sz = cols + 1;
    for (int i = 0; i <= cols; i++) S[i] = 0;
}

void add_row(int r_id, const vector<int>& columns) {
    int first = sz;
    for (int c : columns) {
        L[sz] = sz - 1; R[sz] = sz + 1;
        D[sz] = c; U[sz] = U[c];
        D[U[c]] = sz; U[c] = sz;
        C[sz] = c; row_idx[sz] = r_id;
        S[c]++;
        sz++;
    }
    L[first] = sz - 1;
    R[sz - 1] = first;
}

void cover(int c) {
    L[R[c]] = L[c]; R[L[c]] = R[c];
    for (int i = D[c]; i != c; i = D[i]) {
        for (int j = R[i]; j != i; j = R[j]) {
            U[D[j]] = U[j]; D[U[j]] = D[j];
            S[C[j]]--;
        }
    }
}

void uncover(int c) {
    for (int i = U[c]; i != c; i = U[i]) {
        for (int j = L[i]; j != i; j = L[j]) {
            U[D[j]] = j; D[U[j]] = j;
            S[C[j]]++;
        }
    }
    L[R[c]] = c; R[L[c]] = c;
}

bool dfs() {
    if (R[0] == 0) return true;
    int c = R[0];
    for (int i = R[0]; i != 0; i = R[i]) {
        if (S[i] < S[c]) c = i;
    }

    cover(c);
    for (int i = D[c]; i != c; i = D[i]) {
        ans.push_back(row_idx[i]);
        for (int j = R[i]; j != i; j = R[j]) cover(C[j]);

        if (dfs()) return true;
        for (int j = L[i]; j != i; j = L[j]) uncover(C[j]);
        ans.pop_back();
    }
    uncover(c);
    return false;
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    init(324);
    for (int r = 0; r < 9; ++r) {
        for (int c = 0; c < 9; ++c) {
            cin >> board[r][c];
            int start_v = (board[r][c] == 0) ? 1 : board[r][c];
            int end_v = (board[r][c] == 0) ? 9 : board[r][c];

            for (int v = start_v; v <= end_v; ++v) {
                vector<int> row_cols = {
                    r * 9 + c + 1,
                    81 + r * 9 + v,
                    162 + c * 9 + v,
                    243 + ((r / 3) * 3 + (c / 3)) * 9 + v
                };
                add_row(r * 81 + c * 9 + (v - 1), row_cols);
            }
        }
    }

    dfs();
    for (int idx : ans) {
        int r = idx / 81, c = (idx % 81) / 9, v = (idx % 9) + 1;
        board[r][c] = v;
    }
    for (int r = 0; r < 9; ++r) {
        for (int c = 0; c < 9; ++c) {
            cout << board[r][c] << " ";
        }
        cout << "\n";
    }
}
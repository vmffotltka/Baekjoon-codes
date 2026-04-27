#include <bits/stdc++.h>
using namespace std;

struct Node {
    int l, r, p;
    int val, sum;
    bool rev;
} t[30005];

void push_up(int x) {
    t[x].sum = t[t[x].l].sum + t[t[x].r].sum + t[x].val;
}

void push_down(int x) {
    if (t[x].rev) {
        swap(t[x].l, t[x].r);
        if (t[x].l) t[t[x].l].rev ^= 1;
        if (t[x].r) t[t[x].r].rev ^= 1;
        t[x].rev = false;
    }
}

bool is_root(int x) {
    return t[t[x].p].l != x && t[t[x].p].r != x;
}

void rotate(int x) {
    int p = t[x].p, g = t[p].p;
    if (!is_root(p)) {
        if (t[g].l == p) t[g].l = x;
        else t[g].r = x;
    }
    t[x].p = g;
    if (t[p].l == x) {
        t[p].l = t[x].r;
        if (t[x].r) t[t[x].r].p = p;
        t[x].r = p;
    }
    else {
        t[p].r = t[x].l;
        if (t[x].l) t[t[x].l].p = p;
        t[x].l = p;
    }
    t[p].p = x;
    push_up(p);
    push_up(x);
}

void splay(int x) {
    int top = 0;
    static int st[30005];
    st[++top] = x;
    for (int i = x; !is_root(i); i = t[i].p) st[++top] = t[i].p;
    while (top) push_down(st[top--]);

    while (!is_root(x)) {
        int p = t[x].p, g = t[p].p;
        if (!is_root(p)) {
            if ((t[p].l == x) ^ (t[g].l == p)) rotate(x);
            else rotate(p);
        }
        rotate(x);
    }
}

void access(int x) {
    for (int y = 0; x; y = x, x = t[x].p) {
        splay(x);
        t[x].r = y;
        push_up(x);
    }
}

void make_root(int x) {
    access(x);
    splay(x);
    t[x].rev ^= 1;
}

int find_root(int x) {
    access(x);
    splay(x);
    while (t[x].l) {
        push_down(x);
        x = t[x].l;
    }
    splay(x);
    return x;
}

bool link(int x, int y) {
    make_root(x);
    if (find_root(y) == x) return false;
    t[x].p = y;
    return true;
}

void update_node(int x, int val) {
    splay(x);
    t[x].val = val;
    push_up(x);
}

int query(int x, int y) {
    make_root(x);
    if (find_root(y) != x) return -1;
    access(y);
    splay(y);
    return t[y].sum;
}

int main() {
    cin.tie(0)->sync_with_stdio(0);

    int n; cin >> n;
    for (int i = 1; i <= n; i++) {
        int penguins;
        cin >> penguins;
        t[i].val = penguins;
        t[i].sum = penguins;
        t[i].l = t[i].r = t[i].p = 0;
        t[i].rev = false;
    }
    int q; cin >> q;

    string cmd;
    int a, b;
    for (int i = 0; i < q; i++) {
        cin >> cmd >> a >> b;
        if (cmd == "bridge") {
            if (link(a, b)) cout << "yes\n";
            else cout << "no\n";
            cout.flush();
        }
        else if (cmd == "penguins")
            update_node(a, b);
        else if (cmd == "excursion") {
            int result = query(a, b);
            if (result == -1) cout << "impossible\n";
            else cout << result << "\n";
            cout.flush();
        }
    }
}
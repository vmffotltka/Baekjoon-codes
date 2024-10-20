#include <bits/stdc++.h>
using namespace std;

static int f(int a, int b, char op) {
    int ret;
    if (op == '+') ret = a + b;
    else if (op == '-') ret = a - b;
    else if (op == '*') ret = a * b;
    else if (op == '/') ret = a / b;
    return ret;
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int a, b, c; char op1, op2;
    cin >> a >> op1 >> b >> op2 >> c;
    int ans1 = f(f(a, b, op1), c, op2), ans2 = f(a, f(b, c, op2), op1);
    cout << min(ans1, ans2) << '\n' << max(ans1, ans2);
}
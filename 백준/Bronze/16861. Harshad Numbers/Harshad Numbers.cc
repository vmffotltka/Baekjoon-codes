#include <bits/stdc++.h>
using namespace std;

bool isHarshad(int n) {
    int sum = 0, num = n;
    while (num) {
        sum += num % 10;
        num /= 10;
    }
    return (n % sum == 0 ? true : false);
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n; cin >> n;
    while (true) {
        if (isHarshad(n)) {
            cout << n; break;
        }
        else n++;
    }
}
#include <bits/stdc++.h>
using namespace std;

int prize[4] = { 0, 500, 800, 1000 };

int main() {
	int n, sum = 0; while (cin >> n) {
		sum += prize[n];
	}
	cout << 5000 - sum;
}
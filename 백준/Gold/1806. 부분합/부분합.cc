#include <iostream>
#define INF 987654321
using namespace std;

int main() {
	int start = 0, end= 0;
	int res = INF;
	int n, s;
	cin >> n >> s;
	int* arr = new int[n];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int hap = arr[0];
	while (true) {
		if (hap < s) { end++; }
		else {
			if (res > end - start) { res = end - start; }
			hap -= arr[start];
			start++;
			continue;
		}
		if (end == n) { break; }
		hap += arr[end];
	}
	if (res == INF) { cout << 0; }
	else { cout << res + 1; }
}

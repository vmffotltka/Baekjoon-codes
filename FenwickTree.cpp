#include <iostream>
#include <vector>
#include <algorithm>

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

    // 초기화 (size: 데이터의 최대 개수)
    FenwickTree(int size) : n(size), tree(size + 1, 0) {}

    // 값 업데이트: index 위치에 diff만큼 더함
    // (값을 변경하는 게 아니라 '더하는' 것임에 주의)
    void update(int idx, T diff) {
        while (idx <= n) {
            tree[idx] += diff;
            idx += (idx & -idx); // LSB를 더해서 다음 위치로 이동
        }
    }

    // 1부터 idx까지의 누적 합 (Prefix Sum)
    T query(int idx) {
        T sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx); // LSB를 빼서 부모/이전 구간으로 이동
        }
        return sum;
    }

    // 구간 합 [start, end]
    T query(int start, int end) {
        if (start > end) return 0;
        return query(end) - query(start - 1);
    }
};

// --- 사용 예시 (User's Problem: Inversion Counting) ---
int main() {
    // 입출력 속도 향상
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    if (!(cin >> N)) return 0;

    vector<int> A(N);
    vector<int> coords; // 좌표 압축용 벡터

    for (int i = 0; i < N; i++) {
        cin >> A[i];
        coords.push_back(A[i]);
    }

    // 1. 좌표 압축 (Coordinate Compression)
    // Java의 TreeSet + ArrayList 방식보다 훨씬 빠르고 간결한 C++ 정석 패턴
    sort(coords.begin(), coords.end());
    coords.erase(unique(coords.begin(), coords.end()), coords.end());

    // 압축된 인덱스를 구하는 람다 함수 (1-based index 반환)
    auto getIdx = [&](int val) {
        return lower_bound(coords.begin(), coords.end(), val) - coords.begin() + 1;
    };

    // 2. 펜윅 트리 생성
    // 좌표 압축 후 최대 크기는 coords.size()
    FenwickTree<long long> fw(coords.size());
    long long ans = 0;

    // 3. Inversion Counting
    for (int i = 0; i < N; i++) {
        int idx = getIdx(A[i]); // 현재 값의 압축된 인덱스 (1 ~ M)

        // 내 앞에 들어온 수들 중, 나보다 작거나 같은 수의 개수 = query(idx)
        // 전체 들어온 개수(i) - 나보다 작거나 같은 수 = 나보다 큰 수의 개수
        long long smaller_count = fw.query(idx);
        ans += (long long)i - smaller_count;

        // 현재 수 등장 횟수 1 증가
        fw.update(idx, 1);
    }

    cout << ans << "\n";

    return 0;
}

/**
 * @file BinaryTrie_Array.cpp
 * @brief XOR Maximization 문제 해결을 위한 배열 기반 Binary Trie
 * @note
 * - 기능: Insert, Remove (Lazy Delete), Query (XOR Max)
 * - 시간복잡도: O(Query * BitDepth)
 * - 공간복잡도: O(Query * BitDepth)
 * - 특징: 포인터 방식보다 훨씬 빠르고 캐시 친화적임.
 */

#include <bits/stdc++.h>
using namespace std;

// 문제에 따라 비트 수와 쿼리 수 조정 필요
const int MAX_BITS = 30; // 10억 이하의 수는 30비트면 충분 (2^30 > 10^9)
const int MAX_QUERIES = 200005; 
const int MAX_NODES = MAX_QUERIES * (MAX_BITS + 1);

struct BinaryTrie {
    // trie[노드][0/1]: 자식 노드 번호
    // cnt[노드]: 해당 노드를 거쳐간 수의 개수 (Lazy Delete용)
    int trie[MAX_NODES][2];
    int cnt[MAX_NODES];
    int root, unused;

    // 초기화 함수 (Test Case가 여러 개일 때 필수)
    void clear() {
        // 전체를 0으로 미는 것보다 필요한 만큼만 초기화하거나
        // 전역으로 선언하고 unused를 조절하는 게 빠름.
        // 여기서는 안전하게 memset 사용 (시간이 빡빡하면 unused 관리로 변경 추천)
        memset(trie, 0, sizeof(trie));
        memset(cnt, 0, sizeof(cnt));
        root = 1;
        unused = 2;
    }

    BinaryTrie() {
        clear();
    }

    // 숫자 x 추가
    void insert(int x) {
        int cur = root;
        cnt[cur]++;
        for (int i = MAX_BITS - 1; i >= 0; i--) {
            int b = (x >> i) & 1;
            if (!trie[cur][b]) {
                trie[cur][b] = unused++;
            }
            cur = trie[cur][b];
            cnt[cur]++;
        }
    }

    // 숫자 x 제거 (실제 삭제 안 하고 count만 감소)
    void remove(int x) {
        int cur = root;
        cnt[cur]--;
        for (int i = MAX_BITS - 1; i >= 0; i--) {
            int b = (x >> i) & 1;
            cur = trie[cur][b];
            cnt[cur]--;
        }
    }

    // x와 XOR 했을 때 가장 큰 값을 만드는 수 찾기 -> 그 최댓값 반환
    int query_xor_max(int x) {
        int cur = root;
        int result = 0;
        for (int i = MAX_BITS - 1; i >= 0; i--) {
            int b = (x >> i) & 1;
            int target = b ^ 1; // 가고 싶은 방향 (반대 비트)

            // 반대 방향 노드가 존재하고, 지워지지 않은 수(cnt>0)가 있다면
            if (trie[cur][target] && cnt[trie[cur][target]] > 0) {
                result |= (1 << i); // 해당 비트는 1이 됨
                cur = trie[cur][target];
            } else {
                // 어쩔 수 없이 같은 방향으로 (해당 비트는 0이 됨)
                cur = trie[cur][b];
            }
        }
        return result;
    }
    
    // (선택 사항) x와 XOR 했을 때 가장 작은 값 찾기
    int query_xor_min(int x) {
        int cur = root;
        int result = 0;
        for (int i = MAX_BITS - 1; i >= 0; i--) {
            int b = (x >> i) & 1;
            // 최소를 원하면 같은 비트(b) 쪽으로 가려고 노력해야 함
            if (trie[cur][b] && cnt[trie[cur][b]] > 0) {
                // 같은 쪽으로 가면 XOR 결과는 0 (result에 더할 것 없음)
                cur = trie[cur][b];
            } else {
                // 어쩔 수 없이 반대 쪽으로 (XOR 결과 1)
                result |= (1 << i);
                cur = trie[cur][b ^ 1];
            }
        }
        return result;
    }
};

// 사용 예시 (Main 함수)
BinaryTrie tree;

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    // tree.clear(); // TC가 여러 개면 호출
    
    tree.insert(0); // 문제 조건 등
    // ...
}

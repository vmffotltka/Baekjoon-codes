#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

/**
 * @brief Manacher's Algorithm Implementation
 * Time Complexity: O(N) for construction, O(1) for queries
 */
template <typename T = char> // 기본은 문자(char) 처리
struct Manacher {
    // A: 변형된 문자열/배열 (예: # a # b # a #)
    // P: 각 위치에서의 회문 반지름 길이
    vector<T> A;
    vector<int> P;

    /**
     * @brief Manacher 알고리즘 수행을 위한 초기화
     * @param input 원본 문자열 또는 벡터
     * @param dummy 문자와 문자 사이에 끼워넣을 더미 값 (문자열은 '#', 숫자는 -1 등)
     */
    void build(const vector<T>& input, T dummy) {
        // 1. 변형된 배열 생성 (홀수/짝수 길이 통일)
        int n = input.size();
        A.clear();
        A.resize(n * 2 + 1);
        P.assign(n * 2 + 1, 0);

        for (int i = 0; i < n; i++) {
            A[2 * i] = dummy;
            A[2 * i + 1] = input[i];
        }
        A[2 * n] = dummy;

        // 2. 매내처 알고리즘 수행
        int r = 0, c = 0;
        for (int i = 0; i < A.size(); i++) {
            if (i < r) {
                P[i] = min(P[2 * c - i], r - i);
            }
            // 확장 (범위 체크 및 값 비교)
            while (i - P[i] - 1 >= 0 && i + P[i] + 1 < A.size() && 
                   A[i - P[i] - 1] == A[i + P[i] + 1]) {
                P[i]++;
            }
            if (i + P[i] > r) {
                r = i + P[i];
                c = i;
            }
        }
    }

    // 편의성을 위한 문자열 오버로딩
    void build(const string& s) {
        vector<char> v(s.begin(), s.end());
        build(v, '#');
    }

    /**
     * @brief 특정 구간 [s, e]가 회문인지 확인
     * @param s 시작 인덱스 (0-based)
     * @param e 끝 인덱스 (0-based)
     * @return true면 회문
     */
    bool isPalindrome(int s, int e) {
        // 변형된 문자열에서 중심 인덱스는 s + e + 1
        // 해당 중심에서의 반지름 P[center]가 구간 길이보다 크거나 같아야 함
        int len = e - s + 1;
        int center = s + e + 1; // 변형된 배열 A에서의 인덱스
        return P[center] >= len;
    }

    /**
     * @brief 가장 긴 회문의 길이 반환
     */
    int getLongestLength() {
        int maxLen = 0;
        for (int p : P) maxLen = max(maxLen, p);
        return maxLen;
    }
};

// --- 사용 예시 (Main) ---
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    // 1. 문자열 예시
    Manacher<char> mc;
    string str = "stabcbatk";
    mc.build(str);
    
    cout << "String: " << str << "\n";
    cout << "Is 'abcba' (2~6) palindrome? " << (mc.isPalindrome(2, 6) ? "Yes" : "No") << "\n"; // Yes
    cout << "Longest Palindrome Length: " << mc.getLongestLength() << "\n\n";

    // 2. 숫자 배열 예시 (사용자 코드 스타일)
    Manacher<int> mi;
    int n = 5;
    vector<int> nums = {1, 2, 1, 2, 1}; // 예제
    mi.build(nums, 0); // 더미 값으로 0 사용 (입력에 0이 없다고 가정 시)

    cout << "Numbers: 1 2 1 2 1\n";
    cout << "Is '1 2 1' (0~2) palindrome? " << (mi.isPalindrome(0, 2) ? "Yes" : "No") << "\n"; // Yes
    cout << "Longest Palindrome Length: " << mi.getLongestLength() << "\n";

    return 0;
}

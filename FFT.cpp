#include <iostream>
#include <vector>
#include <complex>
#include <algorithm>
#include <cmath>

using namespace std;

// --- [FFT 템플릿 시작] ---
const double PI = acos(-1); // PI 값
typedef complex<double> cpx; // 복소수 타입 정의

// FFT 수행 함수 (a: 변환할 다항식의 계수 배열, invert: 역변환 여부)
void fft(vector<cpx>& a, bool invert) {
    int n = a.size();
    
    // 1. 비트 반전 순열 (Bit-reversal Permutation)
    // 쿨리-튜키 알고리즘의 반복문 구현을 위해 원소의 자리를 재배치합니다.
    for (int i = 1, j = 0; i < n; i++) {
        int bit = n >> 1;
        while (!((j ^= bit) & bit)) bit >>= 1;
        if (i < j) swap(a[i], a[j]);
    }

    // 2. 쿨리-튜키 알고리즘 (Butterfly Operation)
    // len: 현재 합치고 있는 부분 다항식의 길이 (2 -> 4 -> 8 ...)
    for (int len = 2; len <= n; len <<= 1) {
        double ang = 2 * PI / len * (invert ? -1 : 1);
        cpx wlen(cos(ang), sin(ang)); // 단위근 (Root of Unity)
        
        for (int i = 0; i < n; i += len) {
            cpx w(1); // w^0 = 1
            for (int j = 0; j < len / 2; j++) {
                // Butterfly 연산: u + w*v, u - w*v
                cpx u = a[i + j], v = a[i + j + len / 2] * w;
                a[i + j] = u + v;
                a[i + j + len / 2] = u - v;
                w *= wlen; // 다음 단위근으로 회전
            }
        }
    }

    // 3. 역변환 시 배열 크기 N으로 나누기
    if (invert) {
        for (int i = 0; i < n; i++) a[i] /= n;
    }
}

// 두 다항식(배열) a와 b를 곱하는 함수
void multiply(const vector<int>& a, const vector<int>& b, vector<long long>& res) {
    vector<cpx> fa(a.begin(), a.end()), fb(b.begin(), b.end());
    
    // FFT를 위해 배열 크기를 2의 거듭제곱으로 맞춤
    int n = 1;
    while (n < a.size() + b.size()) n <<= 1;
    
    fa.resize(n);
    fb.resize(n);

    // 1. DFT (변환)
    fft(fa, false);
    fft(fb, false);

    // 2. Point-wise Multiplication (각 점끼리 곱셈)
    for (int i = 0; i < n; i++) fa[i] *= fb[i];

    // 3. IDFT (역변환)
    fft(fa, true);

    // 4. 결과 저장 (실수부만 취해서 반올림)
    res.resize(n);
    for (int i = 0; i < n; i++) {
        res[i] = (long long)round(fa[i].real());
    }
}
// --- [FFT 템플릿 끝] ---

int main() {
    // 입출력 속도 향상
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<int> X(N), Y(N);
    for (int i = 0; i < N; i++) cin >> X[i];
    for (int i = 0; i < N; i++) cin >> Y[i];

    // [핵심 로직]
    // 문제: S = sum(X[i] * Y[i+k]) 형태 (Correlation)
    // FFT는 Convolution(sum(X[i] * Y[k-i]))을 계산함
    // 따라서 X를 뒤집어서 Convolution 형태로 바꿈
    reverse(X.begin(), X.end());

    // Y는 순환 이동을 처리하기 위해 2배로 늘림 (Y + Y)
    // 예: Y = {1, 2, 3} -> {1, 2, 3, 1, 2, 3}
    vector<int> Y_double = Y;
    Y_double.insert(Y_double.end(), Y.begin(), Y.end());

    // FFT를 이용한 다항식 곱셈 수행
    vector<long long> result;
    multiply(X, Y_double, result);

    // [최댓값 찾기]
    // X의 크기가 N, Y_double의 크기가 2N이므로,
    // 유효한 곱셈 결과(완전히 겹치는 구간)는 인덱스 N-1 부터 2N-2 까지 나타남.
    long long max_score = 0;
    for (int i = N - 1; i < 2 * N - 1; i++) {
        max_score = max(max_score, result[i]);
    }

    cout << max_score << "\n";

    return 0;
}

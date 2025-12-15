#include <iostream>
#include <tuple>

using namespace std;

/**
 * @brief 정수론 (Number Theory) 템플릿
 * 포함 기능: 확장 유클리드 호제법 (EEA), 모듈러 역원 (Modular Inverse)
 */
struct NumberTheory {
    /**
     * @brief 확장 유클리드 호제법 (Extended Euclidean Algorithm)
     * @details a*x + b*y = gcd(a, b)를 만족하는 정수해 (x, y)와 gcd를 구함
     * @return tuple<long long, long long, long long> -> {gcd, x, y}
     */
    static tuple<long long, long long, long long> egcd(long long a, long long b) {
        long long s0 = 1, s1 = 0;
        long long t0 = 0, t1 = 1;
        long long r0 = a, r1 = b;

        while (r1 != 0) {
            long long q = r0 / r1;
            
            // r0 = r1, r1 = r0 - q * r1
            long long tempR = r0 - q * r1;
            r0 = r1; r1 = tempR;

            // s0 = s1, s1 = s0 - q * s1
            long long tempS = s0 - q * s1;
            s0 = s1; s1 = tempS;

            // t0 = t1, t1 = t0 - q * t1
            long long tempT = t0 - q * t1;
            t0 = t1; t1 = tempT;
        }
        // r0가 gcd, s0가 a의 계수(x), t0가 b의 계수(y)
        return {r0, s0, t0};
    }

    /**
     * @brief 모듈러 곱셈 역원 (Modular Multiplicative Inverse)
     * @details (a * x) % m = 1 인 x를 구함
     * @return 역원 (존재하지 않으면 -1 반환)
     */
    static long long modInverse(long long a, long long m) {
        auto [g, x, y] = egcd(a, m);
        
        // 1. gcd(a, m) != 1 이면 역원이 존재하지 않음
        if (g != 1) return -1;
        
        // 2. 결과값이 음수일 수 있으므로 양수로 변환
        return (x % m + m) % m;
    }
};

// --- 사용 예시 ---
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    long long A = 3, M = 11;
    
    // 3 * x ≡ 1 (mod 11) -> x = 4
    long long inv = NumberTheory::modInverse(A, M);

    if (inv == -1) {
        cout << "역원이 존재하지 않습니다.\n";
    } else {
        cout << A << "의 모듈러 " << M << "에 대한 역원: " << inv << "\n";
        cout << "검증: (" << A << " * " << inv << ") % " << M << " = " << (A * inv) % M << "\n";
    }

    return 0;
}

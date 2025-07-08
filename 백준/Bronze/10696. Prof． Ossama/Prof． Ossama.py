import sys
input = lambda: sys.stdin.readline().rstrip()

def main():
    cs = int(input())
    for i in range(1, cs + 1):
        n, x = map(int, input().split())
        print(f"Case {i}: {n % x}")

if __name__ == "__main__":
    main()
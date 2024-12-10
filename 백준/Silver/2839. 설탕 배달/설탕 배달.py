a = 5
N = int(input())


if N%a == 0 and N >= 5:
    print(N//a)

else :
    if N%a == 1 and N >= 5:
        print((N-6)//a + 2)

    else :
        if N%a == 2 and N >= 8:
            print((N-12)//a + 4)

        else :
            if N%a == 3 and N >= 5 :
                print((N-3)//a + 1)

            else :
                if N%a == 4 and N >= 5:
                    print((N-9)//a + 3)

                else :
                    if N == 3 :
                        print(1)

                    else :
                        print(-1)
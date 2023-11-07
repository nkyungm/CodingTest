import sys

T = int(input())
for t in range(T):
    N = int(input())
    start = N//2
    end = N//2
    result = 0
    for i in range(N):
        a = [int(k) for k in list(input())]
        if(i <= N//2):
            start = N//2 -i
            end = N//2 +i
        else:
            start += 1
            end -= 1
        for j in range(start,end+1):
            result += a[j]
    print(f"#{t+1} {result}")
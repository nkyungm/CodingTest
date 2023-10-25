import sys

y = [-1,-2,1,2]

for t in range(10):
    count = 0
    T = int(input())
    arr = list(map(int,input().split()))
    for i in range(2,len(arr)-2):
        cnt =255
        for j in y:
            if(arr[i+j] < arr[i]):
                if(cnt > arr[i]-arr[i+j]):
                    cnt = arr[i]-arr[i+j]
            else:
                cnt = 0
                break
        if(cnt !=0):
            count += cnt
    print(f"#{t+1} {count}")
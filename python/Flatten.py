import sys
for i in range(10):
    diff =0
    dump = int(input())
    arr = list(map(int,input().split()))
    for _ in range(dump):
        max_idx = arr.index(max(arr))
        min_idx = arr.index(min(arr))
        if((arr[max_idx] - arr[min_idx]) <= 1):
            diff =arr[max_idx] - arr[min_idx]
            break
        arr[max_idx] -=1
        arr[min_idx] +=1
        # 실수 : 여기서 max값과 min값에 +1,-1를 각각해줘서 더이상 max,min값이
        # max,min이 아닐수 있음!!
        diff = max(arr) - min(arr)
    print(f"#{i+1} {diff}")
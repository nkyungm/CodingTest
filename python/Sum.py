for i in range(10):
    T = int(input())
    arr = [[0]*100 for _ in range(100)]
    SUM =0 # 약속된 함수랑 이름같으면 안됨!!(sum으로 쓰면 안됨)
    for i in range(100):
        num = list(map(int,input().split()))
        for j in range(100):
            arr[i][j] = num[j]
        if(sum(num) > SUM):
            SUM = sum(num)

    for j in range(100):
        j_sum = 0
        for i in range(100):
            j_sum += arr[i][j]
        if(SUM < j_sum):
            SUM = j_sum

    d1_sum =0
    d2_sum =0
    for i in range(100):
        for j in range(100):
            if(i==j): d1_sum +=arr[i][j]
            if(i+j == 99): d2_sum+=arr[i][j]

    if(SUM< d1_sum): SUM = d1_sum
    if(SUM<d2_sum): SUM=d2_sum

    print(f"#{T} {SUM}")


# 4 4 3 2 1 2 2 1 6 5 3 5 4 6 7 4 2 5 9 7 8 1 9 5 6
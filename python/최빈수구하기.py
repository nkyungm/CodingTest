import sys
from collections import Counter
N = int(input())

for _ in range(N):
    T = input()
    arr = sorted(list(map(int, input().split()))) # count의 수가 같을경우 더 큰값이 출력되기 위해 정렬
    count = Counter(arr)
    student = dict(count)
    reverseDict = {v: k for k, v in student.items()}
    num = reverseDict.get(max(list(student.values())))
    print(f"#{T} {num}")
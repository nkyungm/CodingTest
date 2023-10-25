import sys
from itertools import product # 중복순열 사용

#count()함수는 겹치는곳 인식 못하므로 count()사용못함...

data =['A','B','C']

def palindrome(l):
    result =[]
    arr=[]
    if(l==1): result = ['A','B','C']
    elif(l==2) : result = ['AA','BB','CC']
    else:
        if(l%2 == 0):
            arr = list(product(data,repeat=l//2))
            for i in arr:
                st = ''.join(i)
                result.append(st+st[::-1])
        else:
            arr = list(product(data,repeat=l//2+1))
            for i in arr:
                st = ''.join(i)
                result.append(st+st[l//2-1::-1])
    return result

for k in range(10):
    arr=[]
    cnt =0
    LEN = int(input())
    result = palindrome(LEN) #길이별 회문 리스트
    for i in range(8): #가로
        st = input()
        arr.append(list(st))
        for r in result:
            for j in range(9-LEN):
                if(st[j:j+LEN].count(r)>0):
                    cnt+=st[j:j+LEN].count(r)
    
    for j in range(8):
        st2 =''
        for i in range(8):
            st2 += arr[i][j]
        for r in result:
            for p in range(9-LEN):
                if(st2[p:p+LEN].count(r)>0):
                    cnt+=st2[p:p+LEN].count(r)
    
    print(f"#{k+1} {cnt}")

            
# arr=[['1','2'],['1','2']]

# for j in range(2):
#     a=''
#     for i in range(2):
#         a += arr[i][j]
#     print(a)
import java.util.*;
import java.util.stream.Collectors;

public class Baekjoon_15649 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        permutation(N,M,new ArrayList<>());

    }

    private static void permutation(int n, int m, ArrayList<Integer> arr) {
        if(m==0){
            ArrayList<Integer> arr2=new ArrayList<Integer>();
            //중복 제거
            for(int i=0; i<arr.size(); i++) {
                if(!arr2.contains(arr.get(i)))
                    arr2.add(arr.get(i));
            }
            if(arr2.size()==arr.size())
            {
                StringBuilder str = new StringBuilder();
                for (Integer num : arr2) {
                    str.append(num);
                    str.append(" ");
                }
                System.out.println(str);
            }


            return;
        }

        for(int i=1;i<=n;i++){

            arr.add(i);
            permutation(n,m-1,arr);
            arr.remove(arr.size()-1); //한번 다 넣은다음 앞의 리스트 삭제하는 작업
        }
    }
}

import java.util.Scanner;

public class Baekjoon_2501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N,K;
        int count=0;
        //한줄에 여러개 입력하는 방법!
        N=sc.nextInt();
        K=sc.nextInt();

        for(int i=1;i<=N;i++){
            if(N%i==0){
                count+=1;
                if(count==K){
                    System.out.println(i);
                    break;
                }
            }
        }
        if(count<K)
            System.out.println(0);
    }
}

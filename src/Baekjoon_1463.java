import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon_1463 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        int[] dp=new int[X+1];

        dp[1]=0;

        if(X>1){
            for(int i=2;i<=X;i++){
                int m3=X;
                int m2=X;
                if(i%3==0){
                    m3=dp[i/3]+1;
                }
                if(i%2==0){
                    m2=dp[i/2]+1;
                }
                int m1=dp[i-1]+1;
                dp[i]=Math.min(Math.min(m3,m2),m1);
            }
        }
        System.out.println(dp[X]);
    }
}

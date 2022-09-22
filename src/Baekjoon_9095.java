import java.util.Scanner;

public class Baekjoon_9095 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0;i<T;i++){
            int a=sc.nextInt();
            System.out.println(dp(a));
        }
    }
    public static int dp(int n) {
        int count=0;
        if(n==1){
            return 1;
        } else if (n==2) {
            return 2;
        } else if (n==3) {
            return 4;
        }else{
            return dp(n-1)+dp(n-2)+dp(n-3);
        }
    }
}

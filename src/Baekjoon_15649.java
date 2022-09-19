import java.util.Scanner;

public class Baekjoon_15649 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();

        permutation(N,M);
    }

    private static void permutation(int n,int m) {
        int count=0;
        for(int i=count;i<n;i++){
            permutation(n-1,m-1);
        }
    }

}

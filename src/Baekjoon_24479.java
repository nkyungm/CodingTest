
import java.util.Scanner;

public class Baekjoon_24479 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int R=sc.nextInt();
        boolean [] visited=new boolean[N+1];
        //int[][] E= new int[N][M];
        int[][] E= {{},{2,5},{3,5},{5},{},{}};
//        for(int i=0;i<M;i++){
//
//        }
        dfs(visited,E,1);
        for(int i=1;i<=N;i++){
            if(visited[i]==false){
                System.out.println(0);
            }
        }
    }
    public static void dfs(boolean[] V,int[][] E,int R) {
        V[R]=true;
        System.out.printf("%d\n",R);
        for(int node:E[R]){
             if(V[node]==false){
                dfs(V,E,node);
            }
        }
    }
}

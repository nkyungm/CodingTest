import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11660 {
    static int[][] arr;
    static int[][] dp;
    static int[][] xy;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        dp=new int[N][N];
        arr=new int[N][N];
        xy=new int[M][4];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(i==0&&j==0){
                    dp[i][j]=arr[i][j];
                }else if(i==0&&j!=0){
                    dp[i][j]=dp[0][j-1]+arr[i][j];
                }else if(i!=0&&j==0){
                    dp[i][j]=dp[i-1][0]+arr[i][j];
                }else{
                    dp[i][j]=arr[i][j]+dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
                }
            }
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                xy[i][j]=Integer.parseInt(st.nextToken());
            }
            int x1=xy[i][0]-1;
            int y1=xy[i][1]-1;
            int x2=xy[i][2]-1;
            int y2=xy[i][3]-1;
            int total=0;
            if(x1==0&&y1==0){
                total=dp[x2][y2];
                System.out.println(total);
            }else if(x1==0&&y1!=0){
                total=dp[x2][y2]-dp[x2][y1-1];
                System.out.println(total);
            }else if(x1!=0&&y1==0){
                total=dp[x2][y2]-dp[x1-1][y2];
                System.out.println(total);
            }else{
                total=dp[x2][y2]-(dp[x2][y1-1]+dp[x1-1][y2])+dp[x1-1][y1-1];
                System.out.println(total);
            }
        }
    }
}

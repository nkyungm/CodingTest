import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_14503 {
    static int cnt=0;
    static int[][] arr;
    static boolean[][] check;
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine()); //라인 건너뛰기

        int r=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        check=new boolean[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    check[i][j]=true;
                }
            }
        }
        cnt++;
        clean(r,c,d);
    }
    static void clean(int r,int c,int d){
        check[r][c]=true;
        int[] x={-1,0,1,0};
        int[] y={0,1,0,-1};
        int a=(d+2)%4;

        for(int i=0;i<4;i++){
            int left=(d+3-i)%4;
            int next_x=r+x[left];
            int next_y=c+y[left];
            if(0<=next_x && next_x<=N && 0<=next_y && next_y<=M && check[next_x][next_y]==false){
                cnt++;
                clean(next_x,next_y,left);
            }
        }
        if(r+x[a]>=0 && r+x[a]<=N && 0<=c+y[a] && c+y[a]<=M && arr[r+x[a]][c+y[a]]!=1){
            clean(r+x[a],c+y[a],d);
        }else{
            System.out.println(cnt);
            System.exit(0);
        }
    }

}

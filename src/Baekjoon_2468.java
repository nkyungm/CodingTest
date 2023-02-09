import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2468 {
    static int[] rangeX={1,-1,0,0};
    static int[] rangeY={0,0,-1,1};
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        int M=1;
        int[][] E=new int[N][N];
        int cnt=0;

        for(int i=0;i<N;i++){ //물에 안잠기는 경우도 있ㅅ어 0부터 시작함!
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                E[i][j]=Integer.parseInt(st.nextToken());
                if(E[i][j]>M){
                    M=E[i][j];
                }
            }
        }

        for(int rain=0;rain<M;rain++){
            int c=0;
            boolean[][] V=new boolean[N][N];
            for(int i=0;i<N;i++) {
                for (int j = 0; j < N; j++) {
                    if (E[i][j] <= rain) {
                        V[i][j] = true;
                    }
                }
            }

            for(int i=0;i<N;i++) {
                for (int j = 0; j < N; j++) {
                    if(V[i][j]==false){
                        c++;
                        bfs(E,V,i,j);
                    }
                }
            }
            if(c>cnt){
                cnt=c;
            }
        }
        System.out.println(cnt);
    }
    static void bfs(int[][] E,boolean[][] V,int x,int y){
        Queue<int[]> queue=new LinkedList<>();
        int[] xy;
        queue.add(new int[] {x,y});
        V[x][y]=true;
        while (!queue.isEmpty()){
            xy=queue.poll();
            for(int i=0;i<4;i++){
                if(0<=xy[0]+rangeX[i] && xy[0]+rangeX[i]<N  && 0<=xy[1]+rangeY[i] && xy[1]+rangeY[i]<N  && V[xy[0]+rangeX[i]][xy[1]+rangeY[i]]==false){
                    queue.add(new int[] {xy[0]+rangeX[i],xy[1]+rangeY[i]});
                    V[xy[0]+rangeX[i]][xy[1]+rangeY[i]]=true;
                }
            }
        }
    }
}

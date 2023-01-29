import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2667 {
    static int[] rangeX={1,-1,0,0};
    static int[] rangeY={0,0,1,-1};
    static int N;
    static ArrayList<Integer> cnts=new ArrayList<Integer>();

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        int[][] graph=new int[N][N];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<N;j++){
                char c=s.charAt(j);
                graph[i][j]=Character.getNumericValue(c);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j]==1){
                    cnts.add(bfs(graph,i,j));
                }
            }
        }
        Collections.sort(cnts); //오름차순 정렬
        System.out.println(cnts.size());
        for(int i=0;i<cnts.size();i++){
            System.out.println(cnts.get(i));
        }
    }
    static int bfs(int[][] E,int x,int y){
        int cnt=1;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[] {x,y});
        int[] xy;
        E[x][y]=-1;
        while(!queue.isEmpty()){
            xy=queue.poll();
            for(int i=0;i<4;i++){
                 int x1=xy[0]+rangeX[i];
                 int y1=xy[1]+rangeY[i];
                 if(0<=x1 && x1<N && 0<=y1 && y1<N && E[x1][y1]==1){
                     E[x1][y1]=-1;
                     cnt++;
                     queue.add(new int[] {x1,y1});
                 }
            }
        }
        return cnt;
    }
}

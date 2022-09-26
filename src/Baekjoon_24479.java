import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_24479 {
    int cnt=0; //전역변수

    public void solution() throws Exception { //throws Exception 예외처리(매번 해주는게 좋음)
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int [] visited=new int[N];
        ArrayList<Integer>[] E=new ArrayList[N];
        for(int i=0;i<N;i++){
            E[i]=new ArrayList<Integer>();
            visited[i]=0;
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()); //다시 해야함

            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            E[u-1].add(v-1);
            E[v-1].add(u-1);
        }
        for(int i=0;i<N;i++) {
            Collections.sort(E[i]);
        }

        dfs(visited,E,R-1);
        for(int i=0;i<N;i++){
            System.out.println(visited[i]);
        }

    }
    void dfs(int[] V,ArrayList<Integer>[] E,int R) {

        V[R]=++cnt;
        //System.out.printf("%d\n",R+1);
        for(int node:E[R]){
            if(V[node]==0){
                dfs(V,E,node);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}

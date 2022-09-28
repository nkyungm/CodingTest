import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_24481 {
    int cnt=0;
    public void solution() throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int R=Integer.parseInt(st.nextToken());

        int[] visited=new int[N];
        ArrayList<Integer>[] E=new ArrayList[N];
        for(int i=0;i<N;i++){
            E[i]=new ArrayList<Integer>();
            visited[i]=-1;
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());

            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            E[u-1].add(v-1);
            E[v-1].add(u-1);
        }
        for(int i=0;i<N;i++){
            Collections.sort(E[i]);
        }
        visited[R-1]=0;
        dfs(visited,E,R-1);
        for(int i=0;i<N;i++){
            System.out.println(visited[i]);
        }

    }

    void dfs(int[] V, ArrayList<Integer>[] E,int R){

        //cnt++;
//        for(int i=0;i<V.length;i++){
//            System.out.println(V[i]);
//        }
        for(int node:E[R]){

            if(V[node]==-1){
                V[node]=++cnt;
                dfs(V,E,node);

            }
        }
        cnt--;
    }

    public static void main(String[] args) throws Exception{
        new Baekjoon_24481().solution();
    }
}

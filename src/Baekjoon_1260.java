import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1260 {
    static int cnt=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int V=Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] E=new ArrayList[N];
        int[] visitied=new int[N];
        boolean[] visited_bfs=new boolean[N];

        for(int i=0;i<N;i++){
            E[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            E[u-1].add(v-1);
            E[v-1].add(u-1);
        }
        //오름차순 정렬
        for(int i=0;i<N;i++){
            Collections.sort(E[i]);
        }
        dfs(visitied,E,V-1);
        System.out.println();
        bfs(visited_bfs,E,V-1);
    }

    static void dfs(int[]V,ArrayList<Integer>[] E,int R){
        V[R]=++cnt;
        System.out.printf("%d ",R+1);
        for(int node:E[R]){
           if(V[node]==0){
               dfs(V,E,node);
           }
        }
    }

    static void bfs(boolean[] V,ArrayList<Integer>[] E,int R){
        Queue<Integer> queue =new LinkedList<>();
        int c;
        V[R]=true;
        queue.add(R);
        while(!queue.isEmpty()){
            c=queue.poll();
            System.out.printf("%d ",c+1);
            for(int node:E[c]){
                if(V[node]==false){
                    queue.add(node);
                    V[node]=true;
                }
            }
        }
    }
}

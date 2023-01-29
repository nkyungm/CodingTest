import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2606 {
    static int cnt=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int M=Integer.parseInt(st.nextToken());
        boolean[] visited=new boolean[N];
        ArrayList<Integer>[] E=new ArrayList[N];

        for(int i=0;i<N;i++){
            E[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int v=Integer.parseInt(st.nextToken());
            int u=Integer.parseInt(st.nextToken());
            E[v-1].add(u-1);
            E[u-1].add(v-1);
        }

        for(int i=0;i<N;i++){ //ArrayList 오름차순 정렬
            Collections.sort(E[i]);
        }
        bfs(E,visited);
        System.out.println(cnt);
    }

    static void bfs(ArrayList<Integer>[] E,boolean[] V){
        Queue<Integer> queue=new LinkedList<>();
        V[0]=true;
        queue.add(0);
        while(!queue.isEmpty()){
            int c=queue.poll();
            for(int node:E[c]){
                if(V[node]==false){
                    queue.add(node);
                    V[node]=true;
                    cnt++;
                }
            }
        }
    }
}

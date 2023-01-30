import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2644 {
    public static class Pair1{
        int x,cnt;
        Pair1(int x,int cnt){
            this.x=x;
            this.cnt=cnt;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] E=new ArrayList[N];
        boolean[] visited=new boolean[N];
        for(int i=0;i<N;i++){
            E[i]=new ArrayList<>();
        }

        st=new StringTokenizer(br.readLine());
        int person1=Integer.parseInt(st.nextToken());
        int person2=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        int M=Integer.parseInt(st.nextToken());

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
        System.out.println(bfs(E,visited,person2-1,person1-1));
    }
    static int bfs(ArrayList<Integer>[]E,boolean[] V,int start,int end){
        Queue<Pair1> queue=new LinkedList<>();
        Pair1 pair1=null; //초기화 중요
        
        queue.add(new Pair1(start,0));
        V[start]=true;
        while(!queue.isEmpty()){
            pair1=queue.poll();
            if(pair1.x==end){
                return pair1.cnt;
            }else{
                for(int node:E[pair1.x]){
                    if(V[node]==false){
                        queue.add(new Pair1(node, pair1.cnt+1));
                        V[node]=true; //중요중요!!!
                    }
                }
            }
        }
        return -1;
    }
}

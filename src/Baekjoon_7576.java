import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_7576 {
    static int day=0;
    static Queue<Integer> queue =new LinkedList<>();

    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());

        int[] box=new int[N*M];
        int[] visited=new int[N*M];

        for(int i=0;i<N*M;i++){
            box[i]=0;
            visited[i]=0;
        }

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                box[(i+j)+i*(M-1)]=Integer.parseInt(st.nextToken());
                if(box[(i+j)+i*(M-1)]==1){
                    queue.offer((i+j)+i*(M-1));
                }
            }
        }
        bfs(visited,box,M);

        int max=0;
        for(int i=0;i<N*M;i++){
            if(box[i]==0){
                max=-1;
                break;
            }
            if(visited[i]>max){
                max=visited[i];
            }
        }
        System.out.println(max);

    }
    static void bfs(int[] visited,int[] graph,int M){

        int[] checklist=new int[4];

        while(queue.isEmpty()==false){
            int u=queue.poll();
            check(checklist,graph,M,u);
            for(int v:checklist){
                if(v!=-1){
                    graph[v]=1;
                    visited[v]=visited[u]+1;
                    queue.offer(v);
                }
            }
        }
    }

    static void check(int[] V,int[] graph,int M,int u){
        for(int i=0;i<4;i++){
            V[i]=-1;
        }
        int i=0;
        if(u-M>=0 && graph[u-M]==0){ //위쪽이 0이상일 경우
            V[i]=u-M;
            i++;
        }
        if((u-1>=0) && (u%M!=0) && graph[u-1]==0){ //왼쪽이 0이상이고 나머지가 0이 아닐경우
            V[i]=u-1;
            i++;
        }
        if((u+1<graph.length) &&(u%M!=M-1) && graph[u+1]==0){ //오른쪽이 M*N 미만이고 나머지가 M-1이 아닐경우
            V[i]=u+1;
            i++;
        }
        if(u+M<graph.length && graph[u+M]==0){ //뒤쪽이 M*N 미만일 경우
            V[i]=u+M;
        }
    }
}
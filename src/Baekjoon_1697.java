import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1697 {
    static class Pair2{
        int x,cnt;
        Pair2(int x,int cnt){
            this.x=x;
            this.cnt=cnt;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); //수빈
        int M=Integer.parseInt(st.nextToken()); //동생
        boolean[] visited=new boolean[100001];

        System.out.println(bfs(visited,N,M));

    }
    static int bfs(boolean[] V,int start,int end){
        Queue<Pair2> queue=new LinkedList<>();
        Pair2 pair2=null;
        queue.add(new Pair2(start,0));
        V[start]=true;
        while(!queue.isEmpty()){
            pair2=queue.poll();
            if(pair2.x==end){
                return pair2.cnt;
            }else{
                if(0<=pair2.x-1 && pair2.x-1<=100000 && V[pair2.x-1]==false){
                    queue.add(new Pair2(pair2.x-1, pair2.cnt+1));
                    V[pair2.x-1]=true;
                }
                if(0<=pair2.x+1 && pair2.x+1<=100000 && V[pair2.x+1]==false){
                    queue.add(new Pair2(pair2.x+1, pair2.cnt+1));
                    V[pair2.x+1]=true;
                }
                if(0<=pair2.x*2 && pair2.x*2<=100000 && V[pair2.x*2]==false){
                    queue.add(new Pair2(pair2.x*2, pair2.cnt+1));
                    V[pair2.x*2]=true;
                }
            }
        }
        return 0;
    }
}

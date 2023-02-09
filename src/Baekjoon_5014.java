import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baekjoon_5014 {
    static int F,S,G,U,D;

    static class floor{
        int x,cnt;

        public floor(int x,int cnt){
            this.x=x;
            this.cnt=cnt;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        F=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        G=Integer.parseInt(st.nextToken());
        U=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());

        boolean[] visited=new boolean[F+1];
        int f=bfs(visited);
        if(f==-1){
            System.out.println("use the stairs");
        }else{
            System.out.println(f);
        }
    }

    static int bfs(boolean[] V){
        Queue<floor> queue=new LinkedList<>();
        queue.add(new floor(S,0));
        floor c=null;
        V[S]=true;
        while (!queue.isEmpty()){
            c=queue.poll();
            if(c.x==G){
                return c.cnt;
            }else{
                int up=c.x+U;
                int down=c.x-D;
                if(up<=F  && V[up]==false){
                    queue.add(new floor(up,c.cnt+1));
                    V[up]=true;
                }
                if(down<=F && down>=1 && V[down]==false){
                    queue.add(new floor(down,c.cnt+1));
                    V[down]=true;
                }
            }
        }
        return -1;
    }
}

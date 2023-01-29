import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2178 {
    static int[] rangeX={1,-1,0,0};
    static int[] rangeY={0,0,1,-1};

    public static class Pair{
        int x,y,cnt;
        Pair(int x,int y,int cnt){
            this.x=x; //x좌표
            this.y=y; //y좌표
            this.cnt=cnt; //층
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[][] graph=new int[N][M];
        //붙여서 입력할때 쓰는 방법
        for(int i=0;i<N;i++){
            String s=br.readLine(); //한줄로 입력받고
            for(int j=0;j<s.length();j++){
                char c=s.charAt(j); //한개씩 짤라서
                graph[i][j]=Character.getNumericValue(c); //int로 변환해서 저장
            }
        }
        bfs(graph,N,M);
    }

    static void bfs(int[][] E,int N,int M){
        Queue<Pair> queue= new LinkedList<>();
        int cnt=1;
        E[0][0]=-1;
        queue.add(new Pair(0,0,cnt));
        Pair pair = null; //초기화 꼭 하기
        while(!queue.isEmpty()){
            pair=queue.poll();
            if(pair.x==N-1 && pair.y==M-1) { //N,M 목적지 확인
                System.out.println(pair.cnt);
            }else{
                for(int i=0;i<4;i++){
                    //상하좌우 확인
                    int x1=pair.x+rangeX[i];
                    int y1=pair.y+rangeY[i];
                    if(x1>=0 && x1<N && y1>=0 && y1<M && E[x1][y1]==1){ //배열 크기 안, 1인지 확인
                        E[x1][y1]=-1; //간곳 표시
                        queue.add(new Pair(x1,y1, pair.cnt+1)); //큐에 넣기(cnt=부모 층+1)
                    }
                }
            }
        }
    }
}

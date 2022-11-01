import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2636 {

    static int[][] cheeze;
    static int[] rangeX = { -1, 0, 1, 0 };
    static int[] rangeY = { 0, 1, 0, -1 };
    static int cnt=0;

    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int row=Integer.parseInt(st.nextToken()); //가로
        int col=Integer.parseInt(st.nextToken()); //세로

        cheeze=new int[row][col]; //2차원 배열 생성


        for(int i=0;i<row;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<col;j++){
                cheeze[i][j]=Integer.parseInt(st.nextToken()); //입력
//                if(i==0 || i==row-1 || j==0 || j==col-1){
//                    visited[i][j]=true; //가장자리 true로 변환
//                }
            }
        }

        int num=0;
        int count=0;
        while(true){
            bfs(0,0,row,col);
            if(cnt==0){
                System.out.println(count);
                System.out.println(num);
                break;
            }
            else{
                num=cnt;
                count++;
            }
        }

//        for(int i=0;i<row;i++){
//            int[] arr=cheeze[i];
//            for(int j=0;j<col;j++){
//                System.out.print(arr[j]+ " ");
//            }
//            System.out.println();
//        }

    }
    static void bfs(int r,int c,int row,int col){

        Queue<int[]> queue=new LinkedList<>();
        cnt=0;
        queue.offer(new int[] {r,c});
        boolean[][] visited=new boolean[row][col]; //공기 중에 있는지 확인하는 함수
        while(queue.isEmpty()==false){
            int[] u=queue.poll();
            for(int i=0;i<4;i++){
                int rr=u[0]+rangeX[i];
                int cc=u[1]+rangeY[i];
                if(rr>=0 && cc>=0 && rr<row && cc<col && visited[rr][cc]==false){
                    visited[rr][cc]=true;
                    if(cheeze[rr][cc]==0){
                        queue.offer(new int[] {rr,cc});
                    }
                    else{
                        cnt++;
                        cheeze[rr][cc]=0;
                    }
                }
            }
        }
    }
}

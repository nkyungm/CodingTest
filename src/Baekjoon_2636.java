import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2636 { //치즈 문제
    //cheeze, rangeX, rangeY,cnt 전역변수로 설정
    static int[][] cheeze; //사각형 모양의 판 2차원배열
    static int[] rangeX = { -1, 0, 1, 0 }; //상하좌우 x좌표
    static int[] rangeY = { 0, 1, 0, -1 };//상하좌우 y좌표
    static int cnt=0; //녹기 한시간 전에 남아있는 치즈조각의 개수를 위한 변수

    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int row=Integer.parseInt(st.nextToken()); //가로
        int col=Integer.parseInt(st.nextToken()); //세로

        cheeze=new int[row][col]; //2차원 배열 생성

        for(int i=0;i<row;i++){ //이중 for문 돌려 사각판 입력 받음
            st=new StringTokenizer(br.readLine()," "); //한번더 st 정의해줘야함!
            for(int j=0;j<col;j++){
                cheeze[i][j]=Integer.parseInt(st.nextToken()); //0 또는 1입력
            }
        }

        int num=0; //cnt 담기 위한 변수
        /*num 변수 따로 생성한 이유
         =>bfs는 한번 돌때마다 cnt=0으로 초기화 해주기 때문에 그 전의 녹은 치즈 개수 알기 위해
         따로 다른 변수에 저장해 줘야함*/
        int count=0; //치즈 모두 녹은 시간 변수
        while(true){ //무한 loop 돌림
            /*
            while 조건에 cnt==0 넣지 않은 이유 
            * => 전역변수로 cnt=0으로 설정했기 때문에 바로 while문 종료됨
            * */
            bfs(0,0,row,col); //(0,0)부터 bfs 시작
            if(cnt==0){ //cnt==0이면 녹을 치즈가 없다는 것을 의미
                System.out.println(count); //치즈 모두 녹는데 걸리는 시간 출력
                System.out.println(num); //모두 녹기 한시간 전 남아있는 치즈조각 개수 출력
                break; //while 문 중단
            }
            else{ //cnt!=0이면 아직 녹은 치즈가 있다는 의미 => while문 계속 반복
                num=cnt; //bfs 함수에서 저장된 cnt(녹은 치즈 개수) num으로 옮겨줌
                count++; //시간 하루 추가
            }
        }

        //이건 2차원 배열 출력(test를 위함)
//        for(int i=0;i<row;i++){
//            int[] arr=cheeze[i];
//            for(int j=0;j<col;j++){
//                System.out.print(arr[j]+ " ");
//            }
//            System.out.println();
//        }

    }
    static void bfs(int r,int c,int row,int col){ //bfs 함수
        Queue<int[]> queue=new LinkedList<>(); //queue 사용
        /*1차원 배열 형식으로 i,j 자체를 큐에 넣기 위해 Queue<int[]> 형식으로 사용*/
        cnt=0; //cnt 0으로 초기화
        queue.offer(new int[] {r,c}); //0,0 큐에 넣음
        boolean[][] visited=new boolean[row][col]; //큐 방문 여부 확인하는 2차원 배열
        while(queue.isEmpty()==false){ //큐에 아무것도 없을 때까지 loop 돌림
            int[] u=queue.poll(); //큐 맨 앞에 있는 1차원 배열 u 꺼냄
            for(int i=0;i<4;i++){ //상하좌우 확인 위해 for문 4번 반복
                int rr=u[0]+rangeX[i]; //u[0]+rangeX[i] 으로 x 값 변경
                int cc=u[1]+rangeY[i]; //u[1]+rangeY[i] 으로 y 값 변경
                if(rr>=0 && cc>=0 && rr<row && cc<col && visited[rr][cc]==false){
                    //상하좌우의 위치가 사각형 좌표 안에 있고, 방문하지 않았으면
                    visited[rr][cc]=true; //방문 표시
                    if(cheeze[rr][cc]==0){ //0 -> 0으로 간것은 큐에 넣어줌
                        queue.offer(new int[] {rr,cc});
                    }
                    else{ //0 ->1로 간 것이라면 방문처리만 하고 큐에 넣지 X
                        /*큐에 넣지 않는 이유
                        * => 공기와 닿아있는 치즈의 테두리 부분만 녹아야 하기 때문에
                        * 큐에 아예 넣지 않으면 그 안으로 갈 일이 없음
                        * */
                        cnt++; //치즈가 녹은 것으로 판단해 cnt 1 증가
                        cheeze[rr][cc]=0; //치즈가 녹은 것으로 판단해 0으로 값 변경
                    }
                }
            }
        }
    }
}

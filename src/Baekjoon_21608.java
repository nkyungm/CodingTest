import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_21608 {
    static int[][] arr;
    static int[][] like;
    static int N;
    static int[] rangeY = { -1, 0, 1, 0 }; //r
    static int[] rangeX = { 0, 1, 0, -1 };
    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        like=new int[N*N][5];
        arr=new int[N][N];

        for(int i=0;i<N*N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                like[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N*N;i++){
            seating_arrangement(i);
        }
    }

    static void seating_arrangement(int i){
        int cnt1=0;
        int cnt2=0;

        List<int[]> list=new ArrayList<>();
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                int cnt[]=friends_blank(i,r,c);
                cnt1=cnt[0];
                cnt2=cnt[1];
                list.add(new int[] {cnt1,cnt2,r,c}); //0,0 큐에 넣음
            }
        }

    }

    static int[] friends_blank(int i,int r,int c){ //1번째,2번쨰 조건
        int cnt1=0;
        int cnt2=0;
        for(int k=0;k<4;k++){
            int row=r+rangeY[k];
            int col=c+rangeX[k];
            if(0<=row && row<=N && 0<=col && col<=N) {
                if(arr[row][col]==0){
                    cnt2++;
                }
                for (int j = 0; j < 4; j++) {
                    if (arr[row][col] == like[i][j + 1]) {
                        cnt1++;
                    }
                }
            }
        }
        return new int[] {cnt1,cnt2};
    }

}



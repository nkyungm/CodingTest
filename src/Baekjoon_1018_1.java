import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1018_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        char[][] tmp=new char[M][N];
        String[] table=new String[M]; //문자열로 받아오기

        String[] chess=new String[8]; //문자열

        for(int i=0;i<M;i++){
            table[i]=br.readLine();
        }
        for(int i=0;i<M;i++){
            char[] a = table[i].toCharArray();
            for (int k = 0; k < N; k++) {
                tmp[i][k] = a[k]; //table을 2차원 배열로 변경
            }
        }

        //chess8x8(1,2,table,tmp);



//        char[] tmp=table[0].toCharArray();
//        for(int i=0;i<8;i++){ //안에 chessTable 함수쓰기
//            System.out.println(tmp[i]);
//        }

    }

    public static void chessTable(int m,int n,char[][] tmp){ //체스판 8x8 일때 색칠하는 최솟값 계산 함수
        //먼저 main의 tmp[][] 2차배열 가져와서 8x8 이중 for문 돌려서 체스판 만들기
        char[][] a=new char[8][8];

    }
}

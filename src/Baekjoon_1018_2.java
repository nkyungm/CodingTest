import java.io.IOException;
import java.util.Scanner;

public class Baekjoon_1018_2 {
    static char chess[][]; //전역변수로 설정
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //N 받아옴
        int M = sc.nextInt(); //M 받아옴
        chess = new char[N][M]; //NxM 2차원 배열 chess
        sc.nextLine(); //다음칸에서 입력

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine(); //한줄 문자열로 입력받음
            for (int j = 0; j < M; j++) {
                chess[i][j] = s.charAt(j); //2차원배열로 변경
            }
        }

        int ans = 1000000; //최솟값 초기화

        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                ans = Math.min(ans, f(i,j)); //최솟값 찾아냄
            }
        }
        System.out.println(ans);
    }
    public static int f(int x, int y) { //체스 판 만들어서 최솟값 계산하는 함수
        int B = 0;
        int W = 0;

        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if((i + j) % 2 == 0) {
                    if(chess[i][j] == 'B') W++;
                    else B++;
                }else { // (i + j) % 2 == 1)
                    if(chess[i][j] == 'W') W++;
                    else B++;
                }
            }
        }
        return Math.min(B,W);
    }

}

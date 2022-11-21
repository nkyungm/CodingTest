import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_14503 {
    static int[][] paper;
    static int wcnt=0;
    static int bcnt=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        paper=new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken()); //0 또는 1입력
            }
        }

        colorpaper(0,0,N);
        System.out.println(wcnt);
        System.out.println(bcnt);

    }

    static boolean check(int row,int col,int size){
        int wwcnt=0;
        int bbcnt=0;
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(paper[i][j]==0){
                    wwcnt++;
                }else{
                    bbcnt++;
                }
                if(wwcnt!=0 && bbcnt!=0){
                    return false;
                }
            }
        }
        return true;
    }

    static void colorpaper(int row,int col,int size){
        if(check(row, col, size)) {
            if(paper[row][col] == 0) {
                wcnt++;
            }
            else {
                bcnt++;
            }
            return;
        }

        int newSize = size / 2;	// 절반 사이즈
        // 재귀 호출
        colorpaper(row, col, newSize);						// 2사분면
        colorpaper(row, col + newSize, newSize);				// 1사분면
        colorpaper(row + newSize, col, newSize);				// 3사분면
        colorpaper(row + newSize, col + newSize, newSize);	// 4사분면

    }
}

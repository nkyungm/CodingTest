import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_level1_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int[][] sizes=new int[N][2];

        for(int i=0;i< sizes.length;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++){
                sizes[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        Solution s=new Solution();
        System.out.println(s.solution(sizes));
    }
}

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_row=0;
        int max_col=0;

        for(int i=0;i<sizes.length;i++){
            int row=sizes[i][0];
            int col=sizes[i][1];
            if(row<col){
                int temp=row;
                row=col;
                col=temp;
            }
            if(row>max_row){
                max_row=row;
            }
            if(col>max_col){
                max_col=col;
            }
        }
        answer=max_col*max_row;
        return answer;
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_14916 {
    static class Floor{
        int x,cnt;
        public Floor(int x,int cnt){
            this.x=x;
            this.cnt=cnt;
        }
    }
    static int c=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int a=N%5;
        int cnt=0;
        if(a%2!=0){
            if(N>=5) {
                cnt += (N / 5 - 1);
                N -= (5 * (N / 5 - 1));
                cnt += N / 2;
            }else {
                cnt=-1;
            }
        }else{
            cnt+=N/5;
            N-=(5*(N/5));
            cnt+=N/2;

        }
        System.out.println(cnt);
    }

}

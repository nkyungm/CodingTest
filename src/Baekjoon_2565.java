import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class Cable
{
    int start,end;

    public Cable(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class Baekjoon_2565 {
    static int N;
    static Cable [] cables;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        cables = new Cable[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            cables[i] = new Cable(l,r);
        }

        //좌측값을 기준으로 정렬해준다(오름차순 정렬)
        Arrays.sort(cables, (c1, c2) -> c1.start - c2.start);

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, count(i));
        }

        System.out.print(N - max);
    }
    static int count(int n) {
        if (arr[n] < 1) {
            arr[n] = 1;



        }
        return arr[n];
    }
}

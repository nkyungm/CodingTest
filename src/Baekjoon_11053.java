import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11053 {
    static int[] A; //A배열
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        arr = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken()); //A배열 입력
        }

        for(int i = 0; i < N; i++) {
            arr[i] = 1;

            for(int j = 0; j < i; j++) {
                if(A[j] < A[i] && arr[i] < arr[j] + 1) {
                    arr[i] = arr[j] + 1;	// j번째 원소의 +1 값이 i번째 arr가 된다.
                }
            }
        }

        // 최댓값 찾기
        int max = -1;
        for(int i = 0; i < N; i++) {
            max = arr[i] > max ? arr[i] : max;
        }
        System.out.println(max);

    }
}

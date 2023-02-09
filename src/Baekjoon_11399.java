import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_11399 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr=new ArrayList<>();
        int[] result=new int[N];
        int sum=0;

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int c=Integer.parseInt(st.nextToken());
            arr.add(c);
        }

        Collections.sort(arr); //오름차순 정렬
        result[0]=arr.get(0);

        for(int i=1;i<N;i++){
            result[i]=result[i-1]+ arr.get(i);
        }

        for(int i=0;i<N;i++){
            sum+=result[i];
        }
        System.out.println(sum);
    }
}

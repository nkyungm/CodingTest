import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_2217{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        ArrayList<Integer> rope=new ArrayList<>();
        int result=0;
        int j=0;

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            rope.add(r);
        }
        Collections.sort(rope);//오름차순 정렬

        for(int i=0;i<rope.size();i++){
            if(result<rope.get(i)* (rope.size()-j)){
                result=rope.get(i)* (rope.size()-j);
            }
            j++;
        }
        System.out.println(result);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11720 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int sum=0;
        String str= br.readLine();

        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            sum+=Character.getNumericValue(c);
        }
        System.out.println(sum);
    }
}

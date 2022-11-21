import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_9012 {
    public static void main(String[] args)  throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int T= Integer.parseInt(st.nextToken());
        char a='(';
        char b=')';

        for(int i=0;i<T;i++){
            String ps=br.readLine();
            int cnt=0;
            boolean check=true;
            for(int j=0;j<ps.length();j++){
                if(ps.charAt(j)==a){
                    cnt++;
                }else if(ps.charAt(j)==b){
                    cnt--;
                    if(cnt<0){
                        check=false;
                        break;
                    }
                }
            }
            if(check==true && cnt==0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}

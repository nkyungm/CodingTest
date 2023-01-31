import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1213 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        char[] arr=s.toCharArray();
        char[] result=new char[arr.length];
        Arrays.sort(arr); //오름차순 정렬
        int j=0;

        if(arr.length%2==0){ //짝수
            //모든 문자 짝수개인지 확인
            for(int i=0;i<arr.length-1;i=i+2){
                if(arr[i]!=arr[i+1]){
                    System.out.println("I'm Sorry Hansoo");
                    System.exit(0);
                }
            }
            //팰린드롬 출력(사전순으로 빠른거)
            for(int i=0;i<arr.length-1;i=i+2){
                result[j]=arr[i];
                result[arr.length-(j+1)]=arr[i];
                j++;
            }
        }else{ //홀수
            //문자 한개만 홀수인지 확인
            int cnt=0;
            int index=0;
            for(int i=0;i<arr.length-1;i=i+2){
                if(arr[i]!=arr[i+1]){
                    cnt++;
                    index=i;
                    i--;
                    if(cnt>1){
                        System.out.println("I'm Sorry Hansoo");
                        System.exit(0);
                    }
                }
            }
            //팰린드롬 출력(사전순으로 빠른거)
            if(cnt==0){
                result[arr.length/2]=arr[arr.length-1];
            }else{
                result[arr.length/2]=arr[index];
            }
            for(int i=0;i<arr.length-1;i=i+2){
                if(i==index){
                    i--;
                }else{
                    result[j]=arr[i];
                    result[arr.length-(j+1)]=arr[i];
                    j++;
                }
            }
        }

        //결과 출력
        for(int i=0;i<arr.length;i++){
            System.out.printf("%c",result[i]);
        }

    }
}

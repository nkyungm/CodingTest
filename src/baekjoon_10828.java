import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_10828 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int num=Integer.parseInt(st.nextToken());
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<num;i++){
           String command = br.readLine();
           if(command.contains("push")){
               String n=command.substring(5);
               int number=Integer.parseInt(n);
               stack.push(number);
           }
           else if(command.contains("pop")){
               if(stack.isEmpty()==true){
                   System.out.println(-1);
               }else{
                   System.out.println(stack.pop());
               }
           }
           else if(command.contains("size")){
               System.out.println(stack.size());
           }
           else if(command.contains("empty")){
               if(stack.empty()==true){
                   System.out.println(1);
               }
               else{
                   System.out.println(0);
               }
           }
           else if(command.contains("top")){
               if(stack.isEmpty()==true){
                   System.out.println(-1);
               }else{
                   System.out.println(stack.peek());
               }
           }
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_18258 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int num=Integer.parseInt(br.readLine()); //명령의 수
        Deque<Integer> q=new LinkedList<>();

        for(int i=0;i<num;i++){ //for문을 돌려 명령 받아옴
            StringTokenizer st=new StringTokenizer(br.readLine());
            String s=st.nextToken();

            switch(s){
                case "push":{
                    int x=Integer.parseInt(st.nextToken());
                    q.add(x);
                    break;
                }
                case "pop":{
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(q.poll()).append("\n");
                    }
                    break;
                }
                case "size":{
                    sb.append(q.size()).append("\n");
                    break;
                }
                case "empty":{
                    if(q.isEmpty()){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                }
                case "front":{
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(q.peek()).append("\n");
                    }
                    break;
                }
                case "back":{
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(q.peekLast()).append("\n");
                    }
                    break;
                }
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}

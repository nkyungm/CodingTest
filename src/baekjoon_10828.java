import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_10828 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int num=Integer.parseInt(st.nextToken()); //명령의 수
        Stack<Integer> stack=new Stack<>(); //정수형 스택 생성

        for(int i=0;i<num;i++){ //for문을 돌려 명령 받아옴
            String command = br.readLine();
            if(command.contains("push")){ //문자열에 push 포함되어있는 경우
                String n=command.substring(5);
                //문자열에서 5번째 인덱스부터 끝까지 가져옴 => 숫자만 추출가능
                int number=Integer.parseInt(n); // int 형으로 변환
                stack.push(number); //스택 안에 해당 숫자 삽입
            }
            else if(command.contains("pop")){ //문자열에 pop 포함되어 있는 경우
                if(stack.isEmpty()==true){ //비어 있으면 -1 출력
                    System.out.println(-1);
                }else{ //비어 있지 않으면 스택의 가장 위에 있는 정수를 빼서 출력
                    System.out.println(stack.pop());
                }
            }
            else if(command.contains("size")){ //문자열에 size 포함되어 있는 경우
                System.out.println(stack.size()); //스택의 사이즈 출력
            }
            else if(command.contains("empty")){ //문자열에 empty 포함되어 있는 경우
                if(stack.empty()==true){ //비어 있으면 1 출력
                    System.out.println(1);
                }
                else{ //비어 있지 않으면 0 출력
                    System.out.println(0);
                }
            }
            else if(command.contains("top")){ //문자열에 top 포함되어 있는 경우
                if(stack.isEmpty()==true){ //스택 비어 있으면 -1 출력
                    System.out.println(-1);
                }else{ //비어 있지 않으면 stack.peek() 사용해 스택 가장 위에 있는 정수 값 반환해서 출력
                    System.out.println(stack.peek());
                }
            }
        }
    }
}

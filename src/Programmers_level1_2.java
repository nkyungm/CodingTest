import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.IntFunction;

public class Programmers_level1_2 {
    public static void main(String[] args) {
        int[] answers={1,2,3,4,5,1,2,3,4,5};
        Solution1 s=new Solution1();
        int[] ans=s.solution(answers);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}

class Solution1 {
    public int[] solution(int[] answers) {

        ArrayList<Integer> ans=new ArrayList<Integer>();
        int[] student1={1,2,3,4,5};
        int[] student2={2,1,2,3,2,4,2,5};
        int[] student3={3,3,1,1,2,2,4,4,5,5};
        int max1=0;
        int max2=0;
        int max3=0;
        int max=0;

        for(int i=0;i<answers.length;i++){
            if(student1[i%5]==answers[i]){
                max1+=1;
            }
            if(student2[i%8]==answers[i]){
                max2+=1;
            }
            if(student3[i%10]==answers[i]){
                max3+=1;
            }
        }
        if(max1>=max2 && max1>=max3){
            ans.add(1);
        }
        if(max2>=max1 && max2>=max3){
            ans.add(2);
        }
        if(max3>=max1 && max3>=max2){
            ans.add(3);
        }

        int[] answer = ans.stream().mapToInt(i->i).toArray();
        return answer;
    }
}

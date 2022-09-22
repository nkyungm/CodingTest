import java.util.Scanner;

public class Baekjoon_1057_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Kim = sc.nextInt();
        int Lim = sc.nextInt();
        int round=1;
        int result=0;

        while(N!=1){
            if(Kim%2==0){
                if(Lim==Kim-1){
                    result=round;
                    break;
                }
            }
            else{
                if(Lim==Kim+1){
                    result=round;
                    break;
                }
            }
            Kim=(Kim+1)/2;
            Lim=(Lim+1)/2;
            N=(N+1)/2;
            round++;
        }
        if(result==0){
            System.out.println(-1);
        }
        else{
            System.out.println(result);
        }




    }
}

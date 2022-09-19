import java.util.Scanner;

public class Baekjoon_1057_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Kim = sc.nextInt();
        int Lim = sc.nextInt();
        int round=0;

        while(Kim!=Lim){
            Kim=Kim/2+Kim%2;
            Lim=Lim/2+Lim%2;
            round++;
        }
        if(Kim!=Lim){
            System.out.println(-1);
        }
        else{
            System.out.println(round);
        }
    }
}

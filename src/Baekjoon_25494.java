import java.util.Scanner;

public class Baekjoon_25494 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int count=0;
        for(int i=0;i<T;i++){
            count=0;
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            for(int x=1;x<=a;x++)
            {
                for(int y=1;y<=b;y++)
                {
                    for(int z=1;z<=c;z++)
                    {
                        if(((x%y)==(y%z))&&((x%y)==(z%x))&&((y%z)==(z%x)))
                        {
                            count+=1;
                        }
                    }
                }
            }
            System.out.println(count);
        }

    }
}

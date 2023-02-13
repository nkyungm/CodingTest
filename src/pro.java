import java.util.ArrayList;

public class pro {
    static int cnt=0;
    public static void main(String[] args) {
        int n=3;
        String[] word= {"valya","lyglb","vldoh"};

        String target="val";
        ArrayList<Integer>[] E=new ArrayList[target.length()];
        for(int i=0;i<target.length();i++){
            E[i]=new ArrayList<Integer>();
        }

        char[] arr = new char[target.length()];
        for(int i=0;i<target.length();i++){
            char c=target.charAt(i);  //v,a,l
            for (String s : word) {
                for(int j=0;j<s.length();j++){
                    char sc=s.charAt(j);
                    if(c==sc){
                        E[i].add(j);
                    }
                }
            }
        }
        System.out.println(dfs(E,0,-1));
    }
    static int dfs(ArrayList<Integer>[] E,int R,int num){
        if(R<E.length){
            for(int node:E[R]){
                if(num<node){
                    dfs(E,R+1,node);
                    if(R==E.length-1){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    public static class Node{
        String str;
        int index;
        public Node (String str, int idx){
            this.str = str;
            this.index = idx;
        }

        @Override
        public String toString(){
            return "str : "+str+" index : "+index;
        }
    }
    public static int   getGroupedAnagrams (List<String> words){
        List<Node> lists  = new ArrayList<>();
        for(int i =0;i<words.size();i++){
            char[] chr = words.get(i).toCharArray();
            Arrays.sort(chr);
            lists.add(new Node(new String(chr),i));
        }
        Collections.sort(lists, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.str.compareTo(o2.str);
            }
        });
        int count = 1;

        Node pre = lists.get(0);
        List<String> group = new ArrayList<>();
        for(int i=1;i<lists.size();i++){

            if(pre.str.equals(lists.get(i).str)){
                System.out.println("소팅된 문자열 : "+pre.str);

                boolean flag = false;
                String str1 = words.get(pre.index);
                String str2 = words.get(lists.get(i).index);
                group.add(str1);
                System.out.println("같은 지 : "+str2);
                System.out.println("비교 문제"+str1);
                for(int j=0;j<pre.str.length();j++){
                    if (str1.charAt(j)!=str2.charAt(j)){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    count++;
                    pre = lists.get(i);
                }
            }else{
                pre = lists.get(i);
                count++;
            }

        }
        Set<String> set = new HashSet<>(words);
        return set.size();
    }
}
public class pro2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int wordsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, wordsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int result = Result.getGroupedAnagrams(words);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static PrintWriter out = new PrintWriter(System.out);

    public static void main(String...args) {
        /**
         * AtCoder Beginners Contest 212 C問題 Reorder Cards
         * https://atcoder.jp/contests/abc213/tasks/abc213_c
         * 
         * x座標、y座標独立に解いても問題ないので座標圧縮して終わり
         * O(NlogN)
         * 
         */
        int h = in.nextInt();
        int w = in.nextInt();
        int n = in.nextInt();
        int [] a = new int[n];
        int [] b = new int[n];
        for(int i = 0 ; i < n ; i ++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }
        Map<Integer,Integer> x = compress(a);
        Map<Integer,Integer> y = compress(b);
        for(int i = 0 ; i < n ; i ++) {
            out.println(x.get(a[i])+" "+y.get(b[i]));
        }
        out.flush();
    }

    private static Map<Integer,Integer> compress(int [] array) {
        TreeSet<Integer> binarySearchTree = new TreeSet<>(
            Arrays.asList(
                Arrays.stream(array).boxed().toArray(Integer[]::new)
            )   
        );
        Map<Integer,Integer> map = new HashMap<>();
        int id = 0 ;
        for(int v : binarySearchTree)
            map.put(v,++id);
        return map;
    }

}

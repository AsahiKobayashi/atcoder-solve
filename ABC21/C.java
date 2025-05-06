import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static PrintWriter out = new PrintWriter(System.out);

    public static void main(String...args) {
        /**
         * AtCoder Beginners Contest 212 C問題 Min Difference 
         * https://atcoder.jp/contests/abc212/tasks/abc212_c
         * 
         * 数列Aの任意の要素以下の値、以上の値を数列Bから平衡二分木で取得して最小値更新
         * O(NlogN)
         * 
         */
        int n = in.nextInt();
        int m = in.nextInt();
        int [] a = new int[n];
        int [] b = new int[m];
        for(int i = 0 ; i < n ; i ++)
            a[i] = in.nextInt();
        for(int i = 0 ; i < m ; i ++)
            b[i] = in.nextInt();
        TreeSet<Integer> binarySearchTree = new TreeSet<>(
            Arrays.asList(
                Arrays.stream(b).boxed().toArray(Integer[]::new)
            )
        );
        int min = (1 << 30);
        for(int v : a) {
            Integer l = binarySearchTree.floor(v);
            Integer r = binarySearchTree.ceiling(v);
            if(l != null)
                min = Math.min(min , Math.abs(v - l));
            if(r != null)
                min = Math.min(min , Math.abs(v - r));
        }
        out.println(min);
        out.flush();
    }

}

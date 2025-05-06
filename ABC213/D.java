import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static PrintWriter out = new PrintWriter(System.out);

    public static void main(String...args) {
        /**
         * AtCoder Beginners Contest 212 D問題 Takahashi Tour
         * https://atcoder.jp/contests/abc213/tasks/abc213_d
         * 
         * dfsする前にedgeをソートする
         */
        int n = in.nextInt();
        List<Integer> [] G = new ArrayList[n];
        Arrays.setAll(G , i -> new ArrayList<>());
        for(int i = 0 ; i < n - 1; i ++) {
            int a = in.nextInt() , b = in.nextInt();
            --a;--b;
            G[a].add(b);
            G[b].add(a);
        }
        for(int i = 0 ; i < n ; i ++)
            Collections.sort(G[i]);
        boolean [] used = new boolean[n];
        Consumer<Integer> dfs = new Consumer<Integer>() {
            public void accept(Integer e) {
                used[e] = true ;
                out.print((e +1)+" ");
                for(int nxt : G[e]) {
                    if(used[nxt])
                        continue;
                    accept(nxt);
                    out.print((e +1)+" ");
                }
            }
        };
        dfs.accept(0);
        out.flush();
    }

}

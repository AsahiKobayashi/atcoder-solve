import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static PrintWriter out = new PrintWriter(System.out);

    public static void main(String...args) {
        /**
         * AtCoder Beginners Contest 212 D問題 Querying Multiset
         * https://atcoder.jp/contests/abc212/tasks/abc212_d
         *     
         * t = 3 [3 , 4 , 5]
         * t = 4 [3 , 4 , 5] +10 => [13 , 14 , 15] 
         * t = 5 [3 , 4 , 5 , 6]  => [13 , 14 , 15 , 6] => [3 , 4 , 5 , 6 -10] => [3 , 4 , 5 , -4] = [13 , 14 , 15 , 6]
         * つまり
         * [3 , 4 , 5 , 6 , 7]
         * +20 +20 +20 +10 +10 のように全体に加算というより追加するタイミングで減算することで以下のようにあたかも全体に加算したかのように見せる
         * [3 , 4 , 5 , -4 , -3]
         *              -10  -10
         * ...
         * [3 , 4 , 5 , -4 , -3]
         * +20 +20 +20  +20  +20 => [23 , 24 , 25 ,16 , 17]
         * O(qlogN)
         */
        
        int q = in.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long add = 0 ;
        for(int i = 0 ; i < q ; i ++) {
            int t = in.nextInt();
            if(t == 1) {
                long x = in.nextLong();
                pq.add(x - add);
            }
            if(t == 2) {
                long x = in.nextLong();
                add += x ;
            }
            if(t == 3) {
                out.println(pq.poll() + add);
            }
        }
        out.flush();
    }

}

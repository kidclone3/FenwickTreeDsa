import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;

public class TestDriver {
    public static void main(String[] args) throws FileNotFoundException {
//        FenwickTree fw = new FenwickTree(11);
//        for(int i = 1; i <= 10; ++i) fw.add(i, i);
//        System.out.println(fw.getSum(10));
//        System.out.println(fw.getSum(1, 10));
//
//        FenwickTreeMin fwM = new FenwickTreeMin(11);
//        for(int i = 10; i >= 1; --i) fwM.add(10-i+1, i);
//        for(int i = 1; i <= 10; ++i) System.out.println(fwM.getMin(i));
        System.out.print("Segment tree: ");
        SegmentTree st = new SegmentTree();
        Instant start = Instant.now();
        st.main();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time estimate = " + timeElapsed);
        System.out.print("Fenwick tree: ");
        FenwickTree fw = new FenwickTree();
        start = Instant.now();
        fw.main();
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time estimate = " + timeElapsed);

    }
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
}

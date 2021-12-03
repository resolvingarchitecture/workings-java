package ra.workings.bigo;

import java.util.ArrayList;
import java.util.List;

/**
 * O(N) Time with O(N) Space
 */
public class ONTimeONSpace {

    private long number;
    private long startingUsedMemory;
    private long endingUsedMemory;
    private long startingTimeMs;
    private long endingTimeMs;
    private List<String> bucket = new ArrayList<>();

    public static void main(String[] args) {
        ONTimeONSpace m = new ONTimeONSpace();
        m.init();
        m.fill(2000000, "A");
        m.cleanup();

        m.init();
        m.fill(2000000, "A");
        m.cleanup();

        m.init();
        m.fill(2000000, "A");
        m.cleanup();
    }

    private void init() {
        Runtime.getRuntime().gc();
        startingUsedMemory = usedMemory();
        startingTimeMs = System.currentTimeMillis();
    }

    private void fill(long number, String str) {
        this.number = number;
        while(number-- > 0) {
            bucket.add(str);
        }
    }

    private void cleanup() {
        endingTimeMs = System.currentTimeMillis();
        endingUsedMemory = usedMemory();
        System.out.println("Number: " +number+"\n\tMemory Growth: "+(endingUsedMemory - startingUsedMemory)+"\n\tElapsed Time (ms): "+(endingTimeMs - startingTimeMs));
        bucket = new ArrayList<>();
    }

    private long usedMemory() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

}

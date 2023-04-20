package PracticeWork_TimedCompletion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// TODO: DO THE PRACTICAL
public class MainOneThread {
    public static void main(String[] args) throws InterruptedException {

        // Starting the timer.
        long start = System.currentTimeMillis();

        // Part 1. Adding.
        Thread addingThread = new Thread() {
            @Override
            public void run() {
                List<Integer> numbers = new ArrayList<>();
                for (int i = 1; i <= 10000000; i++) {
                    numbers.add(i);
                }
                int  max = Collections.max(numbers);
                System.out.println("Max found: " + max);
            }
        };

        // Part 2. Sorting.
        Thread sortingThread = new Thread() {
            @Override
            public void run() {
                List<Integer> unsorted = new ArrayList<>();
                for (int i = 10000000; i >= 1; i--) {
                    unsorted.add(i);
                }
                Collections.sort(unsorted);
                System.out.println("List is sorted now");
            }
        };


        // Part 3. Removing
        Thread removeThread = new Thread() {
            @Override
            public void run() {
                List<Integer> list = new ArrayList<>();
                for (int i = 1; i <= 10000000; i++) {
                    list.add(i);
                }
                while (list.size() != 0) {
                    list.remove(list.size() - 1);
                }
                System.out.println("List cleared");
            }
        };

        // Conclusion. Running the threads.
        addingThread.start();
        sortingThread.start();
        removeThread.start();

        // Waiting for ending of specific thread
        addingThread.join();
        sortingThread.join();
        removeThread.join();

        // Recording final time
        long end = System.currentTimeMillis();

        System.out.println("Total time: " + (end - start) + " ms"); // Output from ~12ms to ~1440ms
    }
}

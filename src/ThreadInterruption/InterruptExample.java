package ThreadInterruption;

public class InterruptExample {

    public static void main(String[] args) throws InterruptedException { // 4
        Thread threadToInterrupt = new Thread(){
            public void run(){
                while (true) {
                    System.out.println("Working hard");
                    try {
                        Thread.sleep(1000); // 1
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted!");
                        break; // 2
                    }
                }
            }
        };

        threadToInterrupt.start();
        // If to remove line 3 and 5, code will run infinitely.
        //Thread.currentThread().sleep(2500); // 3 // If this line is removed, it will output: Working Hard Interrupted!
        //threadToInterrupt.interrupt(); // 5 // If this line is removed, code will be infinite.
    }
}
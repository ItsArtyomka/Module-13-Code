package First_Chicken_OR_Egg;

import java.util.Random;

public class CE_Main {
    public static void main(String[] args) {
        // Make threads with the names
        ChickenEgg chicken = new ChickenEgg("Chicken");
        ChickenEgg egg = new ChickenEgg("Egg");
        System.out.println("Start the dispute: who appeared first?");
        // Start the threads
        chicken.start();
        egg.start();
        // While both threads is working
        while (chicken.isAlive() || chicken.isAlive()) {
            try {
                // Suspend judge thread
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        // Does Egg won?
        if (egg.isAlive()) {
            try {
                // Stop the egg
                egg.interrupt();
                // Waiting for silence
                egg.join();
            } catch (InterruptedException e) {
            }

            System.out.println("An egg appeared first!");
        } else {
            try {
                // Stop the chicken
                chicken.interrupt();
                // Waiting for silence
                chicken.join();
            } catch (InterruptedException e) {
            }
            System.out.println("A chicken appeared first!");
        }
        System.out.println("The dispute is over");
    }
}

class ChickenEgg extends Thread {

    public ChickenEgg(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                // Приостанавливаем поток
                sleep(getTimeSleep());
                System.out.println(getName());
            } catch (InterruptedException e) {
            }
        }
    }

    final Random random = new Random();

    int getTimeSleep() {
        return random.nextInt(300);
    }
}

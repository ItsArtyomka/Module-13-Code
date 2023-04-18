package Exercise13_4_4;

import java.text.SimpleDateFormat;
import java.util.Calendar;

// This class can basically be a timer.
@SuppressWarnings("BusyWait")
public class ConsoleClock extends Thread {
    @Override
    public void run() {
        long seconds = 1;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        while (!isInterrupted()) {
            try {
                System.out.println(dateFormat.format(calendar.getTime()));
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                System.out.println("The clock was stopped");
                break;
            }
        }
    }
}

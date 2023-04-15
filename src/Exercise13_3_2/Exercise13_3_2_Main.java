/* EXERCISE 13.3.2 TASK
* The author has developed an Advertisement class to monetize his application.
* Naturally, the advertisement has to be shown in a separate stream to allow the user to stop it.
* Run the static show() method of the Advertisement class in a new thread.
* */

package Exercise13_3_2;

public class Exercise13_3_2_Main {
    public static void main(String[] args) {
        ShowAds showAdverts = new ShowAds();
        showAdverts.start();
    }

}

class ShowAds extends Advertisement {
    Advertisement advertisements = new Advertisement();

    @Override
    public void run() {
        advertisements.show();
    }
}

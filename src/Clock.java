import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock extends Thread {
    public void run() {
        while (true) {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss"); //hai dong nay phai khai bao o trong nay
            Calendar calendar = Calendar.getInstance();               //ngoai la no k doi duoc gio
            String str;
            str = sdf.format(calendar.getTime());
            System.out.print(str);
            try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

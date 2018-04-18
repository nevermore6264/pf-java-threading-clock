import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class DemoClock extends JFrame {
    JFrame frame = new JFrame();
    static JLabel lb = new JLabel("", JLabel.CENTER);
    static JButton button = new JButton("Visible");

    DemoClock() {
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(lb);
        frame.add(button);
        frame.setSize(100, 100);
        frame.setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new DemoClock();
        Clock clock = new Clock();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.start();
                button.setVisible(false);
            }
        });
    }

    static class Clock extends Thread {
        public Clock() {
        }

        public void run() {
            while (true) {
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss"); //hai dong nay phai khai bao o trong nay
                Calendar calendar = Calendar.getInstance();               //ngoai la no k doi duoc gio
                String str;
                str = sdf.format(calendar.getTime());
                lb.setText(str);
                try {
                    sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
} 
package nine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GuiTest extends JFrame implements ActionListener{
    private JTextField text;
    private JButton start;
    private JButton stop;
    private Thread t;

    public GuiTest() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5)); // set frame layout,
        //5 pixel gaps between components

        text = new JTextField(10);
        text.setText("0");

        JPanel panel = new JPanel();
        start = new JButton("Start");
        stop = new JButton("Stop");
        stop.setEnabled(false);

        start.addActionListener(this);
        stop.addActionListener(this);
        panel.add(start);
        panel.add(stop);

        add(text, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        new GuiTest();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == start) {
            t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=Integer.valueOf(text.getText()); i<10; i++) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            return;
                        }
                        text.setText(Integer.toString(i+1));
                    }
                    text.setText("0");
                    stop.setEnabled(false);
                    start.setEnabled(true);
                }
            });
            stop.setEnabled(true);
            start.setEnabled(false);
            t.start();
        } else {
            t.interrupt();
            stop.setEnabled(false);
            start.setEnabled(true);
        }
    }
}

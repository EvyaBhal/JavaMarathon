package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    private JFrame jf;
    private JPanel jp;
    private JButton add;
    private JButton clear;
    private JButton exit;
    private JTextField first;
    private JTextField second;
    private JTextField result;

    public Calculator() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initWindow();
            }
        });
    }
    private void initWindow() {
        JPanel pb = new JPanel();
        pb.setLayout(new BoxLayout
                (pb, BoxLayout.X_AXIS));

        exit = new JButton("exit");
        exit.addActionListener(this);

        add = new JButton("Add");
        add.addActionListener(this);
        pb.add(add);
        clear = new JButton("Clear");
        clear.addActionListener (this);
        pb.add(clear);

        jp = new JPanel();
        jp.setBorder(BorderFactory.
                createLineBorder(Color.RED, 5));
        jp.setLayout(new GridLayout
                (0, 2, 10, 10));
        JLabel l1 = new JLabel("First Number");
        l1.setSize(50,10);
        jp.add(l1);
        first = new JTextField(20);
        jp.add(first);

        JLabel l2 = new JLabel("Second Number");
        l2.setSize(50,10);
        jp.add(l2);
        second = new JTextField(20);
        jp.add(second);

        JLabel lr = new JLabel("Result");
        lr.setSize(50,10);
        jp.add(lr);
        result = new JTextField(20);
        result.setEditable(false);
        jp.add(result);
        jp.add(pb);

        jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BoxLayout(
                jf.getContentPane(), BoxLayout.Y_AXIS));
        jf.setPreferredSize(new Dimension(400,200));
        jf.setTitle("Adder");
        jf.add(jp);
        jf.add(exit);
        jf.pack();
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == add){
            try {
                double d1 = Double.parseDouble(first.getText());
                double d2 = Double.parseDouble(second.getText());
                double r = d1 + d2;
                result.setText(Double.toString(r));
            } catch (Exception e) {
                result.setText("invalid values");
            }
        } else if (actionEvent.getSource() == exit){
            System.exit(1);
        } else {
            first.setText("");
            second.setText("");
            result.setText("");
        }
    }
}

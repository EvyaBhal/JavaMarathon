package eightteen;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ButtonFrameA extends JFrame implements ActionListener {

    private static final String BOLD = "bold";
    private static final String UNBOLD = "un-bold";
    private static final String ITALIC = "italic";
    private static final String NONITALIC = "non-italic";
    private static final String FONT_NAME = "Serif";
    private static final int FONT_SIZE = 18;

    private JTextField textField; // displays text in changing fonts
    private JButton boldButton; // to select/deselect bold
    private JButton italicButton; // to select/deselect italic

    private int boldVal; // controls bold font style
    private int italicVal; // controls italic font style

    public ButtonFrameA() {
        setTitle("JButton Test");
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(300, 100);

        boldVal = 0;
        italicVal = 0;
        textField = new JTextField("Write here your text");
        textField.setFont(new Font(FONT_NAME, boldVal + italicVal, FONT_SIZE));
        boldButton = new JButton(BOLD);
        boldButton.addActionListener(this);
        italicButton = new JButton(ITALIC);
        italicButton.addActionListener(this);

        add(textField);
        add(boldButton);
        add(italicButton);
        pack();

    } // end constructor


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == boldButton) {
            boldVal = Math.abs(1 - boldVal);
            boldButton.setText((boldVal == 0 ? BOLD : UNBOLD));
        } else if (ae.getSource() == italicButton) {
            italicVal = Math.abs(1 - italicVal);
            italicButton.setText((italicVal == 0 ? ITALIC : NONITALIC));
        }

        textField.setFont(new Font(FONT_NAME, boldVal * Font.BOLD + italicVal * Font.ITALIC, FONT_SIZE));

    } // end method actionPerformed

    public static void main(String[] args) {
        ButtonFrameA bf = new ButtonFrameA();
    }// end method main

}
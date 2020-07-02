package sixteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;

public class ColorGame implements MouseListener, ActionListener {

    private int numOfGoodShapes; // Number of good shapes
    private int numOfGoodShapesToDisplay; // Number of times good shapes are presented.
    private JButton startButton;

    public ColorGame(int numOfGoodShapes, int numOfGoodShapesToDisplay) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        startButton = new JButton("start");
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(startButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        Set<Shape> shapes = new HashSet<>();
        for (int i=0; i<numOfGoodShapes; i++) {
            shapes.add(new Shape(new Point(10, 20+60*i), new Dimension(50,50)));
        }
        frame.add(new GoodShapesPanel(shapes), BorderLayout.WEST);
        frame.add(new ShapesDisplayPanel(), BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setSize(new Dimension(400,400));
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        ColorGame cg = new ColorGame(2, 10 );

    }

}

/**Spring 2020
 * Java Marathon
 * Evyatar Bhalker
 */
package five;

import javax.swing.*;
import java.awt.*;

class MyPanel extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("rectangle");
        frame.setVisible(true);
        frame.setSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new MyPanel());
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int []x = { 0, getWidth()/2, getWidth(), getWidth()/2 };
        int []y = { getHeight()/2, 0, getHeight()/2, getHeight() };
        graphics.setColor(Color.RED);
        graphics.drawPolygon(x, y, 4);
    }
}

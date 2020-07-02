package sixteen;
import java.awt.Graphics;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author michalh
 *
 * Panel for presenting the good shapes.
 *
 */
public class GoodShapesPanel extends JPanel {

    private Set<Shape> goodShapes;

    public GoodShapesPanel(Set<Shape> goodShapes) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Good Components"));
        setBorder(BorderFactory.createEtchedBorder());
        this.goodShapes = goodShapes;
    }

    public void paintComponent(Graphics g) {
        for (Shape s : goodShapes) {
            s.draw(g);
        }
    }

}

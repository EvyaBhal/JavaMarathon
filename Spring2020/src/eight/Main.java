/**Spring 2020
 * Java Marathon
 * Evyatar Bhalker
 */
package eight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GraphicError extends JPanel implements ActionListener {
    enum WhatToPaint { CLEAR, CIRCLE, TRIANGLE, SQUARE }
    WhatToPaint whatToPaint = WhatToPaint.CLEAR;
    JFrame frame = new JFrame( "Graphic Shapes" );
    JButton circle = new JButton( "Circle" );
    JButton square = new JButton( "Square" );
    JButton triangle = new JButton( "Triangle" );
    JButton clear = new JButton( "Clear" );

    public GraphicError() {
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setPreferredSize( new Dimension( 500, 300 ) );
        frame.setLayout( new FlowLayout() );
        setPreferredSize( new Dimension( 500, 200 ) );
        frame.add(this);
        frame.add(circle);
        frame.add(square);
        frame.add(triangle);
        //frame.add(clear);
        frame.pack();

        /*circle.addActionListener(this);
        square.addActionListener(this);
        triangle.addActionListener(this);
        clear.addActionListener(this);*/
        frame.setVisible(true);
    }

    public void actionPerformed( ActionEvent ae ) {
        if( ae.getSource() == clear ) {
            whatToPaint = WhatToPaint.CLEAR;
        }
        else if( ae.getSource() == circle ) {
            whatToPaint = WhatToPaint.CIRCLE;
        }
        else if( ae.getSource() == square ) {
            whatToPaint = WhatToPaint.SQUARE;
        }
        else if( ae.getSource() == triangle ) {
            whatToPaint = WhatToPaint.TRIANGLE;
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        switch(whatToPaint) {
            case CLEAR:
                g.setColor( getBackground() );
                g.fillRect( 0, 0, getWidth(), getHeight() );
                break;

            case CIRCLE:
                g.setColor( Color.red );
                g.fillOval( 170, 20, 160, 160 );
                break;

            case SQUARE:
                g.setColor( Color.green );
                g.fillRect( 180, 20, 140, 140 );
                break;
            case TRIANGLE:
                g.setColor( Color.blue );
                int[] x = { 160, 250, 340 };
                int[] y = { 20, 176, 20 };
                g.fillPolygon( x, y, 3 );
                break;
            default:
                break;
        }
    }
    /**
     * main -
     *
     * @param args
     */
    public static void main( String[] args ) {
        GraphicError gc = new GraphicError();
    }
}
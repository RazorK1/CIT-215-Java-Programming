/// Kyle Harris
/// CIT-215/CIT-215L Java Programming DO1
/// Java Shapes Inheritance Hierarchy

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  /// Import MouseAdapter, MouseMotionAdapter, ActionListener, etc.

public class DrawingApp extends JFrame {
    private JTextField xField, yField, widthField, heightField;
    private JButton drawRectangleButton, drawSquareButton, clearButton;
    private JPanel drawingPanel;
    private int x, y, x2, y2;

    public DrawingApp() {
        setTitle("Shape Drawing App");
        setSize(650, 500); /// Set Size of GUI here
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); /// Puts GUI in the center of the default screen.

        //////////////////////////// Top panel with input fields
        JPanel controlPanel = new JPanel(new GridLayout(2, 4)); /// Sets Control panel in GUI

        controlPanel.add(new JLabel("X:"));
        xField = new JTextField("100", 5); /// Default position values
        controlPanel.add(xField);

        controlPanel.add(new JLabel("Y:"));
        yField = new JTextField("100", 5); /// Default position values
        controlPanel.add(yField);

        controlPanel.add(new JLabel("Width:"));
        widthField = new JTextField("50", 5); /// Default position values
        controlPanel.add(widthField);

        controlPanel.add(new JLabel("Height:"));
        heightField = new JTextField("50", 5); /// Default position values
        controlPanel.add(heightField);

        /// Buttons
        drawRectangleButton = new JButton("Draw Rectangle"); /// Draw Rectangle
        drawSquareButton = new JButton("Draw Square"); /// Draw Square Button
        clearButton = new JButton("Clear"); /// Clear button

        /////////////////////////////////////// JPanel button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(drawRectangleButton);
        buttonPanel.add(drawSquareButton);
        buttonPanel.add(clearButton);

        ////////////////////////////////////// Drawing Panel
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };
        drawingPanel.setBackground(Color.WHITE); /// Sets background colour to white

        /// Mouse Listener for Click & Drag
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { /// Press that mouse action listener
                x = e.getX();
                y = e.getY();
                xField.setText(String.valueOf(x));
                yField.setText(String.valueOf(y));
            }
        });

        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) { /// Follows position of your mouse
                x2 = e.getX();
                y2 = e.getY();

                Graphics g = drawingPanel.getGraphics();
                g.setColor(Color.BLACK); /// Set Colour here
                g.drawLine(x, y, x2, y2);

                x = x2;
                y = y2;
            }
        });

        //////////////////////////////////// Add ActionListeners
        drawRectangleButton.addActionListener(e -> drawRectangle());
        drawSquareButton.addActionListener(e -> drawSquare());
        clearButton.addActionListener(e -> drawingPanel.repaint());

        ////////////////////////////////////////// Panel Layout Positions
        add(controlPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(drawingPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void drawRectangle() { /// Draws Rectangle
        int x = Integer.parseInt(xField.getText());
        int y = Integer.parseInt(yField.getText());
        int width = Integer.parseInt(widthField.getText());
        int height = Integer.parseInt(heightField.getText());
        width = width * 2; /// Actually forms a Rectangle --- Set size of rectangle here
        /// height = height * 2; /// Set size of rectangle here

        Rectangle rect = new Rectangle(x, y, width, height);
        Graphics g = drawingPanel.getGraphics();
        rect.draw(g, Color.BLUE); /// Blue Rectangle
    }

    private void drawSquare() { /// Draws Square
        int x = Integer.parseInt(xField.getText());
        int y = Integer.parseInt(yField.getText());
        int size = Integer.parseInt(widthField.getText());

        Square square = new Square(x, y, size);
        Graphics g = drawingPanel.getGraphics();
        square.draw(g, Color.RED); /// Red Square
    }

    public static void main(String[] args) { /// Main function
        new DrawingApp();
    }
}

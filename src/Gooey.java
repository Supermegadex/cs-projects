import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gooey extends JPanel {
  public void paintComponent(Graphics g) {
    g.setColor(Color.black);
    g.fillOval(0, 0, 800, 800);
    g.setColor(Color.pink);
    g.drawString("No.", 300, 300);
  }
  public static void main(String args[]) {
    JFrame frame = new JFrame("Hello");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new Gooey());
    frame.setSize(800, 800);
    frame.setVisible(true);
  }
}

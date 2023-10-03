package house.williams;

import javax.swing.*;
import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainFrame extends JFrame {
    public MainFrame() {
        super("Java Game");

        JLabel label = new JLabel("Hello world");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new DisplayArea());

        Dimension minSize = new Dimension();
        minSize.setSize(400, 350);
        setMinimumSize(minSize);

        setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        MainFrame game = new MainFrame();

        while (game.isDisplayable()) {
            Thread.sleep(20);
            game.repaint();
        }
    }
}
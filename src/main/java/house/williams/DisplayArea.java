package house.williams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class DisplayArea extends JRootPane implements MouseListener, KeyListener {

    public DisplayArea() {
        addMouseListener(this);
        addKeyListener(this);
    }

    private int clickX = 50;
    private int clickY = 50;
    private int clicking = 0;

    @Override
    public void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        byte[][][] screen = new byte[height][width][3];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                screen[y][x][0] = (byte)0xff;
                screen[y][x][1] = (byte)0xff;
                screen[y][x][2] = (byte)0xff;
            }
        }

        if (clicking > 0) {
            System.out.println("DRAW");
            for (int y = Math.max(0, clickY - clicking); y < Math.min(height, clickY + clicking); y++) {
                for (int x = Math.max(0, clickX - clicking); x < Math.min(width, clickX + clicking); x++) {
                    screen[y][x][0] = (byte) 0x00;
                    screen[y][x][1] = (byte) 0xff;
                    screen[y][x][2] = (byte) 0xff;
                }
            }
            clicking--;
        }

        BufferedImage screenImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        int[] arr = new int[width * height * 3];
        int index = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                arr[index++] = (((int)screen[y][x][2] & 0xff) | ((int)screen[y][x][1] << 8 & 0xff00) | ((int)screen[y][x][0] << 16 & 0xff0000));
            }
        }
        screenImage.setRGB(0, 0, width, height, arr, 0, width);

        g.drawImage(screenImage, 0, 0, width, height, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("CLICK");
        clickX = e.getX();
        clickY = e.getY();
        clicking = 20;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

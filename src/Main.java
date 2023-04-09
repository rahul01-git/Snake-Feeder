import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Feeder");
        GamePlay gamePlay = new GamePlay();

        frame.setBounds(10,10,905,700);
        frame.setResizable(false);
        frame.setBackground(Color.DARK_GRAY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePlay);
    }
}
import javax.swing.*;
import java.awt.*;

public class GamePlay extends JPanel {
    private ImageIcon titleImage;

    public GamePlay(){

    }

    public void paint(Graphics g){
        //display title image
        titleImage = new ImageIcon("title.png");
        titleImage.paintIcon(this,g,25,5);

        //display gameplay borders
        g.setColor(Color.DARK_GRAY);
        g.drawRect(24,74,851,577);

        //display gameplay background
        g.setColor(Color.black);
        g.fillRect(25,75,851,577);

        g.dispose();
    }


}

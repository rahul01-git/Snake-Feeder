import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {
    private int[] snakeXlength = new int[750];
    private int[] snakeYlength = new int[750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon headLeft;
    private ImageIcon headRight;
    private ImageIcon headUp;
    private ImageIcon headDown;
    private ImageIcon titleImage;
    private ImageIcon tail;

    private int snakeLength = 3;
    private Timer timer;
    private int delay = 100;
    private int moves = 0;
    private int score = 0;

    public GamePlay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(delay,this);
        timer.start();
    }

    public void paint(Graphics g){

        //initially
        if(moves == 0){
            snakeXlength[0] = 100;
            snakeXlength[1] = 75;
            snakeXlength[2] = 50;

            snakeYlength[0] = 100;
            snakeYlength[1] = 100;
            snakeYlength[2] = 100;
        }

        //display title image
        titleImage = new ImageIcon("title.png");
        titleImage.paintIcon(this,g,25,5);

        //display gameplay borders
        g.setColor(Color.DARK_GRAY);
        g.drawRect(24,74,851,577);

        //display gameplay background
        g.setColor(Color.black);
        g.fillRect(25,75,851,577);

        //initial position of image
        headRight = new ImageIcon("headRight.png");
        headRight.paintIcon(this,g,snakeXlength[0],snakeYlength[0]);

        for (int i = 0; i< snakeLength;i++){
            if(i == 0 && right){
                headRight = new ImageIcon("headRight.png");
                headRight.paintIcon(this,g,snakeXlength[i],snakeYlength[i]);
            }
            if(i == 0 && left){
                headLeft = new ImageIcon("headLeft.png");
                headLeft.paintIcon(this,g,snakeXlength[i],snakeYlength[i]);
            }
            if(i == 0 && up){
                headUp = new ImageIcon("headUp.png");
                headUp.paintIcon(this,g,snakeXlength[i],snakeYlength[i]);
            }
            if(i == 0 && down){
                headDown = new ImageIcon("headDown.png");
                headDown.paintIcon(this,g,snakeXlength[i],snakeYlength[i]);
            }
            if(i != 0 ){
                tail = new ImageIcon("tail.png");
                tail.paintIcon(this,g,snakeXlength[i],snakeYlength[i]);
            }
        }

        g.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

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

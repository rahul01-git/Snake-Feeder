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
        timer.restart();
        if(right){
            for (int n = snakeLength-1; n>=0;n--){
                snakeYlength[n+1] = snakeYlength[n];
            }
            for(int n = snakeLength; n>=0; n--){
                if(n==0) snakeXlength[n] = snakeXlength[n] + 25;
                else snakeXlength[n] = snakeXlength[n-1];
                if(snakeXlength[n] > 850) snakeXlength[n] = 25;
            }
            repaint();
        }
        if(left){
            for (int n = snakeLength-1; n>=0;n--){
                snakeYlength[n+1] = snakeYlength[n];
            }
            for(int n = snakeLength; n>=0; n--){
                if(n==0) snakeXlength[n] = snakeXlength[n] - 25;
                else snakeXlength[n] = snakeXlength[n-1];
                if(snakeXlength[n] < 25) snakeXlength[n] = 850;
            }
            repaint();
        }
        if(up){
            for (int n = snakeLength-1; n>=0;n--){
                snakeXlength[n+1] = snakeXlength[n];
            }
            for(int n = snakeLength; n>=0; n--){
                if(n==0) snakeYlength[n] = snakeYlength[n] - 25;
                else snakeYlength[n] = snakeYlength[n-1];
                if(snakeYlength[n] < 75) snakeYlength[n] = 625;
            }
            repaint();
        }
        if(down){
            for (int n = snakeLength-1; n>=0;n--){
                snakeXlength[n+1] = snakeXlength[n];
            }
            for(int n = snakeLength; n>=0; n--){
                if(n==0) snakeYlength[n] = snakeYlength[n] + 25;
                else snakeYlength[n] = snakeYlength[n-1];
                if(snakeYlength[n] > 625) snakeYlength[n] = 75;
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            moves++;
            right = true;
            if(left){
                right = false;
                left = true;
            }else right = true;

            up = false;
            down = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            moves++;
            left = true;
            if(right){
                left = false;
                right = true;
            }else left = true;

            up = false;
            down = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            moves++;
            up = true;
            if(down){
                up = false;
                down = true;
            }else up = true;

            left = false;
            right = false;
        } if(e.getKeyCode() == KeyEvent.VK_DOWN){
            moves++;
            down = true;
            if(up){
                down = false;
                up = true;
            }else down = true;

            left = false;
            right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

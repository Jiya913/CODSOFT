import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 700;
    final int PANEL_HEIGHT = 600;
    Image one,two,three,four,five,six,seven,eight,nine,zero;
    Image one1,two1,three1,four1,five1,six1,seven1,eight1,nine1,zero1;
    Image bg; 
    Timer timer;
    int x = 0, y = 0;           
    int a = 100, b = 100;       
    int p = 500, q = 500;      
    int xVelocity = 8, yVelocity = 4;   
    int aVelocity = 9, bVelocity = 5;   
    int pVelocity = 10, qVelocity = 6;   


    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        bg = new ImageIcon("src/bg_main.png").getImage();


        one = new ImageIcon("src/one.png").getImage();
        two = new ImageIcon("src/two.png").getImage();
        three = new ImageIcon("src/three.png").getImage();
        four = new ImageIcon("src/four.png").getImage();
        five = new ImageIcon("src/five.png").getImage();
        six = new ImageIcon("src/six.png").getImage();
        seven = new ImageIcon("src/seven.png").getImage();
        eight = new ImageIcon("src/eight.png").getImage();
        nine = new ImageIcon("src/nine.png").getImage();
        zero = new ImageIcon("src/zero.png").getImage();

        one1 = new ImageIcon("src/one.png").getImage();
        two1 = new ImageIcon("src/two.png").getImage();
        three1 = new ImageIcon("src/three.png").getImage();
        four1 = new ImageIcon("src/four.png").getImage();
        five1 = new ImageIcon("src/five.png").getImage();
        six1 = new ImageIcon("src/six.png").getImage();
        seven1 = new ImageIcon("src/seven.png").getImage();
        eight1 = new ImageIcon("src/eight.png").getImage();
        nine1 = new ImageIcon("src/nine.png").getImage();
        zero1 = new ImageIcon("src/zero.png").getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        g.setFont(new Font("MV Boli", Font.BOLD, 50));
        g.setColor(Color.WHITE);

        g.drawImage(bg, 0, 0, null); 
        g.drawString("Guess the Number Game!", 30, 150);

        g.drawImage(one, x, y, null); 
        g.drawImage(two, a, b,null);
        g.drawImage(three, a, y,null);
        g.drawImage(four, x, b,null);
        g.drawImage(five, p, q,null);
        g.drawImage(six, x, q,null);
        g.drawImage(seven, p, y,null);
        g.drawImage(eight, a, q,null);
        g.drawImage(nine, p, b,null);
        g.drawImage(zero, b, p,null);

        g.drawImage(one1, x, x, null);  
        g.drawImage(two1, a, a,null);
        g.drawImage(three1, y, y,null);
        g.drawImage(four1, b, b,null);
        g.drawImage(five1, p, p,null);
        g.drawImage(six1, q, q,null);
        g.drawImage(seven1, y, x,null);
        g.drawImage(eight1, b, a,null);
        g.drawImage(nine1, q, p,null);
        g.drawImage(zero1, y, a,null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += xVelocity;
        y += yVelocity;
        a += aVelocity;
        b += bVelocity;
        p += pVelocity;
        q += qVelocity;
        
        if (x >= PANEL_WIDTH - one.getWidth(null) || x <= 0) {
            xVelocity = -xVelocity;
        }
        if (y >= PANEL_HEIGHT - one.getHeight(null) || y <= 0) {
            yVelocity = -yVelocity;
        }
        
        if (a >= PANEL_WIDTH - two.getWidth(null) || a <= 0) {
            aVelocity = -aVelocity;
        }
        if (b >= PANEL_HEIGHT - two.getHeight(null) || b <= 0) {
            bVelocity = -bVelocity;
        }

        if (p >= PANEL_WIDTH - three.getWidth(null) || p <= 0) {
            pVelocity = -pVelocity;
        }
        if (q >= PANEL_HEIGHT - three.getHeight(null) || q <= 0) {
            qVelocity = -qVelocity;
        }
        
        repaint();  
        
    }
}

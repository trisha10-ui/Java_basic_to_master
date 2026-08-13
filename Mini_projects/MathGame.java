import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MathGame extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1;
    JButton b1;
    int n1, n2, s = 0, w = 0;

    public MathGame() {
        setLayout(new FlowLayout());
        l1 = new JLabel();
        l2 = new JLabel("Score : 0");
        t1 = new JTextField(10);
        b1 = new JButton("NEXT");

        add(l1);
        add(l2);
        add(t1);
        add(b1);

        b1.addActionListener(this);
        go();
        setSize(500, 500);
        setVisible(true);
    }

    void go() {
        Random r = new Random();
        n1 = r.nextInt(10);
        n2 = r.nextInt(10);
        l1.setText(n1 + "+" + n2 + " = ");
        t1.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        int ans = Integer.parseInt(t1.getText());
        if (ans == (n1 + n2)) {
            s += 10;
        } else {
            w++;
        }
        l2.setText("Score: " + s);
        if (w >= 2) {
            System.out.println("Game Over");
            System.exit(0);
        }
        go();
    }

    public static void main(String[] args) {
        new MathGame();
    }

}

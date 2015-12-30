
//package time_logger;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import java.io.PrintWriter;

public class tym_logger extends JFrame implements ActionListener, MouseListener {

    public static JPanel p;
    JLabel lbl, dt;
    public static JTextField tx;
    public static String s1, s2, s3;
    public static boolean bl;
    JButton btn;

    public tym_logger() throws Exception {

        p = new JPanel();
        lbl = new JLabel("what are you doing now");
        dt = new JLabel("new date?");

        tx = new JTextField(20);
        btn = new JButton("submit");

        btn.addActionListener(this);
        dt.addMouseListener(this);
        setBounds(100, 100, 300, 200);
        setVisible(true);
        p.add(lbl);
        p.add(tx);
        p.add(btn);
        p.add(dt);
        add(p);




    }

    public static void main(String[] args) throws Exception {
        new tym_logger();
    }

    public static void goer() throws Exception {
        File f = new File("C:\\Users\\appy\\Desktop\\most imp work.txt");
        if (!f.exists()) {
            f.createNewFile();

        }

        FileWriter f1 = new FileWriter(f.getAbsolutePath(), true);
        BufferedWriter b = new BufferedWriter(f1);

        String dater;
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm a");
        if (tym_logger.bl) {

            Date dNow1 = new Date();
            SimpleDateFormat ftr = new SimpleDateFormat("dd/MM/yyyy E");
            dater = ("Date " + ftr.format(dNow1) + "\t");
            b.newLine();
            b.newLine();
            b.write(dater);
            b.newLine();
            b.newLine();

        }
        tym_logger.bl = false;
        String content = ft.format(dNow) + "";
        String content1 = "\t\t" + tym_logger.s1;



        b.write(content);
        b.newLine();
        b.write(content1);


        b.newLine();

        tym_logger.s1 = " ";

        b.close();


    }

    public void actionPerformed(ActionEvent e) {
        tym_logger.s1 = tx.getText();
        tx.setText("");
        try {
            goer();
        } catch (Exception e1) {
        }
        repaint();
    }

    public void mouseClicked(MouseEvent e) {
        tym_logger.bl = true;
        try {
            goer();
        } catch (Exception e1) {
        }
        repaint();

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}

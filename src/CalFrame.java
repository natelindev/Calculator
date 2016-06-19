/**
 * Created by LLL on 16/5/15.
 */
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;

public class CalFrame extends JFrame {

    public CalFrame() {
        super("计算器");
        setSize(240,320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        CalPane cp = new CalPane();
        add(cp);
        setVisible(true);
    }

    private void setLookAndFeel() {
        try{
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        }catch (Exception e) {
            System.err.println("Couldn't use the system" +
                    " look and feel! "+ e);
        }

    }

    public static void main(String[] args) {
        CalFrame calculator = new CalFrame();
    }
}
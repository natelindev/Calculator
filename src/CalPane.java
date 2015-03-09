/**
 * Created by Administrator on 2015/3/8.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalPane extends JPanel {
    GridBagLayout gb = new GridBagLayout();
    int lastNumber = 0;
    char lastSign = '=';

    public CalPane() {
        super();
        GridBagConstraints constraints;
        setLayout(gb);
        final JTextArea display = new JTextArea();
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setEditable(false);
        JButton[] numbers = new JButton[10];
        for (int i = 0;i <10;i++){
            numbers[i] = new JButton(Integer.toString(i));
        }
        for (int i =0;i<10;i++){
            final String currentNumber = Integer.toString(i);
            numbers[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText()+currentNumber
                    );
                }
            });
        }
        JButton plus = new JButton("+");
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate(lastSign,display);
                lastSign = '+';
                display.setText("");
            }
        });
        JButton minus = new JButton("-");
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate(lastSign,display);
                lastSign = '-';
                display.setText("");
            }
        });
        JButton multiply = new JButton("*");
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate(lastSign,display);
                lastSign = '*';
                display.setText("");
            }
        });
        JButton division = new JButton("/");
        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate(lastSign,display);
                lastSign = '/';
                display.setText("");
            }
        });
        JButton equals = new JButton("=");
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate(lastSign,display);
                lastSign = '=';
                display.setText(Integer.toString(lastNumber));
                lastNumber = 0;
            }
        });

        JButton clear = new JButton("AC");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                lastNumber = 0;
                lastSign = '=';
            }
        });
        addComponent(display, 0, 0, 4, 1, 100, 100,
                GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);
        addComponent(clear,0,1,1,1,25,100,
            GridBagConstraints.NONE,GridBagConstraints.CENTER);
        addComponent(numbers[0],1,1,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);
        addComponent(division,2,1,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);
        addComponent(multiply,3,1,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);

        addComponent(numbers[7],0,2,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);
        addComponent(numbers[8],1,2,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);
        addComponent(numbers[9],2,2,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);
        addComponent(minus,3,2,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);

        addComponent(numbers[4],0,3,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);
        addComponent(numbers[5],1,3,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);
        addComponent(numbers[6],2,3,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);
        addComponent(plus,3,3,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);

        addComponent(numbers[1],0,4,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);
        addComponent(numbers[2],1,4,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);
        addComponent(numbers[3],2,4,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);
        addComponent(equals,3,4,1,1,25,100,
                GridBagConstraints.NONE,GridBagConstraints.CENTER);
    }

    private void calculate(char lastSign, JTextArea display) {
        try{
            switch (lastSign) {
                case '+':
                    lastNumber += Integer.valueOf(display.getText());
                    break;
                case '-':
                    lastNumber -= Integer.valueOf(display.getText());
                    break;
                case '*':
                    lastNumber *= Integer.valueOf(display.getText());
                    break;
                case '/':
                    if (Integer.valueOf(display.getText()) != 0)
                        lastNumber /= Integer.valueOf(display.getText());
                    else
                        display.setText("出错");
                    break;
                default:
                    lastNumber = Integer.valueOf(display.getText());
            }
        }catch (NumberFormatException nfe){
            System.err.println(nfe);
            System.exit(1);
        }
    }

    private void addComponent(Component component, int gridx, int gridy,
        int gridwidth, int gridheight, int weightx,int weighty,
        int fill, int anchor) {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.fill = fill;
        constraints.anchor = anchor;
        gb.setConstraints(component,constraints);
        add(component);
    }

}

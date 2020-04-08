package ru.geekbrains.convert;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Window extends JFrame {

    public Window() throws HeadlessException {
        Convert convert = new Convert();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(500, 400);
        setSize(300, 300);
        setResizable(false);
        setVisible(true);
        JPanel panel = new JPanel(new GridLayout(4, 3));
        JTextArea txt = new JTextArea(" ",1,1);
        JButton btn = new JButton("BTC - RUB");
        JButton btn1 = new JButton("BTC - USD");
        JLabel lbl = new JLabel();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }
        });
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                Pattern p = Pattern.compile("\\d{1,5}\\W*+\\d*+");
                Matcher m = p.matcher(txt.getText());
                if(!m.matches()) {
                   txt.setText("");
                }

            }
        });
        txt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {


            }
        });
        btn.addActionListener(action -> {
            double cena = convert.strokavalue("btc-rub");
            double resault = Double.parseDouble(txt.getText()) * cena;
            lbl.setText(String.valueOf(resault));




        });
        btn1.addActionListener(action ->{
            double cena = convert.strokavalue("btc-usd");
            double resault = Double.parseDouble(txt.getText()) * cena;
            lbl.setText(String.valueOf(resault));


        });




        panel.add(txt);panel.add(btn);panel.add(btn1);panel.add(lbl);

        add(panel);
        setVisible(true);
    }
}

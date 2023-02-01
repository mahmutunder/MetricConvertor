import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.UIManager.put;


public class MetricConvertor extends JFrame {
    JRadioButton miles;
    JRadioButton inches;
    JRadioButton feet;
    double kilo;
    JTextField kilometer;

    public MetricConvertor() {



        setTitle("Metric Convertor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);

        JPanel panel = new JPanel();
        JLabel info = new JLabel("Enter a distance in kilometers");
        kilometer = new JTextField(10);

        feet = new JRadioButton("Convert to feet");
        feet.addActionListener(new Calc());
        inches = new JRadioButton("Convert to inches");
        inches.addActionListener(new Calc());
        miles = new JRadioButton("Convert to miles");
        miles.addActionListener(new Calc());
        ButtonGroup group = new ButtonGroup();
        group.add(miles);
        group.add(feet);
        group.add(inches);


        panel.add(info);
        panel.add(kilometer);
        panel.add(miles);
        panel.add(feet);
        panel.add(inches);

        add(panel);

        setVisible(true);

    }

    public static void main(String[] args) {
        new MetricConvertor();
    }

    private class Calc implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String string = kilometer.getText();
            kilo = Double.parseDouble(string);

            if (e.getSource() == miles) {
                miles();
            } else if (e.getSource() == feet) {
                feet();
            } else if (e.getSource() == inches) {
                inches();
            }
        }

        private void inches() {
            JOptionPane.showMessageDialog(null,kilo + " kilometer is " + (kilo * 39370.0) + " inches");
            System.out.println(kilo + " kilometer is " + (kilo * 39370.0) + " inches");
        }

        private void feet() {
            JOptionPane.showMessageDialog(null, kilo + " kilometer is " + (kilo * 3281.0) + " feet");
            System.out.println(kilo + " kilometer is " + (kilo * 3281.0) + " feet");
        }

        private void miles() { JOptionPane.showMessageDialog(null,kilo + " kilometer is " + (kilo * 0.6214) + " miles" );
            System.out.println(kilo + " kilometer is " + (kilo * 0.6214) + " miles");
        }
    }
}

package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SearchPage implements ActionListener {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Search Wiki: ");
    JTextField textField = new JTextField();
    JButton submitBtn = new JButton("Find");

    SearchPage() {

        textField.setPreferredSize(new Dimension(250, 20));

        submitBtn.addActionListener(this);

        frame.add(label);
        frame.add(textField);
        frame.add(submitBtn);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Search");
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            // Buat ngambil teks di Textfield
            System.out.println(textField.getText());
        }
    }
}

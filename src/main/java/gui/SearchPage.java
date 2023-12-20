package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SearchPage implements ActionListener {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Search Wiki: ");
    JTextField textField = new JTextField();
    JButton submitBtn = new JButton("Find");
    JRadioButton r1, r2;

    SearchPage() {

        textField.setPreferredSize(new Dimension(250, 20));

        submitBtn.addActionListener(this);

        frame.add(label);
        frame.add(textField);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        r1 = new JRadioButton("Mata Kuliah");
        r2 = new JRadioButton("Materi");
        r1.setBounds(75, 50, 100, 30);
        r2.setBounds(75, 100, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        panel.add(r1);
        panel.add(r2);
        frame.add(panel);

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
            if (r1.isSelected() || r2.isSelected()) {
                // Buat ngambil teks di Textfield
                System.out.println(textField.getText());
            } else {
                System.out.println("Pilih Opsi Di Kiri!");
            }

        }
    }
}

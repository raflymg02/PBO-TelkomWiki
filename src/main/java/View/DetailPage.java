package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DetailPage extends JFrame {

    DetailPage(String Judul, String Matkul, String Deskripsi, String tag) {
        setTitle(Judul + " - " + Matkul);
        setSize(800, 800);
        add(thisPanel(Judul, Matkul, Deskripsi, tag));
        setVisible(true);
    }

    JPanel thisPanel(String Judul, String Matkul, String Deskripsi, String tag) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel topicTitle = new JLabel();
        JLabel tagTitle = new JLabel();
        JLabel matkulTitle = new JLabel();
        JTextArea deskripsi = new JTextArea();

        topicTitle.setText(Judul);
        topicTitle.setFont(new Font("Calibri", Font.BOLD, 30));
        topicTitle.setSize(500, 30);
        topicTitle.setLocation(20, 30);

        matkulTitle.setText("Mata Kuliah: " + Matkul);
        matkulTitle.setSize(300, 20);
        matkulTitle.setLocation(20, 60);

        tagTitle.setText("Tag: " + tag);
        tagTitle.setSize(300, 20);
        tagTitle.setLocation(20, 80);


        deskripsi.setText(Deskripsi);
        deskripsi.setLineWrap(true);
        deskripsi.setOpaque(false);
        deskripsi.setEditable(false);
        deskripsi.setFocusable(false);
        deskripsi.setSize(750, 600);
        deskripsi.setLocation(20, 120);

        panel.add(topicTitle);
        panel.add(matkulTitle);
        panel.add(tagTitle);
        panel.add(deskripsi);

        return panel;
    }

}

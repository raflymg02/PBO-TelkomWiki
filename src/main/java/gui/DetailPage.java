package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DetailPage extends JFrame {

    DetailPage(String Judul, String Matkul) {
        setTitle(Judul + " - " + Matkul);
        setSize(800, 600);
        add(thisPanel(Judul, Matkul));
        setVisible(true);
    }

    JPanel thisPanel(String Judul, String Matkul) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel topicTitle = new JLabel();
        JLabel matkulTitle = new JLabel();
        JTextArea deskripsi = new JTextArea();

        topicTitle.setText(Judul);
        topicTitle.setFont(new Font("Calibri", Font.BOLD, 30));
        topicTitle.setSize(300, 30);
        topicTitle.setLocation(20, 30);

        matkulTitle.setText("Mata Kuliah: " + Matkul);
        matkulTitle.setSize(300, 30);
        matkulTitle.setLocation(20, 60);

        deskripsi.setText(
                "Ini adalah text yang panjang, sangking panjangnya aku mager ngisi. Dah lah ya ini mah harusnya tuh Lorem Ipsum blabla gitu. Tapi karena ga hafal aku ubah aja jadi gini. Dah ya, disini baris kodenya panjang.");
        deskripsi.setLineWrap(true);
        deskripsi.setOpaque(false);
        deskripsi.setEditable(false);
        deskripsi.setFocusable(false);
        deskripsi.setSize(700, 600);
        deskripsi.setLocation(20, 100);

        panel.add(topicTitle);
        panel.add(matkulTitle);
        panel.add(deskripsi);

        return panel;
    }

}

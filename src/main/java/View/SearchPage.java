package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.WikiPageController;
import Model.WikiPage;

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
            String searchText = textField.getText();
            System.out.println(searchText);


            WikiPageController controller = new WikiPageController();
            
            WikiPage wikiPage = controller.searchWikiPageByTitle(searchText);

            // Example Implementation
            // if (wikiPage != null) {
            //     JOptionPane.showMessageDialog(frame,
            //             "Title: " + wikiPage.getTitle() + "\n" +
            //             "Content: " + wikiPage.getContent() + "\n" +
            //             "Created At: " + wikiPage.getCreatedAt() + "\n" +
            //             "Updated At: " + wikiPage.getUpdatedAt(),
            //             "Wiki Page Details",
            //             JOptionPane.INFORMATION_MESSAGE);
            // } else {
            //     JOptionPane.showMessageDialog(frame,
            //             "No data found for the title: " + searchText,
            //             "Error",
            //             JOptionPane.ERROR_MESSAGE);
            // }
        }
    }
}

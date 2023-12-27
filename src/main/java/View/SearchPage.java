package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.WikiPageController;
import Model.WikiPage;

public class SearchPage implements ActionListener {

    private final JFrame frame = new JFrame();
    private final JLabel label = new JLabel("Search Wiki: ");
    private final JTextField textField = new JTextField();
    private final JButton submitBtn = new JButton("Find");

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
            String searchText = textField.getText();

            WikiPageController controller = new WikiPageController();

            WikiPage wikiPage = controller.searchWikiPageByTitle(searchText);

            if (wikiPage != null) {
                // Display retrieved WikiPage details
                displayWikiPageDetails(wikiPage);
            } else {
                JOptionPane.showMessageDialog(frame,
                        "No data found for the title: " + searchText,
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to display WikiPage details in a JOptionPane
    private void displayWikiPageDetails(WikiPage wikiPage) {
        String message = "Title: " + wikiPage.getTitle() + "\n" +
                "Content: " + wikiPage.getContent() + "\n" +
                "Created At: " + wikiPage.getCreatedAt() + "\n" +
                "Updated At: " + wikiPage.getUpdatedAt();

        JOptionPane.showMessageDialog(frame,
                message,
                "Wiki Page Details",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controller.TagController;
import Controller.WikiPageController;
import Model.WikiPage;

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
        r1 = new JRadioButton("Tag");
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

                String searchText = textField.getText();
                System.out.println(searchText);

                WikiPageController wikiPageController = new WikiPageController();
                TagController tagController = new TagController();
                
                // SEARCH FOR MATERI
                WikiPage wikiPage = wikiPageController.searchWikiPageByTitle(searchText);

                // SEARCH FOR TAG
                List<WikiPage> wikiPages = tagController.fetchWikiPageByTag(searchText);

                for (WikiPage Page : wikiPages) {
                    System.out.println(Page.getTitle());
                }
                

                // TEST CODE - Check if Search is Working (Works when Materi == Mata Kuliah)
                
                if (wikiPage != null && r2.isSelected()) { // DISPLAY IF MATERI FOUND (To Check = Linked List)
                    displayWikiPageDetails(wikiPage);
                } else if (wikiPages != null  && r1.isSelected()) { // DISPLAY IF TAG FOUND (To Check = #Difficulty/Beginner)
                    displayWikiPageLiist(wikiPages);
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "No data found for the title: " + searchText,
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            } else {
                System.out.println("Pilih Opsi Di Kiri!");
            }
            // Example Implementation
            // if (wikiPage != null) {
            // JOptionPane.showMessageDialog(frame,
            // "Title: " + wikiPage.getTitle() + "\n" +
            // "Content: " + wikiPage.getContent() + "\n" +
            // "Created At: " + wikiPage.getCreatedAt() + "\n" +
            // "Updated At: " + wikiPage.getUpdatedAt(),
            // "Wiki Page Details",
            // JOptionPane.INFORMATION_MESSAGE);
            // } else {
            // JOptionPane.showMessageDialog(frame,
            // "No data found for the title: " + searchText,
            // "Error",
            // JOptionPane.ERROR_MESSAGE);
            // }
        }
    }



    // TEST CODE - Check if Search  is working
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

    private void displayWikiPageLiist(List<WikiPage> wikiPages) {
        StringBuilder message = new StringBuilder();
        for (WikiPage wikiPage : wikiPages) {
            message.append("Title: ").append(wikiPage.getTitle()).append("\n");
        }
    
        JOptionPane.showMessageDialog(frame,
                message.toString(),
                "Wiki Page Details",
                JOptionPane.INFORMATION_MESSAGE);
    }
    

    
    
}
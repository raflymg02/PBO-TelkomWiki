package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainPage implements ActionListener {
    JFrame frame = new JFrame();
    // JButton myButton = new JButton("New Window");
    JMenuBar menuBar = new JMenuBar();
    JMenuItem exitItem;
    JMenuItem searchItem;

    MainPage() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Telkom Wiki");
        frame.setSize(800, 600);
        // frame.setLayout(new FlowLayout());
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel();
        title.setText("Judul Wiki");
        title.setHorizontalAlignment(JLabel.LEFT);
        title.setVerticalAlignment(JLabel.TOP);
        // frame.add(title);

        JLabel desc = new JLabel();
        desc.setText("Deskripsi Wiki");
        desc.setHorizontalAlignment(JLabel.LEFT);
        desc.setVerticalAlignment(JLabel.TOP);
        // frame.add(desc);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.BLACK);
        leftPanel.setPreferredSize(new Dimension(300, 100));
        frame.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        // rightPanel.setBackground(Color.YELLOW);
        // rightPanel.setPreferredSize(new Dimension(300, 100));
        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(title, BorderLayout.NORTH);
        rightPanel.add(desc, BorderLayout.SOUTH);
        frame.add(rightPanel, BorderLayout.EAST);

        // myButton.setBounds(100, 160, 200, 40);
        // myButton.setFocusable(false);
        // myButton.addActionListener(this);

        // frame.add(myButton);

        frame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        JMenu searchMenu = new JMenu("Search");
        // JMenu aboutMenu = new JMenu("About");

        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        fileMenu.add(exitItem);

        searchItem = new JMenuItem("Search Wiki");
        searchItem.addActionListener(this);
        searchMenu.add(searchItem);

        menuBar.add(fileMenu);
        menuBar.add(searchMenu);
        // menuBar.add(aboutMenu);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println("Hit");
        // if (e.getSource() == myButton) {
        // new SearchPage();
        // } else
        if (e.getSource() == exitItem) {
            System.out.println("Exit");
        } else if (e.getSource() == searchItem) {
            new SearchPage();
        }
    }
}

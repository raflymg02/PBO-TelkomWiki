package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MainPage extends JFrame implements ActionListener {
    // JFrame frame = new JFrame();
    JMenuBar menuBar = new JMenuBar();
    JMenuItem exitItem;
    JMenuItem searchItem;
    JPanel container = new JPanel();
    JList<String> countryList;
    JLabel title = new JLabel();
    JLabel desc = new JLabel();
    JButton goBtn = new JButton("Go");

    MainPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Telkom Wiki");
        setSize(800, 600);
        menuBar();
        getContentPane().add(container);
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        leftPanel();
        rightPanel();

        setVisible(true);

    }

    public void rightPanel() {
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.WHITE);
        // rightPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
        // "Login Panel"));

        title.setText(countryList.getSelectedValue());
        title.setFont(new Font("Calibri", Font.BOLD, 30));
        title.setSize(300, 50);
        title.setLocation(10, 0);

        desc.setText("Deskripsi Wiki untuk " + countryList.getSelectedValue());
        desc.setSize(200, 30);
        desc.setLocation(10, 50);

        rightPanel.add(title);
        rightPanel.add(desc);

        container.add(rightPanel);
    }

    public void menuBar() {
        setJMenuBar(menuBar);
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
    }

    public void leftPanel() {
        JPanel leftPanel = new JPanel();
        // leftPanel.setLayout(null);
        leftPanel.setPreferredSize(new Dimension(200, 800));
        leftPanel.setMaximumSize(leftPanel.getPreferredSize());
        leftPanel.setMinimumSize(leftPanel.getPreferredSize());
        leftPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Category"));

        // create the model and add elements
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Category A");
        listModel.addElement("Category B");
        listModel.addElement("Category C");
        listModel.addElement("Category D");
        listModel.addElement("Category E");
        listModel.addElement("Category F");
        listModel.addElement("Category G");
        listModel.addElement("Category H");

        // create the list
        countryList = new JList<>(listModel);
        countryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        countryList.setSelectedIndex(0);
        countryList.setFixedCellHeight(30);
        countryList.setFixedCellWidth(180);

        goBtn.addActionListener(this);

        leftPanel.add(countryList);
        leftPanel.add(new JScrollPane(countryList));
        leftPanel.add(goBtn);

        container.add(leftPanel);
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
        } else if (e.getSource() == goBtn) {
            if (countryList.getSelectedIndex() != -1) {
                title.setText(countryList.getSelectedValue());
                desc.setText("Deskripsi Wiki untuk " + countryList.getSelectedValue());
                System.out.println(countryList.getSelectedValue());
            }
        }
    }
}

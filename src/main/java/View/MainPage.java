package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
    JList<String> matkulList;
    JList<String> matkulList2;
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

    // public void rightPanel() {
    // JPanel rightPanel = new JPanel();
    // rightPanel.setLayout(null);
    // rightPanel.setBackground(Color.WHITE);
    // //
    // rightPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
    // // "Login Panel"));

    // title.setText(countryList.getSelectedValue());
    // title.setFont(new Font("Calibri", Font.BOLD, 30));
    // title.setSize(300, 50);
    // title.setLocation(10, 0);

    // desc.setText("Deskripsi Wiki untuk " + countryList.getSelectedValue());
    // desc.setSize(200, 30);
    // desc.setLocation(10, 50);

    // rightPanel.add(title);
    // rightPanel.add(desc);

    // container.add(rightPanel);
    // }

    public void rightPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        // Judul Mata Kuliah
        title.setText(matkulList.getSelectedValue());
        title.setFont(new Font("Calibri", Font.BOLD, 30));
        title.setSize(300, 50);
        title.setLocation(10, 0);

        // Sub-Bab Mata Kuliah
        ArrayList<JLabel> subBab = new ArrayList<JLabel>();
        subBab.add(setGetSubBabLabel("Topik 1"));
        subBab.add(setGetSubBabLabel("Topik 2"));
        subBab.add(setGetSubBabLabel("Topik 3"));
        subBab.add(setGetSubBabLabel("Topik 4"));

        panel.add(title);
        JLabel text = new JLabel();
        text.setText("Topik");
        panel.add(text);
        panel.add(subBab.get(0));

        int i = 0;

        for (JLabel l : subBab) {

            l.setLocation(10, 50 + i);
            i += 40;
            panel.add(l);

        }

        container.add(panel);

    }

    JLabel setGetSubBabLabel(String title) {
        JLabel subBab = new JLabel();
        subBab.setFont(new Font("Calibri", Font.BOLD, 18));
        subBab.setText(title);
        subBab.setForeground(Color.BLUE.darker());
        subBab.setSize(200, 30);
        subBab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        subBab.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new DetailPage(title, matkulList.getSelectedValue());
            }
        });

        return subBab;
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
                "Mata Kuliah"));

        // create the model and add elements
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Mata Kuliah A");
        listModel.addElement("Mata Kuliah B");
        listModel.addElement("Mata Kuliah C");
        listModel.addElement("Mata Kuliah D");
        listModel.addElement("Mata Kuliah E");
        listModel.addElement("Mata Kuliah F");
        listModel.addElement("Mata Kuliah G");
        listModel.addElement("Mata Kuliah H");

        // create the list
        matkulList = new JList<>(listModel);
        matkulList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        matkulList.setSelectedIndex(0);
        matkulList.setFixedCellHeight(30);
        matkulList.setFixedCellWidth(180);

        goBtn.addActionListener(this);

        leftPanel.add(matkulList);
        leftPanel.add(new JScrollPane(matkulList));
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
            if (matkulList.getSelectedIndex() != -1) {
                title.setText(matkulList.getSelectedValue());
                desc.setText("Deskripsi Wiki untuk " + matkulList.getSelectedValue());
                System.out.println(matkulList.getSelectedValue());
            }
        }
    }
}

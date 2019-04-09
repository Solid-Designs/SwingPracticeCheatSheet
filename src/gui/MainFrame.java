package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainFrame extends JFrame {
    private ToolBar toolBar;
    private TextPanel textPanel;
    private FormPanel formPanel;
    private JFileChooser fileChooser;
    private Controller controller;
    private TablePanel tablePanel;

    public MainFrame(){
        super("Hello World");

        setLayout(new BorderLayout());

        toolBar = new ToolBar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();
        fileChooser = new JFileChooser();
        tablePanel = new TablePanel();

        controller = new Controller();

        tablePanel.setData(controller.getPeople());

        // File Chooser filter tutorial
        fileChooser.addChoosableFileFilter(new PersonFileFiler());

        setJMenuBar(createMenuBar());

        add(toolBar, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);

        // Set minimum size that the main frame can shrink
        setMinimumSize(new Dimension(500, 400));
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        toolBar.setListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                // Something to execute
                textPanel.appendText(text);
            }
        });

        formPanel.setFormListener(new FormListener(){
            public void formEventOccurred(FormEvent e){
                // Put all the data in the controller!
                controller.addPerson(e);
                tablePanel.refresh();
            }
        });
    }

    // Menu tutorial
    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu windowMenu = new JMenu("Window");

        JMenu fileMenu = new JMenu("File");
        JMenuItem exportDataItem = new JMenuItem("Export Data...");
        JMenuItem importDataItem = new JMenuItem("Import Data...");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu showMenu = new JMenu("Show");
        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
        showFormItem.setSelected(true);

        showMenu.add(showFormItem);
        windowMenu.add(showMenu);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        // Checkbox menu tutorial
        showFormItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem)ev.getSource();

                formPanel.setVisible(menuItem.isSelected());
            }
        });

        // Mnemonic and accelerator tutorial
        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);

        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        // File Chooser tutorial
        importDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                    try {

                        controller.loadFromFile(fileChooser.getSelectedFile());
                        tablePanel.refresh();

                    } catch (IOException e1) {

                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Could not load data from file", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
            }
        });

        exportDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                    try {

                        controller.saveToFile(fileChooser.getSelectedFile());

                    } catch (IOException e1) {

                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Could not save data to file", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
            }
        });

        // How to make the exit button work in the menu
        // Popup dialogue box tutorial also
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit? ",
                        "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

                // If the action is equal to okay, then quit out.
                // If not, just ignore it
                if(action == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

        return menuBar;
    }
}

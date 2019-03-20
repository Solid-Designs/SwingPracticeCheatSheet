import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ToolBar toolBar;
    private TextPanel textPanel;
    private FormPanel formPanel;

    public MainFrame(){
        super("Hello World");

        setLayout(new BorderLayout());

        toolBar = new ToolBar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();

        setJMenuBar(createMenuBar());

        add(toolBar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);

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
                // Something to execute
                String name = e.getName();
                String occupation = e.getOccupation();
                int ageCat = e.getAgeCategory();
                String empCat = e.getEmpCat();
                String taxID = e.getTaxID();
                boolean usCitizen = e.isUsCitizen();

                textPanel.appendText(name + ": " + occupation + ": "+ ageCat + ", " + empCat + ", " + taxID + "\n");
                System.out.println(e.getGender());
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
        JMenuItem showFormItem = new JMenuItem("Person Form");
        showMenu.add(showFormItem);
        windowMenu.add(showMenu);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        return menuBar;
    }
}

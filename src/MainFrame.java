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

                textPanel.appendText(name + ": " + occupation + ": "+ ageCat + "\n");
            }
        });
    }
}

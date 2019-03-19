import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {
    private JButton helloButton;
    private JButton goodbyeButton;
    private StringListener listener;

    public ToolBar(){
        helloButton = new JButton("Hello");
        goodbyeButton = new JButton("Goodbye");

        setLayout(new FlowLayout(FlowLayout.LEFT));

        helloButton.addActionListener(this);
        goodbyeButton.addActionListener(this);

        add(helloButton);
        add(goodbyeButton);
    }

    public void setListener(StringListener listener){
        this.listener = listener;
    }

    public void actionPerformed(ActionEvent e){
        JButton clicked = (JButton)e.getSource();

        if(clicked == helloButton){
            if(listener != null){
                listener.textEmitted("Hello\n");
            }
        } else if(clicked == goodbyeButton){
            if(listener != null){
                listener.textEmitted("Goodbye\n");
            }
        }
    }
}

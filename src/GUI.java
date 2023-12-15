import org.w3c.dom.events.EventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    public static JTextField text;
    public static JButton button;

    GUI(){
        JFrame frame = new JFrame("Project");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(head(),BorderLayout.NORTH);
        frame.add(midfield(),BorderLayout.CENTER);
        frame.add(bottom(),BorderLayout.SOUTH);
        frame.setVisible(true);
    }



    public JPanel head(){

        JPanel panel = new JPanel(new FlowLayout());

        JLabel label = new JLabel("Film");

        panel.add(label);
        return panel;
    }



    public static JPanel midfield(){

        JPanel panel = new JPanel(new BorderLayout());

        panel.setBorder(BorderFactory.createLineBorder(Color.black,10));

        return panel;
    }




    public JPanel bottom(){

        JPanel panel = new JPanel( new FlowLayout());
        text = new JTextField();

        text.setPreferredSize(new Dimension(100,100));

        button = new JButton();
        button.addActionListener(new eventlisnter());

        panel.add(text);
        panel.add(button);
return panel;
    }

    class eventlisnter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton press = (JButton) e.getSource();

            if (press.equals(button)){
                Api.getRequests(text.getText());
            }

        }
    }
}

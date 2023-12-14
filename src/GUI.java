import javax.swing.*;
import java.awt.*;

public class GUI {

    public static JButton[] button = new JButton[9];

    GUI(){
        JFrame frame = new JFrame("Project");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(head(),BorderLayout.NORTH);
        frame.add(middle.midfield(),BorderLayout.CENTER);
        frame.add(filters.bottom(),BorderLayout.SOUTH);
        frame.setVisible(true);
    }



    public JPanel head(){

        JPanel panel = new JPanel(new FlowLayout());

        JLabel label = new JLabel("Music");



        panel.add(label);
        return panel;
    }



    public static JPanel midfield(){

        JPanel panel = new JPanel(new BorderLayout());

        panel.setBorder(BorderFactory.createLineBorder(Color.black,10));






        return panel;
    }




    public static JPanel bottom(){

        JPanel panel = new JPanel( new FlowLayout());

        for (int i = 0; i<9; i++ ) {

            button[i] = new JButton("Filter");
            button[i].setPreferredSize(new Dimension(70,30));
            panel.add(button[i]);
        }
        return panel;
    }
}

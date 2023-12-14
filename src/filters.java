import javax.swing.*;
import java.awt.*;

public class filters extends GUI{
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

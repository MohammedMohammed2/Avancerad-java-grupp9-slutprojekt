import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class GUI {
    public static String title,year,genre,plot,imdbRate;

    public static String poster;

    public static ImageIcon image;

    public static JTextArea plotge;
    public static JLabel labelTitle, labelYear, labelGenre, labelRate, labelImage;
    public static JTextField text;
    public static JButton button;

    GUI() {

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

        JPanel panel = new JPanel(new FlowLayout());

        panel.setBorder(BorderFactory.createLineBorder(Color.black,10));

        labelTitle = new JLabel();
        labelYear = new JLabel();
        labelGenre = new JLabel();
        labelRate = new JLabel();
        labelImage = new JLabel();

        plotge = new JTextArea();
        plotge.setSize(200,200);
        plotge.setLineWrap(true);
        plotge.setVisible(false);



        panel.add(labelTitle);
        panel.add(labelYear);
        panel.add(labelGenre);
        panel.add(labelRate);
        panel.add(plotge);
        panel.add(labelImage);

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
                labelTitle.setText(Api.title);
                labelYear.setText(Api.year);
                labelGenre.setText(Api.genre);

                labelRate.setText(Api.imdbRate);

                try {
                    image = new ImageIcon(new URL(poster));
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }
                labelImage.setIcon(image);

                plotge.setText(Api.plot);
                plotge.setVisible(true);
                plotge.setEditable(false);
            }
        }
    }
}

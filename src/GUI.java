import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI {
    public static String title,year,genre,plot,imdbRate;
    public static String poster;
    public static JTextArea plotge;
    public static JTextField text,pagenumb;
    public static JButton button,button1;
    public static JTable table;

    static String [] column = {"Title", "Year", "Genre", "Imdb Rating","Plot"};
    static Object [][] data = {{"","","","",""}};
    static DefaultTableModel tableModel = new DefaultTableModel(data,column);



    GUI() {

        JFrame frame = new JFrame("Project");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
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



    public JPanel midfield(){

        JPanel panel = new JPanel(new FlowLayout());


        table = new JTable(data, column);

        table.setModel(tableModel);
        table.setAutoCreateRowSorter(true);
        table.setFillsViewportHeight(true);
        table.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(table);


        panel.add(scrollPane);

        return panel;
    }

    public JPanel bottom(){

        JPanel panel = new JPanel( new FlowLayout());
        text = new JTextField();
        text.setPreferredSize(new Dimension(100,20));

        pagenumb = new JTextField();
        pagenumb.setPreferredSize(new Dimension(50,20));

        button = new JButton("search");
        button.addActionListener(new eventlisnter());
        button.setPreferredSize(new Dimension(100,20));

        button1 = new JButton("Get movies");
        button1.addActionListener(new eventlisnter());
        button1.setPreferredSize(new Dimension(120,20));

        panel.add(text);
        panel.add(pagenumb);
        panel.add(button);
        panel.add(button1);
return panel;
    }

    class eventlisnter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton press = (JButton) e.getSource();

            if (press.equals(button)) {
                Api.getRequests(text.getText());

                String[][] rows = {{Api.title, Api.year, Api.genre, Api.imdbRate,Api.plot}};
                tableModel.setDataVector(rows, column);
                text.setText("");
            }
            if (press.equals(button1)){
                GenreSearch.getRequests(text.getText(), pagenumb.getText());

                tableModel.setDataVector(GenreSearch.rows,GUI.column);

                text.setText("");
            }
        }
    }
}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;

public class Formula1Championship extends Formula1ChampionshipManager {
    public static void main(String[] args) {
        Formula1ChampionshipManager f2 = new Formula1ChampionshipManager();//creating an object from Formula1ChampionshipManager
        f2.loadFile();// loading data from the saved file.


        JFrame f = new JFrame("Formula 1 championship"); //creating the main jframe
        final JFrame parentFrame = new JFrame("Driver table(descending order)"); //creating the 2nd jframe for the 1st button to navigate

        parentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        parentFrame.setVisible(false); //setting visibility of the 2nd jframe to false in the beginning
        parentFrame.setSize(900, 600);

        final JFrame parentFrame2 = new JFrame("Driver table(ascending order)"); //creating the 3rd jframe for the 2nd button to navigate
        parentFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        parentFrame2.setVisible(false);  //setting visibility of the 3rd jframe to false in the beginning
        parentFrame2.setSize(900, 600);

        final JFrame parentFrame3 = new JFrame("Driver table(descending order-first positions)"); //creating the 4th jframe for the 3rd button to navigate
        parentFrame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        parentFrame3.setVisible(false); //setting visibility of the 4th jframe to false in the beginning
        parentFrame3.setSize(900, 600);

        JButton button1 = new JButton("Display driver table(descending order)");
        JButton button2 = new JButton("Display driver table(ascending order)");
        JButton button3 = new JButton("Display driver table(descending order-first positions)");
        JButton button4 = new JButton("Generate a race");


        JLabel lbl2 = new JLabel("FORMULA 1 CHAMPIONSHIP", SwingConstants.CENTER);
        lbl2.setBounds(100, 50, 400, 50);


        button1.setBounds(100, 150, 400, 50);
        button2.setBounds(100, 210, 400, 50);
        button3.setBounds(100, 270, 400, 50);
        button4.setBounds(100, 330, 400, 50);

        //setting background colors and font sizes in elements
        lbl2.setFont(lbl2.getFont().deriveFont(20.0f));
        lbl2.setForeground(Color.decode("#770633"));
        f.getContentPane().setBackground(Color.decode("#1A1A1D"));
        button1.setBackground(Color.decode("#4E4E50"));
        button2.setBackground(Color.decode("#6F2232"));
        button3.setBackground(Color.decode("#950740"));
        button4.setBackground(Color.decode("#C3073F"));

        button1.setFont(new Font("Arial", Font.BOLD, 16));
        button2.setFont(new Font("Arial", Font.BOLD, 17));
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button4.setFont(new Font("Arial", Font.BOLD, 16));

        //adding elements to the main jframe
        f.add(button1);
        f.add(button2);
        f.add(button4);
        f.add(button3);
        f.add(lbl2);

        f.setSize(600, 600);
        f.setLayout(null);
        f.setVisible(true);


         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        button1.addActionListener(new ActionListener() {  // setting an action for the 1st button
            @Override
            public void actionPerformed(ActionEvent e) {
                //f.setVisible(false);
                parentFrame.setVisible(true);

            }

        });


        //creating an array for the headers
        String[] headers = {"Name", "Location", "Team", "No Of first positions", "No Of second positions", "No Of third positions", "Current points", "No Of races"};

        DefaultTableModel model = new DefaultTableModel(headers, 0);  //https://stackoverflow.com/questions/21135452/how-to-add-row-of-data-to-jtable-from-values-received-from-jtextfield-and-combob
        JTable table = new JTable(model);
        JScrollPane scroll = new JScrollPane();
        parentFrame.getContentPane().add(scroll);
        scroll.setViewportView(table);
        //setting current no of points in descending order
        Comparator<Formula1Driver> cm2 = Comparator.comparing(Formula1Driver::getCurrentNoOfPoints);
        Collections.sort(driverDetails, Collections.reverseOrder(cm2));

        details(model, table);
        button2.addActionListener(new ActionListener() {   // setting an action for the 2nd button
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel model1 = new DefaultTableModel(headers, 0);  //https://stackoverflow.com/questions/21135452/how-to-add-row-of-data-to-jtable-from-values-received-from-jtextfield-and-combob
                JTable table = new JTable(model1);
                JScrollPane scroll = new JScrollPane();
                parentFrame2.getContentPane().add(scroll);
                scroll.setViewportView(table);
                Comparator<Formula1Driver> cm2 = Comparator.comparing(Formula1Driver::getCurrentNoOfPoints);

                Collections.sort(driverDetails, cm2);

                details(model1, table);
                parentFrame2.setVisible(true);

            }

        });

        button3.addActionListener(new ActionListener() {  // setting an action for the 3rd button
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel model2 = new DefaultTableModel(headers, 0);
                JTable table = new JTable(model2);
                JScrollPane scroll = new JScrollPane();
                parentFrame3.getContentPane().add(scroll);
                scroll.setViewportView(table);
                Comparator<Formula1Driver> cm2 = Comparator.comparing(Formula1Driver::getfPositions);

                Collections.sort(driverDetails,Collections.reverseOrder(cm2));

                details(model2, table);
                parentFrame3.setVisible(true);

            }
        });

    }
    //method to get the driver details to rows in the jtable.
    private static void details(DefaultTableModel model, JTable table) {
        for (int i = 0; i < driverDetails.size(); i++) {
            String name = driverDetails.get(i).getName();
            String location = driverDetails.get(i).getLocation();
            String team = driverDetails.get(i).getTeam();
            int fpositins = driverDetails.get(i).getfPositions();
            int spositions = driverDetails.get(i).getsPositions();
            int tpositions = driverDetails.get(i).gettPositions();
            int currentpoints = driverDetails.get(i).getCurrentNoOfPoints();
            int races = driverDetails.get(i).getNumberOfRaces();
            Object[] data = {name, location, team, fpositins, spositions, tpositions, currentpoints, races};
            model.addRow(data);
            table.setModel(model);
        }
    }
}

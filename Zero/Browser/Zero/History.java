import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class History implements ActionListener{
    JPanel history = new JPanel();
    JPanel historySubPanel = new JPanel();
    JLabel historyText = new JLabel("In history section");
    JButton historyUpdate = new JButton("Update History");

    String [] historyArray = new String[5];
    int historyCount =0;

    Site historySite = new Site();

    History(){
        historyUpdate.addActionListener(this);

        history.setLayout(new FlowLayout());
        history.setPreferredSize(new Dimension (840,520));
        historySubPanel.setPreferredSize(new Dimension (820,300));
        history.add(historyText);
        history.add(historySubPanel);
        history.add(historyUpdate);
        history.setVisible(false);
    }
    public void actionPerformed(ActionEvent e){
        buildHistory();
    }

    public void buildHistory(){
        historySubPanel.removeAll();
        System.out.println(historyArray[0]);
        int start = historyArray.length;
        JLabel jlabel[] = new JLabel[start];

        //Array is counting it as 5 times....
        for(int a = 0; a< historyCount; a++){
            jlabel[a] = new JLabel(historyArray[a]+"");
            JLabel historyLabel = jlabel[a];
            String siteparam = historyArray[a];
            historyLabel.setPreferredSize(new Dimension (640,50));
            historyLabel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                        historySite.site.setVisible(true);
                        history.setVisible(false);
                        historySite.panelBuilder3(siteparam);
                    }	
                }
            );
            historySubPanel.add(historyLabel);
        }

        historySubPanel.validate();
        historySubPanel.repaint();
    }
}//57
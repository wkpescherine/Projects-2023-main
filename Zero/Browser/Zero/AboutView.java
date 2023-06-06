import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class AboutView {
    Text text = new Text();

    JPanel aboutSec = new JPanel();
    JPanel aboutSubSec = new JPanel();
    JLabel aboutText = new JLabel("None");
    JButton aboutBack = new JButton("Back");

    AboutView(){
        aboutSec.setLayout(new BoxLayout(aboutSec, BoxLayout.Y_AXIS));
        aboutSec.setBackground(Color.BLACK);
        aboutText.setForeground(Color.WHITE);
        aboutSec.setPreferredSize(new Dimension(500,560));
        aboutSubSec.setPreferredSize(new Dimension(480,300));
        aboutText.setText("<html>"+text.about+"</html>");
        aboutBack.setBounds(50,200,200,50);
        aboutBack.setPreferredSize(new Dimension(80,60));
        aboutSec.add(aboutText);
        aboutSec.add(aboutBack);
        aboutSec.setVisible(false);    
    }
}//26
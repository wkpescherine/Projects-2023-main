package src.Sections;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import src.Main.Display;

public class Down implements ActionListener{
    JButton first = new JButton("1st");
    JButton second = new JButton("2nd");
    JButton third = new JButton("3rd");
    JButton fourth = new JButton("4th");
    public JPanel downs = new JPanel();
        
    public Down(){
        first.addActionListener(this);
        second.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.down = "2nd";
                    Display.updateUI();
				}
			}
		);
        third.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.down = "3rd";
                    Display.updateUI();
				}
			}
		);
        fourth.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.down = "4th";
                    Display.updateUI();
				}
			}
		);
        downs.setPreferredSize(new Dimension (210,35));
        first.setPreferredSize(new Dimension (30,25));
        second.setPreferredSize(new Dimension (30,25));
        third.setPreferredSize(new Dimension (30,25));
        fourth.setPreferredSize(new Dimension (30,25));
        downs.add(first);
        downs.add(second);
        downs.add(third);
        downs.add(fourth);
        downs.setPreferredSize(new Dimension (165,35));
        downs.setLayout(new FlowLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Config.down = "1st"; 
        Display.updateUI();  
    }
}
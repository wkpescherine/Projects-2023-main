package src.Sections;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import src.Main.Display;

public class Distance implements ActionListener {
    JButton less1 = new JButton("<1");
    JButton y1to3 = new JButton("1-3");
    JButton y4to6 = new JButton("4-6");
    JButton y7to9 = new JButton("7-9");
    JButton y10 = new JButton("10");
    JButton y11to15 = new JButton("11>");
    JButton y16to20 = new JButton("16>");
    JButton y21over = new JButton("21+");
    public JPanel distance = new JPanel();

    public Distance(){
        less1.addActionListener(this);
        y1to3.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.yards = "1-3";
                    Display.updateUI();
				}
			}
		);
        y4to6.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.yards = "4-6";
                    Display.updateUI();
				}
			}
		);
        y7to9.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.yards = "7-9";
                    Display.updateUI();
				}
			}
		);
        y10.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.yards = "10";
                    Display.updateUI();
				}
			}
		);
        y11to15.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.yards = "11-15";
                    Display.updateUI();
				}
			}
		);
        y16to20.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.yards = "16-20";
                    Display.updateUI();
				}
			}
		);
        y21over.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.yards = "21+";
                    Display.updateUI();
				}
			}
		);
        distance.setPreferredSize(new Dimension (320,35));
        //Previouds total was 480 width
        less1.setPreferredSize(new Dimension (20,25));
        less1.setBounds(5,5,30,25);
        y1to3.setPreferredSize(new Dimension (30,25));
        y1to3.setBounds(45,5,30,25);
        y4to6.setPreferredSize(new Dimension (50,25));
        y4to6.setBounds(85,5,30,25);
        y7to9.setPreferredSize(new Dimension (50,25));
        y7to9.setBounds(125,5,30,25);
        y10.setPreferredSize(new Dimension (45,25));
        y10.setBounds(165,5,30,25);
        y11to15.setPreferredSize(new Dimension (65,25));
        y11to15.setBounds(205,5,30,25);
        y16to20.setPreferredSize(new Dimension (65,25));
        y16to20.setBounds(245,5,30,25);
        y21over.setPreferredSize(new Dimension (65,25));
        y21over.setBounds(285,5,30,25);
        //distance.setLayout(new FlowLayout());
        distance.setLayout(null);
        distance.add(less1);
        distance.add(y1to3);
        distance.add(y4to6);
        distance.add(y7to9);
        distance.add(y10);
        distance.add(y11to15);
        distance.add(y16to20);
        distance.add(y21over);
    }
    public void actionPerformed(ActionEvent e) {
        Config.yards = "<1";   
    }
}
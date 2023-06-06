package src.Sections;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import src.Main.Display;

public class Quarter implements ActionListener{
    JButton Q1 = new JButton("Q1");
    JButton Q2 = new JButton("Q2");
    JButton Q3 = new JButton("Q3");
    JButton Q4 = new JButton("Q4");
    JButton OT = new JButton("OT");
    public JPanel qtr = new JPanel();

    public Quarter(){
        Q1.addActionListener(this);
        Q2.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.quarter = "2";
                    Display.updateUI();
				}
			}
		);
        Q3.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.quarter = "3";
                    Display.updateUI();
				}
			}
		);
        Q4.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.quarter = "4";
                    Display.updateUI();
				}
			}
		);
        OT.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.quarter = "OT";
                    Display.updateUI();
				}
			}
		);
        Q1.setPreferredSize(new Dimension (25,25));
        Q2.setPreferredSize(new Dimension (25,25));
        Q3.setPreferredSize(new Dimension (25,25));
        Q4.setPreferredSize(new Dimension (25,25));
        OT.setPreferredSize(new Dimension (25,25));

        qtr.add(Q1);
        qtr.add(Q2);
        qtr.add(Q3);
        qtr.add(Q4);
        qtr.add(OT);
        qtr.setPreferredSize(new Dimension (165,35));
        qtr.setLayout(new FlowLayout());
    }
    public void actionPerformed(ActionEvent e){
        Config.quarter = "1";
        Display.updateUI();
	}
}
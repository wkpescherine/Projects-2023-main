package src.Sections;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import src.Main.Display;

public class FieldPosition implements ActionListener{
    JButton opp = new JButton("OPP");
    JButton own = new JButton("OWN");
    JButton y1to10 = new JButton("1+");
    JButton y11to20 = new JButton("11+");
    JButton y21to30 = new JButton("21+");
    JButton y31to40 = new JButton("31+");
    JButton y41to49 = new JButton("41+");
    JButton y50 = new JButton("50");
    public JPanel field_pos = new JPanel();

    public FieldPosition(){
        opp.addActionListener(this);
        own.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.side_of_field = "OWN";
                    Display.updateUI();
				}
			}
		);
        y1to10.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.side_of_field = "1-10";
                    Display.updateUI();
				}
			}
		);
        y11to20.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.side_of_field = "11-20";
                    Display.updateUI();
				}
			}
		);
        y21to30.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.side_of_field = "21-30";
                    Display.updateUI();
				}
			}
		);
        y31to40.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.side_of_field = "31-40";
                    Display.updateUI();
				}
			}
		);
        y41to49.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.side_of_field = "41-49";
                    Display.updateUI();
				}
			}
		);
        y50.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.side_of_field = "50";
                    Display.updateUI();
				}
			}
		);

        opp. setPreferredSize(new DimensionUIResource(35, 25));
        own. setPreferredSize(new DimensionUIResource(35, 25));
        y1to10.setPreferredSize(new DimensionUIResource(35, 25));
        y11to20.setPreferredSize(new DimensionUIResource(35, 25));
        y21to30.setPreferredSize(new DimensionUIResource(35, 25));
        y31to40.setPreferredSize(new DimensionUIResource(35, 25));
        y41to49.setPreferredSize(new DimensionUIResource(35, 25));
        y50.setPreferredSize(new DimensionUIResource(35, 25));
        
        field_pos.setPreferredSize(new Dimension (330,35));
        field_pos.setLayout(new FlowLayout());
        field_pos.add(opp);
        field_pos.add(own);
        field_pos.add(y1to10);
        field_pos.add(y11to20);
        field_pos.add(y21to30);
        field_pos.add(y31to40);
        field_pos.add(y41to49);
        field_pos.add(y50);
    }

    public void actionPerformed(ActionEvent e) {
        Config.side_of_field = "OPP"; 
        Display.updateUI();  
    }
}
package src.Sections;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import src.Main.Display;

public class PlayResult implements ActionListener{
    JButton completion = new JButton("COM");
    JButton incomplete = new JButton("INC");
    JButton run = new JButton("RUN");
    JButton interception = new JButton("INT");
    JButton fumble = new JButton("FUM");
    JButton penalty = new JButton("PEN");
    JButton punt = new JButton("PNT");
    JButton fieldGoal = new JButton("FG");
    JButton touchdown = new JButton("TD");
    JButton safety = new JButton("SAF");
    JButton sack = new JButton("SAC");
    public JPanel playresult = new JPanel();
    
    public PlayResult(){
        completion.addActionListener(this);
        incomplete.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.play_result = "INC";
                    Display.updateUI();
				}
			}
		);
        run.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.play_result = "RUN";
                    Display.updateUI();
				}
			}
		);
        interception.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.play_result = "INT";
                    Display.changePoss();
                    Config.down="1st";
                    Config.yards = "10";
                    Display.updateUI();
				}
			}
		);
        fumble.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.play_result = "FUM";
                    Display.changePoss();
                    Config.down="1st";
                    Config.yards = "10";
                    Display.updateUI();
				}
			}
		);
        penalty.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.play_result = "PEN";
                    Display.updateUI();
				}
			}
		);
        punt.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.play_result = "PNT";
                    Display.changePoss();
                    Config.down="1st";
                    Config.yards = "10";
                    Display.updateUI();
				}
			}
		);
        fieldGoal.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.play_result = "FG";
                    Display.changePoss();
                    Config.down="1st";
                    Config.yards = "10";
                    Display.updateUI();

				}
			}
		);
        touchdown.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.play_result = "TD";
                    Display.changePoss();
                    Config.down="1st";
                    Config.yards = "10";
                    Display.updateUI();
				}
			}
		);
        safety.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.play_result = "SAF";
                    Display.changePoss();
                    Config.down="1st";
                    Config.yards = "10";
                    Display.updateUI();
				}
			}
		);
          sack.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.play_result = "SAF";
                    Config.down="2nd";
                    Display.updateUI();
				}
			}
		);

        completion.setPreferredSize(new Dimension (39,25));
        incomplete.setPreferredSize(new Dimension (39,25));
        run.setPreferredSize(new Dimension (39,25));
        interception.setPreferredSize(new Dimension (39,25));
        fumble.setPreferredSize(new Dimension (39,25));
        penalty.setPreferredSize(new Dimension (39,25));
        punt.setPreferredSize(new Dimension (39,25));
        fieldGoal.setPreferredSize(new Dimension (39,25));
        touchdown.setPreferredSize(new Dimension (39,25));
        safety.setPreferredSize(new Dimension (39,25));

        playresult.setPreferredSize(new Dimension (700,35));
        playresult.setLayout(new FlowLayout());
        playresult.add(completion);
        playresult.add(incomplete);
        playresult.add(run);
        playresult.add(interception);
        playresult.add(fumble);
        playresult.add(penalty);
        playresult.add(punt);
        playresult.add(fieldGoal);
        playresult.add(touchdown);
        playresult.add(safety);
    }

    public void actionPerformed(ActionEvent e){
        Config.play_result = "COMP";
        Display.updateUI();
	}

     public void calculatePoints(String scoreResult){
          if(Config.TeamA == Config.offense){
               if(scoreResult == "TD"){
                    Config.TeamAScore += 6;
               }else if(scoreResult == "PAT"){
                    Config.TeamAScore += 1;
               }else if(scoreResult == "FG"){
                    Config.TeamAScore += 3;
               }
          }
     }
}

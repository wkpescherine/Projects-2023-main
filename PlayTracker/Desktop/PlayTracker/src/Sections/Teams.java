package src.Sections;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import src.Main.Display;

public class Teams implements ActionListener {
    JButton offense =  new JButton("OFF");
    JButton defense =  new JButton("DEF");
    JButton BUF = new JButton("Buf");
    JButton NYJ = new JButton("NYJ");
    JButton MIA = new JButton("Mia");
    JButton NE = new JButton("NE");
    JButton PIT = new JButton("Pit");
    JButton BAL = new JButton("Bal");
    JButton CLE = new JButton("Cle");
    JButton CIN = new JButton("Cin");
    JButton KC  = new JButton("KC");
    JButton LV  = new JButton("LV");
    JButton DEN = new JButton("Den");
    JButton LAC = new JButton("LAC");
    JButton IND = new JButton("Ind");
    JButton JAX = new JButton("Jax");
    JButton HOU = new JButton("Hou");
    JButton TEN = new JButton("Ten");
    JButton DAL = new JButton("Dal");
    JButton NYG = new JButton("NYG");
    JButton PHI = new JButton("Phi");
    JButton WAS = new JButton("Was");
    JButton GB  = new JButton("GB");
    JButton MIN = new JButton("Min");
    JButton DET = new JButton("Det");
    JButton CHI = new JButton("Chi");
    JButton TB  = new JButton("TB");
    JButton NO  = new JButton("NO");
    JButton CAR = new JButton("Car");
    JButton ATL = new JButton("Atl");
    JButton SF  = new JButton("SF");
    JButton LAR = new JButton("LAR");
    JButton SEA = new JButton("Sea");
    JButton ARI = new JButton("Ari");

    public JPanel teams = new JPanel();
    
    public Teams(){
        offense.addActionListener(this);
        offense.setPreferredSize(new Dimension (35,25));
        defense.setPreferredSize(new Dimension (35,25));
        defense.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.off_def = "def";
				}
			}
		);
        BUF.setPreferredSize(new Dimension (35,25));
        BUF.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "BUF";
                    }else{ Config.defense= "BUF";}
                    Display.updateUI();
				}
			}
		);
        MIA.setPreferredSize(new Dimension (35,25));
        MIA.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "MIA";
                    }else{ Config.defense= "MIA";}
                    Display.updateUI();
				}
			}
		);
        NYJ.setPreferredSize(new Dimension (35,25));
        NYJ.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "NYJ";
                    }else{ Config.defense= "NYJ";}
                    Display.updateUI();
				}
			}
		);
        NE.setPreferredSize(new Dimension (35,25));
        NE.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "NE";
                    }else{ Config.defense= "NE";}
                    Display.updateUI();
				}
			}
		);
        PIT.setPreferredSize(new Dimension (35,25));
        PIT.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "PIT";
                    }else{ Config.defense= "PIT";}
                    Display.updateUI();
				}
			}
		);
        BAL.setPreferredSize(new Dimension (35,25));
        BAL.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "BAL";
                    }else{ Config.defense= "BAL";}
                    Display.updateUI();
				}
			}
		);
        CLE.setPreferredSize(new Dimension (35,25));
        CLE.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "CLE";
                    }else{ Config.defense= "CLE";}
                    Display.updateUI();
				}
			}
		);
        CIN.setPreferredSize(new Dimension (35,25));
        CIN.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "CIN";
                    }else{ Config.defense= "CIN";}
                    Display.updateUI();
				}
			}
		);
        KC.setPreferredSize(new Dimension (35,25));
        KC.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "KC";
                    }else{ Config.defense= "KC";}
                    Display.updateUI();
				}
			}
		);
        LV.setPreferredSize(new Dimension (35,25));
        LV.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "LV";
                    }else{ Config.defense= "LV";}
                    Display.updateUI();
				}
			}
		);
        DEN.setPreferredSize(new Dimension (35,25));
        DEN.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "DEN";
                    }else{ Config.defense= "DEN";}
                    Display.updateUI();
				}
			}
		);
        LAC.setPreferredSize(new Dimension (35,25));
        LAC.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "LAC";
                    }else{ Config.defense= "LAC";}
                    Display.updateUI();
				}
			}
		);
        IND.setPreferredSize(new Dimension (35,25));
        IND.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "IND";
                    }else{ Config.defense= "IND";}
                    Display.updateUI();
				}
			}
		);
        JAX.setPreferredSize(new Dimension (35,25));
        JAX.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "JAX";
                    }else{ Config.defense= "JAX";}
                    Display.updateUI();
				}
			}
		);
        HOU.setPreferredSize(new Dimension (35,25));
        HOU.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "HOU";
                    }else{ Config.defense= "HOU";}
                    Display.updateUI();
				}
			}
		);
        TEN.setPreferredSize(new Dimension (35,25));
        TEN.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "TEN";
                    }else{ Config.defense= "TEN";}
                    Display.updateUI();
				}
			}
		);
        DAL.setPreferredSize(new Dimension (35,25));
        DAL.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "DAL";
                    }else{ Config.defense= "DAL";}
                    Display.updateUI();
				}
			}
		);
        NYG.setPreferredSize(new Dimension (35,25));
        NYG.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "NYG";
                    }else{ Config.defense= "NYG";}
                    Display.updateUI();
				}
			}
		);
        PHI.setPreferredSize(new Dimension (35,25));
        PHI.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "PHI";
                    }else{ Config.defense= "PHI";}
                    Display.updateUI();
				}
			}
		);
        WAS.setPreferredSize(new Dimension (35,25));
        WAS.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "WAS";
                    }else{ Config.defense= "WAS";}
                    Display.updateUI();
				}
			}
		);
        GB.setPreferredSize(new Dimension (35,25));
        GB.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "GB";
                    }else{ Config.defense= "GB";}
                    Display.updateUI();
				}
			}
		);
        MIN.setPreferredSize(new Dimension (35,25));
        MIN.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "MIN";
                    }else{ Config.defense= "MIN";}
                    Display.updateUI();
				}
			}
		);
        DET.setPreferredSize(new Dimension (35,25));
        DET.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "DET";
                    }else{ Config.defense= "DET";}
                    Display.updateUI();
				}
			}
		);
        CHI.setPreferredSize(new Dimension (35,25));
        CHI.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "CHI";
                    }else{ Config.defense= "CHI";}
                    Display.updateUI();
				}
			}
		);
        TB.setPreferredSize(new Dimension (35,25));
        TB.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "TB";
                    }else{ Config.defense= "TB";}
                    Display.updateUI();
				}
			}
		);
        NO.setPreferredSize(new Dimension (35,25));
        NO.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "NO";
                    }else{ Config.defense= "NO";}
                    Display.updateUI();
				}
			}
		);
        CAR.setPreferredSize(new Dimension (35,25));
        CAR.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "CAR";
                    }else{ Config.defense= "CAR";}
                    Display.updateUI();
				}
			}
		);
        ATL.setPreferredSize(new Dimension (35,25));
        ATL.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "ATL";
                    }else{ Config.defense= "ATL";}
                    Display.updateUI();
				}
			}
		);
        SF.setPreferredSize(new Dimension (35,25));
        SF.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "SF";
                    }else{ Config.defense= "SF";}
                    Display.updateUI();
				}
			}
		);
        SEA.setPreferredSize(new Dimension (35,25));
        SEA.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "SEA";
                    }else{ Config.defense= "SEA";}
                    Display.updateUI();
				}
			}
		);
        LAR.setPreferredSize(new Dimension (35,25));
        LAR.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "LAR";
                    }else{ Config.defense= "LAR";}
                    Display.updateUI();
				}
			}
		);
        ARI.setPreferredSize(new Dimension (35,25));
        ARI.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Config.off_def.equals("off")){
                        Config.offense = "ARI";
                    }else{ Config.defense= "ARI";}
				}
			}
		);

        teams.setPreferredSize(new Dimension (700,60));
        teams.add(offense);
        teams.add(BUF);
        teams.add(MIA);
        teams.add(NYJ);
        teams.add(NE);
        teams.add(PIT);
        teams.add(BAL);
        teams.add(CLE);
        teams.add(CIN);
        teams.add(KC);
        teams.add(LV);
        teams.add(DEN);
        teams.add(LAC);
        teams.add(IND);
        teams.add(JAX);
        teams.add(HOU);
        teams.add(TEN);
        teams.add(defense);
        teams.add(DAL);
        teams.add(NYG);
        teams.add(PHI);
        teams.add(WAS);
        teams.add(GB);
        teams.add(MIN);
        teams.add(DET);
        teams.add(CHI);
        teams.add(TB);
        teams.add(NO);
        teams.add(CAR);
        teams.add(ATL);
        teams.add(SF);
        teams.add(SEA);
        teams.add(ARI);
        teams.add(LAR);
    }

    public void actionPerformed(ActionEvent e){
        Config.off_def = "off";
	}
}
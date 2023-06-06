import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;

public class Site implements ActionListener{
	JPanel site = new JPanel();
	JPanel siteView = new JPanel();
	String [] groupNames = {"group_name0","group_name1","group_name2","group_name3"};
	JPanel adSpace = new JPanel();

    Site(){
		adSpace.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					System.out.println("Clicked in Ad Space");
				}	
			}
		);

		getSite();
		site.removeAll();
        site.setLayout(new FlowLayout());
		site.setPreferredSize(new Dimension (860,540));
		adSpace.setPreferredSize(new Dimension(860,50));
		adSpace.setBackground(Color.WHITE);
		site.setVisible(false);
		site.add(siteView);
		site.add(adSpace);
		site.validate();
		site.repaint();
	}
	
	public void panelBuilder3(String sampleSite){
		String [] sections = sampleSite.split(";");
		int start = sections.length;
		JPanel jpanel[] = new JPanel[start];
		JLabel jlabel[] = new JLabel[start];
		JButton jbutton[] = new JButton[start];

		for(int i = 0; i <sections.length; i++ ){
			String [] subSections = sections[i].split("\\,|\\(|\\)");
			if(subSections[0].equals("Zero")){
				siteView.removeAll();
			}
			if(subSections[0].equals("p")){
				groupNames[i] = subSections[1];
				jpanel[i] = new JPanel();
				JPanel test = jpanel[i];
				int val1 = Integer.parseInt(subSections[2]);
				int val2 = Integer.parseInt(subSections[3]);
				test.setPreferredSize(new Dimension (val1,val2));
				test.setBackground(Color.WHITE);
				siteView.add(test);
			}
			if(subSections[0].equals("t")){
				jlabel[i] = new JLabel("text");
				JLabel testLabel = jlabel[i];
				testLabel.setText(subSections[1]);
				siteView.add(testLabel);
			}
			//b(group_name, button_label)
			if(subSections[0].equals("b")){
				jbutton[i] = new JButton();
				JButton testBtn = jbutton[i];
				testBtn.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
							System.out.println("Button Stub");
						}
					}
				);
				siteView.add(testBtn);
			}
			for(int x = 0; x <4; x ++){
				if(groupNames[x].equals(subSections[0])){
					//name(t(This is a test));
					if(subSections[1].equals("t")){
						jlabel[x] = new JLabel("text");
						JLabel testLabel = jlabel[x];
						testLabel.setText(subSections[2]);
						jpanel[x].add(testLabel);
					}
					//name(p(none,10,10, none))
					if(subSections[1].equals("p")){
						groupNames[i] = subSections[2];
						jpanel[i] = new JPanel();
						JPanel test2 = jpanel[i];
						int val1 = Integer.parseInt(subSections[3]);
						int val2 = Integer.parseInt(subSections[4]);
						test2.setPreferredSize(new Dimension (val1,val2));
						test2.setBackground(Color.RED);
						jpanel[x].add(test2);
					}
					//name(b(none, test Button))
					if(subSections[1].equals("b")){
						groupNames[i] = subSections[2];
						jbutton[i] = new JButton();
						JButton testBtn = jbutton[i];
						testBtn.addActionListener(
							new ActionListener(){
								public void actionPerformed(ActionEvent e){
									System.out.println("Button Stub");
								}
							}
						);
						jpanel[x].add(testBtn);
					}
				}
			}
			
		}
		siteView.validate();
		siteView.repaint();
	}

	public void actionPerformed(ActionEvent e){
        System.out.println("You clicked where an ad can go eventually");
	}
	
	public void getSite(){}
}//121
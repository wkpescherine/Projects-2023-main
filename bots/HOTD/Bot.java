import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.awt.Robot;


public class Bot implements ActionListener{
	JLabel version = new JLabel("version 2");
    JFrame window = new JFrame("Bot");
	JButton active = new JButton("Activate");
	JButton disable = new JButton("Disable");

	static Boolean status = false;

	static Integer number = 0;

    Bot(){
		active.addActionListener(this);
		version.setForeground(Color.WHITE);
		disable.setVisible(false);
		disable.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    status = false;
					active.setVisible(true);
					disable.setVisible(false);
				}
			}
		);

		window.add(active);
		window.add(disable);
		window.add(version);
		window.setLayout(new FlowLayout());
        window.getContentPane().setBackground(Color.BLACK);
		window.setSize(200,300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
    }
    public static void main(String args[]) throws AWTException{
		Bot bot = new Bot();
	}   

	public void actionPerformed(ActionEvent e){
		status = true;
		active.setVisible(false);
		disable.setVisible(true);
		try {
			counter();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
	}

	public static void counter()throws AWTException{
		while(status == true){
			try {
				Robot r = new Robot();
				int mask = InputEvent.BUTTON1_DOWN_MASK;
				number +=1;
				System.out.println("Before");
				r.mouseMove(100, 50);
				r.mousePress(mask);
				r.mousePress(mask);
				System.out.println("After");
				System.out.println(number);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
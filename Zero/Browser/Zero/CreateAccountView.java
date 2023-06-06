import java.awt.*;
import javax.swing.*;
import java.lang.String;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreateAccountView {
	JPanel create = new JPanel();
    JButton logIn = new JButton("Log In");
    JButton back = new JButton("Back");
    JButton newAccount = new JButton("Create Account");
    JLabel CAVusernameLabel = new JLabel("Username");
	JLabel CAVpasswordLabel = new JLabel("Password");
	JLabel seperator = new JLabel("----------------");
	JTextField CAVusernameInput = new JTextField(20);
	JTextField CAVpasswordInput = new JTextField(20);

	JLabel createResult = new JLabel("");
	int checkValue = 0;

    CreateAccountView(){

        create.setLayout(new FlowLayout());
		create.setBackground(Color.BLACK);
		CAVusernameLabel.setForeground(Color.WHITE);
		CAVusernameLabel.setPreferredSize(new Dimension(1020,30));
		CAVusernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CAVusernameInput.setPreferredSize(new Dimension(1020,30));
		CAVpasswordLabel.setForeground(Color.WHITE);
		CAVpasswordLabel.setPreferredSize(new Dimension(1020,30));
		CAVpasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CAVpasswordInput.setPreferredSize(new Dimension(1020,30));
		seperator.setPreferredSize(new Dimension(1020,30));
		createResult.setForeground(Color.WHITE);
		create.setPreferredSize(new Dimension(1040,670));
		newAccount.setPreferredSize(new Dimension(150,40));
		back.setPreferredSize(new Dimension(150,40));
		newAccount.setHorizontalAlignment(SwingConstants.CENTER);		
		back.setHorizontalAlignment(SwingConstants.CENTER);		
        create.add(CAVusernameLabel);
		create.add(CAVusernameInput);
		create.add(CAVpasswordLabel);
		create.add(CAVpasswordInput);
		create.add(seperator);
		create.add(newAccount);
		create.add(back);
		create.add(createResult);
		create.setVisible(false);
	}

	public void checkStatus(){
		checkValue = 0;
		String newUser = CAVusernameInput.getText();
		String newPass = CAVpasswordInput.getText();
		String [] usercheck;

		try{
            File myFile = new File("accountDB.txt");
			Scanner myReader = new Scanner(myFile);
            while(myReader.hasNextLine()){
				String data = myReader.nextLine();
				usercheck = data.split(","); 
				if(usercheck[0].equals(newUser)){
					createResult.setText("This Username already exist");
					checkValue += 1;
				}
			}
            myReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
		}
		
		if(checkValue < 1){
			System.out.println(checkValue);
			try{
				FileWriter myWriter = new FileWriter("accountDB.txt", true);
				BufferedWriter bWriter = new BufferedWriter(myWriter);
				PrintWriter pWriter = new PrintWriter(bWriter);
				pWriter.write(newUser+","+newPass+"\r");
				pWriter.close();
				create.setVisible(false);
			}catch(IOException ioe){
				ioe.printStackTrace();
			}  
		} else {
			createResult.setText("Failed to create account");
		}
	}
}//94
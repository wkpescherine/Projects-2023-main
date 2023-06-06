import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bank implements ActionListener{
    JPanel bank = new JPanel();
    JPanel countryToZ = new JPanel();
    JPanel zToCountry = new JPanel();
    JButton purchaseZ = new JButton("Purchase Zcoins");
    JButton sellZ = new JButton("Sell Zcoins");
    JButton completeAction = new JButton("NONE");
    JLabel bankText = new JLabel("Zero Financials");

    String [] country = {"Mexico", "Canada", "EU", "Turkish Lira", "Chinese Yen"};
    Double [] conversionRate = { 4.12 , 1.12, 1.50, 5.85 , 500.0 };

    Bank(){
        purchaseZ.addActionListener(this);
        sellZ.addActionListener(
            new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    countryToZ.setVisible(false);
                    zToCountry.setVisible(true);
                    convertToCurrency();
				}
			}
        );

        bank.setLayout(new FlowLayout());
        bank.setPreferredSize(new Dimension (840,520));
        purchaseZ.setPreferredSize(new Dimension (350,30));
        sellZ.setPreferredSize(new Dimension (350,30));
        bankText.setPreferredSize(new Dimension (600,30));
        bankText.setHorizontalAlignment(SwingConstants.CENTER);
        countryToZ.setPreferredSize(new Dimension(650,300));
        countryToZ.setBackground(Color.WHITE);
        zToCountry.setPreferredSize(new Dimension(650,300));
        zToCountry.setBackground(Color.WHITE);
        countryToZ.setVisible(false);
        zToCountry.setVisible(false);
        completeAction.setVisible(false);
        bank.add(bankText);
        bank.add(purchaseZ);
        bank.add(sellZ);
        bank.add(countryToZ);
        bank.add(zToCountry);
        bank.add(completeAction);
        bank.setVisible(false);
    }

	public void actionPerformed(ActionEvent e){
        countryToZ.setVisible(true);
        zToCountry.setVisible(false);
        conversionPanelZ();
    }

    public void conversionPanelZ(){
        countryToZ.removeAll();
        int start = country.length;
        JPanel jpanel[] = new JPanel[start];
        JButton jbutton[] = new JButton[start];
        JTextField jtextfield[] = new JTextField[start];
        JLabel jlabelrate[] = new JLabel[start];
        JLabel jlabelcountry[] = new JLabel[start];

        for(int a = 0; a < country.length; a++){
            jpanel[a] = new JPanel();
            jbutton[a] = new JButton("Purchase");
            jlabelcountry[a] = new JLabel(country[a]);
            jlabelrate[a] = new JLabel(conversionRate[a]+"");
            jtextfield[a] = new JTextField(10);
            JPanel countryList = jpanel[a];
            JButton purchase = jbutton[a];
            JLabel countryName = jlabelcountry[a];
            JLabel countryRate = jlabelrate[a];
            JTextField  countryValue = jtextfield[a];
            purchase.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Double zcoins = Double.parseDouble(countryValue.getText());
                        Double zCoinRate = Double.parseDouble(countryRate.getText());
                        convertToZcoin(zcoins, zCoinRate);
                    }
                }
            );
            countryList.setLayout(new FlowLayout());
            countryList.setPreferredSize(new Dimension(600,50));
            countryName.setPreferredSize(new Dimension(120,30));
            countryValue.setPreferredSize(new Dimension(120,30));
            countryRate.setPreferredSize(new Dimension(120,30));
            purchase.setPreferredSize(new Dimension(120,30));
            countryList.add(countryName);
            countryList.add(countryValue);
            countryList.add(countryRate);
            countryList.add(purchase);
            countryToZ.add(countryList);
        }

        countryToZ.validate();
        countryToZ.repaint();
    }

    public void convertToCurrency(){
        zToCountry.removeAll();
        int start = country.length;
        JPanel jpanel[] = new JPanel[start];
        JButton jbutton[] = new JButton[start];
        JTextField jtextfield[] = new JTextField[start];
        JLabel jlabelrate[] = new JLabel[start];
        JLabel jlabelcountry[] = new JLabel[start];

        for(int a = 0; a < country.length; a++){
            jpanel[a] = new JPanel();
            jbutton[a] = new JButton("Sell");
            jlabelcountry[a] = new JLabel(country[a]);
            jlabelrate[a] = new JLabel(conversionRate[a]+"");
            jtextfield[a] = new JTextField(10);
            JPanel countryList = jpanel[a];
            JButton sell = jbutton[a];
            JLabel countryName = jlabelcountry[a];
            JLabel countryRate = jlabelrate[a];
            JTextField  countryValue = jtextfield[a];
            sell.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Double zcoins = Double.parseDouble(countryValue.getText());
                        Double zCoinRate = Double.parseDouble(countryRate.getText());
                        convertToCountry(zcoins,zCoinRate);
                    }
                }
            );
            countryList.setLayout(new FlowLayout());
            countryList.setPreferredSize(new Dimension(600,50));
            countryName.setPreferredSize(new Dimension(120,50));
            countryValue.setPreferredSize(new Dimension(120,50));
            countryRate.setPreferredSize(new Dimension(120,50));
            sell.setPreferredSize(new Dimension(120,50));
            countryList.add(countryValue);
            countryList.add(countryRate);
            countryList.add(countryName);
            countryList.add(sell);
            zToCountry.add(countryList);
        }

        zToCountry.validate();
        zToCountry.repaint();
    }

    public void convertToZcoin(Double zc, Double zr){
        Double price = zc*zr;
        completeAction.setVisible(true);
        completeAction.setText("Purchase "+zc+" at a Rate of "+zr+" for a cost of "+price+" click here to complete");
        completeAction.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    completeAction.setVisible(false);
                }
            }
        );
        conversionPanelZ();
    }

    public void convertToCountry(Double zc, Double zr){
        Double price = zr*zc;
        completeAction.setVisible(true);
        completeAction.setText("Selling "+zc+" at a Rate of "+zr+" for a price of "+price+" click here to complete");
        completeAction.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    completeAction.setVisible(false);
                }
            }
        );
        conversionPanelZ();
    }
}//176
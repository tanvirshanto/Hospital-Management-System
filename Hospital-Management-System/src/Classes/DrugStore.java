package Classes;



import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;



class DrugStore extends JFrame{
		
	Connection conn=null;	
	DrugStore()
		{
			doStoreDrug();	
			conn=DatabaseConnect.dbConnector();
		}
		
		
		public void doStoreDrug(){
			
			try {

				setContentPane(new JLabel(new ImageIcon(
						ImageIO.read(new File("D:/background.JPG")))));
			}

			catch (IOException e) {
				System.out.println("nothing");
				;
				e.printStackTrace();
			}
			
			
			
			
			setLayout(null);
			
			JLabel hospitalLabel = new JLabel("ABC Hospital");
			hospitalLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			hospitalLabel.setBounds(190, 11, 197, 30);
			add(hospitalLabel);
			
			JLabel careLabel = new JLabel("We Care");
			careLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			careLabel.setBounds(295, 36, 92, 14);
			add(careLabel);
			
			JLabel drugLabel = new JLabel("Drug Information");
			drugLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			drugLabel.setBounds(10, 65, 135, 19);
			add(drugLabel);
			
			JLabel idLabel = new JLabel("Drug Id");
			idLabel.setBounds(10, 110, 63, 14);
			add(idLabel);
			
			JTextField idTextField = new JTextField();
			idTextField.setBounds(98, 110, 86, 20);
			add(idTextField);
			
			
			JLabel nameLabel = new JLabel("Drug Name");
			nameLabel.setBounds(10, 183, 63, 14);
			add(nameLabel);
			
			JTextField nameTextField = new JTextField();
			nameTextField.setBounds(98, 180, 86, 20);
			add(nameTextField);
			
			
			JLabel dateLabel = new JLabel("Purchase Date");
			dateLabel.setBounds(5, 249, 98, 14);
			add(dateLabel);
			
			JTextField dateTextField = new JTextField();
			dateTextField.setBounds(98, 246, 86, 20);
			add(dateTextField);
			
			
			JLabel typeLabel = new JLabel("Drug Type");
			typeLabel.setBounds(10, 314, 63, 14);
			add(typeLabel);
			
			String[] types={"--Select--","Tablet","Syrup"};
			JComboBox combo=new JComboBox(types);
			combo.setBounds(100,310,90,20);
			add(combo);
			
			
			
			JLabel expLabel = new JLabel("Exp Date");
			expLabel.setBounds(10, 375, 63, 14);
			add(expLabel);
			
			JTextField expTextField = new JTextField();
			expTextField.setBounds(98, 372, 86, 20);
			add(expTextField);
			
			
			
			JLabel priceLabel = new JLabel("Unit price");
			priceLabel.setBounds(10, 439, 63, 14);
			add(priceLabel);
			
			JTextField priceTextField = new JTextField();
			priceTextField.setBounds(98, 436, 86, 20);
			add(priceTextField);
		
		
			
			JLabel informLabel = new JLabel("Company Information");
			informLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			informLabel.setBounds(235, 63, 165, 23);
			add(informLabel);
			
			JLabel companyLabel = new JLabel("Company Name");
			companyLabel.setBounds(225, 116, 89, 14);
			add(companyLabel);
			
			JTextField companyTextField6 = new JTextField();
			companyTextField6.setBounds(320, 113, 86, 20);
			add(companyTextField6);
			
			
			JLabel adressLabel = new JLabel("Company Address");
			adressLabel.setBounds(210, 183, 113, 14);
			add(adressLabel);
			
			JTextField addressTextField7 = new JTextField();
			addressTextField7.setBounds(320, 180, 86, 20);
			add(addressTextField7);
			
			
			JLabel phnLabel = new JLabel("Phone no");
			phnLabel.setBounds(234, 249, 65, 14);
			add(phnLabel);
			
			JTextField phnTextField = new JTextField();
			phnTextField.setBounds(320, 246, 86, 20);
			add(phnTextField);
			
			
			JLabel mailLabel = new JLabel("Mail Address");
			mailLabel.setBounds(234, 314, 85, 14);
			add(mailLabel);
			
			JTextField mailTextField = new JTextField();
			mailTextField.setBounds(320, 311, 86, 20);
			add(mailTextField);
			
			
	
			
			
			
			JButton btnNewButton = new JButton("Add");
			btnNewButton.setBounds(27, 491, 89, 23);
			add(btnNewButton);
			
			
			btnNewButton.addActionListener(new ActionListener(){
				
				
				public void actionPerformed(ActionEvent d){
					
					
					 try{
							
String query="insert into drug_info(Drug_Id,Drug_Name,Purchase_Date,Drug_Type,Exp_Date,Unit_price,Company_Name,Company_Address,Phone_no,Mail_Address) values(?,?,?,?,?,?,?,?,?,?)";                                   
							
							
							PreparedStatement pst=conn.prepareStatement(query);
							pst.setString(1,idTextField.getText());
							pst.setString(2,nameTextField.getText());
							pst.setString(3,dateTextField.getText());
							pst.setString(4,combo.getSelectedItem().toString());
							pst.setString(5,expTextField.getText());
							pst.setString(6,priceTextField.getText());
							pst.setString(7,companyTextField6.getText());
							pst.setString(8,addressTextField7.getText());
							pst.setString(9,phnTextField.getText());
							pst.setString(10,mailTextField.getText());
							
							
							
							pst.execute();
							JOptionPane.showMessageDialog(null,"Saved");
							
							
					
						pst.close();
						
						idTextField.setText("");
						
						nameTextField.setText("");
						dateTextField.setText("");
						combo.setSelectedItem("--Select--");
					
					
						expTextField.setText("");
						priceTextField.setText("");
						
						companyTextField6.setText("");
						addressTextField7.setText("");
						phnTextField.setText("");
					
						mailTextField.setText("");
						
						}
						
						catch(Exception e)
					    {
							
							JOptionPane.showMessageDialog(null, "Please Fill The Text First");
						}
						
						
					   }
					 
				
				
				
				});
			
			
			
			
			
			JButton btnNewButton_1 = new JButton("Reset");
			btnNewButton_1.addActionListener(new ActionListener(){
				
				
				public void actionPerformed(ActionEvent a){
					

					idTextField.setText("");
					
					nameTextField.setText("");
					dateTextField.setText("");
					combo.setSelectedItem("--Select--");
				
				
					expTextField.setText("");
					priceTextField.setText("");
					
					companyTextField6.setText("");
					addressTextField7.setText("");
					phnTextField.setText("");
				
					mailTextField.setText("");
					
					
				}
				
				});
			
			
			
			
			
			btnNewButton_1.setBounds(135, 491, 89, 23);
			 add(btnNewButton_1);
			
			
			
	
			
			JButton btnNewButton_2 = new JButton("Main menu");
			
			
			btnNewButton_2.addActionListener(new ActionListener(){
				
				
				public void actionPerformed(ActionEvent a){
					
					MenuWindow nx = new MenuWindow();
					setVisible(false);	
					
					
				}
				
				});
			
			
			
			btnNewButton_2.setBounds(234, 491, 105, 23);
			
			
			
			add(btnNewButton_2);
			
			
			
			
			
			JButton btnNewButton_3 = new JButton("Exit");

			btnNewButton_3.addActionListener(new ActionListener(){
				
				
				public void actionPerformed(ActionEvent a){
					
					Welcome wobj = new Welcome();
					setVisible(false);	
					
					
				}
				
				});
			btnNewButton_3.setBounds(350, 491, 89, 23);
			add(btnNewButton_3);
			
			
		
			  setTitle("Drug Store");
			setSize(500,600);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			setVisible(true);
			
			
			
			
		}
		

}

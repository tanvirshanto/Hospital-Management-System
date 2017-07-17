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
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;



class StaffRegistration extends JFrame{
		
		Connection conn=null;
		StaffRegistration()
		{
			doRegist();	
			conn=DatabaseConnect.dbConnector();
		}
		
		
		
		
		public void doRegist(){
			
			
			try {

				setContentPane(new JLabel(new ImageIcon(
						ImageIO.read(new File("D:/background.JPG")))));
			}

			catch (IOException e) {
				System.out.println("nothing");
				e.printStackTrace();
			}
			
			
			
			setLayout(null);
			
			JLabel hospitalLabel=new JLabel("ABC HOSPITAL");
			hospitalLabel.setBounds(230, 5, 333, 27);
			hospitalLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			add(hospitalLabel);
			
			JLabel careLabel=new JLabel("WE CARE");
			careLabel.setBounds(350, 30, 333, 27);
			careLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			add(careLabel);
			
			
			JLabel stuffLabel = new JLabel("Stuff ID");
			stuffLabel.setBounds(26, 40, 46, 14);
			add(stuffLabel);
			
			JTextField stuffTextField = new JTextField();
			stuffTextField.setBounds(95, 40, 86, 20);
			add(stuffTextField);
			
			
			JLabel stuffTypeLabel = new JLabel("Stuff type");
			stuffTypeLabel.setBounds(25, 80, 65, 14);
			add(stuffTypeLabel);
			
            String[] items1={"--Select--","Regular","Irregular"};
			
			JComboBox itemsCombo1=new JComboBox(items1);
			itemsCombo1.setBounds(95, 80, 86, 20);
			add(itemsCombo1);
			
			
			JLabel personalLabel = new JLabel("Personal Details:");
			personalLabel.setBounds(25, 120, 120, 14);
			add(personalLabel);
			
			JLabel nameLabel = new JLabel("Name");
			nameLabel.setBounds(26, 151, 46, 14);
			add(nameLabel);
			
			JTextField nameTextField = new JTextField();
			nameTextField.setBounds(102, 148, 86, 20);
			add(nameTextField);
			
			
			JLabel ageLabel = new JLabel("Age");
			ageLabel.setBounds(26, 205, 46, 14);
			add(ageLabel);
			
			JTextField ageTextField = new JTextField();
			ageTextField.setBounds(102, 202, 86, 20);
			add(ageTextField);
			ageTextField.setColumns(10);
			
			JLabel birthLabel = new JLabel("Birth Date");
			birthLabel.setBounds(26, 255, 60, 40);
		    add(birthLabel);
			
			JTextField birthTextField = new JTextField();
			birthTextField.setBounds(102, 263, 86, 20);
			add(birthTextField);
			
			
			JLabel religionLabel = new JLabel("Religion");
			religionLabel.setBounds(26, 320, 46, 14);
			add(religionLabel);
			
			JTextField religionTextField = new JTextField();
			religionTextField.setBounds(102, 317, 86, 20);
			add(religionTextField);
			
			
			JLabel genderLabel = new JLabel("Gender");
			genderLabel.setBounds(26, 374, 46, 14);
			add(genderLabel);
			

			String[] items={"--Select--","Male","Female"};
			
			JComboBox itemsCombo2=new JComboBox(items);
			itemsCombo2.setBounds(102, 371, 86, 20);
			add(itemsCombo2);
			
			
			

			
			
			
			JLabel bloodLabel = new JLabel("Blood group");
			bloodLabel.setBounds(26, 429, 70, 14);
			add(bloodLabel);
			
			JTextField bloodTextField = new JTextField();
			bloodTextField.setBounds(102, 426, 86, 20);
			add(bloodTextField);
		
			
			JLabel maritalLabel = new JLabel("Marital Status");
			maritalLabel.setBounds(20, 495, 85, 14);
			add(maritalLabel);
			
			JTextField maritalTextField = new JTextField();
			maritalTextField.setBounds(102, 492, 86, 20);
			add(maritalTextField);
			
			
			JLabel salaryLabel = new JLabel("Salary");
			salaryLabel.setBounds(252, 151, 46, 14);
			add(salaryLabel);
			
			JTextField salaryTextField = new JTextField();
			salaryTextField.setBounds(308, 145, 86, 20);
			add(salaryTextField);
			
			
			JLabel addressLabel = new JLabel("Address");
			addressLabel.setBounds(245, 205, 65, 14);
			add(addressLabel);
			
			JTextField addressTextField = new JTextField();
			addressTextField.setBounds(308, 202, 86, 20);
			add(addressTextField);
			
			
			JLabel phoneLabel = new JLabel("phone");
			phoneLabel.setBounds(252, 269, 46, 14);
			add(phoneLabel);
			
			JTextField phnTextField = new JTextField();
			phnTextField.setBounds(308, 266, 86, 20);
			add(phnTextField);
			
			
			
			
			
			
			
			
			JButton addButton = new JButton("Add");
			addButton.setBounds(10, 546, 89, 23);
			add(addButton);
			
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ar) {
					
				
	                try{
						
	                	
	                	
						String query="insert into staff_info(staff_ID,staff_type,Name,Age,Birthdate,Religion,Gender,Blood_Group,Marital_Status,"
								+ "Salary,Address,phone) values(?,?,?,?,?,?,?,?,?,?,?,?)";                                   
					
						
						PreparedStatement pst=conn.prepareStatement(query);
						pst.setString(1,stuffTextField.getText());
						pst.setString(2,itemsCombo1.getSelectedItem().toString());
						pst.setString(3,nameTextField.getText());
						pst.setString(4,ageTextField.getText());
						pst.setString(5,birthTextField.getText());
						pst.setString(6,religionTextField.getText());
						pst.setString(7,itemsCombo2.getSelectedItem().toString());
						pst.setString(8,bloodTextField.getText());
						pst.setString(9,maritalTextField.getText());
						pst.setString(10,salaryTextField.getText());
						pst.setString(11,addressTextField.getText());
						pst.setString(12,phnTextField.getText());
						
						
						
						pst.execute();
						JOptionPane.showMessageDialog(null,"Saved Data Successfully");
						
					pst.close();

					
					stuffTextField.setText("");
					itemsCombo1.setSelectedItem("Regular");
					nameTextField.setText("");
					ageTextField.setText("");
					birthTextField.setText("");
					
					religionTextField.setText("");
					itemsCombo2.setSelectedItem("Male");
					
					bloodTextField.setText("");
					maritalTextField.setText("");
					salaryTextField.setText("");
					addressTextField.setText("");
					phnTextField.setText("");
					
					}
					
					catch(Exception e){
						
						//JOptionPane.showMessageDialog(null, e);
						JOptionPane.showMessageDialog(null, "Please Fill all the Fields");
						
						
					}
					
					
				}
			});
			
			

			JButton buttonReset = new JButton("Reset");
			buttonReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ar) {
					
	                try{
						
						
					
	                	stuffTextField.setText("");
	                	itemsCombo1.setSelectedItem("--Select--");
	                	nameTextField.setText("");
	                	ageTextField.setText("");
	                	birthTextField.setText("");
						
	                	religionTextField.setText("");
						
	                	itemsCombo2.setSelectedItem("--Select--");
						
	                	bloodTextField.setText("");
	                	maritalTextField.setText("");
	                	salaryTextField.setText("");
	                	addressTextField.setText("");
	                	phnTextField.setText("");
						
						
						
				
					
					
					}
					
					catch(Exception e){
						
						JOptionPane.showMessageDialog(null, e);
						
						
					}
					
					
				}
			});
			
			
			
			buttonReset.setBounds(123, 546, 89, 23);
			add(buttonReset);
			
			JButton buttonMainMenu = new JButton("Main menu");
			
			buttonMainMenu.addActionListener(new ActionListener(){
				
				
				public void actionPerformed(ActionEvent a){
					
					MenuWindow nx = new MenuWindow();
					setVisible(false);	
					
					
				}
				
				});
			
			
			
			
			
			
			buttonMainMenu.setBounds(230, 546, 100, 23);
			add(buttonMainMenu);
			
			JButton buttonExit = new JButton("Exit");
			buttonExit.addActionListener(new ActionListener(){
				
				
				public void actionPerformed(ActionEvent a){
					
					Welcome wp = new Welcome();
					
					setVisible(false);	
					
					
				}
				
				});
			
			
			
			
			
			
			buttonExit.setBounds(345, 546, 89, 23);
			


			add(buttonExit);
			
		     
			
			
			
			
			
			
			setTitle("Staff Rgistration");
			setSize(500,650);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			setVisible(true);
			
			
			
			
		}
		

}

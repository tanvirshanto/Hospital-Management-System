package Classes;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Choice;
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



class PatientRegistration extends JFrame{
		
		Connection conn=null;
	PatientRegistration()
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
				;
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
			
			JLabel idLabel = new JLabel("Patient ID");
			idLabel.setBounds(26, 40, 65, 14);
			add(idLabel);
			
			JTextField	idTextField = new JTextField();
			idTextField.setBounds(82, 40, 86, 20);
			add(idTextField);
			
			
			JLabel typeLabel = new JLabel("Patient type");
			typeLabel.setBounds(10, 80, 90, 14);
			add(typeLabel);
			
             String[] items1={"--Select--","Vip","Normal"};
			
			JComboBox jcombo1=new JComboBox(items1);
			jcombo1.setBounds(82, 80, 86, 20);
			add(jcombo1);
			
			
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
			
			JTextField ageText = new JTextField();
			ageText.setBounds(102, 202, 86, 20);
			add(ageText);
			
			
			JLabel gendeLabel = new JLabel("Gender");
			gendeLabel.setBounds(26, 255, 60, 40);
		    add(gendeLabel);
			
	        String[] items={"--Select--","Male","Female"};
			
			JComboBox jcombo=new JComboBox(items);
			jcombo.setBounds(102, 263, 86, 20);
			add(jcombo);
			
			
			JLabel birthLabel = new JLabel("Birth Date");
			birthLabel.setBounds(20, 320, 80, 14);
			add(birthLabel);
			
			JTextField birthTextField = new JTextField();
			birthTextField.setBounds(102, 317, 86, 20);
			add(birthTextField);
			
			
			JLabel ocuLabel = new JLabel("Occupation");
			ocuLabel.setBounds(26, 374, 65, 14);
			add(ocuLabel);
			
			JTextField ocuTextField = new JTextField();
			
			ocuTextField.setBounds(102, 374, 86, 20);
			add(ocuTextField);
		
			
			

		    JLabel refLabel = new JLabel("REF By");
		    refLabel.setBounds(26, 429, 70, 14);
			add(refLabel);
			
			JTextField refTextField = new JTextField();
			refTextField.setBounds(102, 426, 86, 20);
			add(refTextField);
			
			JLabel addressLabel = new JLabel("Address");
			addressLabel.setBounds(20, 495, 85, 14);
			add(addressLabel);
			
			JTextField adressText = new JTextField();
			adressText.setBounds(102, 492, 86, 20);
			add(adressText);
		
			
			JLabel phoneLabel = new JLabel("phone");
			phoneLabel.setBounds(252, 151, 46, 14);
			add(phoneLabel);
			
			JTextField phoneTextField = new JTextField();
			phoneTextField.setBounds(308, 145, 86, 20);
			add(phoneTextField);
	
			
			
			JLabel emegencyLabel=new JLabel("Emergency Contact Person");
			emegencyLabel.setBounds(280,250,180,20);
			add(emegencyLabel);
			
			
			
			JLabel renameLabel = new JLabel("Name");
			renameLabel.setBounds(252, 280, 46, 14);
			add(renameLabel);
			
			JTextField nameTextField1 = new JTextField();
			nameTextField1.setBounds(308, 280, 86, 20);
			add(nameTextField1);
			
			
			
			JLabel phoneLabel1 = new JLabel("phone");
			phoneLabel1.setBounds(252, 320, 46, 14);
			add(phoneLabel1);
			
			JTextField phoneTextField1 = new JTextField();
			phoneTextField1.setBounds(308, 320, 86, 20);
			add(phoneTextField1);
			
			
			
			JLabel relatioLabel = new JLabel("Relation");
			relatioLabel.setBounds(252, 360, 46, 14);
			add(relatioLabel);
			
			JTextField relationText1 = new JTextField();
			relationText1.setBounds(308, 360, 86, 20);
			add(relationText1);
			
			
			
			
			JButton addButton = new JButton("Add");
			addButton.setBounds(10, 546, 89, 23);
			add(addButton);
			
			addButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent ar)
				{
					
					
					
					 try{
							
String query1="insert into patientinfo(Patient_ID,Patient_type,Name,Age,Gender,Birth_Date,Occupation,REF_By,Address,phone,Person_Name,Contact_No,Relation) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";                                   
							
							
							PreparedStatement pst=conn.prepareStatement(query1);
							pst.setString(1,idTextField.getText());
							pst.setString(2,jcombo1.getSelectedItem().toString());
							pst.setString(3,nameTextField.getText());
							pst.setString(4,ageText.getText());
							pst.setString(5,jcombo.getSelectedItem().toString());
							pst.setString(6,birthTextField.getText());
							pst.setString(7,ocuTextField.getText());
							pst.setString(8,refTextField.getText());
							pst.setString(9,adressText.getText());
							pst.setString(10,phoneTextField.getText());
							pst.setString(11,nameTextField1.getText());
							pst.setString(12,phoneTextField1.getText());
							pst.setString(13,relationText1.getText());
							
							
							
							
							pst.execute();
							JOptionPane.showMessageDialog(null,"Saved");
							
							
						//rs.close();
						pst.close();
						

						idTextField.setText("");
						jcombo1.setSelectedItem("--Select--");
						nameTextField.setText("");
						ageText.setText("");
						jcombo.setSelectedItem("--Select--");
					
						birthTextField.setText("");
						ocuTextField.setText("");
						
						refTextField.setText("");
						adressText.setText("");
						phoneTextField.setText("");
					
						nameTextField1.setText("");
						phoneTextField1.setText("");
						relationText1.setText("");
						
						
						
						}
						
						catch(Exception e){
							
							JOptionPane.showMessageDialog(null, "Please Fill The Text First");
						}
						
						
					}
					
			});
			
			
			JButton resetButton = new JButton("Reset");
			resetButton.setBounds(123, 546, 89, 23);
			
			resetButton.addActionListener(new ActionListener(){
				
				
				public void actionPerformed(ActionEvent a){
					
					idTextField.setText("");
					jcombo1.setSelectedItem("--Select--");
					nameTextField.setText("");
					ageText.setText("");
					jcombo.setSelectedItem("--Select--");
				
					birthTextField.setText("");
					ocuTextField.setText("");
					
					refTextField.setText("");
					adressText.setText("");
					phoneTextField.setText("");
				
					nameTextField1.setText("");
					phoneTextField1.setText("");
					relationText1.setText("");
						
					
					
				}
				
				});
			
			
			
			
			add(resetButton);
			
			
			
			
			
			JButton menuButton = new JButton("Main menu");
			
			menuButton.addActionListener(new ActionListener(){
				
				
				public void actionPerformed(ActionEvent a){
					
					MenuWindow nx = new MenuWindow();
					setVisible(false);	
					
					
				}
				
				});
			
			
			menuButton.setBounds(230, 546, 100, 23);
			add(menuButton);
			
			
			
			
			JButton exitButton = new JButton("Exit");
			exitButton.addActionListener(new ActionListener(){
					
					
					public void actionPerformed(ActionEvent a){
						
						Welcome wobj = new Welcome();
						setVisible(false);	
						
						
					}
					
					});
			
			
			
			exitButton.setBounds(345, 546, 89, 23);
			add(exitButton);
			
			
		
		
			  setTitle("Patient Rgistration");
			setSize(500,650);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			setVisible(true);
			
			
			
			
		}
		

}

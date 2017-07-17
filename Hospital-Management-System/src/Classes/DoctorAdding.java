package Classes;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;




class DoctorAdding extends JFrame{
		
		Connection conn=null;
		DoctorAdding()
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
			
			JLabel idLabel = new JLabel("Dr. ID");
			idLabel.setBounds(28, 44, 46, 14);
			add(idLabel);
			
			JTextField idTextField = new JTextField();
			idTextField.setBounds(97, 41, 86, 20);
		     add(idTextField);
			
			
			JLabel nameLabel = new JLabel("Dr.Name");
			nameLabel.setBounds(28, 91, 85, 14);
			add(nameLabel);
			
			
		
			JTextField nameTextField = new JTextField();
			nameTextField.setBounds(97, 88, 86, 20);
			add(nameTextField);
			
			
			JLabel timeLabel = new JLabel("Visit Time");
			timeLabel.setBounds(28, 150, 85, 14);
			add(timeLabel);
			
			JTextField timeTextField_2 = new JTextField();
			timeTextField_2.setBounds(97, 147, 86, 20);
			add(timeTextField_2);
			
			JLabel feeLabel = new JLabel("Visit Fee");
			feeLabel.setBounds(28, 215, 85, 14);
			add(feeLabel);
			
		
			JTextField feeTextField_3 = new JTextField();
			feeTextField_3.setBounds(97, 212, 86, 20);
			add(feeTextField_3);
			
			
		
			
			
			JLabel specialLabel = new JLabel("Specialist");
			specialLabel.setBounds(273, 70, 85, 14);
			add(specialLabel);
			
			JTextField specialTextField_4 = new JTextField();
			specialTextField_4.setBounds(341, 67, 86, 20);
			add(specialTextField_4);
			
			
			JLabel roomLabel = new JLabel("Room No");
			roomLabel.setBounds(273, 100, 85, 14);
			add(roomLabel);
			
			JTextField roomTextField_5 = new JTextField();
			roomTextField_5.setBounds(341, 98, 86, 20);
			add(roomTextField_5);
			
			
			JButton saveButton = new JButton("Save");
			saveButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent ar)
				{
					
					
					
					 try{
							
String query1="insert into  dr_room_information(Dr_ID,Dr_Name,Visit_time,Visit_Fee,Specialist,Room_No) values(?,?,?,?,?,?)";                                   
							
							
							PreparedStatement pst=conn.prepareStatement(query1);
							pst.setString(1,idTextField.getText());
							pst.setString(2,nameTextField.getText());
							pst.setString(3,timeTextField_2.getText());
							pst.setString(4,feeTextField_3.getText());
							pst.setString(5,specialTextField_4.getText());
							pst.setString(6,roomTextField_5.getText());
							
							
							
							
							pst.execute();
							JOptionPane.showMessageDialog(null,"Saved");
							
							
						//rs.close();
						pst.close();
						

					
						
						idTextField.setText("");
						nameTextField.setText("");
						timeTextField_2.setText("");
					
						feeTextField_3.setText("");
						specialTextField_4.setText("");
						roomTextField_5.setText("");
						
						
						
						}
						
						catch(Exception e){
							
							JOptionPane.showMessageDialog(null, "Please Fill The Text First");
						}
						
						
					}
					
			});
			
			
			
			
			saveButton.setBounds(28, 278, 89, 23);
			add(saveButton);
			
			
			JButton resetButton = new JButton("Reset");
			resetButton.addActionListener(new ActionListener(){
				
				
				public void actionPerformed(ActionEvent a){
					

					idTextField.setText("");
					nameTextField.setText("");
					timeTextField_2.setText("");
				
					feeTextField_3.setText("");
					specialTextField_4.setText("");
					roomTextField_5.setText("");
					
					
				}
				
				});
			
			
			resetButton.setBounds(174, 278, 89, 23);
			add(resetButton);
			

			JButton backButton = new JButton("Back");
			backButton.addActionListener(new ActionListener(){
					
					
					public void actionPerformed(ActionEvent a){
						
						RoomInformation room = new RoomInformation();
						setVisible(false);	
						
						
					}
					
					});
			backButton.setBounds(341, 278, 89, 23);
			add(backButton);
			
			
		
			
			
			
		
			  setTitle("Doctor Rgistration");
			setSize(500,400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			setVisible(true);
			
			
			
			
		}
		

}

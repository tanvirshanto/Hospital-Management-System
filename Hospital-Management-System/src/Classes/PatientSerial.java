package Classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PatientSerial extends JFrame {
	Connection conn=null;
	{
		addSerial();
		conn=DatabaseConnect.dbConnector();
	}
	
	

	
	public void addSerial(){
		
		setLayout(null);
		
		
		try {

			setContentPane(new JLabel(new ImageIcon(
					ImageIO.read(new File("D:/blank-yellow-sheet-paper-pencil-6080919.JPG")))));
		}

		catch (IOException e) {
			System.out.println("nothing");
			;
			e.printStackTrace();
		}
		
		
		
		
		
		
		JLabel serialLabel = new JLabel("Serial No");
		serialLabel.setBounds(28, 91, 65, 14);
		add(serialLabel);
		
		JTextField	serialTextField = new JTextField();
		serialTextField.setBounds(97, 88, 86, 20);
		add(serialTextField);
		

		JLabel nameLabel = new JLabel("Dr.Name");
		nameLabel.setBounds(28, 150, 65, 14);
		add(nameLabel);
		
		JTextField	nameTextField_2 = new JTextField();
		nameTextField_2.setBounds(97, 147, 86, 20);
		add(nameTextField_2);
	
		
		
		
		JLabel patientLabel = new JLabel("Patient Name");
		patientLabel.setBounds(15, 226, 110, 14);
		add(patientLabel);

		JTextField	patientTextField_3 = new JTextField();
		patientTextField_3.setBounds(97, 223, 86, 20);
		add(patientTextField_3);
		
		JButton okButton=new JButton("ok");
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ar) {
				
				
                try{
					
					String query="insert into Serial_No(Serial_No,Dr_Name,Patient_Name) values(?,?,?)";                                   
					
					
					
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,serialTextField.getText());
					
					pst.setString(2,nameTextField_2.getText());
					pst.setString(3,patientTextField_3.getText());
					
					
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null,"Saved");
					
				pst.close();

				
				serialTextField.setText("");
				
				nameTextField_2.setText("");
				patientTextField_3.setText("");
				
				
				}
				
				catch(Exception e){
					
					//JOptionPane.showMessageDialog(null, e);
					JOptionPane.showMessageDialog(null,"This Serial Has Taken or The Text is Unfilled");
					
					
				}
				
				
			}
		});
		
		
	
		
		okButton.setBounds(110,270,65,20);
		add(okButton);
		
		
		JButton backButton=new JButton("Back");
		backButton.setBounds(220,270,65,20);
		add(backButton);
		backButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae) {
				
				
				RoomInformation roominfo=new RoomInformation();
				
				
				setVisible(false);
			}
		});
		backButton.setBounds(220,270,65,20);
		add(backButton);
		
		
		
		
		setTitle("Serial");
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

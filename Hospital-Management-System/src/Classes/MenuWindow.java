package Classes;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

class  MenuWindow extends JFrame{
	
	
	MenuWindow(){ 
		nextDesign();
	}
	
	public void nextDesign(){
		
		
		setLayout(null);
		
		
		
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:/338238-hospital.JPG")))));
		} 
	 
	 catch (IOException e)
	   {
		System.out.println("nothing");;
			e.printStackTrace();
		}
		
		
		
		
		JButton staffButton=new JButton("Staff Registration");
		 
		staffButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					StaffRegistration reg=new StaffRegistration();
					
					setVisible(false);
				}
			});
		
		JButton patientButton=new JButton("Patient Registration");
		patientButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae) {
				PatientRegistration reg=new PatientRegistration();
				
				setVisible(false);
			}
		});
		 
		 
		 
		 JButton drugButton=new JButton("Drug Store");
		 
		 drugButton.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent ae) {
					DrugStore reg=new DrugStore();
					
					setVisible(false);
				}
			});
		 
		 
		 JButton staffDetailsButton=new JButton("Staff Details");

		 staffDetailsButton.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent ae) {
					ShowStaffs staff=new ShowStaffs();
					
					setVisible(false);
				}
			});
		 
		 
		 
		 
		 
		 
		 
		 JButton patientDetailsButton=new JButton("Patient Details");
		 
		 patientDetailsButton.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent ae) {
					ShowPatient ShowPatientobj =new ShowPatient();
					
					setVisible(false);
				}
			});
		 
		 
		 
	 JButton showDrugButton=new JButton("Drug Details");
	 
	 
	 showDrugButton.addActionListener(new ActionListener(){
					
					public void actionPerformed(ActionEvent ae) {
						ShowDrugs drugs =new ShowDrugs();
						
						setVisible(false);
					}
				});
		 
		 
	
		 
	 JButton billButton=new JButton("Billing Process");

	 billButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae) {
				BillingInformation bill=new BillingInformation();
				
				setVisible(false);
			}
		});
	 
	 
	 
	 
	 
	 
		 
		 
		 JButton roomButton=new JButton("Room Info");

		 roomButton.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent ae) {
					
					
					RoomInformation romminfrm=new RoomInformation();
					
					
					setVisible(false);
				}
			});
		 
			
			
			
			
			JButton serialInfoButton=new JButton("Show Patient Serials");

			serialInfoButton.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent ae) {
					
					PatientSerialInfo pt=new PatientSerialInfo();
					
					setVisible(false);
				}
			});
		 
			
			
			
			JButton logButton=new JButton("Log Out");
			
			logButton.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent ae) {
					
					
					Welcome wc=new Welcome();
					
					
					setVisible(false);
				}
			});
			
			
			
			
			JLabel labelName = new JLabel("ABC HOSPITAL");
			labelName.setFont(new Font("Tahoma", Font.BOLD, 25));

			JLabel labelTitle = new JLabel("we Care");
			labelTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
			
			labelTitle.setForeground(Color.black);
		 
		 
	
		     
		 
		 add(staffButton);
		 add(patientButton);
		 add(drugButton);
		 add(staffDetailsButton);
		 add(patientDetailsButton);
		 add(roomButton);
		 add(showDrugButton);
		 add(billButton);
		 add(labelName);
		 add(labelTitle);
		 add(serialInfoButton);
		 add(logButton);
		 
		 
		 
		    labelName.setBounds(400,2,400,60);
            labelTitle.setBounds(470, 30, 200, 60);
            
            
            staffButton.setBounds(20, 50, 170, 30);
            staffButton.setFont(new Font("Tahoma", Font.BOLD, 15));

            patientButton.setBounds(10, 120, 190, 30);
            patientButton.setFont(new Font("Tahoma", Font.BOLD, 15));

            drugButton.setBounds(20, 190, 170, 30);
            drugButton.setFont(new Font("Tahoma", Font.BOLD, 15));

            staffDetailsButton.setBounds(20, 260, 170, 30);
			staffDetailsButton.setFont(new Font("Tahoma", Font.BOLD, 15));

			patientDetailsButton.setBounds(20, 330, 170, 30);
			patientDetailsButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			showDrugButton.setBounds(20, 400, 170, 30);
			showDrugButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			billButton.setBounds(20, 470, 180, 30);
			billButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			

			roomButton.setBounds(20, 540, 170, 30);
			roomButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			serialInfoButton.setBounds(20, 610, 200, 30);
			serialInfoButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			logButton.setBounds(700, 605, 170, 30);
			logButton.setFont(new Font("Tahoma", Font.BOLD, 15));
	
		 
		 
		 
			
			
		
			
			
			
			
			
		 
     setTitle("Main Menu");
	setSize(900,690);
     
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	setVisible(true);
	}
}

		
	
package Classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.sql.*;

public class ShowPatient extends JFrame {
	
	JTable table;
	
	Connection conn=null;
	
	ShowPatient()
	{
		ShowDetails();
		 conn=DatabaseConnect.dbConnector();
	}
	
	
	public void refreshTable(){
		
		
		 try{
  		   
  		   String query="select * from patientinfo";
  		   PreparedStatement pst= conn.prepareStatement(query);
  		   ResultSet rs=pst.executeQuery();
  		   table.setModel(DbUtils.resultSetToTableModel(rs));
  		   pst.close();
  		   rs.close();
  		   
  		   
  		   
  		   
  	   }
  	   
  	   
     catch(Exception e){
  	   
  	   JOptionPane.showMessageDialog(null, e);
  	   
  	   
     }
	    
			
			
		}
		
		
		
		
		

	
	

	
	public void ShowDetails(){
		
		try {

			setContentPane(new JLabel(new ImageIcon(
					ImageIO.read(new File("D:/blank-yellow-sheet-paper-pencil-6080919.JPG")))));
		}

		catch (IOException e) {
			System.out.println("nothing");
			;
			e.printStackTrace();
		}
		setLayout(null);
		
		 table=new JTable();
		
		table.setBounds(226, 120, 1000, 300);
		
		
		add(table);
		
		
		
		JLabel idLabel=new JLabel("Patient ID");
		idLabel.setBounds(226,100,85,20);
		add(idLabel);
		
		JLabel typeLable=new JLabel("Patient type");
		typeLable.setBounds(310,100,85,20);
		add(typeLable);
		
		JLabel rnamelabel=new JLabel("Name");
		rnamelabel.setBounds(394,100,40,20);
		add(rnamelabel);
		
		JLabel ragelabel=new JLabel("Age");
		ragelabel.setBounds(478,100,45,20);
		add(ragelabel);
		
		JLabel gendeLabel=new JLabel("Gender");
		gendeLabel.setBounds(530,100,85,20);
		add(gendeLabel);
		
		JLabel birthLabel=new JLabel("Birth Date");
		birthLabel.setBounds(610,100,85,20);
		add(birthLabel);
		
		JLabel ocLabel=new JLabel("Occupation");
		ocLabel.setBounds(690,100,100,20);
		add(ocLabel);
		
		JLabel refLabeel=new JLabel("Ref By");
		refLabeel.setBounds(770,100,85,20);
		add(refLabeel);
		
		JLabel addressLabel=new JLabel("Address");
		addressLabel.setBounds(850,100,60,20);
		add(addressLabel);
		
		JLabel phLabel=new JLabel("phone");
		phLabel.setBounds(940,100,60,20);
		add(phLabel);
		
		JLabel personNameLabel=new JLabel("Person Name");
		personNameLabel.setBounds(990,100,85,20);
		add(personNameLabel);
		
		JLabel noLabel=new JLabel("Contact No");
		noLabel.setBounds(1070,100,85,20);
		add(noLabel);
		
		
		JLabel relateLabel=new JLabel("Relation");
		relateLabel.setBounds(1150,100,85,20);
		add(relateLabel);
	
	///////////////////////////////////////////////////////////////////////////////////
		
		JLabel patienIdLabel = new JLabel("Patient ID");
		patienIdLabel.setBounds(26, 40, 85, 14);
		add(patienIdLabel);
		
		JTextField	idTextField = new JTextField();
		idTextField.setBounds(98, 40, 86, 20);
		add(idTextField);
		
		
		JLabel typeLabel = new JLabel("Patient type");
		typeLabel.setBounds(20, 85, 85, 14);
		add(typeLabel);
		
        String[] items1={"--Select--","vip","normal"};
		
		JComboBox jcombo1=new JComboBox(items1);
		jcombo1.setBounds(98, 85, 86, 20);
		add(jcombo1);
		
		
		JLabel detailsLabel = new JLabel("Personal Details:");
		detailsLabel.setBounds(25, 120, 120, 14);
		add(detailsLabel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(26, 151, 46, 14);
		add(nameLabel);
		
		JTextField nameTextField = new JTextField();
		nameTextField.setBounds(102, 148, 86, 20);
		add(nameTextField);
		
		
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setBounds(26, 180, 46, 14);
		add(ageLabel);
		
		JTextField ageTextField = new JTextField();
		ageTextField.setBounds(102, 180, 86, 20);
		add(ageTextField);
		
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setBounds(26, 210, 60, 40);
	    add(genderLabel);
        
	    String[] items={"--Select--","Male","Female"};
		
		JComboBox jcombo=new JComboBox(items);
		jcombo.setBounds(102, 220, 86, 20);
		add(jcombo);
		
		
		JLabel birthDateLabel = new JLabel("Birth Date");
		birthDateLabel.setBounds(26, 260, 85, 14);
		add(birthDateLabel);
		
		JTextField birthDateText = new JTextField();
		birthDateText.setBounds(102, 260, 86, 20);
		add(birthDateText);
		
		
		JLabel ocuLabel = new JLabel("Occupation");
		ocuLabel.setBounds(20, 300, 85, 14);
		add(ocuLabel);
		
		JTextField occupationText_Field = new JTextField();
		occupationText_Field.setBounds(102, 300, 86, 20);
		add(occupationText_Field);
		
	
		
		JLabel refLabel = new JLabel("Ref By");
		refLabel.setBounds(20, 340, 70, 14);
		add(refLabel);
		
		JTextField refTextField = new JTextField();
		refTextField.setBounds(102, 340, 86, 20);
		add(refTextField);
		
		
		JLabel adressLabel = new JLabel("Address");
		adressLabel.setBounds(20, 380, 85, 14);
		add(adressLabel);
		
		JTextField addressText = new JTextField();
		addressText.setBounds(102, 380, 86, 20);
		add(addressText);
		
		
		JLabel phoneLabel = new JLabel("phone");
		phoneLabel.setBounds(20, 420, 46, 14);
		add(phoneLabel);
		
		JTextField phnTextField = new JTextField();
		phnTextField.setBounds(102, 420, 86, 20);
		add(phnTextField);
		
		JLabel emerLabel=new JLabel("Emergeny Contact Person");
		emerLabel.setBounds(20,460,150,20);
		add(emerLabel);
		
		
		JLabel personLabel = new JLabel("Person Name");
		personLabel.setBounds(20, 500, 85, 14);
		add(personLabel);
		
		JTextField personText = new JTextField();
		personText.setBounds(102, 500, 86, 20);
		add(personText);
		
		
		JLabel contactLabel = new JLabel("Contact No");
		contactLabel.setBounds(20, 540, 85, 14);
		add(contactLabel);
		
		JTextField contactText = new JTextField();
		contactText.setBounds(102, 540, 86, 20);
		add(contactText);
		
		
		
		
		JLabel labelRelation = new JLabel("Relation");
		labelRelation.setBounds(20, 580, 46, 14);
		add(labelRelation);
		
		JTextField relationTextField = new JTextField();
		relationTextField.setBounds(102, 580, 86, 20);
		add(relationTextField);
		

		JButton searchButton=new JButton("Search by name");
		searchButton.setBounds(800,50,130,25);
		add(searchButton);
		
		JTextField SearchTextField=new JTextField();
		SearchTextField.setBounds(950,50,86,25);
		add(SearchTextField);
		
		searchButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent a) 
			{
				
				  
		    	   try{
		    		   
		    		   String query1="select * from patientinfo  where Name='"+SearchTextField.getText()+"'";
		    		   PreparedStatement pst=conn.prepareStatement(query1);
		    		  
		    		   ResultSet rs=pst.executeQuery();
		    		   table.setModel(DbUtils.resultSetToTableModel(rs));
		    	
		    	   }
		    	   
		    	   
		       catch(Exception e){
		    	   
		    	   JOptionPane.showMessageDialog(null, e);
		    	   
		    	   
		       }
		       
			
			}
		
			
		});
		
		
table.addMouseListener(new MouseAdapter(){
			
			
			public void mouseClicked(MouseEvent ar)
			
			{
				try{
					
					int row=table.getSelectedRow();
					String Patient_ID=(table.getModel().getValueAt(row, 0)).toString();
					 String query1="select * from patientinfo  where Patient_ID='"+Patient_ID+"'";
		    		   PreparedStatement pst=conn.prepareStatement(query1);
		    		  
		    		   ResultSet rs=pst.executeQuery();
		    		  
		    		  while(rs.next()){
		    		


		    			  idTextField.setText(rs.getString("Patient_ID"));
							jcombo1.setSelectedItem(rs.getString("Patient_type"));;
							nameTextField.setText(rs.getString("Name"));
							ageTextField.setText(rs.getString("Age"));
							jcombo.setSelectedItem(rs.getString("Gender"));;
							
							birthDateText.setText(rs.getString("Birth_Date"));
							occupationText_Field.setText(rs.getString("Occupation"));
							
							refTextField.setText(rs.getString("REF_By"));
							addressText.setText(rs.getString("Address"));
							phnTextField.setText(rs.getString("phone"));

							personText.setText(rs.getString("Person_Name"));
							contactText.setText(rs.getString("Contact_No"));
							relationTextField.setText(rs.getString("Relation"));
		    			  

					
		    		  }
					
					
					pst.close();

				
				}
				
				   
			       catch(Exception e){
			    	   
			    	   JOptionPane.showMessageDialog(null, e);
			    	   
			    	   
			       }
			
			}});
		
		
		
                   try{
                	  
                	   
         Class.forName("com.mysql.jdbc.Driver");
	   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/log_info","root","");
	   String query="select * from patientinfo";
	   PreparedStatement pst= conn.prepareStatement(query);
	    ResultSet rs=pst.executeQuery();
	   table.setModel(DbUtils.resultSetToTableModel(rs));
	   pst.close();
	   rs.close();
	   
	   
	   
	   
                    }


                     catch(Exception e){

                       JOptionPane.showMessageDialog(null, e);


                                          }
		
		
		
		
		
		
		
		
		
	
		
		
		
				JButton loadButton =new JButton("Load Patient Data");
				
				loadButton.addActionListener(new ActionListener()
						{
					       public void actionPerformed(ActionEvent g){
					    	   
					    	   refreshTable();
					       
					
					                  }});
				
				
				
				
				
				loadButton.setBounds(500,50,150,25);
				add(loadButton);
				
				
				JButton updateButton=new JButton("Update");
				updateButton.setBounds(400,430,100,20);
				updateButton.addActionListener(new ActionListener()
				{
			       public void actionPerformed(ActionEvent g){
			    	   
			    	   try{
			    		   
			    		   if(!idTextField.getText().equals("")){
			    		   String query = "Update patientinfo set Patient_ID=' "+idTextField.getText()+" ', Patient_type=' "+jcombo1.getSelectedItem().toString()+" ',Name=' "+nameTextField.getText()+" ',Age=' "+ageTextField.getText()+" ',Gender=' "+jcombo.getSelectedItem().toString()+" ',Birth_Date=' "+birthDateText.getText()+" ',Occupation=' "+occupationText_Field.getText()+" ',REF_By=' "+refTextField.getText()+" ',Address=' "+addressText.getText()+" ',phone=' "+phnTextField.getText()+" ',Person_Name=' "+personText.getText()+" ',Contact_No=' "+contactText.getText()+" ',Relation=' "+relationTextField.getText()+" ' where Patient_ID='"+idTextField.getText()+"'";
			    		 
			    		   PreparedStatement pst=conn.prepareStatement(query);
			    		  
			    		     
			    		     pst.execute();
			    		   
			    		     JOptionPane.showMessageDialog(null, "Updated Successfully");
			    		     pst.close();
			    		        
			    		        
			    		     idTextField.setText("");
								jcombo1.setSelectedItem("--Select--");
								nameTextField.setText("");
								ageTextField.setText("");
								jcombo.setSelectedItem("--Select--"
										);
							
								birthDateText.setText("");
								occupationText_Field.setText("");
								
								refTextField.setText("");
								addressText.setText("");
								phnTextField.setText("");
							
								personText.setText("");
								contactText.setText("");
								relationTextField.setText("");
			    		     
			    		   }
			    		   
			    		   else{
			    			   
			    			   
			    			   JOptionPane.showMessageDialog(null, "Please Fill The Text First");
			    		   }
			    		   
			    		   
			    	   }
			    	   
			    	   
			       catch(Exception e){
			    	   
			    	   JOptionPane.showMessageDialog(null, e);
			    	   
			    	   
			       }
			       
			    	   refreshTable();
			
			                  }});
		
				
				
				
				
				
				
			
				
				add(updateButton);
				
				
				
				JButton deleteButton=new JButton("Delete");

				deleteButton.addActionListener(new ActionListener()
				{
			       public void actionPerformed(ActionEvent g){
			    	  
			    	 
			    	   try{
			    		   if(!idTextField.getText().equals("")){
			    	           
			    	        
			    		   String query = "delete from patientinfo where Patient_ID='"+idTextField.getText()+"'";
			    		 
			    		   PreparedStatement pst=conn.prepareStatement(query);
			    		  
			    		     
			    		     pst.execute();
			    		   
			    		     JOptionPane.showMessageDialog(null, "Deleted Successfully");
			    		     pst.close();
			    		     idTextField.setText("");
								jcombo1.setSelectedItem("--Select--");
								nameTextField.setText("");
								ageTextField.setText("");
								jcombo.setSelectedItem("--Select--");
							
								birthDateText.setText("");
								occupationText_Field.setText("");
								
								refTextField.setText("");
								addressText.setText("");
								phnTextField.setText("");
							
								personText.setText("");
								contactText.setText("");
								relationTextField.setText("");
			    		  }
			    		     
			    		  else{
			    			  
			    			  JOptionPane.showMessageDialog(null, "Please Select Something You Want to Delete");
			    		  }
			    		   
			    		   
			    	   }  
			    	   
			    	   
			       
			    	   
			    	   
			       catch(Exception e){
			    	   
			    	   JOptionPane.showMessageDialog(null, e);
			    	   
			    	   
			       }
			    	   
			    	 refreshTable();
			
			    	  
			                  }});
		
				
				
				
				deleteButton.setBounds(525,430,100,20);
				add(deleteButton);
				
				
				JButton exitButton=new JButton("Main Menu");
			
				exitButton.addActionListener(new ActionListener(){
					
					
					public void actionPerformed(ActionEvent a){
						
						MenuWindow nx = new MenuWindow();
						setVisible(false);	
						
						
					}
					
					});
			
				
				
				
				exitButton.setBounds(650,430,100,20);
				add(exitButton);
				
				
				
				
			
				
				
				setTitle("Patient Details");
				setSize(1300,700);
				setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				
					
				
				
		
		
		
		
		
		
		
	}
	
}

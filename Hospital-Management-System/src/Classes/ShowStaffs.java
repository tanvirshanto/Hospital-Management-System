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

public class ShowStaffs extends JFrame {
	

	JTable table;
	
	Connection conn=null;
	
	ShowStaffs()
	{
		ShowDetails();
		
		 conn=DatabaseConnect.dbConnector();
	}
	
	
	
	public void refreshTable(){
		
		
		
		  
 	   try{
 		   
 		   String query="select * from staff_info";
 		   PreparedStatement pst= conn.prepareStatement(query);
 		   ResultSet rs=pst.executeQuery();
 		   table.setModel(DbUtils.resultSetToTableModel(rs));
 		   
 		   
 		   
 		   
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
		
		table.setBounds(226, 120, 900, 300);
	
		
		add(table);
		
	
	
		
		
		JLabel Stufflabel=new JLabel("staff Id");
		Stufflabel.setBounds(226,100,45,20);
		add(Stufflabel);
		
		JLabel staff_typelabel=new JLabel("staff type");
		staff_typelabel.setBounds(310,100,85,20);
		add(staff_typelabel);
		
		JLabel Namelabel=new JLabel("Name");
		Namelabel.setBounds(394,100,40,20); 
		add(Namelabel);
		
		JLabel Agelabel=new JLabel("Age");
		Agelabel.setBounds(478,100,45,20);
		add(Agelabel);
		
		JLabel Birthdatelabel=new JLabel("Birth date");
		Birthdatelabel.setBounds(530,100,85,20);
		add(Birthdatelabel);
		
		JLabel Religionlabel=new JLabel("Religion");
		Religionlabel.setBounds(610,100,85,20);
		add(Religionlabel);
		
		JLabel Genderlabel=new JLabel("Gender");
		Genderlabel.setBounds(680,100,70,20);
		add(Genderlabel);
		
		JLabel Blood_Grouplabel=new JLabel("Blood Group");
		Blood_Grouplabel.setBounds(750,100,85,20);
		add(Blood_Grouplabel);
		
		JLabel Marital_Statuslabel=new JLabel("Marital Status");
		Marital_Statuslabel.setBounds(830,100,100,20);
		add(Marital_Statuslabel);
		
		JLabel Salarylabel=new JLabel("Salary");
		Salarylabel.setBounds(920,100,60,20);
		add(Salarylabel);
		
		JLabel Addresslabel=new JLabel("Address");
		Addresslabel.setBounds(990,100,60,20);
		add(Addresslabel);
		
		JLabel phonelabel=new JLabel("phone");
		phonelabel.setBounds(1060,100,45,20);
		add(phonelabel);
	

		
		
		JLabel stuffLabel = new JLabel("Stuff ID");
		stuffLabel.setBounds(26, 40, 46, 14);
		add(stuffLabel);
		
		JTextField	stuffTextField = new JTextField();
		stuffTextField.setBounds(82, 40, 86, 20);
		add(stuffTextField);
		
		
		JLabel stufftypeLabel = new JLabel("Stuff type");
		stufftypeLabel.setBounds(25, 70, 65, 14);
		add(stufftypeLabel);
		
        String[] items1={"Regular","Irregular"};
		
		JComboBox jcombo1=new JComboBox(items1);
		jcombo1.setBounds(82, 70, 86, 20);
		add(jcombo1);
		
		
		JLabel personalLabel = new JLabel("Personal Details:");
		personalLabel.setBounds(25, 120, 120, 14);
		add(personalLabel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(26, 151, 46, 14);
		add(nameLabel);
		
		JTextField nameTextFiled = new JTextField();
		nameTextFiled.setBounds(102, 148, 86, 20);
		add(nameTextFiled);
		
		
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setBounds(26, 180, 46, 14);
		add(ageLabel);
		
		JTextField ageTextField = new JTextField();
		ageTextField.setBounds(102, 180, 86, 20);
		add(ageTextField);
		
		
		JLabel birthDateLabel = new JLabel("Birth Date");
		birthDateLabel.setBounds(26, 210, 60, 40);
	    add(birthDateLabel);
		
		JTextField birthDateText = new JTextField();
		birthDateText.setBounds(102, 220, 86, 20);
		add(birthDateText);
		
		
		JLabel religionLabel = new JLabel("Religion");
		religionLabel.setBounds(26, 260, 46, 14);
		add(religionLabel);
		
		JTextField religionText = new JTextField();
		religionText.setBounds(102, 260, 86, 20);
		add(religionText);
		
		
		JLabel gendeLabel = new JLabel("Gender");
		gendeLabel.setBounds(26, 300, 46, 14);
		add(gendeLabel);
		

		String[] items={"Male","Female"};
		
		JComboBox jcombo=new JComboBox(items);
		jcombo.setBounds(102, 300, 86, 20);
		add(jcombo);
		
		
		
		
		JLabel bloodGroupLabel = new JLabel("Blood group");
		bloodGroupLabel.setBounds(26, 340, 70, 14);
		add(bloodGroupLabel);
		
		JTextField bloodTextField = new JTextField();
		bloodTextField.setBounds(102, 340, 86, 20);
		add(bloodTextField);
		
		
		JLabel maritalLabel = new JLabel("Marital Status");
		maritalLabel.setBounds(20, 380, 85, 14);
		add(maritalLabel);
		
		JTextField maritalText = new JTextField();
		maritalText.setBounds(102, 380, 86, 20);
		add(maritalText);
		
		
		JLabel salaryLabel = new JLabel("Salary");
		salaryLabel.setBounds(20, 420, 46, 14);
		add(salaryLabel);
		
		JTextField salaryTextField = new JTextField();
		salaryTextField.setBounds(102, 420, 86, 20);
		add(salaryTextField);
		
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(20, 460, 65, 14);
		add(addressLabel);
		
		JTextField addressText = new JTextField();
		addressText.setBounds(102, 460, 86, 20);
		add(addressText);
		
		
		JLabel phoneLabel = new JLabel("phone");
		phoneLabel.setBounds(20, 500, 46, 14);
		add(phoneLabel);
		
		JTextField phoneText = new JTextField();
		phoneText.setBounds(102, 500, 86, 20);
		add(phoneText);
		
		
		JButton searchButton=new JButton("Search By Name");
		searchButton.setBounds(800,50,130,25);
		
		
		JTextField SearchTextField=new JTextField();
		SearchTextField.setBounds(950,50,86,25);
	
		
		searchButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent a) 
			{
				
				  
		    	   try{
		    		   
		    		  
		    		   String query1="select * from staff_info  where Name='"+SearchTextField.getText()+"'";
		    		   PreparedStatement pst=conn.prepareStatement(query1);
		    		  
		    		   ResultSet rs=pst.executeQuery();
		    		   table.setModel(DbUtils.resultSetToTableModel(rs));
		    		 
		    	         pst.close();
		    	         rs.close();
		    	        
		    	         SearchTextField.setText("");
		    	
		    		   
		    	   }
		    	   
		    	   
		       catch(Exception e){
		    	   
		    	   JOptionPane.showMessageDialog(null, e);
		    	   
		    	   
		       }
		       
			
			}
		
			
		});
		
		add(searchButton);
		add(SearchTextField);
		
		
		
		
		

		table.addMouseListener(new MouseAdapter(){
			
			
			public void mouseClicked(MouseEvent ar)
			
			{
				try{
					
					int row=table.getSelectedRow();
					String staff_ID=(table.getModel().getValueAt(row, 0)).toString();
					 String query1="select * from staff_info  where staff_ID='"+staff_ID+"'";
		    		   PreparedStatement pst=conn.prepareStatement(query1);
		    		  
		    		   ResultSet rs=pst.executeQuery();
		    		  
		    		  while(rs.next()){
		    		
		    			  

		    			  stuffTextField.setText(rs.getString("staff_ID"));
							jcombo1.setSelectedItem(rs.getString("staff_type"));;
							nameTextFiled.setText(rs.getString("Name"));
							ageTextField.setText(rs.getString("Age"));
							birthDateText.setText(rs.getString("Birthdate"));
							
							religionText.setText(rs.getString("Religion"));
							jcombo.setSelectedItem(rs.getString("Gender"));
							
							bloodTextField.setText(rs.getString("Blood_Group"));
							maritalText.setText(rs.getString("Marital_Status"));
							salaryTextField.setText(rs.getString("Salary"));
							addressText.setText(rs.getString("Address"));
							phoneText.setText(rs.getString("phone"));
		    			  

					
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
					    		   String query="select * from staff_info";
					    		   PreparedStatement pst= conn.prepareStatement(query);
					    		   ResultSet rs=pst.executeQuery();
					    		   table.setModel(DbUtils.resultSetToTableModel(rs));
					    		   pst.close();
					    	       rs.close();
					    		   
					    	     
					    		   
					    		   
					    	   }
					    	   
					    	   
					       catch(Exception e){
					    	   
					    	   JOptionPane.showMessageDialog(null, e);
					    	   
					    	   
					       }
					       
					    		
								JButton loadButton =new JButton("Load Staff Data");
									
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
			    		   if(!stuffTextField.getText().equals("")){
			    		
			    		   String query = "Update staff_info set staff_ID=' "+stuffTextField.getText()+" ', staff_type=' "+jcombo1.getSelectedItem().toString()+" ',Name=' "+nameTextFiled.getText()+" ',Age=' "+ageTextField.getText()+" ',Birthdate=' "+birthDateText.getText()+" ',Religion=' "+religionText.getText()+" ',Gender=' "+jcombo.getSelectedItem().toString()+" ',Blood_Group=' "+bloodTextField.getText()+" ',Marital_Status=' "+maritalText.getText()+" ',Salary=' "+salaryTextField.getText()+" ',Address=' "+addressText.getText()+" ',phone=' "+phoneText.getText()+" ' where staff_ID='"+stuffTextField.getText()+"'";
			    		 
			    		   PreparedStatement pst=conn.prepareStatement(query);
			    		   
			    		     pst.execute();
			    		     JOptionPane.showMessageDialog(null, "Updated Successfully");
			    		     pst.close();
			    		    

			    		     stuffTextField.setText("");
								jcombo1.setSelectedItem("Regular");
								nameTextFiled.setText("");
								ageTextField.setText("");
								birthDateText.setText("");
								
								religionText.setText("");
								jcombo.setSelectedItem("Male");
								
								bloodTextField.setText("");
								maritalText.setText("");
								salaryTextField.setText("");
								addressText.setText("");
								phoneText.setText("");
			    		     
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
			    		   
			    		   if(!stuffTextField.getText().equals("")){
			    		   
			    		   String query = "delete from staff_info  where staff_ID='"+stuffTextField.getText()+"'";
			    		 
			    		   PreparedStatement pst=conn.prepareStatement(query);
			    		  
			    		     
			    		     pst.execute();
			    		     
			    		     JOptionPane.showMessageDialog(null, "Deleted Successfully");
			    		     pst.close();
			    		     

			    		     stuffTextField.setText("");
								jcombo1.setSelectedItem("Regular");
								nameTextFiled.setText("");
								ageTextField.setText("");
								birthDateText.setText("");
								
								religionText.setText("");
								jcombo.setSelectedItem("Male");
								
								bloodTextField.setText("");
								maritalText.setText("");
								salaryTextField.setText("");
								addressText.setText("");
								phoneText.setText("");
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
				
				
				JButton exitButton=new JButton("Main Manu");
				exitButton.addActionListener(new ActionListener(){
						
						
						public void actionPerformed(ActionEvent a){
							
							MenuWindow nx = new MenuWindow();
							setVisible(false);	
							
							
						}
						
						});
				
				
				
				
				
				
				
				exitButton.setBounds(650,430,105,20);
				add(exitButton);
				
				
				
			
				
				setTitle("Staff Details");
				setSize(1200,600);
				setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				
					
				
				
		
		
		
		
		
		
		
	}
	
}

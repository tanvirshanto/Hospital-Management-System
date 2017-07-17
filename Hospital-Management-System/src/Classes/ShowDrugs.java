package Classes;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

public class ShowDrugs extends JFrame {
	

	JTable table;
	
	Connection conn=null;
	
	ShowDrugs()
	{
		ShowDetails();
		
		 conn=DatabaseConnect.dbConnector();
	}
	
	
	
	public void refreshTable(){
		
		
		
		  
 	   try{
 		   
 		   String query="select * from drug_info";
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
		
		
		
	//////////////////////////////////////////////////////////////////
		

		JLabel infoLabel = new JLabel("Drug Information");
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		infoLabel.setBounds(10, 40, 135, 19);
		add(infoLabel);
		
		JLabel idLabel = new JLabel("Drug Id");
		idLabel.setBounds(26, 85, 85, 15);
		add(idLabel);
		
		JTextField idTextField = new JTextField();
		idTextField.setBounds(98, 85, 86, 20);
		add(idTextField);
		
		
		JLabel nameLabel = new JLabel("Drug Name");
		nameLabel.setBounds(10, 130, 63, 14);
		add(nameLabel);
		
		JTextField nameTextField1 = new JTextField();
		nameTextField1.setBounds(98, 130, 86, 20);
		add(nameTextField1);
		
		
		JLabel dateLabel = new JLabel("Purchase Date");
		dateLabel.setBounds(5, 175, 98, 14);
		add(dateLabel);
		
		JTextField dateTextField2 = new JTextField();
		dateTextField2.setBounds(98, 175, 86, 20);
		add(dateTextField2);
		
		
		JLabel typeLabel = new JLabel("Drug Type");
		typeLabel.setBounds(10, 220, 63, 14);
		add(typeLabel);
		
		String[] types={"--Select--",
				"Tablet","Syrup"};
		JComboBox combo=new JComboBox(types);
		combo.setBounds(100,220,90,20);
		add(combo);
		
		
		
		JLabel expDateLabel = new JLabel("Exp Date");
		expDateLabel.setBounds(10, 265, 63, 14);
		add(expDateLabel);
		
		JTextField expTextField4 = new JTextField();
		expTextField4.setBounds(98, 265, 86, 20);
		add(expTextField4);
		
		
		
		JLabel unitLabel = new JLabel("Unit price");
		unitLabel.setBounds(10, 310, 63, 14);
		add(unitLabel);
		
		JTextField priceTextField5 = new JTextField();
		priceTextField5.setBounds(98, 310, 86, 20);
		add(priceTextField5);
	
	
		
		JLabel cinfoLabel = new JLabel("Company Information");
		cinfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cinfoLabel.setBounds(10, 355, 200, 20);
		add(cinfoLabel);
		
		JLabel cnameLabel = new JLabel("Company Name");
		cnameLabel.setBounds(10, 400, 100, 14);
		add(cnameLabel);
		
		JTextField nameTextField6 = new JTextField();
		nameTextField6.setBounds(102, 400, 85, 20);
		add(nameTextField6);
		
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(10, 445, 85, 14);
		add(addressLabel);
		
		JTextField addressTextField7 = new JTextField();
		addressTextField7.setBounds(102, 445, 86, 20);
		add(addressTextField7);
		
		
		JLabel phnLabel = new JLabel("Phone no");
		phnLabel.setBounds(10, 490, 85, 14);
		add(phnLabel);
		
		JTextField phnTextField8 = new JTextField();
		phnTextField8.setBounds(102, 490, 86, 20);
		add(phnTextField8);
		
		
		JLabel mailAddresss = new JLabel("Mail Address");
		mailAddresss.setBounds(10, 535, 85, 14);
		add(mailAddresss);
		
		JTextField mailTextField9 = new JTextField();
		mailTextField9.setBounds(102, 535, 86, 20);
		add(mailTextField9);
		
		
		
	///////////////////////////////////////////////////////////////////	
		JLabel idLabel1=new JLabel("Drug Id");
		idLabel1.setBounds(240,100,45,20);
		add(idLabel1);
		
		JLabel nameLabel1=new JLabel("Drug Name");
		nameLabel1.setBounds(320,100,85,20);
		add(nameLabel1);
		
		JLabel dateLabel1=new JLabel("Purchase Date");
		dateLabel1.setBounds(404,100,85,20); 
		add(dateLabel1);
		
		JLabel typeLabel1=new JLabel("Drug Type");
		typeLabel1.setBounds(510,100,85,20);
		add(typeLabel1);
		
		JLabel expLabel1=new JLabel("Exp Date");
		expLabel1.setBounds(600,100,85,20);
		add(expLabel1);
		
		JLabel unitLabel1=new JLabel("Unit price");
		unitLabel1.setBounds(690,100,85,20);
		add(unitLabel1);
		
		JLabel cnameLabel1=new JLabel("Company Name");
		cnameLabel1.setBounds(768,100,100,20);
		add(cnameLabel1);
		
		JLabel addresssLabel1=new JLabel("Address");
		addresssLabel1.setBounds(880,100,100,20);
		add(addresssLabel1);
		
		JLabel phnLabel1=new JLabel("Phone no");
		phnLabel1.setBounds(950,100,100,20);
		add(phnLabel1);
		
		JLabel adreessLabel1=new JLabel("Mail Address");
		adreessLabel1.setBounds(1040,100,100,20);
		add(adreessLabel1);
		
	
////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		JButton searchButton=new JButton("Search by Name");
		searchButton.setBounds(800,50,130,25);
		add(searchButton);
		
		JTextField SearchTextField=new JTextField();
		SearchTextField.setBounds(950,50,86,25);
		add(SearchTextField);
		
		searchButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent a) 
			{
				
				  
		    	   try{
		    		   
		    		   String query1="select * from drug_info  where Drug_Name='"+SearchTextField.getText()+"'";
		    		   PreparedStatement pst=conn.prepareStatement(query1);
		    		  
		    		   ResultSet rs=pst.executeQuery();
		    		   table.setModel(DbUtils.resultSetToTableModel(rs));
		    		 
		    		   
		    	   }
		    	   
		    	   
		       catch(Exception e){
		    	   
		    	   JOptionPane.showMessageDialog(null, e);
		    	   
		    	   
		       }
		       
			
			}
		
			
		});
		
		

		
		////////////////////////////////////////////////////////////////////////////////
		table.addMouseListener(new MouseAdapter(){
			
			
			public void mouseClicked(MouseEvent ar)
			
			{
				try{
					
					int row=table.getSelectedRow();
					String Drug_Name=(table.getModel().getValueAt(row, 0)).toString();
					 String query1="select * from drug_info  where Drug_Id='"+Drug_Name+"'";
		    		   PreparedStatement pst=conn.prepareStatement(query1);
		    		  
		    		   ResultSet rs=pst.executeQuery();
		    		  // table.setModel(DbUtils.resultSetToTableModel(rs));
		    		  while(rs.next()){
		    		

		    			  idTextField.setText(rs.getString("Drug_Id"));
							
		    			  nameTextField1.setText(rs.getString("Drug_Name"));
		    			  dateTextField2.setText(rs.getString("Purchase_Date"));
							combo.setSelectedItem(rs.getString("Drug_Type"));;
							expTextField4.setText(rs.getString("Exp_Date"));
							
							priceTextField5.setText(rs.getString("Unit_price"));
						
							
							nameTextField6.setText(rs.getString("Company_Name"));
							addressTextField7.setText(rs.getString("Company_Address"));
							phnTextField8.setText(rs.getString("Phone_no"));
							mailTextField9.setText(rs.getString("Mail_Address"));
							
		    			  

					
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
 		   String query="select * from drug_info";
 		   PreparedStatement pst= conn.prepareStatement(query);
 		   ResultSet rs=pst.executeQuery();
 		   table.setModel(DbUtils.resultSetToTableModel(rs));
 		   
 		 	   
 	   }
 	   
 	   
    catch(Exception e){
 	   
 	   JOptionPane.showMessageDialog(null, e);
 	   
 	   
    }
		
		
		
		
			JButton loadButton =new JButton("Load Drugs Data");
				
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
			    			   
			    		   
			    		   String query = "Update drug_info set Drug_Id=' "+idTextField.getText()+" ', Drug_Name=' "+nameTextField1.getText()+" ',Purchase_Date=' "+dateTextField2.getText()+" ',Drug_Type=' "+combo.getSelectedItem().toString()+" ',Exp_Date=' "+expTextField4.getText()+" ',Unit_price=' "+priceTextField5.getText()+" ',Company_Name=' "+nameTextField6.getText()+" ',Company_Address=' "+addressTextField7.getText()+" ',Phone_no=' "+phnTextField8.getText()+" ',Mail_Address=' "+mailTextField9.getText()+" ' where Drug_Id='"+idTextField.getText()+"'";
			    		 
			    		   PreparedStatement pst=conn.prepareStatement(query);
			    		  
			    		     
			    		     pst.execute();
			    		     JOptionPane.showMessageDialog(null, "Data Updated Successfully");
			    		     
			    		     pst.close();

			    		     idTextField.setText("");
								
			    		     nameTextField1.setText("");
			    		     dateTextField2.setText("");
								combo.setSelectedItem("--Select--");
							
							
								expTextField4.setText("");
								priceTextField5.setText("");
								
								nameTextField6.setText("");
								addressTextField7.setText("");
								phnTextField8.setText("");
							
								mailTextField9.setText("");
								
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
			    		   
			    			   String query = "delete from drug_info  where Drug_Id='"+idTextField.getText()+"'";
			    		 
			    		   PreparedStatement pst=conn.prepareStatement(query);
			    		  
			    		     
			    		     pst.execute();
			    		     JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
			    		     
			    		     pst.close();
			    		     
			    		     idTextField.setText("");
								
			    		     nameTextField1.setText("");
			    		     dateTextField2.setText("");
								combo.setSelectedItem("--Select--");
							
							
								expTextField4.setText("");
								priceTextField5.setText("");
								
								nameTextField6.setText("");
								addressTextField7.setText("");
								phnTextField8.setText("");
							
								mailTextField9.setText("");
			    		   }
								
			    		   else
			    		   {
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
				
				
				
			
				
				  setTitle("Drug Details");
				setSize(1200,620);
				setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				
					
				
				
		
		
		
		
		
		
		
	}
	
}

package Classes;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class PatientSerialInfo extends JFrame {
	Connection conn=null;
	JTable roomTable;
	
	PatientSerialInfo()
	
	{
		showInfo();
		conn=DatabaseConnect.dbConnector();
		
	}
	
	
	
	
	public void showInfo()
	
	
	{
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
		
		
		
		roomTable=new JTable();
		roomTable.setBounds(26, 91, 466, 197);
	
		add(roomTable);
		

		JButton loadButton = new JButton("Load Data");
		loadButton.addActionListener(new ActionListener()
		{
	     public void actionPerformed(ActionEvent g){
	    	   
			
			refreshTable();
			}});
		
		
		loadButton.setBounds(131, 11, 100, 23);
	     add(loadButton);
		
		JLabel serialLabel = new JLabel("Serial");
		serialLabel.setBounds(50, 75, 46, 14);
		add(serialLabel);
		
		JLabel nameLabel = new JLabel("DR.Name");
		nameLabel.setBounds(200, 75, 65, 14);
		add(nameLabel);
		
		JLabel patientLabel = new JLabel("Patient Name");
		patientLabel.setBounds(350, 75, 85, 14);
		add(patientLabel);
	//////////////////////////////////////////////////////////////////
		JLabel serialLabel1 = new JLabel("Serial");
		serialLabel1.setBounds(26, 300, 46, 14);
		add(serialLabel1);
		
		JTextField searialTextField = new JTextField();
		searialTextField.setBounds(100, 300, 86, 20);
		add(searialTextField);
		
		
		JLabel nameLabel1 = new JLabel("DR.Name");
		nameLabel1.setBounds(26, 340, 65, 14);
		add(nameLabel1);
		
		JTextField nameTextField = new JTextField();
		nameTextField.setBounds(100, 340, 86, 20);
		add(nameTextField);
		
		
		JLabel patientLabel1 = new JLabel("Patient Name");
		patientLabel1.setBounds(20, 380, 85, 14);
		add(patientLabel1);
		
		JTextField patientTextField = new JTextField();
		patientTextField.setBounds(100, 380, 86, 20);
		add(patientTextField);
		
		
		
		//////////////////////////////////////////////////////////////
		
		JButton menuButton = new JButton("Main Menu");
		menuButton.addActionListener(new ActionListener()
		{
	     public void actionPerformed(ActionEvent g){
	    	   MenuWindow mw = new MenuWindow();
	    	   setVisible(false);
	       
	
	     }});
		
		
		menuButton.setBounds(502, 181, 110, 23);
		add(menuButton);
		
		
		
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener()
		{
	       public void actionPerformed(ActionEvent g){
	    	   
	    	   try{
	    		   
	    		   if(!searialTextField.getText().equals("")){
	    		   
	    		   String query = "delete from serial_no  where Serial_No='"+searialTextField.getText()+"'";
	    		 
	    		   PreparedStatement pst=conn.prepareStatement(query);
	    		  
	    		     
	    		     pst.execute();
	    		     
	    		     JOptionPane.showMessageDialog(null, "Deleted Successfully");
	    		     pst.close();
	    		     

	    		     
	    		     searialTextField.setText("");
	    		     nameTextField.setText("");
	    		     patientTextField.setText("");
						
						
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
		
		
		deleteButton.setBounds(502, 220, 110, 23);
		add(deleteButton);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JButton searchButton = new JButton("Search by Name");
		searchButton.setBounds(335, 11, 130, 23);
		add(searchButton);
		
		JTextField searchTextField = new JTextField();
		searchTextField.setBounds(480, 12, 86, 20);
		add(searchTextField);
		
		
		
		searchButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent a) 
			{

			 	   try{
			 		   
			 		  
			 		   String query1="select * from serial_no where Patient_Name='"+searchTextField.getText()+"'";
			 		   PreparedStatement pst=conn.prepareStatement(query1);
			 		  
			 		   ResultSet rs=pst.executeQuery();
			 		   roomTable.setModel(DbUtils.resultSetToTableModel(rs));
			 		 
			 	         pst.close();
			 	         rs.close();
			 	        
			 	        searchTextField.setText("");
			 	
			 		   
			 	   }
			 	   
			 	   
			    catch(Exception e){
			 	   
			 	   JOptionPane.showMessageDialog(null, e);
			 	   
			 	   
			    }
			    
			}
		
			
		});
		
	
	

	 	   try{
	 		  Class.forName("com.mysql.jdbc.Driver");
  			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/log_info","root","");
	 		   String query="select * from Serial_No";
	 		   PreparedStatement pst= conn.prepareStatement(query);
	 		   ResultSet rs=pst.executeQuery();
	 		   roomTable.setModel(DbUtils.resultSetToTableModel(rs));
	 		   
	 		   
	 		   
	 		   
	 	   }
	 	   
	 	   
	    catch(Exception e){
	 	   
	 	   JOptionPane.showMessageDialog(null, e);
	 	   
	 	   
	    }
		
	 	   
	 	  roomTable.addMouseListener(new MouseAdapter(){
				
				
				public void mouseClicked(MouseEvent ar)
				
				{
					try{
						
						int row=roomTable.getSelectedRow();
						String Serial_No=(roomTable.getModel().getValueAt(row, 0)).toString();
						 String query1="select * from Serial_No  where Serial_No='"+Serial_No+"'";
			    		   PreparedStatement pst=conn.prepareStatement(query1);
			    		  
			    		   ResultSet rs=pst.executeQuery();
			    		  
			    		  while(rs.next()){
			    		
			    			  

			    			  searialTextField.setText(rs.getString("Serial_No"));
								
			    			  nameTextField.setText(rs.getString("Dr_Name"));
			    			  patientTextField.setText(rs.getString("Patient_Name"));
						
								
								

						
			    		  }
						
						
						pst.close();

					
					}
					
					   
				       catch(Exception e){
				    	   
				    	   JOptionPane.showMessageDialog(null, e);
				    	   
				    	   
				       }
				
				}});
	 	   
	 	   
		
		setTitle("Patient Serial Information");
		setSize(700,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		
	}
	
	
	
	public void refreshTable(){
		
		try{
	 	
	 		   String query="select * from Serial_No";
	 		   PreparedStatement pst= conn.prepareStatement(query);
	 		   ResultSet rs=pst.executeQuery();
	 		   roomTable.setModel(DbUtils.resultSetToTableModel(rs));
	 		   
	 		   
	 		   
	 		   
	 	   }
	 	   
	 	   
	    catch(Exception e){
	 	   
	 	   JOptionPane.showMessageDialog(null, e);
	 	   
	 	   
	    }
		
		
		
		
		
	}
	
	
	
	
	
}

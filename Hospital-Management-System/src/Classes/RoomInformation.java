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

public class RoomInformation extends JFrame {
	Connection conn=null;
	JTable roomTable;
	
	RoomInformation()
	
	{
		showRoom();
		conn=DatabaseConnect.dbConnector();
		
	}
	
	
	
	
	public void showRoom()
	
	
	{
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
		 roomTable=new JTable();
		roomTable.setBounds(26, 91, 466, 197);
	
		add(roomTable);
		
		
		
		
		
		
		

		JButton loadButton = new JButton("Load Data");
		loadButton.addActionListener(new ActionListener()
		{
	     public void actionPerformed(ActionEvent g){
	    	 refreshTable();
			
	                  }});
		
		
		

 	   try{
 		  Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/log_info","root","");
 		   String query="select * from dr_room_information";
 		   PreparedStatement pst= conn.prepareStatement(query);
 		   ResultSet rs=pst.executeQuery();
 		   roomTable.setModel(DbUtils.resultSetToTableModel(rs));
 		   
 		   
 		   
 		   
 	   }
 	   
 	   
    catch(Exception e){
 	   
 	   JOptionPane.showMessageDialog(null, e);
 	   
 	   
    }
		
		
		
		
		
 	  loadButton.setBounds(131, 11, 100, 23);
	     add(loadButton);
		
		JLabel idLabel1 = new JLabel("Dr.ID");
		idLabel1.setBounds(45, 66, 46, 14);
		add(idLabel1);
		
		JLabel nameLabel1 = new JLabel("DR.Name");
		nameLabel1.setBounds(122, 66, 65, 14);
		add(nameLabel1);
		
		
		JLabel visitLabel1 = new JLabel("Visit Time");
		visitLabel1.setBounds(195, 66, 65, 14);
		add(visitLabel1);
		
		JLabel visitFeeLabel = new JLabel("Visit Fee");
		visitFeeLabel.setBounds(270, 66, 65, 14);
		add(visitFeeLabel);
		
		JLabel specialistLbael = new JLabel("Specialist");
		specialistLbael.setBounds(343, 66, 65, 14);
		add(specialistLbael);
		
		JLabel roomNoLabel = new JLabel("Room No");
		roomNoLabel.setBounds(414, 66, 65, 14);
		add(roomNoLabel);
		
	/////////////////////////////////////////////////////////////////////	
		
		JLabel idLabel = new JLabel("Dr. ID");
		idLabel.setBounds(28, 327, 46, 14);
		add(idLabel);
		
		JTextField idTextField = new JTextField();
		idTextField.setBounds(84, 324, 86, 20);
		add(idTextField);
		
		
		
		
		JLabel nameLabel = new JLabel("Dr.Name");
		nameLabel.setBounds(28, 380, 85, 14);
		add(nameLabel);
		
		JTextField nameTextField = new JTextField();
		 nameTextField.setBounds(84, 377, 86, 20);
		add(nameTextField);
		
		
		
		
		
		JLabel visitLabel = new JLabel("Visit Time");
		visitLabel.setBounds(196, 330, 85, 14);
		add(visitLabel);
		
		JTextField visitTextField_2 = new JTextField();
		visitTextField_2.setBounds(273, 327, 86, 20);
		add(visitTextField_2);
		
	
		
		JLabel feeLabel = new JLabel("Visit Fee");
		feeLabel.setBounds(196, 380, 85, 14);
		add(feeLabel);
		
		JTextField feeTextField_3 = new JTextField();
		feeTextField_3.setBounds(273, 377, 86, 20);
		add(feeTextField_3);
		
		
		
		
		
		
		JLabel specialLabel = new JLabel("Specialist");
		specialLabel.setBounds(403, 330, 85, 14);
		add(specialLabel);
		
		JTextField specialTextField_4 = new JTextField();
		specialTextField_4.setBounds(482, 327, 86, 20);
		add(specialTextField_4);
	
		
		JLabel roomlabel = new JLabel("Room No");
		roomlabel.setBounds(403, 380, 85, 14);
		add(roomlabel);
		
		JTextField roomTextField_5 = new JTextField();
		roomTextField_5.setBounds(482, 377, 86, 20);
		add(roomTextField_5);
		
		
	////////////////////////////////////////////////////////	
		JButton appointmentButton = new JButton("Appoinment");
		appointmentButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae) {
				
				
				PatientSerial serial=new PatientSerial();
				
				
				setVisible(false);
			}
		});
		
		
		
		
		
		appointmentButton.setBounds(502, 100, 110, 23);
		add(appointmentButton);
		
		JButton doctorAddingButton = new JButton("ADD");
		doctorAddingButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae) {
				
				DoctorAdding mw = new DoctorAdding(); 
				
				
				setVisible(false);
			}
		});
		
		
		
		doctorAddingButton.setBounds(502, 140, 110, 23);
		
		add(doctorAddingButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.setBounds(502, 180, 110, 23);
		add(updateButton);
		updateButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae) {
				
				try{
		    		   if(!idTextField.getText().equals("")){
		    		
		    		   String query = "Update dr_room_information set Dr_ID=' "+idTextField.getText()+" ',Dr_Name=' "+nameTextField.getText()+" ',Visit_time=' "+visitTextField_2.getText()+" ',Visit_Fee=' "+feeTextField_3.getText()+" ',Specialist=' "+specialTextField_4.getText()+" ',Room_No=' "+roomTextField_5.getText()+" ' where Dr_ID ='"+idTextField.getText()+"'";
		    		 
		    		   PreparedStatement pst=conn.prepareStatement(query);
		    		   
		    		     pst.execute();
		    		     JOptionPane.showMessageDialog(null, "Updated Successfully");
		    		     pst.close();
		    		    
		    		 	
		    		        idTextField.setText("");
							nameTextField.setText("");
							visitTextField_2.setText("");
						
							feeTextField_3.setText("");
							specialTextField_4.setText("");
							roomTextField_5.setText("");
		    		     
		    		   }
		    		   
							
		    		   else{
		    			   
		    			   
		    			   
		    			   JOptionPane.showMessageDialog(null, "Please Fill The Text First");
		    		   }	
							
		    		   
		    	   }
		    	   
		    	   
		       catch(Exception e){
		    	   
		    	   JOptionPane.showMessageDialog(null, e);
		    	   
		    	   
		       }
		       
		    	   refreshTable();
		
			}
		});
		
		
		
		

		//doctorAddingButton.setBounds(502, 140, 110, 23);
		
		//add(doctorAddingButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(502, 220, 110, 23);
		add(deleteButton);
		deleteButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae) {
				 try{
		    		   
		    		   if(!idTextField.getText().equals("")){
		    		   
		    		   String query = "delete from dr_room_information  where Dr_ID='"+idTextField.getText()+"'";
		    		 
		    		   PreparedStatement pst=conn.prepareStatement(query);
		    		  
		    		     
		    		     pst.execute();
		    		     
		    		     JOptionPane.showMessageDialog(null, "Deleted Successfully");
		    		     pst.close();
		    		     

		    		     idTextField.setText("");
							nameTextField.setText("");
							visitTextField_2.setText("");
						
							feeTextField_3.setText("");
							specialTextField_4.setText("");
							roomTextField_5.setText("");
		    		   }
		    		   
		    		   else{
		    			   
		    			   JOptionPane.showMessageDialog(null, "Please Select Something You Want to Delete");
		    		   }
		    		   
		    		   
		    	   }
		    	   
		    	   
		       catch(Exception e){
		    	   
		    	   JOptionPane.showMessageDialog(null, e);
		    	   
		    	   
		       }
		       
		    	   refreshTable();
			
			}
		});
        
		JButton exitButton = new JButton("Main Manu");
		
		exitButton.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent a){
				
				MenuWindow menu=new MenuWindow();
				setVisible(false);	
				
				
			}
			
			});
		exitButton.setBounds(502, 260, 110, 23);
		add(exitButton);
        
        
	
		
		
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
			 		   
			 		  
			 		   String query1="select * from dr_room_information where Dr_Name='"+searchTextField.getText()+"'";
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
		
   
		

		roomTable.addMouseListener(new MouseAdapter(){
			
			
			public void mouseClicked(MouseEvent ar)
			
			{
				try{
					
					int row=roomTable.getSelectedRow();
					String Dr_ID=(roomTable.getModel().getValueAt(row, 0)).toString();
					 String query1="select * from dr_room_information  where Dr_ID='"+Dr_ID+"'";
		    		   PreparedStatement pst=conn.prepareStatement(query1);
		    		  
		    		   ResultSet rs=pst.executeQuery();
		    		  
		    		  while(rs.next()){
		    		
		    			  

		    			  idTextField.setText(rs.getString("Dr_ID"));
							
		    			  nameTextField.setText(rs.getString("Dr_Name"));
							
		    			  visitTextField_2.setText(rs.getString("Visit_time"));
							
							
		    			  feeTextField_3.setText(rs.getString("Visit_Fee"));
		    			  specialTextField_4.setText(rs.getString("Specialist"));
		    			  roomTextField_5.setText(rs.getString("Room_No"));
							


							
		    		  }
					
					
					pst.close();

				
				}
				
				   
			       catch(Exception e){
			    	   
			    	   JOptionPane.showMessageDialog(null, e);
			    	   
			    	   
			       }
			
			}});
		
		
		
		
		
		
		
		
		
		
			
		
		setTitle("Room Information");
		
		setSize(700,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		
	}
	
	
	 public void refreshTable(){

	 	   try{
	 		
	 		   String query="select * from dr_room_information";
	 		   PreparedStatement pst= conn.prepareStatement(query);
	 		   ResultSet rs=pst.executeQuery();
	 		   roomTable.setModel(DbUtils.resultSetToTableModel(rs));
	 		   
	 		   
	 		   
	 		   
	 	   }
		   
		    catch(Exception e){
		 	   
		 	   JOptionPane.showMessageDialog(null, e);
		 	   
		 	   
		    }
			
		}
	
	
	
	
	
	
}

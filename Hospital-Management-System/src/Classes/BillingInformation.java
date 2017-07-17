package Classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;



class BillingInformation extends JFrame{
		
		Connection conn=null;
		BillingInformation()
		{
			doRegist();	
			conn=DatabaseConnect.dbConnector();
		}
		
		
		public void doRegist(){
			

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
			
			JLabel hospitalLbael=new JLabel("ABC HOSPITAL");
			hospitalLbael.setBounds(300, 5, 333, 27);
			hospitalLbael.setFont(new Font("Tahoma", Font.PLAIN, 20));
			add(hospitalLbael);
			
			JLabel careLabel=new JLabel("WE CARE");
			careLabel.setBounds(400, 30, 333, 27);
			careLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
			add(careLabel);

			
			JLabel nameLabel = new JLabel("Name");
			nameLabel.setBounds(10, 89, 46, 14);
		     add(nameLabel);
			
		    JTextField nameTextField = new JTextField();
		    nameTextField.setBounds(50, 86, 86, 20);
		    add(nameTextField);
			
			
			
			JLabel ageLabel = new JLabel("Age");
			ageLabel.setBounds(160, 89, 46, 14);
			add(ageLabel);
			
			JTextField ageTextField = new JTextField();
			ageTextField.setBounds(200, 89, 86, 20);
			add(ageTextField);
			
			
			JLabel genderLabel = new JLabel("Gender");
			genderLabel.setBounds(300, 86, 46, 14);
			add(genderLabel);
			
			JTextField genderTextField = new JTextField();
			genderTextField.setBounds(350, 86,85, 20);
			add(genderTextField);
			
			
			
			
			JLabel idLabel = new JLabel("ID");
			idLabel.setBounds(10, 27, 46, 14);
			add(idLabel);
			
			JTextField idTextField = new JTextField();
			idTextField.setBounds(66, 24, 86, 20);
			add(idTextField);
			
			
			JButton getButton = new JButton("Get");
			

			getButton.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent a) 
				{
					
					  
			    	   try{
			    		   
			    		   String query1="select * from patientinfo  where Patient_ID='"+idTextField.getText()+"'";
			    		   PreparedStatement pst=conn.prepareStatement(query1);
			    		  
			    		   ResultSet rs=pst.executeQuery();
			    		 
			    		  if(rs.next()){
			    			  nameTextField.setText(rs.getString("Name"));
			    			  ageTextField.setText(rs.getString("Age"));
			    			  genderTextField.setText(rs.getString("Gender"));

				    		   
			    		   }
			    	         
			    	             
			    		   else{
			    			   
			    			   
			    			   JOptionPane.showMessageDialog(null,"Not in The List");
			    		   }   
			    			   
			    		 pst.close();
			    		 rs.close();
			    	
			    	
			    		   
			    	   }
			    	   
			    	   
			       catch(Exception e){
			    	   
			    	   JOptionPane.showMessageDialog(null, e);
			    	   
			    	   
			       }
			       
				
				}
			
				
			});
			
			
			
			
			
			
			
			
			
			
			
			getButton.setBounds(179, 23, 89, 23);
			add(getButton);
			
			
			JLabel itemsLabel = new JLabel("items");
			itemsLabel.setBounds(10, 145, 59, 14);
			add(itemsLabel);
			
			JCheckBox xrayCheckBox = new JCheckBox("X-RAY");
		
			xrayCheckBox.setBounds(6, 176, 86, 23);
			add(xrayCheckBox);
			
			
			
			
			
			JCheckBox cityScanCheckBox = new JCheckBox("City-Scan");
			cityScanCheckBox.setBounds(10, 220, 86, 23);
			add(cityScanCheckBox);
			
			JLabel amountLabel = new JLabel("Amount");
			amountLabel.setBounds(335, 145, 46, 14);
			add(amountLabel);
			
			JTextField xrayTextField= new JTextField();
			xrayTextField.setBounds(309, 177, 86, 20);
			add(xrayTextField);
			
			
			JTextField cityScanTextField = new JTextField();
			cityScanTextField.setBounds(309, 223, 86, 20);
			add(cityScanTextField);
			
			
			JLabel othersLabel = new JLabel("Others");
			othersLabel.setBounds(10, 286, 46, 14);
			add(othersLabel);
			
			JTextField othersTextField = new JTextField();
			othersTextField.setBounds(309, 283, 86, 20);
			add(othersTextField);
			
			
			JLabel totalWithoutVatLabel = new JLabel("Total Without Vat");
			totalWithoutVatLabel.setBounds(10, 333, 130, 14);
			add(totalWithoutVatLabel);	
			
			
			JTextField totalWithoutVatTextField = new JTextField();
			totalWithoutVatTextField.setBounds(309, 330, 86, 20);
			add(totalWithoutVatTextField);
			
			
			JLabel netLabel = new JLabel("Net Vat(5%)");
			netLabel.setBounds(10, 372, 120, 14);
			add(netLabel);
			
			JTextField netTextField = new JTextField();
			netTextField.setBounds(309, 369, 86, 20);
			add(netTextField);
			
			
			JLabel totalLabel = new JLabel("Total With Vat");
			totalLabel.setBounds(10, 423, 120, 14);
		    add(totalLabel);
			
			JTextField totalField = new JTextField();
			totalField.setBounds(309, 420, 86, 20);
			add(totalField);
			
			
			JButton totalButton = new JButton("Total");
			totalButton.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent ae) {
				
					try{
					
					
					 if(xrayCheckBox.isSelected() && cityScanCheckBox.isSelected()){
				            double t = Double.parseDouble(xrayTextField.getText()) + 
				                        Double.parseDouble(cityScanTextField.getText()) + 
				                        Double.parseDouble(othersTextField.getText());
				            totalWithoutVatTextField.setText(Double.toString(t));
				        }
				        else if(xrayCheckBox.isSelected()){
				            double t = Double.parseDouble(xrayTextField.getText())+Double.parseDouble(othersTextField.getText());
				            totalWithoutVatTextField.setText(Double.toString(t));
				        }
				        else if(cityScanCheckBox.isSelected()){
				            double t = Double.parseDouble(cityScanTextField.getText())+Double.parseDouble(othersTextField.getText());
				            totalWithoutVatTextField.setText(Double.toString(t));
				        }
				        else{
				            double t = Double.parseDouble(othersTextField.getText());
				            totalWithoutVatTextField.setText(Double.toString(t));
				        }
				        double v =( Double.parseDouble(totalWithoutVatTextField.getText()) * Double.parseDouble("5")) / (Double.parseDouble("100"));
				        netTextField.setText(Double.toString(v));
				        
				        double to = Double.parseDouble(totalWithoutVatTextField.getText()) + Double.parseDouble(netTextField.getText());
				        totalField.setText(Double.toString(to));
				    }
					
				
					
					
				catch(Exception e) {
					
					
					JOptionPane.showMessageDialog(null, "Please Fill The Text First");
				}
					
				
			}});
			
			
			
			totalButton.setBounds(87, 461, 89, 23);
			
			add(totalButton);
			
			JButton printButton = new JButton("Print");
			printButton.setBounds(239, 461, 89, 23);
			add(printButton);
			
			JButton mainButton = new JButton("Main Menu");
			
			mainButton.addActionListener(new ActionListener(){
						
						
						public void actionPerformed(ActionEvent a){
							
							MenuWindow nx = new MenuWindow();
							setVisible(false);	
							
							
						}
						
						});
					
			
			
			
			
			mainButton.setBounds(415, 461, 98, 23);
			add(mainButton);
		

		
			  setTitle("Billing Process");
			setSize(650, 600);
			setBackground(Color.CYAN);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			setVisible(true);

		
			}
			
		}
		

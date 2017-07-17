package Classes;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.*;

public class WelcomePanel {

	public static void main(String[] args) {

		Welcome obj = new Welcome();

	}

}

class Welcome extends JFrame {

	Connection conn = null;

	public Welcome() {
		design();
		conn = DatabaseConnect.dbConnector();
	}

	public void design() {

		setLayout(null);
		JLabel nameLabel = new JLabel("ABC HOSPITAL");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel careLabel = new JLabel("we Care");
		careLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		careLabel.setBounds(270, 30, 200, 60);
		careLabel.setForeground(Color.black);
		
		
		JLabel userLabel = new JLabel("Username");
		JLabel passwordLabel = new JLabel("Password");
		
		
		
		
		try {

			setContentPane(new JLabel(new ImageIcon(
					ImageIO.read(new File("D:/colage1.JPG")))));
		}

		catch (IOException e) {
			System.out.println("nothing");
			
			e.printStackTrace();
		}
		JButton loginButton=new JButton("Login");
		
		

		JTextField userTextField = new JTextField(20);
		JPasswordField passwordTextField = new JPasswordField(20);

		
		
		add(nameLabel);
		add(careLabel);
		
		add(userLabel);
		add(userTextField);
		add(passwordLabel);
		add(passwordTextField);
		add(loginButton);
		

		nameLabel.setBounds(200, 2, 400, 60);
		
		userLabel.setBounds(200, 60, 150, 100);
		passwordLabel.setBounds(200, 100, 150, 100);
		userTextField.setBounds(280, 100, 130, 20);
		passwordTextField.setBounds(280, 140, 130, 20);
		loginButton.setBounds(290, 180, 100, 20);
		userLabel.setForeground(Color.black);
		passwordLabel.setForeground(Color.black);
		nameLabel.setForeground(Color.black);
		

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ar) {

				
				try {

					String query = "select * from log_info where username=? and password=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, userTextField.getText());
					pst.setString(2, passwordTextField.getText());
					ResultSet rs = pst.executeQuery();
					if (rs.next()) {
						//JOptionPane.showMessageDialog(null, "Username and password is Correct");
						MenuWindow nx = new MenuWindow();
						setVisible(false);

					}

					else {
						JOptionPane.showMessageDialog(null, "Username & Password is incorrect");
						userTextField.setText("");
						passwordTextField.setText("");

					}

					rs.close();
					pst.close();

				}

				catch (Exception e) {

					JOptionPane.showMessageDialog(null, e);
				}

			}
		});

		
        setTitle("Hospital Management System");
		setSize(650, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

	}

}

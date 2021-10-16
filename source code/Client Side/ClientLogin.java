import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.lang.String;
import java.io.*;

import java.io.*;
import java.net.*;
import java.lang.*;
import java.sql.*;
import javax.swing.*;

class ClientLogin extends JFrame //implements ActionListener
{
	
	JPanel mainPanel,workPanel,subPanel;
	
	JTextField userName;
	JPasswordField userPasswd;
	
	JLabel name,Pass;
	
	JButton login,register;
	
	ClientLogin()
	{
	 setTitle("User Login");
	 buildframe();
	 setSize(400,200);
	 setLocation((800-400)/2,(600-165)/2);
     pack();
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     setVisible(true);
     setResizable(false);
	}
	
	
	protected void buildframe()
	{
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		
		mainPanel.add(createScreen());
		getContentPane().add(mainPanel);
		
	}
	
	protected  JPanel createScreen()
	{
	 	subPanel = new JPanel();
	 	subPanel.setLayout(new FlowLayout());
	 	
	 	workPanel = new JPanel();
	 	workPanel.setLayout(new GridLayout(3,2,2,5));
	 	
	 	name = new JLabel("Enter Name:");
	 	workPanel.add(name);
	 	
	 	userName = new JTextField(20);
	 	workPanel.add(userName);
	 	
	 	Pass = new JLabel("Enter Password:");
	 	workPanel.add(Pass);
	 	
	 	userPasswd = new JPasswordField(20);
	 	workPanel.add(userPasswd);
	 	
	 	login = new JButton("Login");
	 	workPanel.add(login);
	 	
        register = new JButton("Register");
        workPanel.add(register);

        //login.addActionListener(this);
        //register.addActionListener(this);
	 	
	 	
	 	subPanel.add(workPanel);
	 	return subPanel;
	 	
	 	
		
	}
	
	public static void main(String args[])
	{
		ClientLogin c = new ClientLogin();
	}
	
}



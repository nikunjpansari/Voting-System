import java.io.*;
import java.net.*;
import java.lang.*;
import java.sql.*;
import javax.swing.*;


import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.lang.String;
import java.io.*; 


public class ServerT 
{
	
	public static void main(String[] args)
	{
			/*setSize(800,600);
			setTitle("True");
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);*/
		try
		{
				String Vname1,Vno1;
			//new AddPanel();
			//Thread t = new Thread(new ServerThread());
		//	t.start();
			System.out.println("DFD");
			ServerModule c1= new ServerModule();
			 
	//		Vname1=c1.Header[0];
	//	 	Vno1=c1.Dsc[0];
		 	
		//	System.out.println("Hi:"+Vname);
	//		System.out.println("Hi:"+Vno);	
			
			
		
		}
		catch(Exception e)
		{
			System.out.println(e);			
		}
	}
}

class ServerThread implements Runnable {
	ServerSocket socket;
	String ClientPanelName,ClientPanelDsc,ClientPanelInfo;
	public ServerThread(String x,String y,String z) {
		try {
			socket=new ServerSocket(8765);
			 ClientPanelName = x;
	    	 ClientPanelDsc = y;
		     ClientPanelInfo=z;
		}
		catch(Exception e ) { 
			System.out.println(e);
		}
			
	}
	
	public void run() {
		System.out.println("Server is ready");
		
		//Temp v = new Temp();
		
		save s = new save();
		
		
		
		
		s.VoterName = ClientPanelName;
		s.VoterDsc = ClientPanelDsc;
		s.VoterInfo = ClientPanelInfo;
		
		try {

		while(true) {
			Socket insocket=socket.accept();//with the help of accept() we can got the request from client.
			System.out.println("Client is connected");

			
			OutputStream out=insocket.getOutputStream();
			ObjectOutputStream oos =new ObjectOutputStream(out);
			
		
					
			System.out.println("No:"+s.VoterName);
			System.out.println("No:"+s.VoterDsc);
			
			oos.writeObject(s);
			oos.flush(); 
			insocket.close();
		}
		}
		catch(Exception e ) { 
			System.out.println(e);
		}
			
	}
}

class save implements Serializable
{
	String VoterName,VoterDsc,VoterInfo;
}

/*class Temp  
{
	String Vname,Vno;
	
	
	Temp()
	{
	//	this.Vname = "VNAME";
	//	this.Vno = "11";
		 CandidateTemp c1= new CandidateTemp();
		 Vname=c1.Header[0];
		 Vno=c1.Dsc[0];
		System.out.println("Hi:"+Vname);
			System.out.println("Hi:"+Vno);	
	
	
    }  
		
}*/

 


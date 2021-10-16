/***************************************************************************************
*	Class: Digital Reading , Result GUI
*	Project: On Line Voting System
*   Language: JAVA.
*	Year: 2007-2008
*
*	Use this project module for Used in the show the result in any OnLine vcoting system purposes.
*	The Result Can be show accourding its value ie hear result will show accourding to voting.
*	Feel free to distribute and re-distribute this project.
*	Feel free to add new features.
*	Suggestions are welcomed.
*
*	Redistribution and use in source and binary forms, with or
*	without modification, are permitted provided that the following
*	conditions are met:
*
*   Feature: 
*	-the Code is Reusuable.
*   -the Code is Readable.
*	You acknowledge that Software is not designed
*	intended for use in the design, construction, operation or
*	maintenance of any nuclear facility.
*   
******************************************************************************************/






import java.awt.*;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class DigitalReadings extends JFrame {

	private Map<String,Integer> pieData;
	
	public DigitalReadings() {
		pieData = new TreeMap<String,Integer>();
		initializeData();
		buildWindow();
		
		         
	}
	// To Initialize the Object
	protected void initializeData() {
		pieData.put("BJP",170);
		pieData.put("Congress", 270);
		pieData.put("Shivsena", 370);
		pieData.put("BSP", 470);
		pieData.put("Others", 870);
	}
	
	/**
	 * Put all the code,which builds the GUI here..
	 *
	 */
	protected void buildWindow() {
		
	     addWindowListener(new WindowAdapter()
           {
               public void windowClosing(WindowEvent e)
                 {
                        System.exit(0);
                 }
           });
                
   		 setTitle("DigitalReadings");
         setSize(800,600);
         setVisible(true);
    }
	
	/**
	 * This method should draw the pie based on the pie data.
	 * Calculate total number of voted from the PieData map,
	 * Calculate the % of vote each party has got.
	 * Calculate how to transform this data into  the data which can be displayed in Pie.
	 * I.E. 50% means 0.5*360 = 180 degree and so on..
	 * @param g
	 */
	  	int Tvotes ;
	  	double percentage;
	  	int Vote1,Vote,Iangle=90;
	  	int color1=150,color2=45,color3=115,X_axixs=220,Y_axis=300;
	  	protected void drawPie(final Graphics g) 
	 	{    
	 		
	 		Set<String> keySet = pieData.keySet();
	     	Iterator<String> keyIterator = keySet.iterator();
	    	while(keyIterator.hasNext()) 						//To Get the Total Number Of Votes 
	    	{    
	        	String partyName = keyIterator.next();
	       		pieData.get(partyName);
	       		Vote1 = pieData.get(partyName);
	       		Tvotes=Tvotes+Vote1;							//Formula For Total Number of Votes
	      	}	
	     		     
	     
	     Set<String> keySet1 = pieData.keySet();
	     Iterator<String> keyIterator1 = keySet1.iterator();
	     while(keyIterator1.hasNext()) 							//To Calculate the Degrees & Draw the Pie Diagram.
	     {    
	     	double Tvotes2=(double)Tvotes;
    	   	String partyName1 = keyIterator1.next();
	       	pieData.get(partyName1);							//For Accessing the Partyname from Mapped Set
	       	System.out.println(partyName1);
	       	
	       	Vote = pieData.get(partyName1);						//For Accessing the Votes of Parties from Mapped Set
	       	System.out.println("Vote \t" +Vote);
	       	System.out.println("Total Votes \t" +Tvotes2);		
	       	
	       	percentage=(Vote/Tvotes2)*100;						//To Calculate the Percentage of Votes.
	       	System.out.println("Percentage \t" +percentage);
	       	
	       	double deg1=(percentage/100)*360;					//To Calculate the Degrees from Percentage of Votes.
	        int degree1=(int) deg1;
	       	System.out.println("DEGREE \t\t"+degree1);
	       	
	       	Color color4=new Color(color1,color2,color3);
	 		g.setColor(color4);
	 		
	 		Font font=new Font("ArialBlack",Font.ITALIC,20);
	 		g.setFont(font);
	 		String Votes=" "+Vote;
	 		g.drawString(Votes,350,Y_axis);
	 	    String per =" "+percentage;
	 	    g.drawString(per,450,Y_axis);
	 	    
	 		g.drawString(partyName1,X_axixs,Y_axis);				//For Printing the Party Names of Respective Pie-Diagram. 
	 		Y_axis=Y_axis+40;
	 		                                                                                                              
	 	    
		    
		    /*g.fillArc(300,200,201,201,Iangle,degree1);			//For Drawing the Pie Diagram of Respective Political Parties.
		    Iangle=Iangle+degree1;
	        
	        color1=color1+25;									//For Filling the Pie-Diagram with Different Colors Shades.
	        color2=color2+25;
	        color3=color3+25;*/
	        
	        System.out.println("\n\n");
	     }
	     
	     String label="* DIGITAL-READINGS *";
	     Font font=new Font("ArialBlack",Font.ITALIC,30);
	     g.drawRect(30,60,700,500);
 		 g.setColor(Color.black);
 		 g.drawString("PARTIES",220,260);
	 	 g.drawString("VOTES",350,260);
	 	 g.drawString("PERCENTAGES",450,260);
	 	 g.setFont(font);
	 	 g.drawString(label,280,150);
	 	 
	 	 
	 }
	
	public void paint(final Graphics g) {
		drawPie(g);
	}
	
	public static void main(String []args) {
		new DigitalReadings();
	}
	
	
}
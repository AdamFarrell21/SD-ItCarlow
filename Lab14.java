import javax.swing.*;  
    public class Lab14 
    {  
         Lab14(){  
            JFrame f= new JFrame("CheckBox Example");  
            JCheckBox checkBox1 = new JCheckBox("Snap to Grid");  
            checkBox1.setBounds(50,100, 100,50);  
            JCheckBox checkBox2 = new JCheckBox("Show Grid ", true);  
            checkBox2.setBounds(50,133, 100,50);
            JCheckBox checkBox3 = new JCheckBox("Show Grid ", true);  
            checkBox3.setBounds(50,165, 100,50); 
            f.add(checkBox1);  
            f.add(checkBox2);
            f.add(checkBox3);   
            f.setSize(400,400);  
            f.setLayout(null);  
            f.setVisible(true);  
            
		  
		
		   
		    
		    JButton b=new JButton("Ok");  
		    b.setBounds(250,100,95,30);  
		    f.add(b);  
		    f.setSize(400,400);  
		    f.setLayout(null);  
		    f.setVisible(true); 
		    
		    JButton c=new JButton("Cancel");  
		    c.setBounds(250,140,95,30);  
		    f.add(c);  
		    f.setSize(400,400);  
		    f.setLayout(null);  
		    f.setVisible(true);   
		    
		    JButton d=new JButton("Setup");  
		    d.setBounds(250,180,95,30);  
		    f.add(d);  
		    f.setSize(400,400);  
		    f.setLayout(null);  
		    f.setVisible(true);     
			
			JButton e=new JButton("Help");  
		    e.setBounds(250,220,95,30);  
		    f.add(e);  
		    f.setSize(400,400);  
		    f.setLayout(null);  
		    f.setVisible(true); 
		    
		     String[] optionsToChoose = {"Apple", "Orange", "Banana", "Pineapple", "None of the listed"};

        

        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
        jComboBox.setBounds(80, 50, 140, 20);

        JButton g=new new JButton("Done");
        g.setBounds(100, 100, 90, 20);

        JLabel jLabel = new JLabel();
        JLabel.setBounds(90, 100, 400, 100);

        JFrame.add(jButton);
        JFrame.add(jComboBox);
        JFrame.add(jLabel);
        
        JFrame.setLayout(null);
        JFrame.setSize(350, 250);
        JFrame.setVisible(true);
         }  
    public static void main(String args[])  
        {  
        new Lab14();  
        }
     }  
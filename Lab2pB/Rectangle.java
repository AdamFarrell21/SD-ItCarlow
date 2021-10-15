package Lab2B;

public class Rectangle {
	
	
		int length,width; //attributes of class rectangle
		public Rectangle(){ ///constructor to initialize default values to the attributes
		length = 5;
		width = 10;
		}
		
		public float Perimeter(){ //member functions
		return 2*(length+width);
		}
		public float area(){
		return (length*width);
		}
		   
		public void setLength(float len)
		{
		if(len >0.0 && len <40)
		length = (int) len;
		else
		System.out.println("Invalid Length");
		}
		public void setWidth(float wid)
		{
		if(wid >0.0 && wid <40)
		width = (int) wid;
		else
		System.out.println("Invalid width");
		}
		public float getLength(){
		return length;
		}
		public float getWidth(){
		return width;
		}
	
	 
 }



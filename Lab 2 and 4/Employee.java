package Lab4;

public class Employee {
	public static void main(String args[]) {  
        
         
		MyHR emp = new MyHR();  
        emp.setEmp_id(100);  
        emp.setName("Emma Watson");
        emp.setDepartment("IT"); 
        emp.setRoomNumber("10");
        emp.setAddress("carlow ,dublin street ,ireland");
        emp.setEmail("Emmawatson123@gmail.com"); 
        
        System.out.println(emp);

        MyHR mep = new MyHR();  
        mep.setEmp_id(12);  
        mep.setName("John Ross");
        mep.setDepartment("IT"); 
        mep.setRoomNumber("50");
        mep.setAddress("Dublin ,Amiens Stret,ireland");
        mep.setEmail("johnRoss212@gmail.com"); 
         
        System.out.println(mep);  
	}
}
          
        
       


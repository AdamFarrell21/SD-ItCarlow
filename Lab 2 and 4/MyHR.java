package Lab4; 
//Creating Employee class  
class MyHR {  
  //Creating properties of Employee class  
int emp_id;
String roomnumber;  
String name, address, department, email;  

//Getter and setters for getting and setting properties  
public int getEmp_id() {  
  return emp_id;  
}  
public void setEmp_id(int emp_id) {  
  this.emp_id = emp_id;  
}  
public String getRoomNumber() {  
  return roomnumber;  
}  
public void setRoomNumber(String string) {  
  this.roomnumber = string;  
}  
public String getName() {  
  return name;  
}  
public void setName(String name) {  
  this.name = name;  
}  
public String getAddress() {  
  return address;  
}  
public void setAddress(String address) {  
  this.address = address;  
}  
public String getDepartment() {  
  return department;  
}  
public void setDepartment(String department) {  
  this.department = department;  
}  
public String getEmail() {  
  return email;  
}  
public void setEmail(String email) {  
  this.email = email;  
}  

//Overriding toString() method  
@Override  
public String toString() {  
  return "Employee [emp_id = " + emp_id + ", roomnumber = " + roomnumber + ", name = " + name + ", address = " + address  
          + ", department = " + department + ", email = " + email + "]";  
  }  
    
} 